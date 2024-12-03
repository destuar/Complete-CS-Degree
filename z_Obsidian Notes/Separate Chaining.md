**Solving the collision problems in [[HashSet]]s and [[Hash Table]]s by storing a list at each index.**
- add/search/remove must traverse lists, but the lists are short
- impossible to "run out" of indexes, unlike probing or clustering
- uses [[LinkedList]] and [[Pointers]] to create lists in each index

![[Separate Chaining Diagram.png]]

![[Rehash Diagram.png]]