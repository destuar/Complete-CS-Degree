**A special arrangement of elements in an [[array]].**
- The "start" or "root" index is 1. (index 0 is empty and unused)
- Every index $i$ has a "parent" index ($i/2$) and two child indexes ($i*2$,$i*2+1$)

- *Ordering Property*: We will make sure to keep the array arranged so that all "parents" have lower priority than their children.

Can be used to-
- `enqueue`: place new element at first empty index.
	- It may now be out of order, so...
	- **swap it upward** with its parent until it is in order called a "bubble up"
	- The opposite swap downward is called a "bubble down"

This is an efficient [[Abstract Data Types (ADTs)]] for implementing something like a [[Priority Queue]].

Tags:
[[C++]]