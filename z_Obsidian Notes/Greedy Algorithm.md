A **greedy algorithm** is an approach that makes the **locally optimal choice** at each step in the hope of finding the globally optimal solution. It does not backtrack or reconsider previous decisions.

Greedy algorithms are often efficient and simple but **do not always guarantee the best possible solution**.

**GRAPH COLORING EXAMPLE:**

In **[[graph]] coloring**, the goal is to assign colors to vertices so that no two adjacent vertices have the same color while minimizing the total number of colors used.

A **greedy [[graph coloring]] algorithm** follows these steps:

1. **Pick a vertex** and assign it the **smallest available color** that has not been used by its adjacent vertices.
2. **Move to the next vertex** and repeat the process.
3. Continue until all vertices are colored.