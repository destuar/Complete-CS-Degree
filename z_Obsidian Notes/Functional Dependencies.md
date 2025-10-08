# Functional Dependencies

A **Functional Dependency** (FD) is a constraint between two sets of attributes in a relational database that expresses a deterministic relationship: if two tuples agree on one set of attributes, they must agree on another set. Functional dependencies are fundamental to database design, normalization, data compression, and query optimization.

## Basic Definition

A functional dependency $X \rightarrow Y$ (read "$X$ functionally determines $Y$" or "$Y$ is functionally dependent on $X$") means:

- **$X$ and $Y$ are sets of attributes** in relation $R$
- **For any two tuples $t_1$ and $t_2$ in $R$**:
  - If $t_1[X] = t_2[X]$, then $t_1[Y] = t_2[Y]$
- **Deterministic relationship**: Knowing $X$ uniquely determines $Y$
- **Constraint**: Must hold for all instances of the relation

## Mathematical Foundation

### **Formal Definition**

Let $R$ be a relation schema with attributes $\text{attr}(R)$.

A functional dependency $X \rightarrow Y$ holds on $R$ if:
$$\forall t_1, t_2 \in R: t_1[X] = t_2[X] \Rightarrow t_1[Y] = t_2[Y]$$

Where:
- $X, Y \subseteq \text{attr}(R)$
- $t_1[X]$ denotes the values of attributes $X$ in tuple $t_1$
- The implication must hold for every valid instance of $R$

### **Notation & Terminology**

- **$X \rightarrow Y$**: $X$ functionally determines $Y$
- **Left-hand side (LHS)**: $X$ is the **determinant**
- **Right-hand side (RHS)**: $Y$ is the **dependent**
- **Composite FD**: When $X$ or $Y$ contains multiple attributes
- **Set notation**: $\{A, B\} \rightarrow \{C, D\}$ or simply $AB \rightarrow CD$

### **Examples**

**Students**(StudentID, Name, Major, Advisor, GPA)

Valid functional dependencies:
- StudentID $\rightarrow$ Name (each student ID determines one name)
- StudentID $\rightarrow$ Major (each student has one major)
- StudentID $\rightarrow$ Name, Major, Advisor, GPA (ID determines all attributes)
- StudentID, CourseID $\rightarrow$ Grade (composite determinant)

Invalid examples:
- Major $\rightarrow$ StudentID (many students can have same major)
- GPA $\rightarrow$ Name (multiple students can have same GPA)

## Types of Functional Dependencies

### **Trivial Functional Dependency**

**Definition**: $X \rightarrow Y$ is trivial if $Y \subseteq X$ (the right side is a subset of the left side).

**Properties**:
- Always satisfied by definition
- Not useful for database design or normalization
- Can be derived from reflexivity axiom

**Examples**:
- StudentID, Name $\rightarrow$ Name (trivial)
- StudentID, Name $\rightarrow$ StudentID (trivial)
- ABC $\rightarrow$ A, AB, B, C, ABC (all trivial)

### **Non-trivial Functional Dependency**

**Definition**: $X \rightarrow Y$ is non-trivial if $Y \not\subseteq X$ (right side is not a subset of left side).

**Properties**:
- Represents actual business rules and constraints
- Important for normalization and design
- Guides decomposition decisions

**Examples**:
- StudentID $\rightarrow$ Name, Major (non-trivial)
- CourseID $\rightarrow$ CourseName, Credits (non-trivial)

**Completely Non-trivial**: $X \rightarrow Y$ where $X \cap Y = \emptyset$ (no overlap)
- StudentID $\rightarrow$ Name (completely non-trivial)
- Most useful form for analysis

### **Partial Dependency**

**Definition**: Non-key attribute depends on a proper subset of a composite candidate key.

**Form**: $X \rightarrow Y$ where:
- $X$ is a proper subset of a candidate key $K$ (i.e., $X \subset K$)
- $Y$ is a non-key attribute

**Example**:

**Enrollments**(StudentID, CourseID, StudentName, Grade)
- Candidate key: {StudentID, CourseID}
- StudentID $\rightarrow$ StudentName (partial dependency)
- Violates Second Normal Form (2NF)

**Problems**:
- Causes redundancy (StudentName repeated for each course)
- Update anomalies (changing name requires multiple updates)
- Requires decomposition to eliminate

### **Full Functional Dependency**

**Definition**: $Y$ is fully functionally dependent on $X$ if $Y$ depends on all of $X$ and not on any proper subset of $X$.

**Form**: $X \rightarrow Y$ where:
- For every proper subset $X' \subset X$: $X' \not\rightarrow Y$
- $Y$ requires the complete set $X$

**Example**:

**Enrollments**(StudentID, CourseID, Grade)
- StudentID, CourseID $\rightarrow$ Grade (full dependency)
- StudentID $\not\rightarrow$ Grade and CourseID $\not\rightarrow$ Grade
- Required for Second Normal Form

### **Transitive Dependency**

**Definition**: $X \rightarrow Z$ exists indirectly through an intermediate attribute set $Y$.

**Form**: If $X \rightarrow Y$ and $Y \rightarrow Z$ where:
- $X$ is typically a key
- $Y$ is a non-key attribute
- $Z$ is a non-key attribute
- $Y \not\rightarrow X$ (Y doesn't determine X)

**Example**:

**Students**(StudentID, Major, DepartmentBuilding)
- StudentID $\rightarrow$ Major (direct)
- Major $\rightarrow$ DepartmentBuilding (direct)
- StudentID $\rightarrow$ DepartmentBuilding (transitive)
- Violates Third Normal Form (3NF)

**Problems**:
- Causes redundancy (DepartmentBuilding repeated for each student in major)
- Update anomalies
- Deletion anomalies (deleting all students in major loses building information)

## Armstrong's Axioms

**Armstrong's Axioms** are inference rules that allow deriving new functional dependencies from existing ones. They are **sound** (only derive valid FDs) and **complete** (can derive all valid FDs).

### **Primary Axioms**

**1. Reflexivity (Trivial Rule)**
$$\text{If } Y \subseteq X, \text{ then } X \rightarrow Y$$

- Any set of attributes determines its subsets
- Basis for trivial dependencies

**Example**: {StudentID, Name} $\rightarrow$ Name

**2. Augmentation**
$$\text{If } X \rightarrow Y, \text{ then } XZ \rightarrow YZ \text{ for any set } Z$$

- Adding attributes to both sides preserves dependency
- Can extend dependencies with additional attributes

**Example**: 
- Given: StudentID $\rightarrow$ Major
- Derive: StudentID, CourseID $\rightarrow$ Major, CourseID

**3. Transitivity**
$$\text{If } X \rightarrow Y \text{ and } Y \rightarrow Z, \text{ then } X \rightarrow Z$$

- Dependencies chain together
- Foundation of transitive dependencies

**Example**:
- Given: StudentID $\rightarrow$ Major, Major $\rightarrow$ Building
- Derive: StudentID $\rightarrow$ Building

### **Derived Rules**

**4. Union (Additive)**
$$\text{If } X \rightarrow Y \text{ and } X \rightarrow Z, \text{ then } X \rightarrow YZ$$

- Combine multiple dependencies with same left side

**Proof**:
1. $X \rightarrow Y$ (given)
2. $XZ \rightarrow YZ$ (augmentation with $Z$)
3. $X \rightarrow Z$ (given)
4. $XY \rightarrow ZY$ (augmentation with $Y$)
5. $X \rightarrow YZ$ (combining)

**Example**:
- Given: StudentID $\rightarrow$ Name, StudentID $\rightarrow$ Major
- Derive: StudentID $\rightarrow$ Name, Major

**5. Decomposition (Splitting)**
$$\text{If } X \rightarrow YZ, \text{ then } X \rightarrow Y \text{ and } X \rightarrow Z$$

- Split right side into individual attributes or sets

**Proof**:
1. $X \rightarrow YZ$ (given)
2. $YZ \subseteq YZ$ (reflexivity)
3. $YZ \rightarrow Y$ (reflexivity)
4. $X \rightarrow Y$ (transitivity of 1 and 3)
5. Similarly for $X \rightarrow Z$

**Example**:
- Given: StudentID $\rightarrow$ Name, Major, GPA
- Derive: StudentID $\rightarrow$ Name, StudentID $\rightarrow$ Major, StudentID $\rightarrow$ GPA

**6. Pseudotransitivity**
$$\text{If } X \rightarrow Y \text{ and } YZ \rightarrow W, \text{ then } XZ \rightarrow W$$

- Combination of transitivity and augmentation

**Proof**:
1. $X \rightarrow Y$ (given)
2. $XZ \rightarrow YZ$ (augmentation)
3. $YZ \rightarrow W$ (given)
4. $XZ \rightarrow W$ (transitivity)

### **Using Armstrong's Axioms**

**Closure Computation**: Find all attributes determined by a set
**Minimal Cover**: Simplify a set of FDs to canonical form
**Equivalence Testing**: Check if two FD sets are equivalent
**Key Finding**: Identify candidate keys from FDs

## Closure of Attributes

The **closure** of a set of attributes $X$, denoted $X^+$, is the set of all attributes that can be functionally determined by $X$ using a given set of functional dependencies $F$.

### **Definition**

$$X^+ = \{A \mid X \rightarrow A \text{ can be inferred from } F\}$$

### **Algorithm**

```
Algorithm: Compute_Closure(X, F)
Input: Set of attributes X, set of FDs F
Output: X+ (closure of X under F)

1. Result = X
2. Repeat until Result doesn't change:
   3.   For each FD Y → Z in F:
   4.      If Y ⊆ Result:
   5.         Result = Result ∪ Z
6. Return Result
```

**Time Complexity**: $O(|F| \times |R|)$ where $|F|$ is number of FDs and $|R|$ is number of attributes

### **Example Computation**

Given relation $R(A, B, C, D, E)$ with FDs:
- $F = \{A \rightarrow B, B \rightarrow C, CD \rightarrow E\}$

**Compute $\{A, D\}^+$:**

**Iteration 1:**
- Start: Result = {A, D}
- Check $A \rightarrow B$: A ⊆ {A, D}, so Result = {A, B, D}
- Check $B \rightarrow C$: B ⊆ {A, B, D}, so Result = {A, B, C, D}
- Check $CD \rightarrow E$: CD ⊆ {A, B, C, D}, so Result = {A, B, C, D, E}

**Result**: $\{A, D\}^+ = \{A, B, C, D, E\}$ (all attributes, so {A, D} is a superkey)

### **Applications of Closure**

**1. Testing if X is a superkey**
- Compute $X^+$
- If $X^+ = $ all attributes in $R$, then $X$ is a superkey

**2. Testing if X → Y holds**
- Compute $X^+$
- If $Y \subseteq X^+$, then $X \rightarrow Y$ holds

**3. Finding candidate keys**
- Find minimal sets $X$ where $X^+ = $ all attributes
- No proper subset of $X$ should be a superkey

**4. Testing FD equivalence**
- Two FD sets $F$ and $G$ are equivalent if:
- Every FD in $F$ can be inferred from $G$
- Every FD in $G$ can be inferred from $F$

## Data Storage & Compression

Functional dependencies provide opportunities for data compression and efficient storage by eliminating redundancy.

### **Redundancy from FDs**

**Problem**: When $X \rightarrow Y$, storing both $X$ and $Y$ for every tuple causes redundancy.

**Example**:

**Orders**(OrderID, CustomerID, CustomerName, CustomerAddress)
- CustomerID $\rightarrow$ CustomerName, CustomerAddress

| OrderID | CustomerID | CustomerName | CustomerAddress |
|---------|------------|--------------|-----------------|
| 1001    | C001       | Alice        | 123 Main St     |
| 1002    | C001       | Alice        | 123 Main St     |
| 1003    | C002       | Bob          | 456 Oak Ave     |
| 1004    | C001       | Alice        | 123 Main St     |

**Redundancy**: Alice's name and address repeated in 3 rows (wasted storage)

### **Compression through Normalization**

**Solution**: Decompose based on functional dependencies.

**Customers**(CustomerID, CustomerName, CustomerAddress)
- Stores each customer once
- CustomerID $\rightarrow$ CustomerName, CustomerAddress enforced

**Orders**(OrderID, CustomerID)
- Stores only OrderID and CustomerID reference
- Significantly smaller storage

**Storage Savings**:
- Original: 4 rows × (OrderID + CustomerID + Name + Address)
- Decomposed: 2 customers × (ID + Name + Address) + 4 orders × (OrderID + CustomerID)
- Savings increase with more orders per customer

### **Columnar Storage & FDs**

**Column-oriented databases** leverage functional dependencies:

**Dictionary Encoding**:
- When $X \rightarrow Y$ and $X$ has few distinct values
- Store $Y$ values once in dictionary
- Store only $X$ values (or codes) in main table

**Example**: State $\rightarrow$ Country, Timezone
- Store {State → Country} mapping once
- Reference state codes in main table
- Massive compression for large datasets

### **Normalized vs. Denormalized Storage**

**Normalized (Compressed)**:
- Respect functional dependencies
- Minimal redundancy
- Smaller storage footprint
- More joins required for queries

**Denormalized (Fast Access)**:
- Intentionally violate FDs for performance
- Store redundant data
- Larger storage, but faster reads
- Common in data warehousing

**Trade-off Decision Factors**:
- Storage cost vs. query performance
- Update frequency (normalized better for frequent updates)
- Query patterns (denormalized better for complex joins)
- Data volume (compression more valuable for large datasets)

## Query Reasoning & Optimization

Functional dependencies enable powerful query optimizations and reasoning about query equivalence and results.

### **Query Rewriting**

**Using FDs to simplify queries:**

**Example FD**: StudentID $\rightarrow$ Name, Major

**Original Query**:
```sql
SELECT DISTINCT StudentID, Name
FROM Students
WHERE Major = 'CS';
```

**Optimized Query** (using FD):
```sql
SELECT StudentID, Name
FROM Students
WHERE Major = 'CS';
```

**Reasoning**: Since StudentID $\rightarrow$ Name, each StudentID has exactly one Name, so DISTINCT is redundant.

### **Join Elimination**

**Using FDs to eliminate unnecessary joins:**

**FDs**: 
- OrderID $\rightarrow$ CustomerID
- CustomerID $\rightarrow$ CustomerName

**Query**:
```sql
SELECT o.OrderID, c.CustomerName
FROM Orders o
JOIN Customers c ON o.CustomerID = c.CustomerID
WHERE o.OrderID = 1001;
```

**Observation**: Since we're selecting by OrderID, and OrderID $\rightarrow$ CustomerID $\rightarrow$ CustomerName, we can potentially cache or precompute this.

### **Query Result Size Estimation**

**Using FDs to estimate result cardinality:**

Given:
- Table has $N$ rows
- Query filters on attribute $X$
- $X$ has $d$ distinct values
- FD: $X \rightarrow Y$

**Estimation**:
- Result size for `SELECT Y WHERE X = v` ≈ $N/d$ rows
- All result tuples have same $Y$ value (due to FD)
- Helps optimizer choose join order and methods

### **Semantic Query Optimization**

**Using FDs to detect impossible conditions:**

**FD**: StudentID $\rightarrow$ Major

**Query**:
```sql
SELECT *
FROM Students
WHERE StudentID = 1001 
  AND Major = 'CS'
  AND Major = 'Math';
```

**Optimization**: Query returns empty result (no need to execute)
- Each StudentID has exactly one Major (due to FD)
- Cannot be both 'CS' and 'Math'
- Contradiction detected at compile time

### **Projection Optimization**

**FD-based column elimination:**

**FD**: CourseID $\rightarrow$ CourseName, Credits

**Query**:
```sql
SELECT DISTINCT CourseID, CourseName
FROM Courses;
```

**Optimization**:
1. Project only CourseID first
2. Get DISTINCT CourseID values
3. Join back for CourseName (or use index/materialized path)

Since CourseID determines CourseName, we can optimize the distinct operation on fewer columns.

### **Constraint Checking Optimization**

**Using FDs to minimize validation:**

**FD**: ISBN $\rightarrow$ Title, Author, Publisher

**Operation**: INSERT book with ISBN already in database

**Naive**: Check all attributes match existing tuple
**Optimized**: Check only ISBN (FD guarantees others match if ISBN does)

### **Materialized View Maintenance**

**Using FDs to determine which views need updates:**

**Base Table**: Orders(OrderID, CustomerID, Amount)
**FD**: OrderID $\rightarrow$ CustomerID, Amount

**Materialized View**: 
```sql
CREATE VIEW CustomerTotals AS
SELECT CustomerID, SUM(Amount) as Total
FROM Orders
GROUP BY CustomerID;
```

**Update Analysis**:
- INSERT new order: Must update view (adds to customer total)
- UPDATE OrderID: Not possible (OrderID is key)
- UPDATE CustomerID: Must update view (changes customer association)
- UPDATE Amount: Must update view (changes sum)

FDs help identify exactly which view maintenance is needed.

## Boyce-Codd Normal Form (BCNF)

Functional dependencies are the foundation of BCNF, the strictest normal form based solely on FDs.

### **BCNF Definition**

A relation $R$ is in **Boyce-Codd Normal Form** (BCNF) if for every non-trivial functional dependency $X \rightarrow Y$:
$$X \text{ is a superkey of } R$$

**Equivalent Statement**: Every determinant must be a superkey.

### **BCNF vs. 3NF**

**3NF allows exception**: $X \rightarrow Y$ where $Y$ is part of a candidate key (prime attribute), even if $X$ is not a superkey

**BCNF has no exception**: $X$ must always be a superkey

**Consequence**: BCNF is stricter; some 3NF relations are not in BCNF

### **Testing for BCNF**

**Algorithm**:
```
For each non-trivial FD X → Y:
   Compute X+
   If X+ ≠ all attributes:
      R is not in BCNF
      X → Y is a BCNF violation
Return "R is in BCNF"
```

### **BCNF Violation Example**

**Relation**: CourseSchedule(Student, Time, Room, Instructor)

**FDs**:
- Student, Time $\rightarrow$ Room, Instructor
- Instructor $\rightarrow$ Room (instructor always uses same room)

**Candidate Keys**:
- {Student, Time}
- Other combinations if instructor and time can be keys in certain scenarios

**BCNF Analysis**:
- FD: Instructor $\rightarrow$ Room
- Instructor is NOT a superkey (doesn't determine all attributes)
- **Violates BCNF**

**Problems from Violation**:
- Redundancy: Room repeated for each class instructor teaches
- Update anomaly: Changing instructor's room requires multiple updates
- Insertion anomaly: Cannot store instructor's room without a class
- Deletion anomaly: Deleting all classes loses instructor-room mapping

### **BCNF Decomposition**

**Algorithm**:
```
BCNF_Decompose(R, F):
   If R is in BCNF:
      Return {R}
   
   Find X → Y that violates BCNF (X is not a superkey)
   
   Compute X+
   
   Create R1 = X+
   Create R2 = X ∪ (R - X+)
   
   Recursively decompose R1 and R2
   
   Return union of results
```

**Example Decomposition**:

**Original**: CourseSchedule(Student, Time, Room, Instructor)

**Step 1**: Identify violation: Instructor $\rightarrow$ Room

**Step 2**: Compute Instructor+ = {Instructor, Room}

**Step 3**: Create relations:
- R1 = InstructorRooms(Instructor, Room)
- R2 = Schedule(Student, Time, Instructor)

**Verify BCNF**:
- InstructorRooms: Instructor $\rightarrow$ Room, Instructor is key ✓
- Schedule: Student, Time $\rightarrow$ Instructor, {Student, Time} is key ✓

### **Properties of BCNF Decomposition**

**Lossless Join**: Always guaranteed
- Can reconstruct original relation by joining decomposed relations
- $R_1 \bowtie R_2 = R$ (original relation)

**Dependency Preservation**: Not always guaranteed
- Some FDs may require joins to check
- Trade-off: BCNF eliminates anomalies but may lose dependency checking

**Anomaly Elimination**: Complete for FD-based anomalies
- BCNF relations have no redundancy from functional dependencies
- All update, insertion, deletion anomalies from FDs eliminated

### **When to Use BCNF**

**Use BCNF when**:
- Data integrity is critical
- Update anomalies must be completely eliminated
- Storage efficiency is important
- Dependency preservation can be sacrificed

**Consider alternatives (3NF) when**:
- Dependency preservation is required
- Some redundancy is acceptable for performance
- Application can handle constraint checking via joins

## Important Notes

- **Not Always Explicit**: FDs must be identified from business rules and data semantics
- **Instance vs. Schema**: FDs are schema constraints, not instance properties
- **Verification**: Testing FDs requires understanding domain, not just examining data
- **Trade-offs**: Complete normalization (BCNF) may sacrifice dependency preservation
- **Context Matters**: Appropriate normalization level depends on use case

## Related Concepts

- **[[Normal Form]]**: Progressive levels of normalization using FDs
- **[[Relational Design]]**: Overall design process guided by FDs
- **[[Decomposition]]**: Technique for achieving normal forms
- **[[Relation]]**: Structure constrained by FDs
- **[[Attribute]]**: Elements involved in functional dependencies
- **[[Schema]]**: Formal specification including FDs
- **[[Database Management System (DBMS)]]**: System enforcing FDs
