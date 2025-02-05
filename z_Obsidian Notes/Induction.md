*Induction is really just an [[axiom]]*

**Induction** is a reasoning method that establishes the truth of an infinite number of cases by proving a base case and a general rule. It is commonly used in mathematics and logic to prove statements about natural numbers.

There are two main types of induction:

1. **Mathematical Induction** – Used to prove properties of natural numbers.
2. **Structural Induction** – Used to prove properties of recursively defined structures, like trees and graphs.

---
**Proof by Mathematical Induction**

[[Proof]] by induction is a technique used to prove statements of the form:

$P(n) \text{ is true for all } n∈N$

**Steps of Induction**

A proof by induction consists of two steps:

1. **Base Case**:
    - Prove that the statement holds for the smallest value, usually $n=1$ (or $n=0$ if the set includes $0$).
    - This establishes that the claim is true for at least one case.

2. **Inductive Step**:
    - Assume that the statement is true for some arbitrary natural number $n$, i.e., assume $P(n)$ is true.
    - Use this assumption (called the **inductive hypothesis**) to prove that $P(n+1)$ is also true.

If both steps hold, then **by the principle of mathematical induction,** the statement is true for all $n∈N$.

A "more powerful" $P(n)$ generally means that the inductive hypothesis assumes a stronger statement. This helps in two key ways:

1. **Stronger Assumptions Make the Inductive Step Easier**  
    If $P(n)$ includes additional useful properties, then proving $P(n+1)$ might become more straightforward. This is because a stronger $P(n)$ provides more tools when transitioning to $P(n+1)$.

2. **Covers More Cases and Avoids Gaps**  
    Sometimes, a naive choice of $P(n)$ might fail to cover all necessary cases when proving $P(n+1)$. A stronger version ensures that the induction can properly extend the proof to all numbers without missing crucial information.