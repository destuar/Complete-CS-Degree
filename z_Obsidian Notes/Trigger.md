# Trigger

A **Trigger** (also known as an **Event-Condition-Action rule** or **ECA rule**) is a dynamic database mechanism that monitors changes to the database and automatically executes specified actions when certain conditions are met. Unlike constraints which define valid static states, triggers react to database modifications and can initiate complex responses.

## Basic Definition

A trigger is a database object that:

- **Monitors Events**: Watches for specific database modifications (INSERT, UPDATE, DELETE)
- **Checks Conditions**: Evaluates whether specified conditions are true
- **Executes Actions**: Performs operations if conditions are satisfied
- **Operates Automatically**: Runs without explicit invocation
- **Dynamic Behavior**: Responds to changes rather than enforcing static rules

## Event-Condition-Action (ECA) Model

Triggers follow the **ECA paradigm**, consisting of three components:

### **Event (When)**

The database modification that activates the trigger.

**Event Types**:
- **INSERT**: New row added to table
- **UPDATE**: Existing row modified
- **DELETE**: Row removed from table

**Timing**:
- **BEFORE**: Execute before the modification
- **AFTER**: Execute after the modification
- **INSTEAD OF**: Replace the modification with trigger action

**Granularity**:
- **Row-level**: Trigger fires for each affected row
- **Statement-level**: Trigger fires once per SQL statement

**Example Events**:
```sql
-- After insert on Students table
AFTER INSERT ON Students

-- Before update of GPA column
BEFORE UPDATE OF GPA ON Students

-- After delete on any row
AFTER DELETE ON Applications
```

### **Condition (If)**

The boolean expression that determines whether the action should execute.

**Condition Types**:
- **Value checks**: Compare attribute values to constants or ranges
- **Existence checks**: Verify presence/absence of related data
- **Aggregation checks**: Evaluate computed values like counts or sums
- **Complex queries**: Any SQL query returning boolean result

**Example Conditions**:
```sql
-- Check if enrollment exceeds threshold
WHERE (SELECT Enrollment FROM Colleges WHERE CollegeName = NEW.CollegeName) > 35000

-- Check if GPA is exceptionally high
WHERE NEW.GPA > 3.95

-- Check if value seems unlikely
WHERE NEW.HSSize > 50000 OR NEW.HSSize < 100
```

### **Action (Then)**

The operation(s) performed when the event occurs and condition is true.

**Action Types**:
- **Reject modification**: Raise error and rollback
- **Modify data**: Update, insert, or delete other data
- **Cascade changes**: Propagate modifications to related tables
- **Log events**: Record changes for audit trail
- **Send notifications**: Alert administrators or applications

**Example Actions**:
```sql
-- Reject the operation
RAISE_APPLICATION_ERROR(-20001, 'Enrollment limit exceeded');

-- Automatically accept applicant
UPDATE Applications SET Decision = 'Y' WHERE ApplicationID = NEW.ApplicationID;

-- Correct suspicious value
SET NEW.HSSize = (SELECT AVG(HSSize) FROM Students);

-- Log the change
INSERT INTO AuditLog VALUES (CURRENT_TIMESTAMP, USER, 'Student GPA updated');
```

## Purpose and Benefits

### **Move Monitoring Logic to Database**

**Problem**: Application-level monitoring requires implementing logic in every application that accesses the database.

**Solution**: Triggers centralize monitoring logic in the database itself.

**Benefits**:
- **Modularity**: Logic defined once, works for all applications
- **Automatic Execution**: Cannot be bypassed by applications
- **Consistency**: Same rules apply regardless of access method
- **Maintenance**: Update logic in one place

**Example**:
```sql
-- Instead of checking enrollment in every application:
-- Java app checks enrollment
// if (college.getEnrollment() > 35000) reject();

-- C# app checks enrollment
// if (college.Enrollment > 35000) Reject();

-- Python app checks enrollment
// if college.enrollment > 35000: reject()

-- Use trigger that works for all:
CREATE TRIGGER EnrollmentCheck
AFTER INSERT ON Applications
FOR EACH ROW
WHEN ((SELECT Enrollment FROM Colleges WHERE CollegeName = NEW.CollegeName) > 35000)
BEGIN
    RAISE_APPLICATION_ERROR(-20001, 'College at capacity');
END;
```

### **Enforce Constraints**

**Problem**: Built-in constraint systems may be limited in expressiveness.

**Solution**: Triggers provide more expressive constraint enforcement.

**When to Use Triggers for Constraints**:
- Multi-table constraints not supported by assertions
- Complex conditional logic beyond CHECK constraints
- Dynamic constraints that depend on current database state
- Constraints requiring aggregation or subqueries

**Example**:
```sql
-- Constraint: No more than 5 applications per student
CREATE TRIGGER LimitApplications
BEFORE INSERT ON Applications
FOR EACH ROW
DECLARE
    app_count INT;
BEGIN
    SELECT COUNT(*) INTO app_count
    FROM Applications
    WHERE StudentID = :NEW.StudentID;
    
    IF app_count >= 5 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Maximum 5 applications per student');
    END IF;
END;
```

**Advantage**: Triggers are often more expressive than built-in constraint features, allowing complex rules that would be difficult or impossible to express declaratively.

### **Implement Constraint Repair Logic**

**Problem**: Standard constraints only reject violations; they cannot fix them.

**Solution**: Triggers can implement repair logic to automatically correct violations.

**Repair Strategies**:
- **Adjust values**: Modify data to satisfy constraints
- **Cascade corrections**: Fix related data automatically
- **Use default values**: Replace invalid values with sensible defaults
- **Normalize data**: Transform data to valid format

**Example - Auto-Correction**:
```sql
-- If high school size seems unlikely, replace with average
CREATE TRIGGER ValidateHSSize
BEFORE INSERT OR UPDATE OF HSSize ON Students
FOR EACH ROW
BEGIN
    -- Check if value is suspicious
    IF :NEW.HSSize > 50000 OR :NEW.HSSize < 100 THEN
        -- Option 1: Raise error
        -- RAISE_APPLICATION_ERROR(-20003, 'Invalid high school size');
        
        -- Option 2: Correct the value
        SELECT AVG(HSSize) INTO :NEW.HSSize
        FROM Students
        WHERE HSSize BETWEEN 100 AND 50000;
    END IF;
END;
```

**Example - Cascading Repair**:
```sql
-- When student GPA updated, recalculate eligibility
CREATE TRIGGER UpdateEligibility
AFTER UPDATE OF GPA ON Students
FOR EACH ROW
BEGIN
    -- If GPA drops below threshold, revoke scholarship
    IF :NEW.GPA < 3.0 AND :OLD.GPA >= 3.0 THEN
        UPDATE Scholarships
        SET Status = 'Revoked'
        WHERE StudentID = :NEW.StudentID;
    END IF;
    
    -- If GPA rises above threshold, consider for scholarship
    IF :NEW.GPA >= 3.5 AND :OLD.GPA < 3.5 THEN
        INSERT INTO ScholarshipCandidates VALUES (:NEW.StudentID, CURRENT_DATE);
    END IF;
END;
```

## Trigger Examples

### **Example 1: Reject Applications When Over Capacity**

**Requirement**: If enrollment exceeds 35,000, reject all new applications.

```sql
CREATE TRIGGER RejectOverCapacity
AFTER INSERT ON Applications
FOR EACH ROW
DECLARE
    current_enrollment INT;
BEGIN
    -- Get college enrollment
    SELECT Enrollment INTO current_enrollment
    FROM Colleges
    WHERE CollegeName = :NEW.CollegeName;
    
    -- Check if over capacity
    IF current_enrollment > 35000 THEN
        RAISE_APPLICATION_ERROR(-20001, 
            'College ' || :NEW.CollegeName || ' is over capacity');
    END IF;
END;
```

### **Example 2: Auto-Accept High GPA Applicants**

**Requirement**: If application has GPA > 3.95, automatically accept.

```sql
CREATE TRIGGER AutoAcceptHighGPA
BEFORE INSERT ON Applications
FOR EACH ROW
DECLARE
    student_gpa DECIMAL(3,2);
BEGIN
    -- Get student's GPA
    SELECT GPA INTO student_gpa
    FROM Students
    WHERE StudentID = :NEW.StudentID;
    
    -- Auto-accept if GPA is exceptional
    IF student_gpa > 3.95 THEN
        :NEW.Decision := 'Y';
    END IF;
END;
```

### **Example 3: Validate and Correct Data**

**Requirement**: If high school size is updated to unlikely value, raise error or change value.

```sql
CREATE TRIGGER ValidateHighSchoolSize
BEFORE INSERT OR UPDATE OF HSSize ON Students
FOR EACH ROW
BEGIN
    -- Check if value is outside reasonable range
    IF :NEW.HSSize > 50000 THEN
        RAISE_APPLICATION_ERROR(-20003, 
            'High school size ' || :NEW.HSSize || ' exceeds maximum of 50,000');
    ELSIF :NEW.HSSize < 100 THEN
        RAISE_APPLICATION_ERROR(-20004,
            'High school size ' || :NEW.HSSize || ' below minimum of 100');
    END IF;
END;
```

**Alternative - Auto-Correction**:
```sql
CREATE TRIGGER CorrectHighSchoolSize
BEFORE INSERT OR UPDATE OF HSSize ON Students
FOR EACH ROW
DECLARE
    avg_size INT;
BEGIN
    -- If unlikely value, replace with average
    IF :NEW.HSSize > 50000 OR :NEW.HSSize < 100 THEN
        SELECT AVG(HSSize) INTO avg_size
        FROM Students
        WHERE HSSize BETWEEN 100 AND 50000;
        
        :NEW.HSSize := avg_size;
        
        -- Optionally log the correction
        INSERT INTO DataCorrectionLog
        VALUES (CURRENT_TIMESTAMP, 'HSSize', :OLD.HSSize, :NEW.HSSize);
    END IF;
END;
```

### **Example 4: Maintain Derived Data**

**Requirement**: Keep ApplicationCount updated when applications added/deleted.

```sql
-- Trigger for INSERT
CREATE TRIGGER IncrementAppCount
AFTER INSERT ON Applications
FOR EACH ROW
BEGIN
    UPDATE Students
    SET ApplicationCount = ApplicationCount + 1
    WHERE StudentID = :NEW.StudentID;
END;

-- Trigger for DELETE
CREATE TRIGGER DecrementAppCount
AFTER DELETE ON Applications
FOR EACH ROW
BEGIN
    UPDATE Students
    SET ApplicationCount = ApplicationCount - 1
    WHERE StudentID = :OLD.StudentID;
END;
```

### **Example 5: Audit Trail**

**Requirement**: Log all changes to sensitive data.

```sql
CREATE TRIGGER AuditGPAChanges
AFTER UPDATE OF GPA ON Students
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (
        Timestamp,
        TableName,
        StudentID,
        OldValue,
        NewValue,
        ChangedBy
    ) VALUES (
        CURRENT_TIMESTAMP,
        'Students',
        :NEW.StudentID,
        :OLD.GPA,
        :NEW.GPA,
        USER
    );
END;
```

## SQL Trigger Syntax

### **Standard Structure**

```sql
CREATE TRIGGER trigger_name
{BEFORE | AFTER | INSTEAD OF} {INSERT | UPDATE | DELETE}
[OF column_name [, column_name ...]]
ON table_name
[FOR EACH ROW | FOR EACH STATEMENT]
[WHEN (condition)]
BEGIN
    -- SQL statements (action)
    -- Can reference :NEW and :OLD values
END;
```

### **Components**

**Trigger Name**: Unique identifier for the trigger

**Timing**: 
- `BEFORE`: Execute before database modification
- `AFTER`: Execute after database modification
- `INSTEAD OF`: Replace modification with trigger action (for views)

**Event**:
- `INSERT`: Trigger fires on row insertion
- `UPDATE`: Trigger fires on row update
- `UPDATE OF column`: Trigger only for specific column updates
- `DELETE`: Trigger fires on row deletion

**Table**: The table being monitored

**Granularity**:
- `FOR EACH ROW`: Fires once per affected row
- `FOR EACH STATEMENT`: Fires once per SQL statement (default)

**Condition**: Optional WHEN clause for additional filtering

**Action**: SQL statements to execute

### **Special Variables**

**:NEW**: New values being inserted or updated
- Available in INSERT and UPDATE triggers
- Can be modified in BEFORE triggers
- Read-only in AFTER triggers

**:OLD**: Old values before update or delete
- Available in UPDATE and DELETE triggers
- Always read-only

**Example**:
```sql
CREATE TRIGGER ValidateUpdate
BEFORE UPDATE ON Students
FOR EACH ROW
BEGIN
    -- Access old and new values
    IF :NEW.GPA < :OLD.GPA - 1.0 THEN
        RAISE_APPLICATION_ERROR(-20005, 
            'GPA cannot drop by more than 1.0 in single update');
    END IF;
    
    -- Modify new value
    :NEW.LastModified := CURRENT_TIMESTAMP;
END;
```

## Triggers vs. Constraints

### **Constraints (Static)**

**Nature**: Define valid database states
**Focus**: What data is allowed
**Enforcement**: Automatic validation
**Result**: Accept or reject modifications
**Complexity**: Limited expressiveness

**Example**:
```sql
CHECK (GPA >= 0.0 AND GPA <= 4.0)
```

### **Triggers (Dynamic)**

**Nature**: React to database changes
**Focus**: What happens when data changes
**Enforcement**: Programmable actions
**Result**: Accept, reject, or modify
**Complexity**: Highly expressive

**Example**:
```sql
IF :NEW.GPA > 3.95 THEN
    UPDATE Applications SET Decision = 'Y';
END IF;
```

### **Relationship**

- Triggers can enforce constraints (when constraint system is limited)
- Triggers are more expressive than constraints
- Constraints are simpler and more declarative
- Both ensure data integrity, but in different ways

**Best Practice**: Use constraints when possible (simpler, clearer); use triggers when constraints are insufficient (more complex logic needed).

## Important Considerations

### **Performance Impact**

- Triggers add overhead to database modifications
- Complex triggers can significantly slow operations
- Row-level triggers on large updates can be expensive
- Consider trigger efficiency carefully

### **Debugging Challenges**

- Trigger behavior not visible in SQL statements
- Can be difficult to trace execution flow
- Errors may be cryptic
- Testing requires careful setup

### **Cascading Triggers**

- Triggers can activate other triggers
- Risk of infinite loops
- Database systems usually limit recursion depth
- Design carefully to avoid unintended cascades

### **Maintenance**

- Hidden logic can make system harder to understand
- Changes may have unexpected side effects
- Document triggers thoroughly
- Review trigger interactions regularly

### **When to Avoid Triggers**

- Logic can be handled in application
- Simple constraints suffice
- Performance is critical
- Logic changes frequently

## Important Notes

- **Dynamic Nature**: Triggers respond to changes, not define valid states
- **Power and Complexity**: Very expressive but can be complex
- **Automatic Execution**: Cannot be bypassed, always enforced
- **Database-Specific**: Syntax varies across database systems
- **Use Judiciously**: Overuse can make systems difficult to maintain

## Related Concepts

- **[[Constraint]]**: Static mechanism for enforcing data integrity rules
- **[[SQL]]**: Language for defining and managing triggers
- **[[Database Management System (DBMS)]]**: System that implements and executes triggers
- **[[Relational Database]]**: Database that supports trigger functionality
- **[[Schema]]**: Triggers are part of the database schema definition
- **[[Data Definition Language (DDL)]]**: SQL subset for creating triggers
- **[[Data Manipulation Language (DML)]]**: Operations that can activate triggers

