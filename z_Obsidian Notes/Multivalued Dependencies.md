# Multivalued Dependencies

A **Multivalued Dependency** (MVD) is a constraint between sets of attributes in a relational database where one attribute determines a set of values for another attribute, independent of other attributes in the relation. Multivalued dependencies are the foundation for Fourth Normal Form (4NF) and address redundancy that functional dependencies cannot eliminate.

## Basic Definition

A multivalued dependency $X \twoheadrightarrow Y$ (read "$X$ multidetermines $Y$") holds in relation $R$ if:

- **For any two tuples $t_1$ and $t_2$** with the same $X$ values
- **There exist tuples $t_3$ and $t_4$** in $R$ such that:
  - All four tuples agree on $X$ values
  - $t_3$ combines $Y$ values from $t_1$ with other attribute values from $t_2$
  - $t_4$ combines $Y$ values from $t_2$ with other attribute values from $t_1$
- **Independence**: The set of $Y$ values associated with an $X$ value is independent of values in other attributes

## Mathematical Foundation

### **Formal Definition**

Let $R$ be a relation schema with attributes $R = X \cup Y \cup Z$ where $X$, $Y$, and $Z$ are disjoint sets.

A multivalued dependency $X \twoheadrightarrow Y$ holds on $R$ if:

$$\forall t_1, t_2 \in R: \text{if } t_1[X] = t_2[X]$$

$$\text{then } \exists t_3, t_4 \in R \text{ such that:}$$

- $t_3[X] = t_4[X] = t_1[X] = t_2[X]$
- $t_3[Y] = t_1[Y]$ and $t_4[Y] = t_2[Y]$
- $t_3[Z] = t_2[Z]$ and $t_4[Z] = t_1[Z]$

Where $Z = R - X - Y$ (all other attributes)

### **Intuitive Interpretation**

**Key Insight**: The $Y$ values for a given $X$ value exist independently of the $Z$ values.

**Consequence**: If we have all combinations of:
- An $X$ value with its associated $Y$ values
- The same $X$ value with its associated $Z$ values

Then the relation must contain the **Cartesian product** of $Y$ values and $Z$ values for that $X$ value.

### **Notation & Terminology**

- **$X \twoheadrightarrow Y$**: $X$ multidetermines $Y$
- **Left-hand side**: $X$ is the **determinant**
- **Right-hand side**: $Y$ is the **dependent** set
- **Complementary MVD**: If $X \twoheadrightarrow Y$, then $X \twoheadrightarrow Z$ (where $Z = R - X - Y$)

## Relationship to Functional Dependencies

### **Every FD is an MVD**

**Theorem**: If $X \rightarrow Y$, then $X \twoheadrightarrow Y$

**Proof Intuition**:
- If $X$ functionally determines $Y$, then each $X$ value has exactly one $Y$ value
- This single-valued relationship satisfies the MVD definition trivially
- The independence condition holds because there's only one $Y$ value

**Implication**: Functional dependencies are a special case of multivalued dependencies where the "set" of values has size 1.

### **Not All MVDs are FDs**

**Distinction**:
- **FD**: $X \rightarrow Y$ means each $X$ value has exactly **one** $Y$ value
- **MVD**: $X \twoheadrightarrow Y$ means each $X$ value has a **set** of $Y$ values (possibly multiple)

**Example of MVD that is not FD**:
- Person $\twoheadrightarrow$ PhoneNumber (person can have multiple phone numbers)
- Person $\not\rightarrow$ PhoneNumber (not a functional dependency)

## Types of Multivalued Dependencies

### **Trivial Multivalued Dependency**

**Definition**: $X \twoheadrightarrow Y$ is trivial if:
- $Y \subseteq X$ (right side is subset of left side), or
- $X \cup Y = R$ (together they include all attributes)

**Properties**:
- Always satisfied by definition
- Not useful for normalization
- Do not cause redundancy

**Examples**:
- $AB \twoheadrightarrow A$ (trivial, $A \subseteq AB$)
- $AB \twoheadrightarrow ABC$ when $R = \{A, B, C\}$ (trivial, includes all attributes)

### **Non-trivial Multivalued Dependency**

**Definition**: $X \twoheadrightarrow Y$ is non-trivial if:
- $Y \not\subseteq X$ (right side not subset of left side), and
- $X \cup Y \neq R$ (don't include all attributes together)

**Properties**:
- Represents actual independence between attribute sets
- Causes redundancy (Cartesian product effect)
- Requires decomposition to eliminate
- Target for Fourth Normal Form

**Examples**:
- InstructorID $\twoheadrightarrow$ Course (when instructors have multiple courses)
- InstructorID $\twoheadrightarrow$ Textbook (when instructors recommend multiple textbooks)

## MVD Inference Rules

Inference rules allow deriving new multivalued dependencies from existing ones.

### **Complementation Rule**

$$\text{If } X \twoheadrightarrow Y, \text{ then } X \twoheadrightarrow (R - X - Y)$$

**Interpretation**: 
- If $X$ multidetermines $Y$, it also multidetermines all other attributes
- MVDs always come in pairs
- $Y$ and $(R - X - Y)$ are independent given $X$

**Example**:
- Given: InstructorID $\twoheadrightarrow$ Course in R(InstructorID, Course, Textbook)
- Derive: InstructorID $\twoheadrightarrow$ Textbook

### **Augmentation Rule**

$$\text{If } X \twoheadrightarrow Y \text{ and } W \supseteq Z, \text{ then } WX \twoheadrightarrow YZ$$

**Interpretation**: Adding attributes to both sides preserves MVD

**Example**:
- Given: A $\twoheadrightarrow$ B
- Derive: AC $\twoheadrightarrow$ BC (augment both sides with C)

### **Transitivity Rule**

$$\text{If } X \twoheadrightarrow Y \text{ and } Y \twoheadrightarrow Z, \text{ then } X \twoheadrightarrow (Z - Y)$$

**Interpretation**: MVDs chain through intermediate attributes

**Note**: Must remove $Y$ from result to get proper transitive closure

### **Functional Dependency Promotion**

$$\text{If } X \rightarrow Y, \text{ then } X \twoheadrightarrow Y$$

**Interpretation**: Every functional dependency is also a multivalued dependency

**Important**: This allows mixing FDs and MVDs in inference

### **Replication Rule**

$$\text{If } X \rightarrow Y, \text{ then } X \twoheadrightarrow Z \text{ for any set } Z$$

**Interpretation**: If $X$ is a superkey (functionally determines everything), then it multidetermines any subset

## Recognizing Multivalued Dependencies

### **Cartesian Product Pattern**

**Symptom**: Relation contains all combinations of values for independent attributes.

**Example Pattern**:

| X | Y₁ | Y₂ | ... | Z₁ | Z₂ | ... |
|---|----|----|-----|----|----|-----|
| x | y₁ | y₂ | ... | z₁ | z₂ | ... |
| x | y₁ | y₂ | ... | z₃ | z₄ | ... |
| x | y₅ | y₆ | ... | z₁ | z₂ | ... |
| x | y₅ | y₆ | ... | z₃ | z₄ | ... |

**Observation**: For $X = x$, we see all combinations of $(Y₁, Y₂, ...)$ values with $(Z₁, Z₂, ...)$ values.

**Conclusion**: $X \twoheadrightarrow Y$ and $X \twoheadrightarrow Z$ (complementary MVDs)

### **Business Rule Indicators**

**Question to Ask**: "Are these attributes independent given the key?"

**Example Scenarios**:
1. **Instructor teaches multiple courses AND recommends multiple textbooks**
   - Courses and textbooks are independent
   - InstructorID $\twoheadrightarrow$ Course and InstructorID $\twoheadrightarrow$ Textbook

2. **Employee has multiple skills AND multiple certifications**
   - Skills and certifications are independent
   - EmployeeID $\twoheadrightarrow$ Skill and EmployeeID $\twoheadrightarrow$ Certification

3. **Movie has multiple actors AND multiple genres**
   - Actors and genres are independent
   - MovieID $\twoheadrightarrow$ Actor and MovieID $\twoheadrightarrow$ Genre

### **Storage Redundancy Indicator**

**Symptom**: Adding a new value for one attribute requires adding multiple rows.

**Example**:
- Instructor teaches CS101 and CS102
- Instructor uses Book A and Book B
- Current: 4 rows (2 courses × 2 books)
- Add Book C: Must add 2 new rows (one for each course)
- **This indicates MVD**: InstructorID $\twoheadrightarrow$ Textbook

## MVD Example Analysis

### **Concrete Example**

**Relation**: Teaching(InstructorID, Course, Textbook)

**Data**:

| InstructorID | Course | Textbook |
|--------------|--------|----------|
| 101          | CS101  | Book A   |
| 101          | CS101  | Book B   |
| 101          | CS102  | Book A   |
| 101          | CS102  | Book B   |
| 102          | CS101  | Book C   |
| 102          | CS103  | Book C   |

**Analysis for Instructor 101**:
- Courses: {CS101, CS102}
- Textbooks: {Book A, Book B}
- Table contains: 2 × 2 = 4 rows with all combinations

**MVDs Present**:
- InstructorID $\twoheadrightarrow$ Course
- InstructorID $\twoheadrightarrow$ Textbook (by complementation)

**Verification**: 
- Take tuples $t_1$ = (101, CS101, Book A) and $t_2$ = (101, CS102, Book B)
- They agree on InstructorID = 101
- $t_3$ = (101, CS101, Book B) exists (combines Course from $t_1$, Textbook from $t_2$)
- $t_4$ = (101, CS102, Book A) exists (combines Course from $t_2$, Textbook from $t_1$)
- MVD definition satisfied ✓

### **Problems from MVD Violation**

**Redundancy**:
- Instructor 101 with 3 courses and 4 textbooks needs 12 rows
- Massive storage waste for Cartesian product

**Update Anomalies**:
- Changing which courses instructor teaches requires updates to multiple rows
- Risk of inconsistency if not all rows updated

**Insertion Anomalies**:
- Adding new course for instructor requires adding row for each textbook
- Adding new textbook requires adding row for each course

**Deletion Anomalies**:
- Removing last course-textbook combination might lose information
- Cannot easily remove just course or just textbook information

## Fourth Normal Form (4NF)

Multivalued dependencies are the foundation for Fourth Normal Form, which eliminates MVD-based redundancy.

### **4NF Definition**

A relation $R$ is in **Fourth Normal Form** (4NF) if:

**For every non-trivial multivalued dependency $X \twoheadrightarrow Y$:**
$$X \text{ is a superkey of } R$$

**Equivalent Statement**: Every multideterminant must be a superkey.

### **4NF Requirements**

1. **Must be in BCNF** (handles functional dependencies)
2. **No non-trivial MVDs** where the determinant is not a superkey
3. **Independent multi-valued facts** must be stored in separate relations

### **Testing for 4NF**

**Algorithm**:
```
For each non-trivial MVD X ⤏ Y:
   Check if X is a superkey
   If X is not a superkey:
      R is not in 4NF
      X ⤏ Y is a 4NF violation
Return "R is in 4NF"
```

### **4NF Violation Example**

**Relation**: Teaching(InstructorID, Course, Textbook)

**MVDs**:
- InstructorID $\twoheadrightarrow$ Course
- InstructorID $\twoheadrightarrow$ Textbook

**Primary Key**: {InstructorID, Course, Textbook} (all three attributes)

**4NF Analysis**:
- InstructorID is NOT a superkey (doesn't determine all attributes)
- InstructorID $\twoheadrightarrow$ Course violates 4NF
- InstructorID $\twoheadrightarrow$ Textbook violates 4NF

### **Converting to 4NF**

**Decomposition Strategy**: Split based on multivalued dependencies.

**Original**: Teaching(InstructorID, Course, Textbook)

**Decomposed Relations**:

**TeachingAssignments**(InstructorID, Course)
- Stores which courses each instructor teaches
- Primary Key: {InstructorID, Course}
- MVD becomes trivial: InstructorID $\twoheadrightarrow$ Course (includes all attributes)

**TextbookRecommendations**(InstructorID, Textbook)
- Stores which textbooks each instructor recommends
- Primary Key: {InstructorID, Textbook}
- MVD becomes trivial: InstructorID $\twoheadrightarrow$ Textbook (includes all attributes)

**Data After Decomposition**:

**TeachingAssignments**:

| InstructorID | Course |
|--------------|--------|
| 101          | CS101  |
| 101          | CS102  |
| 102          | CS101  |
| 102          | CS103  |

**TextbookRecommendations**:

| InstructorID | Textbook |
|--------------|----------|
| 101          | Book A   |
| 101          | Book B   |
| 102          | Book C   |

**Benefits**:
- Original: 6 rows total
- Decomposed: 4 + 3 = 7 rows (but for instructor 101: 4 rows → 2 + 2 = 4 rows)
- Savings increase dramatically with more courses/textbooks
- No Cartesian product redundancy

### **4NF Decomposition Algorithm**

```
Algorithm: 4NF_Decompose(R, M)
Input: Relation R with attributes, set of MVDs M
Output: Set of relations in 4NF

1. If R is in 4NF:
   2.   Return {R}

3. Find non-trivial MVD X ⤏ Y that violates 4NF
   (X is not a superkey)

4. Decompose R into:
   5.   R1 = X ∪ Y
   6.   R2 = X ∪ (R - Y)

7. Recursively apply algorithm to R1 and R2

8. Return union of results
```

**Key Points**:
- Decomposition is based on the violating MVD
- $R_1$ contains determinant and dependent set
- $R_2$ contains determinant and all other attributes
- Process repeats until all relations are in 4NF

### **Properties of 4NF Decomposition**

**Lossless Join**: Always guaranteed
- Can reconstruct original relation by joining decomposed relations
- $R_1 \bowtie R_2 = R$ (original relation)
- Join attribute is the MVD determinant $X$

**Dependency Preservation**: May be lost
- Some MVDs may require joins to check
- Trade-off: 4NF eliminates anomalies but checking MVDs may require joins

**Anomaly Elimination**: Complete for MVD-based anomalies
- 4NF relations have no redundancy from multivalued dependencies
- Eliminates Cartesian product redundancy
- Prevents insertion, update, and deletion anomalies from MVDs

## Practical Recognition of MVDs

### **Database Design Scenarios**

**Scenario 1: Many-to-Many Relationships**
- Entity has multiple values for two independent attributes
- Example: Student enrolls in multiple courses AND has multiple phone numbers
- MVD: StudentID $\twoheadrightarrow$ Course and StudentID $\twoheadrightarrow$ Phone

**Scenario 2: Independent Attributes**
- Two attributes vary independently for the same key
- Example: Employee assigned to multiple projects AND has multiple skills
- MVD: EmployeeID $\twoheadrightarrow$ Project and EmployeeID $\twoheadrightarrow$ Skill

**Scenario 3: Repeated Values Pattern**
- Adding value for one attribute requires duplicating all values of another
- Indicates Cartesian product structure
- Clear sign of MVD

### **Questions to Identify MVDs**

1. **"Can an entity have multiple values for attribute A?"** → Possible multi-valued fact
2. **"Can the same entity have multiple values for attribute B?"** → Another multi-valued fact
3. **"Are A and B independent of each other?"** → MVD exists
4. **"Do we store all combinations of A and B values?"** → Confirms MVD

### **Common MVD Patterns**

**Pattern 1: Collections**
- Person with multiple addresses and multiple phones
- Product with multiple colors and multiple sizes

**Pattern 2: Assignments**
- Employee working on multiple projects using multiple skills
- Teacher teaching multiple courses with multiple certifications

**Pattern 3: Preferences/Choices**
- Customer with multiple payment methods and multiple shipping addresses
- User with multiple interests and multiple languages

## Comparison: FDs vs MVDs

| Aspect | Functional Dependency | Multivalued Dependency |
|--------|----------------------|------------------------|
| **Notation** | $X \rightarrow Y$ | $X \twoheadrightarrow Y$ |
| **Meaning** | $X$ determines single $Y$ value | $X$ determines set of $Y$ values |
| **Cardinality** | One-to-one or many-to-one | One-to-many |
| **Redundancy** | Duplicates $Y$ values | Cartesian product of values |
| **Normal Form** | Addressed by BCNF | Addressed by 4NF |
| **Subset** | FDs are special case of MVDs | MVDs generalize FDs |
| **Independence** | $Y$ depends on $X$ | $Y$ independent of other attributes given $X$ |

## When to Use 4NF

### **Use 4NF When**:
- Relation has independent multi-valued attributes
- Cartesian product redundancy exists
- Storage efficiency is important
- Independent facts should be stored separately
- Insertion/deletion anomalies from MVDs need elimination

### **Consider Alternatives When**:
- Performance requires denormalization
- Join cost outweighs redundancy cost
- Application frequently needs combined data
- MVD checking can be sacrificed
- Data warehouse or analytical workload

### **Trade-offs**

**Benefits of 4NF**:
- Eliminates Cartesian product redundancy
- Reduces storage requirements significantly
- Prevents MVD-based anomalies
- Cleaner data model with independent facts

**Costs of 4NF**:
- Requires joins to reconstruct original data
- May lose some MVD constraint checking
- Query complexity increases
- More tables to manage

## Important Notes

- **Recognition is Key**: Identifying MVDs requires understanding data semantics and independence
- **Not Always Obvious**: MVDs are subtler than FDs and may not be apparent from data alone
- **Business Rules**: MVDs typically arise from business requirements about independent facts
- **Context Dependent**: Whether to normalize to 4NF depends on access patterns and performance needs
- **Complementary MVDs**: MVDs always come in pairs due to complementation rule

## Related Concepts

- **[[Functional Dependencies]]**: Special case of MVDs with single values
- **[[Normal Form]]**: 4NF is highest commonly used normal form
- **[[Relational Design]]**: Overall design process including MVD analysis
- **[[Decomposition]]**: Technique for achieving 4NF
