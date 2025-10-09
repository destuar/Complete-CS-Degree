# Constraint

A **Constraint** (or **Integrity Constraint**) is a restriction imposed on the allowable states of a database that ensures data validity, consistency, and correctness. Constraints are a **static** concept that defines rules about what data values and combinations are permitted, capturing semantic restrictions that go beyond basic structural and type requirements.

## Basic Definition

A constraint specifies rules that must be satisfied by the database state:

- **Restrictions on Values**: Limits on what data values are acceptable
- **Semantic Rules**: Business logic and domain requirements
- **Data Validity**: Ensures data conforms to application requirements
- **Automatic Enforcement**: Database system checks and enforces constraints
- **Error Prevention**: Blocks invalid data from entering the database

## Purpose of Constraints

Constraints serve multiple critical functions in database systems:

### **Catch Data Entry Errors**

Constraints prevent invalid or incorrect data from being inserted into the database.

**Examples**:
- Age cannot be negative
- Email must contain '@' symbol
- Date of birth cannot be in the future
- Phone number must match specific format

**Benefit**: Catches mistakes at data entry time rather than discovering them later during data analysis or processing.

### **Serve as Correctness Criteria**

Constraints define what constitutes valid data, providing clear rules for updates and modifications.

**Examples**:
- Product price must be positive
- Order quantity must be at least 1
- Student must be enrolled before registering for courses

**Benefit**: Provides automatic validation that all database modifications maintain data correctness.

### **Enforce Consistency**

Constraints maintain consistency across duplicated or dependent data elements.

**Examples**:
- Foreign keys ensure referential consistency between tables
- Total price must equal sum of line item prices
- Department budget cannot exceed company total

**Benefit**: Prevents data anomalies where related information becomes inconsistent.

### **Inform System About Data**

Constraints provide metadata that the database system can use for optimization.

**Examples**:
- Uniqueness constraints enable certain query optimizations
- Not-null constraints inform storage decisions
- Range constraints help with indexing strategies

**Benefit**: Enables efficient storage strategies and query processing optimizations.

## Types of Integrity Constraints

### **Non-Null Constraints**

Require that an attribute must have a value (cannot be NULL).

**Syntax**:
```sql
CREATE TABLE Students (
    StudentID INT NOT NULL,
    StudentName VARCHAR(100) NOT NULL,
    Email VARCHAR(100) NOT NULL
);
```

**Use Cases**:
- Primary keys (always required)
- Essential attributes that must be known
- Mandatory fields in forms

**Example**: Student name cannot be null - every student must have a name.

### **Unique Constraints**

Ensure that all values in a column or set of columns are distinct.

**Syntax**:
```sql
CREATE TABLE Students (
    StudentID INT UNIQUE,
    Email VARCHAR(100) UNIQUE,
    SSN CHAR(11) UNIQUE
);
```

**Use Cases**:
- Email addresses (one per user)
- Social security numbers
- Product codes or SKUs
- Usernames

**Example**: Each student must have a unique email address.

### **Key Constraints (Primary Keys)**

Special case of unique + non-null that identifies each row uniquely.

**Syntax**:
```sql
CREATE TABLE Students (
    StudentID INT PRIMARY KEY,
    StudentName VARCHAR(100)
);
```

**Properties**:
- Automatically NOT NULL and UNIQUE
- Only one primary key per table
- Often used as reference target for foreign keys
- May be automatically indexed

### **Referential Integrity (Foreign Key Constraints)**

Ensure that a value in one table matches a value in another table's primary key.

**Syntax**:
```sql
CREATE TABLE Enrollments (
    StudentID INT,
    CourseID INT,
    FOREIGN KEY (StudentID) REFERENCES Students(StudentID),
    FOREIGN KEY (CourseID) REFERENCES Courses(CourseID)
);
```

**Actions on Violation**:
- **CASCADE**: Delete/update related rows automatically
- **SET NULL**: Set foreign key to NULL
- **SET DEFAULT**: Set foreign key to default value
- **RESTRICT/NO ACTION**: Prevent the operation

**Example**: A student enrollment must reference an existing student and an existing course.

### **Attribute-Based Constraints (CHECK Constraints)**

Constraints on individual attribute values within a single column.

**Syntax**:
```sql
CREATE TABLE Students (
    StudentID INT,
    StudentName VARCHAR(100),
    GPA DECIMAL(3,2) CHECK (GPA >= 0.0 AND GPA <= 4.0),
    Age INT CHECK (Age >= 16 AND Age <= 100)
);
```

**Examples**:
- GPA must be between 0.0 and 4.0
- Age must be positive and reasonable
- Enrollment date must be valid date

**Characteristics**:
- Evaluated for each row
- Applied to single column value
- Simple boolean expression

### **Tuple-Based Constraints**

Constraints that involve multiple attributes within the same tuple (row).

**Syntax**:
```sql
CREATE TABLE Colleges (
    CollegeName VARCHAR(100),
    Enrollment INT,
    MaxEnrollment INT,
    CHECK (Enrollment <= MaxEnrollment)
);

CREATE TABLE Applications (
    StudentID INT,
    CollegeName VARCHAR(100),
    Major VARCHAR(50),
    Decision CHAR(1) CHECK (Decision IN ('Y', 'N') OR Decision IS NULL),
    CHECK (NOT (Major = 'CS' AND Decision = 'Y'))  -- No CS acceptances
);
```

**Examples**:
- Decision must be 'Y', 'N', or NULL
- Enrollment must be less than maximum enrollment (< 50,000)
- Start date must be before end date
- If Major is 'CS', Decision cannot be 'Y' (conditional constraint)

**Characteristics**:
- Can reference multiple columns in same row
- More expressive than attribute constraints
- Evaluated per tuple

### **General Assertions**

Complex constraints expressed using full SQL query capabilities, potentially involving multiple tables.

**Syntax** (SQL standard, not widely supported):
```sql
CREATE ASSERTION SmallHighSchoolRestriction
CHECK (NOT EXISTS (
    SELECT * FROM Students S, Applications A
    WHERE S.StudentID = A.StudentID
    AND S.HSSize < 1000
    AND A.CollegeName IN (
        SELECT CollegeName FROM Colleges WHERE Enrollment > 30000
    )
    AND A.Decision = 'Y'
));
```

**Examples**:
- No student from small high school (< 1000) admitted to large college (> 30,000)
- Total department budgets cannot exceed company budget
- Number of employees in department matches count in employee table

**Characteristics**:
- Most expressive type of constraint
- Can involve complex queries across multiple tables
- Computationally expensive to check
- Not supported by all database systems

## Declaration and Enforcement

### **Declared with Schema**

Constraints are typically declared when creating the database schema.

**Process**:
1. Define tables with constraints
2. Bulk load data into empty tables
3. Check all constraints after loading
4. If violations exist, fix data or adjust constraints

**Example**:
```sql
CREATE TABLE Students (
    StudentID INT PRIMARY KEY,
    StudentName VARCHAR(100) NOT NULL,
    GPA DECIMAL(3,2) CHECK (GPA >= 0.0 AND GPA <= 4.0)
);

-- Bulk load data
LOAD DATA INFILE 'students.csv' INTO TABLE Students;

-- Constraints checked after load completes
```

**Benefits**:
- Constraints defined upfront with data model
- All data validated consistently from start
- Violations caught before system goes live

### **Declared on Operational Database**

Constraints can be added to an existing database with data already present.

**Process**:
1. Add constraint to existing table
2. System immediately checks current database state
3. If violations exist, constraint addition fails
4. Must fix violations before constraint can be added

**Example**:
```sql
-- Add constraint to existing table
ALTER TABLE Students 
ADD CONSTRAINT chk_gpa CHECK (GPA >= 0.0 AND GPA <= 4.0);

-- If any student has GPA outside range, constraint addition fails
-- Must fix data first:
UPDATE Students SET GPA = 4.0 WHERE GPA > 4.0;

-- Then add constraint
ALTER TABLE Students 
ADD CONSTRAINT chk_gpa CHECK (GPA >= 0.0 AND GPA <= 4.0);
```

**Benefits**:
- Can add data integrity rules later
- Validates existing data meets requirements
- Enforces constraints going forward

### **Checked After Every Modification**

Once constraints are in place, they are checked after each INSERT, UPDATE, or DELETE operation.

**Ideal Behavior**: Check only for "dangerous" modifications

**Examples**:
- **INSERT**: Check all constraints for new row
- **UPDATE StudentID**: Check foreign keys that reference it
- **UPDATE GPA**: Check GPA range constraint
- **DELETE Student**: Check foreign keys from Enrollments table

**Non-dangerous modifications** (don't need checking):
- Update that doesn't change constrained columns
- Delete when no foreign keys reference the row

**Performance Consideration**:
- Checking every modification can be expensive
- Systems optimize to check only relevant constraints
- Trade-off between safety and performance

### **Deferred Constraint Checking**

Allows constraints to be violated temporarily within a transaction, checking only when transaction commits.

**Syntax**:
```sql
SET CONSTRAINTS ALL DEFERRED;

BEGIN TRANSACTION;
    -- These might temporarily violate constraints
    UPDATE Students SET Major = 'Undecided' WHERE StudentID = 123;
    UPDATE Students SET Advisor = NULL WHERE StudentID = 123;
    -- Insert new advisor relationship
    INSERT INTO Advisors VALUES (123, 456);
    
    -- Constraints checked here when transaction commits
COMMIT;
```

**Use Cases**:
- Circular dependencies between tables
- Series of modifications that together maintain validity
- Complex updates that temporarily violate constraints

**Example Scenario**:
```
Swapping two students' IDs (both are primary and foreign keys):
1. Update Student1.ID = temp_value (violates foreign keys temporarily)
2. Update Student2.ID = Student1.original_ID
3. Update Student1.ID = Student2.original_ID
4. Commit (all constraints valid now)
```

**Benefits**:
- Enables complex multi-step operations
- More flexible than immediate checking
- Still maintains data integrity at transaction boundaries

### **Handling Violations**

When a constraint is violated, the database system typically:

1. **Raises an Error**: Returns error message indicating which constraint was violated
2. **Undoes the Modification**: Rolls back the operation that caused violation
3. **Maintains Database State**: Database remains in previous valid state

**Example**:
```sql
INSERT INTO Students VALUES (123, 'Alice', 'CS', 4.5);
-- ERROR: Check constraint 'chk_gpa' violated
-- GPA value 4.5 exceeds maximum of 4.0
-- INSERT operation rolled back
-- Database unchanged
```

**Alternative**: Some systems allow constraint repair logic (typically through triggers).

## Examples of Constraints

### **Simple Range Constraint**

```sql
CREATE TABLE Students (
    GPA DECIMAL(3,2) CHECK (GPA >= 0.0 AND GPA <= 4.0)
);
```
GPA must be between 0.0 and 4.0.

### **Enrollment Limit**

```sql
CREATE TABLE Colleges (
    Enrollment INT CHECK (Enrollment < 50000)
);
```
College enrollment must be less than 50,000.

### **Enumerated Values**

```sql
CREATE TABLE Applications (
    Decision CHAR(1) CHECK (Decision IN ('Y', 'N') OR Decision IS NULL)
);
```
Decision attribute must be 'Y', 'N', or NULL.

### **Conditional Constraint**

```sql
CREATE TABLE Applications (
    Major VARCHAR(50),
    Decision CHAR(1),
    CHECK (NOT (Major = 'CS' AND Decision IS NOT NULL))
);
```
No decisions allowed on CS applications.

### **Multi-Table Constraint**

```sql
-- Using assertion (if supported)
CREATE ASSERTION SmallHSLargeCollege
CHECK (NOT EXISTS (
    SELECT *
    FROM Students S, Applications A, Colleges C
    WHERE S.StudentID = A.StudentID
    AND A.CollegeName = C.CollegeName
    AND S.HSSize < 1000
    AND C.Enrollment > 30000
    AND A.Decision = 'Y'
));
```
Students from small high schools (< 1000) cannot be admitted to large colleges (> 30,000).

## Constraints vs. Application Logic

### **Constraints in Database**

**Advantages**:
- Enforced automatically by DBMS
- Cannot be bypassed by applications
- Centralized in one place
- Consistent across all applications
- Declarative and clear

**Disadvantages**:
- Limited expressiveness in some systems
- Can impact performance
- May be difficult to express complex rules

### **Validation in Application**

**Advantages**:
- More flexible and expressive
- Can provide better user feedback
- Easier to modify
- No database performance impact

**Disadvantages**:
- Can be bypassed or forgotten
- Duplicated across multiple applications
- May become inconsistent
- Not enforced if data entered directly

### **Best Practice**

Use both:
- **Critical constraints**: Enforce in database (last line of defense)
- **User-friendly validation**: Implement in application (better UX)
- **Complex business rules**: May need application logic or triggers

## Important Notes

- **Static Nature**: Constraints define valid states, not transitions
- **Performance Impact**: Complex constraints can slow down modifications
- **Design Trade-offs**: Balance between constraint complexity and system performance
- **Documentation**: Constraints serve as formal documentation of data rules
- **Evolution**: Constraints may need to change as business rules evolve

## Related Concepts

- **[[Trigger]]**: Dynamic mechanism for enforcing constraints and reacting to changes
- **[[Schema]]**: Constraints are part of the database schema definition
- **[[SQL]]**: Language for declaring and managing constraints
- **[[Relational Database]]**: System that enforces integrity constraints
- **[[Database Management System (DBMS)]]**: Software that checks and enforces constraints
- **[[Data Definition Language (DDL)]]**: SQL subset for defining constraints
- **[[Functional Dependencies]]**: Mathematical foundation for certain constraints
- **[[Normal Form]]**: Design principles that help avoid constraint violations

