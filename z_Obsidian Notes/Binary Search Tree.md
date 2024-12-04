**A [[Binary Tree]] where each non-empty node R has the following properties:
- every element of R's **left** subtree contains data **less** than R's data,
- every element of R's **right** subtree contains data **greater** than R's,
- R's left and right subtrees are also binary search trees.

![[Binary Search Tree Diagram.png]]

This can improve the search efficiency of a Binary Tree from O(N) to O(log(N)) by constraining the way the tree is created (ordering the values at each of the nodes).