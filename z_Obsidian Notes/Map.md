**A [[collection]] that stores pairs, where each pair consists of a first half called a *key*, and a second half called a *value*.**

- Sometimes called a [[Dictionary]], Associative [[Array]]or a [[HashMap]] 
- Usage: add (*key*, *value*) pairs; look up a value by supplying a key

![[Map Diagram.png]]

- Implemented using a linked structure called a [[Binary Search Tree]]
	- pretty fast for all operations; keys are stored in sorted order
	- both kinds of maps implement exactly the same operations
	- *the keys' type must be a comparable type with a < operation*
Tags:
[[C++]]