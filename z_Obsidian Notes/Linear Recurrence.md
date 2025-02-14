A linear recurrence is a recurrence relation where each term in the [[sequence]] is a linear combination of previous terms (ex. Fibonacci Sequence). It follows the general form:

$$T(n) = c_1 T(n-1) + c_2 T(n-2) + \dots + c_k T(n-k) + f(n)$$

where:

- $c_1, c_2, \dots, c_k$ are constants,
- $f(n)$ is an optional function of $n$,
- The recurrence depends on the **previous $k$ terms**.

There are several methods to solve linear recurrences:

1. **Iteration (Unrolling the Recurrence)** – Expanding the terms to find a pattern.
2. **Substitution Method** – Guessing a solution and proving by induction.
3. **Characteristic Equation Method** – Used for homogeneous recurrences.
4. **Generating Functions** – Converts the recurrence into a function for closed-form solutions.

Tags:
[[Recursion]]