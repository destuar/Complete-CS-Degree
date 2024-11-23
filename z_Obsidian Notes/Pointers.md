`type* name = address;`

**A variable that stores a [[memory address]].**
- In the code below, p points to x.
	- The `int x` is the "pointee" of the pointer `p`.
- The pointer is also a variable that occupies memory.

`int x = 42`
`int* p = &x`
`cout << p << endl;`     `// 0x7f8e20`

Tags:
[[C++]]