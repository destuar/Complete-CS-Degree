The Master Method is a powerful "black box" technique for solving recurrence relations that arise in the analysis of divide-and-conquer algorithms, providing asymptotic bounds without requiring complex mathematical manipulations.

## Basic Definition

- Used to solve recurrences of the form:
  $$ T(n) = aT(n/b) + f(n) $$

- Where:
  - $T(n)$ is the cost of the algorithm on input of size $n$
  - $a \geq 1$ is the number of subproblems
  - $b > 1$ is the factor by which the input size is reduced
  - $f(n)$ is the cost of dividing the problem and combining solutions

- Assumption: All subproblems have equal size

## Simplified Formula

For recurrences of the form $T(n) = aT(n/b) + O(n^d)$, the solution is:

$$T(n) = \begin{cases}
O(n^d \log n) & \text{if } a = b^d \\
O(n^d) & \text{if } a < b^d \\
O(n^{\log_b a}) & \text{if } a > b^d
\end{cases}$$

This provides an easy way to determine the asymptotic complexity by comparing $a$ and $b^d$.

## The Three Cases (Formal Definition)

1. **Case 1**: If $f(n) = O(n^{\log_b a - \epsilon})$ for some constant $\epsilon > 0$, then:
   $$ T(n) = \Theta(n^{\log_b a}) $$
   - Work to solve subproblems dominates
   - Example: Merge sort with $a=2$, $b=2$, $f(n)=n$ gives $T(n) = \Theta(n \log n)$

2. **Case 2**: If $f(n) = \Theta(n^{\log_b a} \log^k n)$ for some $k \geq 0$, then:
   $$ T(n) = \Theta(n^{\log_b a} \log^{k+1} n) $$
   - Work to solve subproblems and combine solutions are comparable
   - Example: $T(n) = 2T(n/2) + n\log n$ gives $T(n) = \Theta(n \log^2 n)$

3. **Case 3**: If $f(n) = \Omega(n^{\log_b a + \epsilon})$ for some constant $\epsilon > 0$, and if $af(n/b) \leq cf(n)$ for some $c < 1$ and sufficiently large $n$, then:
   $$ T(n) = \Theta(f(n)) $$
   - Work to combine solutions dominates
   - Example: $T(n) = 2T(n/2) + n^2$ gives $T(n) = \Theta(n^2)$

## Application to Common Algorithms

1. **[[Binary Search Tree|Binary Search]]**:
   - Recurrence: $T(n) = T(n/2) + \Theta(1)$
   - $a=1$, $b=2$, $f(n) = \Theta(1)$, so $d=0$
   - Compare: $a = 1 < 2^0 = 1$ (equal)
   - By simplified formula: $T(n) = O(n^0 \log n) = O(\log n)$
   - Solution: $T(n) = \Theta(\log n)$

2. **Merge Sort**:
   - Recurrence: $T(n) = 2T(n/2) + \Theta(n)$
   - $a=2$, $b=2$, $f(n) = \Theta(n)$, so $d=1$
   - Compare: $a = 2 = 2^1 = 2$ (equal)
   - By simplified formula: $T(n) = O(n^1 \log n) = O(n \log n)$
   - Solution: $T(n) = \Theta(n \log n)$

3. **Strassen's Algorithm**:
   - Recurrence: $T(n) = 7T(n/2) + \Theta(n^2)$
   - $a=7$, $b=2$, $f(n) = \Theta(n^2)$, so $d=2$
   - Compare: $a = 7 > 2^2 = 4$ (greater)
   - By simplified formula: $T(n) = O(n^{\log_2 7}) \approx O(n^{2.81})$
   - Solution: $T(n) = \Theta(n^{\log_2 7}) \approx \Theta(n^{2.81})$

## Limitations and Extensions

1. **Limitations**:
   - Only applies to recurrences of the specific form $T(n) = aT(n/b) + f(n)$
   - Requires subproblems of equal size
   - Doesn't handle floors or ceilings in the recurrence
   - Gap between Case 1 and Case 3 (when $f(n) = \Theta(n^{\log_b a})$)