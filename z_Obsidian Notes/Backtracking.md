**Finding solution(s) by trying partial solutions and then abandoning them if they are not suitable.**

- a "brute force" algorithmic technique (tries all paths)
- often implemented recursively

Applications:
- producing all permutations of a set of values
- parsing languages
- games: anagrams, crosswords, word jumbles
- combinatorics and logic programming
- escaping from a maze

**Explore**(*decisions*):
- if there are no more decisions to make: stop.
- else, let's handle one decision ourselves, and the rest by recursion. for each available choice *C* for this decision:
	- **Choose** *C*.
	- **Explore** the remaining decisions that could follow *C*.
	- **Un-choose** *C*. (backtrack!)

Tags:
[[Exhaustive Search]]
[[Recursion]]