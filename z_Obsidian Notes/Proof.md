*A **proof** is a method for ascertaining the truth.*
##### **Mathematical Proof**

A **mathematical proof** is a verification of a [[proposition]] by a chain of logical deductions from a set of [[axiom]]s. The purpose of a mathematical proof is to provide a rigorous argument that a statement is necessarily true under a given system of axioms and inference rules.
##### **Types of Mathematical Proofs**
Different proof techniques are used based on the nature of the proposition:

1. **Direct Proof**:
    - Proves a statement $P→Q$ directly through logical deductions.
    - Example: Proving that the sum of two even numbers is always even by writing $2a+2b=2(a+b)$

2. **Indirect Proof (Proof by Contradiction)**:
    - Assumes the negation of the proposition and derives a contradiction.
    - Example: Proving $\sqrt{2}$​ is irrational by assuming it is rational and showing this leads to a contradiction.

3. **Proof by Contrapositive**:
    - Instead of proving $P→Q$, proves $¬Q→¬P$.
    - Example: If a number is not even, then it is not divisible by 2.

4. **Proof by Induction**:
    - Used for statements involving natural numbers.
    - Steps:
        - **Base Case**: Show that the statement holds for the smallest value (e.g., $n=1$).
        - **Inductive Step**: Assume it holds for $n$, then prove it holds for $n+1$.
    - Example: Proving the sum of the first $n$ natural numbers is $\frac{n(n+1)}{2}$.

5. **Proof by Exhaustion (Case Analysis)**:
    - The statement is proven by checking all possible cases.
    - Example: Proving a property for a small set of numbers (e.g., checking divisibility rules for digits 0-9).

6. **Proof by Construction**:
    - Proves the existence of an object by explicitly constructing an example.
    - Example: Showing there exists an irrational number $x$ such that $x^x$ is rational by considering $x = \sqrt{2}^{\sqrt{2}}$​.

7. **Proof by Counterexample**:
    - Used to disprove a universal statement by finding a single counterexample.
    - Example: Disproving “All prime numbers are odd” by citing $2$.

##### **Formalism and Proofs**
Mathematical proofs operate within formal systems, which consist of:
- **Axioms**: Assumed truths (e.g., Peano axioms for natural numbers).
- **Inference Rules**: Logical rules used to derive new truths.
- **Theorems**: Statements that have been proven using axioms and prior theorems.

A valid proof must be:
- **Valid**: The logical structure follows from the given axioms.
- **Sound**: The conclusion must be true if the premises are true