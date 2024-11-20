**The definition of an operation in terms of itself.**

- Solving a problem using recursion depends on solving smaller occurrences of the same problem.
- Key question: *"How is this problem self-similar?*

- Occurs in may places in code and in real world:
	- Looking up a word in dictionary may involve looking up other words.
	- Nested structures (trees, file folders, [[collection]]s) can be self-similar.
	- Patterns can contain smaller version of the same pattern (fractals).
	- Shells, plants, mountains, clouds, etc.

**Every recursive algorithm involves at least 2 cases:**
- base case: A simple occurrence that can be answered directly.
- recursive case: A more complex occurrence of the problem that cannot be directly answered, but can instead be described in terms of smaller occurrences of the same problem.

Example:
`int factorial(int n) {`
	`if (n == 0 || n == 1) {`
		`// base case`
		`return 1;`
	`} else {`
		`// recursive case`
		`return n * factorial(n - 1);`
`}`

*Key idea*: In a recursive piece of code, you handle a small part of the overall task yourself, then make a recursive call to handle the rest.