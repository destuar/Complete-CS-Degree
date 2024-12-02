`type* name = address;`

**A variable that stores a [[memory address]].**
- In the code below, p points to x.
	- The `int x` is the "pointee" of the pointer `p`.
- The pointer is also a variable that occupies memory.

`int x = 42`
`int* p = &x`
`cout << p << endl;`     `// 0x7f8e20`

`*p` means "the value that p points to".
- This is called *dereferencing the pointer*.

`int x = 42`
`int* p = &x`

`// access the pointee`
`cout << p << endl;`     `// 0x7f8e20`
`cout << *p << endl;`    `// 42`

`// modify the pointee`
`*p = 99;`
`cout << x << endl;`    `// 99`

**Using `->` or `*x.__` notation, [[LinkedList]] has a larger scope where the memory associated with `->` objects/variables is not cleaned up at the end of a function.**

Tags:
[[C++]]