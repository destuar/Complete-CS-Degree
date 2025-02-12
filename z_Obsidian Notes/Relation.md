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

Tags:
[[Cartesian Equation]]