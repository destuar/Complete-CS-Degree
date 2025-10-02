In **[[set]] theory**, a **relation** is a **subset of a Cartesian product** of two sets. It represents a connection between elements of two (or more) sets.

---

### **Definition of a Relation**

In **set theory**, a **relation** is a **subset of a Cartesian product** of two sets. It represents a connection between elements of two (or more) sets.

Given two sets $A$ and $B$, a **relation $R$ from $A$ to $B$** is a **subset** of the Cartesian product:
$$R \subseteq A \times B$$
This means that a relation consists of **ordered pairs** $(a, b)$ where $a \in A$ and $b \in B$, indicating that $a$ is **related** to $b$ by $R$.

---

### **Example of a Relation**

Let $A = {1, 2, 3}$ and $B = {a, b}$.

The **Cartesian product** is:

$$A \times B = \{(1,a), (1,b), (2,a), (2,b), (3,a), (3,b)\}$$

A possible relation $R$ could be:

$$R = \{(1,a), (2,a), (3,b)\}$$
This means:

- $1$ is related to $a$,
- $2$ is related to $a$,
- $3$ is related to $b$.

---

### **Types of Relations**

**1. Reflexive Relation**

A relation $R$ on set $A$ is **reflexive** if every element relates to itself:
$$\forall a \in A, (a, a) \in R$$
---

**2. Symmetric Relation**

A relation $R$ is **symmetric** if:
$$\forall (a, b) \in R, \quad (b, a) \in R$$
---

**3. Transitive Relation**

A relation $R$ is **transitive** if:
$$\forall (a, b) \in R \text{ and } (b, c) \in R, \quad (a, c) \in R$$
---

**4. Equivalence Relation**

A relation is an **equivalence relation** if it is **reflexive, symmetric, and transitive**.

---

## **Database Relations**

In **relational database theory**, a **relation** is a **table** (also called a relation) that organizes data into **rows** (tuples) and **columns** (attributes). This extends the mathematical concept of relations to practical data storage and retrieval.

### **Database Relation Structure**

A database relation $R$ with attributes $A_1, A_2, ..., A_n$ can be represented as:
$$R(A_1, A_2, ..., A_n)$$

Where:
- **$A_i$** are **attribute names** (column headers)
- **Tuples** are **rows** containing values for each attribute
- **Domain** $D_i$ defines valid values for attribute $A_i$
- **Relation instance** is the actual data stored at a given time

### **Database Relation Properties**

**1. No Duplicate Tuples**
- Each tuple (row) must be unique
- Mathematically: Relations are sets, and sets contain unique elements

**2. Unordered Tuples**
- Rows have no inherent ordering
- Order may change without affecting the relation

**3. Unordered Attributes**
- Columns have no inherent ordering
- Attribute order doesn't affect relation semantics

**4. Atomic Values**
- Each cell contains a single, indivisible value
- No repeating groups or nested structures (1NF requirement)

### **Database Relation Example**

Consider a **Students** relation:

| StudentID | Name | Age | Major |
|-----------|------|-----|-------|
| 1001      | Alice| 20  | CS    |
| 1002      | Bob  | 19  | Math  |
| 1003      | Carol| 21  | CS    |

This relation has:
- **Attributes**: StudentID, Name, Age, Major
- **Tuples**: Three rows of student data
- **Domain**: StudentID (integers), Name (strings), Age (integers), Major (strings)

### **Key Concepts in Database Relations**

**Primary Key**
- One or more attributes that uniquely identify each tuple
- Cannot contain NULL values
- Example: StudentID in the Students relation

**Foreign Key**
- Attributes that reference primary keys in other relations
- Maintains referential integrity between tables
- Example: StudentID in an Enrollments relation referencing Students

**Functional Dependencies**
- $X \rightarrow Y$ means attribute $Y$ is functionally dependent on $X$
- If two tuples have the same values for $X$, they must have the same values for $Y$
- Example: StudentID $\rightarrow$ Name (each student ID uniquely determines the name)

### **Relational Operations**

**Selection ($\sigma$)**
- Filter tuples based on conditions
- Example: $\sigma_{Age > 20}(Students)$ selects students older than 20

**Projection ($\pi$)**
- Extract specific attributes
- Example: $\pi_{Name, Major}(Students)$ returns only name and major columns

**Join ($\bowtie$)**
- Combine tuples from related relations
- Example: Natural join between Students and Enrollments relations

**Union ($\cup$)**
- Combine tuples from compatible relations
- Relations must have the same attribute structure

### **Normalization of Database Relations**

**First Normal Form (1NF)**
- All attribute values are atomic (indivisible)
- No repeating groups or arrays within cells

**Second Normal Form (2NF)**
- 1NF + no partial dependencies on composite primary keys
- All non-key attributes depend on the entire primary key

**Third Normal Form (3NF)**
- 2NF + no transitive dependencies
- Non-key attributes depend only on the primary key, not on other non-key attributes

---

Tags:
[[Cartesian Equation]]
[[Attribute]]
[[Database Management System (DBMS)]]
[[Schema]]