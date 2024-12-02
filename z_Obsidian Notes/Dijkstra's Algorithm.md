**Finds the minimum-weight path between a pair of vertices and a weighted directed [[graph]].**

- Solves the "shortest path from a given vertex" problem in weighted graphs.

- *basic algorithm concept*: Store information about the currently known best way to reach each vertex (cost, previous vertex), and improve it until it reaches the best solution.

- *Example*: In a graph where vertices are cities and weighted edges are roads between cities, Dijkstra's algorithm can be used to find the shortest route from one city to any other.

![[Dijkstra's Pseudocode.png]]![[Dijkstra's Diagram.png]]![[Dijkstra's Diagram 2.png]]

**Dijkstra's algorithm is a *greedy algorithm* because it makes choices that currently seem best.**

- it is correct because it maintains the following two properties:
	- 1) for every marked vertex, the current recorded cost is the lowest cost to that vertex from the source vertex.
	- 2) for every unmarked vertex *v*, its recorded distance is shortest path distance to *v* from source vertex, considering only currently known vertices and *v*.

![[Dijkstra's Runtime.png]]