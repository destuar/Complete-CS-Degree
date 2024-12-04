Diagram:
![[Adjacency Matrix Diagram.png]]
Pros:
- fast to tell whether an edge exists between any two vertices *i* and *j* (and to get its weight)
Cons:
- consumes a lot of memory on sparse [[graph]]s (ones with few edges)
- slow to add/remove a vertex ($O(V^2)$)
- somewhat slow to get all neighbors of a given matrix

**Runtime Comparison**
![[Graph Runtime Comparison.png]]