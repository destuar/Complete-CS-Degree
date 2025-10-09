# Normal Form

A **Normal Form** is a set of criteria that a relational database schema must satisfy to ensure data integrity, minimize redundancy, and avoid anomalies. Normal forms are progressively restrictive conditions applied to relations, where each higher normal form builds upon the requirements of lower forms, guided by **functional dependencies** and **multivalued dependencies**.

## Basic Definition

Normal forms provide a systematic approach to database design that:

- **Eliminate Redundancy**: Remove unnecessary data duplication
- **Prevent Anomalies**: Avoid update, insertion, and deletion anomalies
- **Preserve Information**: Maintain all necessary data through decomposition
- **Maintain Dependencies**: Keep functional relationships enforceable
- **Ensure Data Integrity**: Guarantee consistency and correctness

## Functional Dependencies

**Functional dependencies** (FDs) are the foundation for First through Third Normal Forms and Boyce-Codd Normal Form. They express relationships between attributes that guide normalization decisions.

### **Definition**

A functional dependency $X \rightarrow Y$ means:
- $X$ and $Y$ are sets of attributes in relation $R$
- For any two tuples $t_1$ and $t_2$ in $R$:
  - If $t_1[X] = t_2[X]$, then $t_1[Y] = t_2[Y]$
- $X$ **functionally determines** $Y$
- $Y$ is **functionally dependent on** $X$
- Whenever two tuples agree on $X$, they must agree on $Y$

### **Types of Functional Dependencies**

**1. Trivial Functional Dependency**
- $X \rightarrow Y$ where $Y \subseteq X$
- Always satisfied by definition
- Example: {StudentID, Name} $\rightarrow$ {Name}
- Not useful for normalization analysis

**2. Non-trivial Functional Dependency**
- $X \rightarrow Y$ where $Y \not\subseteq X$
- Represents real business rules and constraints
- Example: StudentID $\rightarrow$ StudentName
- Key driver for decomposition decisions

**3. Completely Non-trivial Functional Dependency**
- $X \rightarrow Y$ where $X \cap Y = \emptyset$
- $X$ and $Y$ have no attributes in common
- Example: StudentID $\rightarrow$ {Name, Major}
- Strongest form of non-trivial dependency

**4. Partial Dependency**
- $X \rightarrow Y$ where $X$ is a proper subset of a candidate key
- Non-key attribute depends on part of composite key
- Example: {StudentID, CourseID} $\rightarrow$ StudentName (depends only on StudentID)
- Violates Second Normal Form (2NF)

**5. Transitive Dependency**
- $X \rightarrow Y$ and $Y \rightarrow Z$ where $Y$ is not a candidate key
- Non-key attribute depends on another non-key attribute
- Example: StudentID $\rightarrow$ Major $\rightarrow$ DepartmentBuilding
- Violates Third Normal Form (3NF)

**6. Full Functional Dependency**
- $X \rightarrow Y$ where $Y$ does not depend on any proper subset of $X$
- Attribute depends on all of $X$, not just part
- Example: {StudentID, CourseID} $\rightarrow$ Grade
- Required for Second Normal Form

### **Armstrong's Axioms**

Inference rules for deriving functional dependencies:

**Primary Rules:**

**1. Reflexivity (Trivial)**
$$\text{If } Y \subseteq X, \text{ then } X \rightarrow Y$$
- Any set of attributes determines its subsets
- Basis for trivial dependencies

**2. Augmentation**
$$\text{If } X \rightarrow Y, \text{ then } XZ \rightarrow YZ \text{ for any set } Z$$
- Adding attributes to both sides preserves dependency
- Used to generate new dependencies

**3. Transitivity**
$$\text{If } X \rightarrow Y \text{ and } Y \rightarrow Z, \text{ then } X \rightarrow Z$$
- Dependencies chain together
- Foundation of transitive dependencies

**Derived Rules:**

**4. Union**
$$\text{If } X \rightarrow Y \text{ and } X \rightarrow Z, \text{ then } X \rightarrow YZ$$
- Combine multiple dependencies with same left side

**5. Decomposition (Splitting)**
$$\text{If } X \rightarrow YZ, \text{ then } X \rightarrow Y \text{ and } X \rightarrow Z$$
- Split right side into individual attributes

**6. Pseudotransitivity**
$$\text{If } X \rightarrow Y \text{ and } YZ \rightarrow W, \text{ then } XZ \rightarrow W$$
- Combination of transitivity and augmentation

### **Closure of Attributes**

The **closure** of a set of attributes $X$, denoted $X^+$, is the set of all attributes functionally determined by $X$.

**Computing Closure:**
```
Algorithm: Closure(X)
Input: Set of attributes X, set of FDs F
Output: X+ (closure of X)

1. Result = X
2. Repeat until Result doesn't change:
   3. For each FD Y → Z in F:
      4. If Y ⊆ Result:
         5. Result = Result ∪ Z
6. Return Result
```

**Uses:**
- **Test if X is a superkey**: Check if $X^+ =$ all attributes
- **Test if X → Y holds**: Check if $Y \subseteq X^+$
- **Find candidate keys**: Minimal sets where $X^+ =$ all attributes

**Example:**

Given FDs: A → B, B → C, CD → E
- $A^+ = \{A, B, C\}$
- ${A, D}^+ = \{A, B, C, D, E\}$ (superkey)
- $C^+ = \{C\}$

## First Normal Form (1NF)

**Definition**: A relation is in **First Normal Form** if all attribute values are atomic (indivisible).

### **Requirements**

1. **Atomic Values**: Each cell contains a single, indivisible value
2. **No Repeating Groups**: No arrays or lists within attributes
3. **Single-valued Attributes**: Each attribute has one value per tuple
4. **Unique Rows**: Each tuple is unique (has a primary key)
5. **Consistent Types**: Each column contains values of the same data type

### **Example Violation**

**Students** relation (NOT in 1NF):

| StudentID | Name  | PhoneNumbers          | Courses              |
|-----------|-------|-----------------------|----------------------|
| 1001      | Alice | 555-1234, 555-5678   | CS101, CS102, CS201  |
| 1002      | Bob   | 555-9999             | CS101, MATH201       |

**Problems:**
- PhoneNumbers contains multiple values in one cell
- Courses contains a list/array of course IDs
- Cannot easily query or manipulate individual phone numbers or courses

### **Converting to 1NF**

**Approach 1: Separate Rows**

**Students** (in 1NF):

| StudentID | Name  | PhoneNumber | Course  |
|-----------|-------|-------------|---------|
| 1001      | Alice | 555-1234    | CS101   |
| 1001      | Alice | 555-1234    | CS102   |
| 1001      | Alice | 555-1234    | CS201   |
| 1001      | Alice | 555-5678    | CS101   |
| 1001      | Alice | 555-5678    | CS102   |
| 1001      | Alice | 555-5678    | CS201   |
| 1002      | Bob   | 555-9999    | CS101   |
| 1002      | Bob   | 555-9999    | MATH201 |

**Problem**: Massive redundancy (Alice's name repeated many times)

**Approach 2: Decomposition (Better)**

**Students**(StudentID, Name)
**StudentPhones**(StudentID, PhoneNumber)
**Enrollments**(StudentID, Course)

This eliminates redundancy while maintaining 1NF.

## Second Normal Form (2NF)

**Definition**: A relation is in **Second Normal Form** if it is in 1NF and has no partial dependencies (every non-key attribute is fully functionally dependent on the entire primary key).

### **Requirements**

1. **Must be in 1NF**
2. **No Partial Dependencies**: No non-key attribute depends on only part of a composite key
3. **Full Functional Dependency**: All non-key attributes depend on the complete primary key

### **When 2NF Applies**

- **Relevant** when relation has a composite primary key (multiple attributes)
- **Automatically satisfied** if primary key is a single attribute
- **Focus** on dependencies between key parts and non-key attributes

### **Example Violation**

**CourseEnrollments** (NOT in 2NF):

| StudentID | CourseID | StudentName | StudentMajor | CourseName | Instructor | Grade |
|-----------|----------|-------------|--------------|------------|------------|-------|
| 1001      | CS101    | Alice       | CS           | Intro to CS| Dr. Smith  | A     |
| 1001      | CS102    | Alice       | CS           | Data Struct| Dr. Jones  | B     |
| 1002      | CS101    | Bob         | Math         | Intro to CS| Dr. Smith  | A     |

**Primary Key**: {StudentID, CourseID}

**Functional Dependencies:**
- StudentID $\rightarrow$ StudentName, StudentMajor (partial dependency)
- CourseID $\rightarrow$ CourseName, Instructor (partial dependency)
- StudentID, CourseID $\rightarrow$ Grade (full dependency)

**Problems:**
- StudentName and StudentMajor repeated for each course enrollment
- CourseName and Instructor repeated for each student enrolled
- Update, insertion, and deletion anomalies

### **Converting to 2NF**

Decompose to eliminate partial dependencies:

**Students**(StudentID, StudentName, StudentMajor)
- Primary Key: StudentID
- FD: StudentID $\rightarrow$ StudentName, StudentMajor

**Courses**(CourseID, CourseName, Instructor)
- Primary Key: CourseID
- FD: CourseID $\rightarrow$ CourseName, Instructor

**Enrollments**(StudentID, CourseID, Grade)
- Primary Key: {StudentID, CourseID}
- FD: StudentID, CourseID $\rightarrow$ Grade
- Foreign Keys: StudentID references Students, CourseID references Courses

**Benefits:**
- No partial dependencies
- Student and course information stored once
- No redundancy for non-key attributes

## Third Normal Form (3NF)

**Definition**: A relation is in **Third Normal Form** if it is in 2NF and has no transitive dependencies (non-key attributes depend only on the key, not on other non-key attributes).

### **Requirements**

1. **Must be in 2NF**
2. **No Transitive Dependencies**: Non-key attributes cannot depend on other non-key attributes
3. **Alternative Definition**: For every non-trivial FD $X \rightarrow Y$:
   - Either $X$ is a superkey, or
   - $Y$ is part of a candidate key (prime attribute)

### **Transitive Dependency**

If $X \rightarrow Y$ and $Y \rightarrow Z$ where:
- $X$ is the primary key
- $Y$ is a non-key attribute
- $Z$ is a non-key attribute
- $Y$ does not determine $X$ (not a candidate key)

Then $Z$ has a transitive dependency on $X$ through $Y$.

### **Example Violation**

**Employees** (NOT in 3NF):

| EmployeeID | Name    | Department | DepartmentHead | Office    |
|------------|---------|------------|----------------|-----------|
| E001       | Alice   | CS         | Dr. Johnson    | Room 301  |
| E002       | Bob     | CS         | Dr. Johnson    | Room 301  |
| E003       | Carol   | Math       | Dr. Williams   | Room 205  |
| E004       | David   | Math       | Dr. Williams   | Room 205  |

**Primary Key**: EmployeeID

**Functional Dependencies:**
- EmployeeID $\rightarrow$ Name, Department (good)
- Department $\rightarrow$ DepartmentHead, Office (transitive!)
- Therefore: EmployeeID $\rightarrow$ Department $\rightarrow$ DepartmentHead, Office

**Problems:**
- DepartmentHead and Office repeated for all employees in same department
- If department head changes, must update multiple rows
- Cannot store department information without an employee

### **Converting to 3NF**

Decompose to eliminate transitive dependencies:

**Employees**(EmployeeID, Name, Department)
- Primary Key: EmployeeID
- FD: EmployeeID $\rightarrow$ Name, Department
- Foreign Key: Department references Departments

**Departments**(Department, DepartmentHead, Office)
- Primary Key: Department
- FD: Department $\rightarrow$ DepartmentHead, Office

**Benefits:**
- No transitive dependencies
- Department information stored once
- Can store departments without employees
- Updates to department data affect single row

### **3NF Decomposition Algorithm**

**Algorithm: 3NF Synthesis**
```
Input: Relation R, set of FDs F
Output: Set of relations in 3NF

1. Find minimal cover (canonical cover) of F
2. For each FD X → Y in minimal cover:
   3. Create relation with attributes X ∪ Y
4. If no relation contains a candidate key of R:
   5. Create relation with attributes of a candidate key
6. Eliminate redundant relations
```

**Properties:**
- Guarantees lossless join
- Guarantees dependency preservation
- May not achieve BCNF

## Boyce-Codd Normal Form (BCNF)

**Definition**: A relation is in **Boyce-Codd Normal Form** if for every non-trivial functional dependency $X \rightarrow Y$, $X$ is a superkey.

### **Requirements**

1. **Must be in 3NF** (usually)
2. **Superkey Requirement**: For each non-trivial FD $X \rightarrow Y$:
   - $X$ must be a superkey (can determine all attributes)
3. **Stricter than 3NF**: Eliminates all anomalies based on functional dependencies

### **Difference from 3NF**

**3NF allows**: $X \rightarrow Y$ where $Y$ is part of a candidate key (prime attribute), even if $X$ is not a superkey

**BCNF requires**: $X$ must always be a superkey (no exceptions)

### **Example Violation**

**CourseSchedule** (in 3NF but NOT in BCNF):

| StudentID | CourseTime | Room  | Instructor |
|-----------|------------|-------|------------|
| 1001      | Mon 9AM    | R101  | Dr. Smith  |
| 1002      | Mon 9AM    | R101  | Dr. Smith  |
| 1003      | Mon 10AM   | R205  | Dr. Jones  |
| 1001      | Wed 2PM    | R101  | Dr. Smith  |

**Candidate Keys**: 
- {StudentID, CourseTime}
- {StudentID, Room, Instructor} (assuming student can only be in one place)

**Functional Dependencies:**
- StudentID, CourseTime $\rightarrow$ Room, Instructor (superkey ✓)
- Room, CourseTime $\rightarrow$ Instructor (not a superkey, but Instructor is prime)
- **Instructor $\rightarrow$ Room** (instructor always teaches in same room)

**Problem**: 
- Instructor $\rightarrow$ Room, but Instructor is NOT a superkey
- Violates BCNF (though satisfies 3NF because Room is part of candidate key)
- Causes redundancy: Room repeated for each class by instructor

### **Converting to BCNF**

**Decomposition Process:**
1. Find FD $X \rightarrow Y$ that violates BCNF ($X$ not a superkey)
2. Create two relations:
   - $R_1$(X, Y) - the violating dependency
   - $R_2$(X, Z) - where Z = all attributes in R except those in Y not in X
3. Repeat for each resulting relation until all are in BCNF

**BCNF Solution:**

**InstructorRooms**(Instructor, Room)
- Primary Key: Instructor
- FD: Instructor $\rightarrow$ Room

**Schedule**(StudentID, CourseTime, Instructor)
- Primary Key: {StudentID, CourseTime}
- FDs: StudentID, CourseTime $\rightarrow$ Instructor
- Foreign Key: Instructor references InstructorRooms

**Benefits:**
- All functional dependencies have superkeys on left side
- No redundancy based on functional dependencies
- Eliminates anomalies from Instructor → Room

### **BCNF Decomposition Algorithm**

```
Algorithm: BCNF Decomposition
Input: Relation R with attributes A, set of FDs F
Output: Set of relations in BCNF

1. If R is in BCNF, return {R}
2. Find an FD X → Y that violates BCNF (X is not a superkey)
3. Decompose R into:
   - R1 = X ∪ Y
   - R2 = X ∪ (R - Y)
4. Recursively apply algorithm to R1 and R2
5. Return union of results
```

**Trade-offs:**
- **Lossless Join**: Always guaranteed
- **Dependency Preservation**: May be lost (cannot always check all original FDs)
- **Anomaly Elimination**: Complete for functional dependency anomalies

## Multivalued Dependencies

**Multivalued dependencies** (MVDs) are the foundation for Fourth Normal Form. They express relationships where one attribute determines a set of values for another attribute, independent of other attributes.

### **Definition**

A multivalued dependency $X \twoheadrightarrow Y$ holds in relation $R$ if:
- For any tuples $t_1$ and $t_2$ with $t_1[X] = t_2[X]$
- There exist tuples $t_3$ and $t_4$ in $R$ such that:
  - $t_3[X] = t_4[X] = t_1[X] = t_2[X]$
  - $t_3[Y] = t_1[Y]$ and $t_4[Y] = t_2[Y]$
  - $t_3[Z] = t_2[Z]$ and $t_4[Z] = t_1[Z]$ (where $Z = R - X - Y$)

**Intuitive Meaning**: The set of $Y$ values matching an $X$ value is independent of the values of other attributes.

### **Types of Multivalued Dependencies**

**1. Trivial MVD**
- $X \twoheadrightarrow Y$ where $Y \subseteq X$ or $XY = R$ (all attributes)
- Always satisfied
- Not useful for normalization

**2. Non-trivial MVD**
- $X \twoheadrightarrow Y$ where $Y \not\subseteq X$ and $XY \neq R$
- Indicates actual independence between attribute sets
- Causes redundancy requiring 4NF decomposition

**3. Functional Dependency as MVD**
- Every FD is also an MVD: If $X \rightarrow Y$, then $X \twoheadrightarrow Y$
- But not all MVDs are FDs
- FDs are a special case of MVDs

### **Example of Multivalued Dependency**

**Instructors**:

| InstructorID | Course  | Textbook    |
|--------------|---------|-------------|
| 101          | CS101   | Book A      |
| 101          | CS101   | Book B      |
| 101          | CS102   | Book A      |
| 101          | CS102   | Book B      |
| 102          | CS101   | Book C      |
| 102          | CS103   | Book C      |

**Analysis:**
- Instructor 101 teaches courses {CS101, CS102}
- Instructor 101 uses textbooks {Book A, Book B}
- Courses and textbooks are independent (any combination exists)
- Must store all combinations (Cartesian product)

**Multivalued Dependencies:**
- InstructorID $\twoheadrightarrow$ Course
- InstructorID $\twoheadrightarrow$ Textbook

**Problems:**
- Adding new course for instructor requires adding rows for all textbooks
- Adding new textbook requires adding rows for all courses
- Massive redundancy for instructors with many courses and textbooks

### **MVD Inference Rules**

**1. Complementation**
$$\text{If } X \twoheadrightarrow Y, \text{ then } X \twoheadrightarrow (R - X - Y)$$

**2. Augmentation**
$$\text{If } X \twoheadrightarrow Y \text{ and } W \supseteq Z, \text{ then } WX \twoheadrightarrow YZ$$

**3. Transitivity**
$$\text{If } X \twoheadrightarrow Y \text{ and } Y \twoheadrightarrow Z, \text{ then } X \twoheadrightarrow (Z - Y)$$

**4. FD Promotion**
$$\text{If } X \rightarrow Y, \text{ then } X \twoheadrightarrow Y$$

**5. Replication**
$$\text{If } X \rightarrow Y, \text{ then } X \twoheadrightarrow Z \text{ for any } Z$$

## Fourth Normal Form (4NF)

**Definition**: A relation is in **Fourth Normal Form** if it is in BCNF and has no non-trivial multivalued dependencies that are not functional dependencies.

### **Requirements**

1. **Must be in BCNF**
2. **No Non-trivial MVDs**: For every non-trivial MVD $X \twoheadrightarrow Y$:
   - $X$ must be a superkey, or
   - The MVD is actually a functional dependency

### **When 4NF Applies**

- Relevant when relation has independent multi-valued facts
- Addresses redundancy not handled by BCNF
- Common in relations with multiple many-to-many relationships

### **Example Violation**

**Instructors** (in BCNF but NOT in 4NF):

| InstructorID | Course  | Textbook    |
|--------------|---------|-------------|
| 101          | CS101   | Book A      |
| 101          | CS101   | Book B      |
| 101          | CS102   | Book A      |
| 101          | CS102   | Book B      |

**Primary Key**: {InstructorID, Course, Textbook}

**Multivalued Dependencies:**
- InstructorID $\twoheadrightarrow$ Course (independent of Textbook)
- InstructorID $\twoheadrightarrow$ Textbook (independent of Course)

**Problem**: 
- InstructorID is not a superkey
- MVDs are not functional dependencies
- Violates 4NF
- Cartesian product redundancy

### **Converting to 4NF**

Decompose based on multivalued dependencies:

**InstructorCourses**(InstructorID, Course)
- Primary Key: {InstructorID, Course}
- MVD: InstructorID $\twoheadrightarrow$ Course becomes trivial

**InstructorTextbooks**(InstructorID, Textbook)
- Primary Key: {InstructorID, Textbook}
- MVD: InstructorID $\twoheadrightarrow$ Textbook becomes trivial

**Benefits:**
- Each independent fact stored separately
- Adding course doesn't require adding textbook combinations
- Adding textbook doesn't require adding course combinations
- Eliminates Cartesian product redundancy

### **4NF Decomposition Algorithm**

```
Algorithm: 4NF Decomposition
Input: Relation R with attributes A, set of MVDs M
Output: Set of relations in 4NF

1. If R is in 4NF, return {R}
2. Find non-trivial MVD X ⤏ Y that violates 4NF (X not a superkey)
3. Decompose R into:
   - R1 = X ∪ Y
   - R2 = X ∪ (R - Y)
4. Recursively apply algorithm to R1 and R2
5. Return union of results
```

**Properties:**
- **Lossless Join**: Always guaranteed
- **Dependency Preservation**: May be lost for some MVDs
- **Eliminates MVD Anomalies**: Complete for multivalued dependency anomalies

## Comparison of Normal Forms

| Normal Form | Based On | Requirement | Allows |
|-------------|----------|-------------|--------|
| **1NF** | Basic structure | Atomic values | Any dependencies |
| **2NF** | FDs | No partial dependencies | Transitive dependencies |
| **3NF** | FDs | No transitive dependencies | Some non-superkey determinants if prime |
| **BCNF** | FDs | All determinants are superkeys | MVD anomalies |
| **4NF** | MVDs | No non-trivial MVDs unless superkey | Join dependencies |

### **Progressive Refinement**

$$\text{1NF} \subseteq \text{2NF} \subseteq \text{3NF} \subseteq \text{BCNF} \subseteq \text{4NF}$$

- Each higher form is more restrictive
- Each higher form eliminates more anomalies
- Each higher form may require more decomposition

### **When to Use Each Form**

**1NF**: Minimum requirement for relational databases
- Must eliminate multi-valued attributes
- Foundation for all other forms

**2NF**: For relations with composite keys
- Eliminates partial dependency redundancy
- Usually easy to achieve

**3NF**: Standard for most business applications
- Eliminates transitive dependency redundancy
- Good balance of normalization and practicality
- Preserves dependencies

**BCNF**: When complete FD anomaly elimination needed
- Stricter than 3NF
- May lose dependency preservation
- Ideal for critical data integrity

**4NF**: When independent multi-valued facts exist
- Eliminates MVD redundancy
- Required for relations with multiple many-to-many relationships
- Prevents Cartesian product redundancy

## Key Features

### **Systematic Approach**
- Progressive refinement through normal forms
- Clear criteria for each level
- Mathematical foundation (FDs and MVDs)
- Algorithmic decomposition processes

### **Anomaly Prevention**
- Each form eliminates specific anomalies
- Higher forms provide stronger guarantees
- Reduces redundancy systematically
- Maintains data consistency

### **Flexibility & Trade-offs**
- Choose appropriate normal form for use case
- Balance normalization with performance
- Consider dependency preservation needs
- Evaluate lossless join requirements

## Important Notes

- **Not Always Necessary**: Not all relations need highest normal form
- **Context Matters**: Business requirements guide normalization level
- **Performance Trade-offs**: Higher normalization may increase joins
- **Dependency Preservation**: BCNF and 4NF may lose this property
- **Practical Balance**: 3NF often sufficient for most applications

## Related Concepts

- **[[Functional Dependencies]]**: Foundation for 1NF through BCNF normalization
- **[[Boyce-Codd Normal Form]]**: Dedicated treatment of the strictest FD-based normal form
- **[[Multivalued Dependencies]]**: Foundation for 4NF and higher normal forms
- **[[Relational Design]]**: Overall process using normal forms
- **[[Relational Database]]**: Database systems that implement normal forms
- **[[Decomposition]]**: Technique for achieving normal forms
- **[[Schema]]**: Result of normalization process
- **[[Relation]]**: Structure being normalized
- **[[Attribute]]**: Elements involved in dependencies
