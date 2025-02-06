Graph coloring is the process of **assigning colors** to the **vertices, edges, or faces** of a [[graph]] under specific constraints. The most common form is **vertex coloring**, where adjacent vertices must have different colors.

---

**1. Vertex Coloring**
- The goal is to assign colors to **vertices** so that **no two adjacent vertices share the same color**.
- The **chromatic number** $\chi(G)$ is the minimum number of colors needed to properly color the graph.

**2. Edge Coloring**
- Assign colors to **edges** so that **no two adjacent edges share the same color**.
- The **chromatic index** $\chi'(G)$ is the minimum number of colors needed.

**3. Face Coloring (Planar Graphs)**
- Assign colors to **regions** of a planar graph so that **no two adjacent regions have the same color**.
- **Four Color Theorem**: Any planar graph can be colored with at most **4 colors**.

**4. Graph Coloring Algorithm (Greedy Algorithm)**
- A simple **[[greedy algorithm]]** for vertex coloring:
	1. Assign the **first color** to the first vertex.
	2. For each remaining vertex:
	    - Choose the **smallest available color** that is **not used** by its adjacent vertices.
	3. Repeat until all vertices are colored.