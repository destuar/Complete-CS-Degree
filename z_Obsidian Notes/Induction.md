*Induction is really just an [[axiom]]*

**Induction** is a reasoning method that establishes the truth of an infinite number of cases by proving a base case and a general rule. It is commonly used in mathematics and logic to prove statements about natural numbers.

There are two main types of induction:

1. **Mathematical Induction** – Used to prove properties of natural numbers.
2. **Structural Induction** – Used to prove properties of recursively defined structures, like trees and graphs.

---

### **Proof by Mathematical Induction**

[[Proof]] by induction is a technique used to prove statements of the form:

$P(n) \text{ is true for all } n∈N$

#### **Steps of Induction**

A proof by induction consists of two steps:

1. **Base Case**:
    - Prove that the statement holds for the smallest value, usually $n=1$ (or $n=0$ if the set includes $0$).
    - This establishes that the claim is true for at least one case.

2. **Inductive Step**:
    - Assume that the statement is true for some arbitrary natural number $k$, i.e., assume $P(k)$ is true.
    - Use this assumption (called the **inductive hypothesis**) to prove that $P(k+1)$ is also true.

If both steps hold, then **by the principle of mathematical induction,** the statement is true for all $n∈N$.