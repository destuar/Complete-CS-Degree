
Computational complexity refers to the amount of *resources* (time and/or space) an algorithm or computation requires as the size of its input grows. 

![[Complexity Image.png]]

1. **Time Complexity**:  
   - Describes how the *running time* of an algorithm scales with the input size $n$.  
   - Expressed in **[[Big O-Notation]]** (or sometimes Big-$\Theta$, Big-$\Omega$), for example: $O(n)$, $O(n \log n)$, $O(n^2)$, $O(2^n)$, etc.

2. **Space Complexity**:  
   - Measures the *amount of memory* (space) needed by an algorithm as the input size $n$ changes.
   - Also often expressed in Big-O notation (e.g., $O(n)$ memory usage).

3. **Big-O Notation**:  
   - A way to describe the *upper bound* on how fast resource usage grows.  
   - For instance, $O(n^2)$ means that the resources required (time or space) grow at most on the order of $n^2$ for large $n$.
   
### Complexity Classes (Theory)

- **P**: Problems solvable in *polynomial* time ($O(n^k)$ for some constant $k$).
- **NP**: Problems verifiable in polynomial time; includes many known “hard” problems (e.g., the Traveling Salesman Problem).
- **NP-Complete**: Problems in NP such that *any* NP problem can be transformed into them in polynomial time. If any NP-complete problem can be solved in polynomial time, *all* NP problems can be.
- **NP-Hard**: At least as hard as the hardest NP problems, but not necessarily in NP (decision vs. optimization problems).
- Other classes include **PSPACE**, **EXP**, **co-NP**, etc., which focus on different resource constraints.
