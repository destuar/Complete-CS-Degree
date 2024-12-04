A data structure ([[Abstract Data Types (ADTs)]]) containing:
- a set of **vertices** V, *(sometimes called nodes)*
- a set of **edges** E, *(sometimes called arcs)*
	which are connections between 2 vertices.
		- Graph G = (V, E)
		- an edge is a pair (v, w) where v, w are in V

- the graph below:
	- V = {a, b, c, d}
	- E = {{a, c}, {b, c}, {b, d}, {c, d}}
![[Graph Diagram.png]]
- **degree**: number of edges touching a given vertex.
	- at right: a=1, b=2, c=3, d=2

![[Graph Path.png]]![[Graph Reachability.png]]
![[Graph Cycle.png]]
![[Graph Weight.png]]
![[Directed Graph.png]]

**CONNECTIONS BETWEEN GRAPHS AND OTHER DATA STRUCTURES**

A [[Binary Tree]] is a graph with some restrictions:
- The tree is unweighted, directed, acyclic graph (DAG)
- Each node's in-degree is at most 1, and out-degree is at most 2
- There is exactly one path from the root to every node

A [[LinkedList]] is also a graph:
- Unweighted DAG
- In/out degree of at most 1 for all nodes

![[Graph Search.png]]