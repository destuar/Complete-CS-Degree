A **tree** is a directed, acyclic structure of linked nodes.
	- *directed* : Has one-way links between nodes.
	- *acyclic* : No path wraps back around to the same node twice.
		- Only one unique path from a node to any other node.

**A binary tree is a tree where each node as at most two children.**

*Recursive definition*: A tree is either:
	- empty (`nullptr`), or
	- a **root** node that contains:
		- **data**
		- a **left** subtree, and 
		- a **right** subtree. (left and/or right subtree could be empty)

![[Binary Tree Diagram.png]]
**Terminology**:
**node**: an object containing a data value and left/right children
	**root**: topmost node of a tree
	**leaf**: a node that has no children
	**branch**: any internal node; neither a root nor a leaf
	**parent**: a node that refers to this one
	**child**: a node that this node refers to
	**sibling**: a node with a common parent

**subtree**: the smaller tree of nodes on the left or right of the current node
**height**: length of the longest path from the root to any node
**level** or **depth**: length of the path from a root to a given node

Tags:
[[Tree Node Object]]