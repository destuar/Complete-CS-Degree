A divide and conquer recurrence describes the running time of an algorithm that **recursively divides a problem into smaller subproblems**, solves them independently, and then combines the results.

It follows the general recurrence form:

$$T(n) = aT\left(\frac{n}{b}\right) + f(n)$$
where:

- **$T(n)$** is the time complexity for an input of size $ n $.
- **$a$** is the number of subproblems.
- **$b$** is the factor by which the problem size is reduced.
- **$f(n)$** represents the time to divide and merge the subproblems.

**Example 1: Merge Sort**
[[Merge Sort]] divides the array into two halves, sorts each recursively, and then merges them:

$$T(n) = 2T\left(\frac{n}{2}\right) + O(n)$$

Using the **Master Theorem**, we get:

$$T(n) = O(n \log n)$$

**Example 2: Binary Search**
[[Binary search tree]] divides the problem into one smaller subproblem and does constant work:

$$T(n) = T\left(\frac{n}{2}\right) + O(1)$$

Solving the recurrence:

$$T(n) = O(\log n)$$

---

#### **Solving Divide & Conquer Recurrences**

There are three common methods:

1. **Substitution Method**
    - Expand the recurrence iteratively until a pattern emerges.
    - Example: Expanding $T(n) = 2T(n/2) + O(n)$ leads to $O(n \log n)$.

2. **[[Recursion]] Tree Method**
    - Draw the recursive calls as a tree.
    - Compute the total cost across all levels.

3. **Master Theorem**  
    The **Master Theorem** provides a direct way to solve recurrences of the form:
    $$T(n) = aT(n/b) + f(n)$$
    
    Based on the relationship between $f(n)$ and $n^{\log_b a}$, we categorize $T(n)$ into one of three cases.