**Exploring every possible combination from a set of choices or values**
- often implemented recursively ([[recursion]])

Applications:
- producing all permutations of a set of values
- enumerating all possible names, passwords, etc.
	- combinatorics and logic programming

Often the search space consists of many *decisions*, each of which has several available *choices*.
- Example: When enumerating all 5-letter strings, each of the 5 letters is a *decision*, and each of those decisions has 26 possible *choices*.

**Explore**(*decisions*):
- if there are no more decisions to make: stop.
- else, let's handle one decision ourselves, and the rest by recursion. for each available choice *C* for this decision:
	- **Choose** *C*.
	- **Explore** the remaining decisions that could follow *C*.