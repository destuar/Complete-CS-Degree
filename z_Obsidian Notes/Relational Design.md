# Relational Design

**Relational Design** is the process of structuring data in a relational database to minimize redundancy, avoid anomalies, and ensure data integrity. It involves applying systematic principles and techniques, particularly **decomposition** and **normalization**, to transform poorly designed schemas into well-structured relations that maintain data consistency and support efficient operations.

## Basic Definition

Relational design focuses on creating database schemas that:

- **Minimize Redundancy**: Eliminate unnecessary duplication of data
- **Avoid Anomalies**: Prevent inconsistencies during insert, update, and delete operations
- **Preserve Information**: Maintain all necessary data without loss
- **Maintain Dependencies**: Preserve functional relationships between attributes
- **Optimize Performance**: Balance normalization with query efficiency

## Design Anomalies

Design anomalies are problems that arise from poor database design, leading to data inconsistencies, redundancy, and operational difficulties. These anomalies motivate the need for proper relational design techniques.

### **Redundancy**

**Definition**: The unnecessary repetition of data values across multiple tuples in a relation.

**Problems**:
- **Wasted Storage**: Same information stored multiple times
- **Inconsistency Risk**: Repeated data may become inconsistent
- **Maintenance Overhead**: Updates must be applied to multiple locations
- **Data Integrity**: Difficult to ensure all copies remain synchronized

**Example**:

Consider a poorly designed **CourseEnrollment** relation:

| StudentID | StudentName | Major | CourseID | CourseName | Instructor |
|-----------|-------------|-------|----------|------------|------------|
| 1001      | Alice       | CS    | CS101    | Intro to CS| Dr. Smith  |
| 1001      | Alice       | CS    | CS102    | Data Struct| Dr. Jones  |
| 1002      | Bob         | Math  | CS101    | Intro to CS| Dr. Smith  |
| 1002      | Bob         | Math  | MATH201  | Calculus   | Dr. Brown  |

**Redundancy Issues**:
- Student names and majors repeat for each course enrollment
- Course names and instructors repeat for each student enrolled
- If Alice changes her major, multiple rows must be updated

### **Update Anomaly**

**Definition**: Inconsistencies that arise when the same data is updated differently in different locations.

**Problems**:
- **Partial Updates**: Some instances of redundant data updated, others not
- **Inconsistent State**: Database contains conflicting information
- **Data Integrity Violation**: No single source of truth for a fact
- **Application Complexity**: Must track and update all occurrences

**Example**:

Using the same **CourseEnrollment** relation:

If Alice changes her major from CS to Math:
```sql
UPDATE CourseEnrollment 
SET Major = 'Math' 
WHERE StudentID = 1001 AND CourseID = 'CS101';
```

**Problem**: Only the first row is updated, leaving the second row with the old major (CS). The database now has conflicting information about Alice's major.

**Correct Approach**: Would require updating all rows:
```sql
UPDATE CourseEnrollment 
SET Major = 'Math' 
WHERE StudentID = 1001;
```

This is error-prone and inefficient, demonstrating the need for better design.

### **Insertion Anomaly**

**Definition**: Inability to insert certain data without the presence of other unrelated data.

**Problems**:
- **Forced NULL Values**: Must insert NULL for missing attributes
- **Incomplete Information**: Cannot record facts until all data is available
- **Business Logic Violations**: Schema structure conflicts with business requirements
- **Data Loss Risk**: Information delayed or never recorded

**Example**:

Using the **CourseEnrollment** relation:

**Problem 1**: Cannot add a new student who hasn't enrolled in any courses yet
- Would need to insert NULL for CourseID, CourseName, and Instructor
- Violates the intended structure of the relation

**Problem 2**: Cannot add a new course until at least one student enrolls
- Would need NULL values for student information
- Course information is dependent on student enrollment

**Result**: Important information (student profiles, course catalog) cannot be stored independently.

### **Deletion Anomaly**

**Definition**: Unintended loss of information when deleting data, where removing one fact causes the loss of other unrelated facts.

**Problems**:
- **Information Loss**: Deleting intended data removes unintended data
- **Cascading Deletions**: One deletion triggers loss of related information
- **Incomplete Records**: Cannot remove specific facts without affecting others
- **Data Recovery Issues**: Lost information may be difficult to restore

**Example**:

Using the **CourseEnrollment** relation:

**Scenario 1**: If Bob drops MATH201 (his only math course):
```sql
DELETE FROM CourseEnrollment 
WHERE StudentID = 1002 AND CourseID = 'MATH201';
```

**Problem**: If Bob later drops CS101 as well, we lose all information about Bob entirely (his name, major, etc.), even though he's still a student.

**Scenario 2**: If all students drop CS101:
```sql
DELETE FROM CourseEnrollment 
WHERE CourseID = 'CS101';
```

**Problem**: We lose all information about CS101 (course name, instructor), even though the course still exists in the curriculum.

**Result**: Deletion of enrollment data causes loss of student and course information that should persist independently.

## Design by Decomposition

**Decomposition** is the primary technique for eliminating design anomalies by breaking down a relation with anomalies into multiple smaller, well-designed relations.

### **Decomposition Principles**

**1. Lossless Join Decomposition**
- **Requirement**: Must be able to reconstruct the original relation by joining the decomposed relations
- **Mathematical Condition**: Natural join of decomposed relations equals original relation
- **No Information Loss**: All original tuples can be recovered exactly
- **Notation**: If $R$ decomposes into $R_1$ and $R_2$, then $R_1 \bowtie R_2 = R$

**2. Dependency Preservation**
- **Requirement**: All functional dependencies from the original relation must be enforceable in the decomposed relations
- **Purpose**: Maintain data integrity constraints
- **Testing**: Can check all original constraints using only the decomposed relations
- **Trade-offs**: Sometimes conflicts with achieving higher normal forms

**3. No Spurious Tuples**
- **Requirement**: Join of decomposed relations must not create tuples that weren't in the original
- **Problem**: Bad decomposition can generate artificial data
- **Solution**: Ensure decomposition is based on valid functional dependencies
- **Verification**: Check that join produces exactly original tuples

### **Decomposition Process**

**Step 1: Identify Functional Dependencies**

Determine all functional dependencies (FDs) in the relation:
- $X \rightarrow Y$ means $Y$ is functionally dependent on $X$
- Every tuple with the same $X$ values must have the same $Y$ values
- Example: StudentID $\rightarrow$ StudentName, Major

**Step 2: Identify Anomalies**

Analyze where anomalies occur:
- Look for redundant data (repeated values)
- Identify attributes that depend on non-key attributes
- Check for transitive dependencies

**Step 3: Decompose Based on Dependencies**

Split the relation to isolate dependencies:
- Create separate relations for distinct entity types
- Ensure each relation represents a single concept
- Use foreign keys to maintain relationships

**Step 4: Verify Decomposition Quality**

Check decomposition properties:
- Lossless join: Can reconstruct original data
- Dependency preservation: Can enforce all constraints
- No spurious tuples: Join produces only valid data

### **Decomposition Example**

**Original Relation** (with anomalies):

**CourseEnrollment**(StudentID, StudentName, Major, CourseID, CourseName, Instructor)

**Functional Dependencies**:
- StudentID $\rightarrow$ StudentName, Major
- CourseID $\rightarrow$ CourseName, Instructor
- StudentID, CourseID $\rightarrow$ (all attributes)

**Decomposition** (eliminating anomalies):

**Students**(StudentID, StudentName, Major)
- Primary Key: StudentID
- Represents student information independently

**Courses**(CourseID, CourseName, Instructor)
- Primary Key: CourseID
- Represents course information independently

**Enrollments**(StudentID, CourseID)
- Primary Key: (StudentID, CourseID)
- Foreign Keys: StudentID references Students, CourseID references Courses
- Represents the many-to-many relationship

**Benefits of Decomposition**:
- **No Redundancy**: Student and course information stored once
- **No Update Anomaly**: Changes to student or course data happen in one place
- **No Insertion Anomaly**: Can add students or courses independently
- **No Deletion Anomaly**: Dropping enrollments doesn't delete student or course data

## Functional Dependencies

Functional dependencies (FDs) are the foundation of relational design and guide the decomposition process.

### **Definition & Notation**

A functional dependency $X \rightarrow Y$ states:
- $X$ and $Y$ are sets of attributes
- For any two tuples $t_1$ and $t_2$: if $t_1[X] = t_2[X]$, then $t_1[Y] = t_2[Y]$
- $X$ **functionally determines** $Y$
- $Y$ is **functionally dependent on** $X$

### **Types of Functional Dependencies**

**1. Trivial FD**
- $X \rightarrow Y$ where $Y \subseteq X$
- Always true by definition
- Example: StudentID, Name $\rightarrow$ Name
- Not useful for design analysis

**2. Non-trivial FD**
- $X \rightarrow Y$ where $Y \not\subseteq X$
- Represents actual business rules
- Example: StudentID $\rightarrow$ StudentName
- Important for decomposition decisions

**3. Partial Dependency**
- $X \rightarrow Y$ where $X$ is a subset of a composite key
- Violates Second Normal Form (2NF)
- Example: StudentID, CourseID $\rightarrow$ StudentName (depends on part of key)
- Causes redundancy and anomalies

**4. Transitive Dependency**
- $X \rightarrow Y$ and $Y \rightarrow Z$, so $X \rightarrow Z$ indirectly
- Violates Third Normal Form (3NF)
- Example: StudentID $\rightarrow$ Major $\rightarrow$ DepartmentBuilding
- Causes redundancy for non-key attributes

**5. Full Dependency**
- $X \rightarrow Y$ where $Y$ depends on all of $X$, not just a subset
- Required for Second Normal Form
- Example: StudentID, CourseID $\rightarrow$ Grade
- Properly structured for composite keys

### **Armstrong's Axioms**

Rules for inferring functional dependencies:

**1. Reflexivity**
- If $Y \subseteq X$, then $X \rightarrow Y$
- Basis for trivial dependencies

**2. Augmentation**
- If $X \rightarrow Y$, then $XZ \rightarrow YZ$ for any set $Z$
- Adding attributes maintains dependency

**3. Transitivity**
- If $X \rightarrow Y$ and $Y \rightarrow Z$, then $X \rightarrow Z$
- Basis for transitive dependencies

**4. Union** (derived)
- If $X \rightarrow Y$ and $X \rightarrow Z$, then $X \rightarrow YZ$
- Combine dependencies with same left side

**5. Decomposition** (derived)
- If $X \rightarrow YZ$, then $X \rightarrow Y$ and $X \rightarrow Z$
- Split dependencies with multiple right-side attributes

**6. Pseudotransitivity** (derived)
- If $X \rightarrow Y$ and $YZ \rightarrow W$, then $XZ \rightarrow W$
- Combined transitivity and augmentation

## Normalization

Normalization is a systematic approach to decomposition that eliminates anomalies by progressively refining the database schema through normal forms.

### **First Normal Form (1NF)**

**Definition**: A relation is in 1NF if all attribute values are atomic (indivisible).

**Requirements**:
- No repeating groups or arrays
- Each cell contains a single value
- Each column contains values of the same type
- Each row is unique (has a primary key)

**Example Violation**:

| StudentID | Name  | Courses              |
|-----------|-------|----------------------|
| 1001      | Alice | CS101, CS102, CS201  |
| 1002      | Bob   | CS101, MATH201       |

**Problem**: Courses column contains multiple values.

**1NF Solution**:

| StudentID | Name  | Course  |
|-----------|-------|---------|
| 1001      | Alice | CS101   |
| 1001      | Alice | CS102   |
| 1001      | Alice | CS201   |
| 1002      | Bob   | CS101   |
| 1002      | Bob   | MATH201 |

### **Second Normal Form (2NF)**

**Definition**: A relation is in 2NF if it is in 1NF and has no partial dependencies (all non-key attributes depend on the entire primary key).

**Requirements**:
- Must be in 1NF
- No non-key attribute depends on only part of a composite key
- All non-key attributes fully functionally dependent on primary key

**Example Violation**:

**Enrollments**(StudentID, CourseID, StudentName, CourseName, Grade)
- Primary Key: (StudentID, CourseID)
- StudentName depends only on StudentID (partial dependency)
- CourseName depends only on CourseID (partial dependency)

**2NF Solution**:

**Students**(StudentID, StudentName)
**Courses**(CourseID, CourseName)
**Enrollments**(StudentID, CourseID, Grade)

### **Third Normal Form (3NF)**

**Definition**: A relation is in 3NF if it is in 2NF and has no transitive dependencies (non-key attributes depend only on the key, not on other non-key attributes).

**Requirements**:
- Must be in 2NF
- No transitive dependencies
- For each FD $X \rightarrow Y$, either:
  - $X$ is a superkey, or
  - $Y$ is part of a candidate key

**Example Violation**:

**Students**(StudentID, Major, DepartmentHead)
- Primary Key: StudentID
- Transitive dependency: StudentID $\rightarrow$ Major $\rightarrow$ DepartmentHead

**Problem**: DepartmentHead depends on Major, not directly on StudentID.

**3NF Solution**:

**Students**(StudentID, Major)
**Departments**(Major, DepartmentHead)

### **Boyce-Codd Normal Form (BCNF)**

**Definition**: A relation is in BCNF if for every non-trivial functional dependency $X \rightarrow Y$, $X$ is a superkey.

**Requirements**:
- Stricter than 3NF
- For each FD $X \rightarrow Y$:
  - Either $X \rightarrow Y$ is trivial ($Y \subseteq X$), or
  - $X$ is a superkey

**Difference from 3NF**: In 3NF, $Y$ can be part of a candidate key even if $X$ is not a superkey. BCNF doesn't allow this exception.

**Example Violation**:

**CourseSchedule**(StudentID, CourseTime, Room, Instructor)
- Candidate Keys: (StudentID, CourseTime) or (Room, CourseTime)
- FD: Instructor $\rightarrow$ Room (instructor always teaches in same room)
- Instructor is not a superkey, violates BCNF

**BCNF Solution**:

**InstructorRooms**(Instructor, Room)
**Schedule**(StudentID, CourseTime, Instructor)

### **Fourth Normal Form (4NF)**

**Definition**: A relation is in 4NF if it is in BCNF and has no multi-valued dependencies that are not functional dependencies.

**Multi-valued Dependency**: $X \twoheadrightarrow Y$ means the set of $Y$ values associated with an $X$ value is independent of other attributes.

**Example Violation**:

**Instructors**(InstructorID, Course, Textbook)
- An instructor can teach multiple courses
- An instructor can recommend multiple textbooks
- Courses and textbooks are independent

| InstructorID | Course  | Textbook    |
|--------------|---------|-------------|
| 101          | CS101   | Book A      |
| 101          | CS101   | Book B      |
| 101          | CS102   | Book A      |
| 101          | CS102   | Book B      |

**Problem**: Must repeat all course-textbook combinations.

**4NF Solution**:

**InstructorCourses**(InstructorID, Course)
**InstructorTextbooks**(InstructorID, Textbook)

## Design Best Practices

### **Start with Good Requirements**
- Understand business rules and data relationships
- Identify entities, attributes, and relationships clearly
- Document functional dependencies
- Consider future data growth and evolution

### **Apply Normalization Systematically**
- Start with 1NF (atomic values)
- Progress through 2NF (no partial dependencies)
- Achieve 3NF for most applications
- Consider BCNF for critical data integrity
- Apply 4NF when multi-valued dependencies exist

### **Balance Normalization with Performance**
- Higher normal forms reduce anomalies but may increase joins
- Denormalize selectively for read-heavy workloads
- Use materialized views for complex aggregations
- Index appropriately to support common queries
- Monitor and optimize based on actual usage patterns

### **Maintain Data Integrity**
- Define primary keys for all relations
- Use foreign keys to enforce referential integrity
- Apply appropriate constraints (NOT NULL, CHECK, UNIQUE)
- Document business rules and validation logic
- Implement cascading rules carefully

### **Design for Flexibility**
- Anticipate schema evolution needs
- Use descriptive, consistent naming conventions
- Document design decisions and trade-offs
- Version control schema changes
- Plan migration strategies for updates

### **Test the Design**
- Verify lossless join decomposition
- Check dependency preservation
- Test for all types of anomalies
- Validate against real-world scenarios
- Performance test with realistic data volumes

## Trade-offs & Considerations

### **Normalization vs. Performance**
- **High Normalization**: Less redundancy, more joins, complex queries
- **Denormalization**: Faster reads, more redundancy, update complexity
- **Optimal Balance**: 3NF for transactional systems, selective denormalization for analytics

### **Design Complexity**
- **Simple Design**: Fewer tables, easier to understand, more anomalies
- **Complex Design**: More tables, harder to grasp, fewer anomalies
- **Practical Approach**: Normalize appropriately, document thoroughly

### **Application Requirements**
- **OLTP Systems**: Emphasize normalization, data integrity, concurrent updates
- **OLAP Systems**: Allow denormalization, optimize for complex queries, reporting
- **Hybrid Systems**: Balance both needs, use separate schemas if necessary

## Key Features

### **Anomaly Prevention**
- Eliminate redundancy through decomposition
- Prevent update, insertion, and deletion anomalies
- Maintain data consistency and integrity
- Reduce maintenance overhead and error risk

### **Systematic Approach**
- Functional dependencies guide design decisions
- Normal forms provide structured progression
- Armstrong's axioms enable dependency analysis
- Clear criteria for evaluating design quality

### **Flexibility & Maintainability**
- Well-designed schemas adapt to changing requirements
- Modular structure supports incremental changes
- Clear relationships simplify understanding
- Documented dependencies facilitate maintenance

## Important Notes

- **Design is Iterative**: Rarely perfect on first attempt; refine based on usage
- **Context Matters**: Optimal design depends on specific application requirements
- **Document Everything**: Record functional dependencies, design decisions, and trade-offs
- **Test Thoroughly**: Verify design eliminates anomalies and supports all operations
- **Monitor Performance**: Adjust design based on real-world performance metrics

## Related Concepts

- **[[Relation]]**: Tables that form the foundation of relational design
- **[[Attribute]]**: Columns whose dependencies drive design decisions
- **[[Schema]]**: Formal specification resulting from design process
- **[[Relational Database]]**: System implementing well-designed relations
- **[[Database Management System (DBMS)]]**: Software enforcing design constraints
- **[[Decomposition]]**: Mathematical technique for splitting relations
- **[[Relational Algebra]]**: Operations supported by proper design
