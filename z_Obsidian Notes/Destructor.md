**Called when the object is deleted by the program (when the object falls out of { } scope).**

- Useful if your object needs to free any memory before it dies to prevent "memory leaks"
	- `delete` any pointers stored as private members
	- `delete[]` any arrays stored as private members

`// ClassName.h`
`~ClassName();`

`// ClassName.cpp`
`ClassName::~ClassName() {...}`

**This is the opposite of a [[Constructor]].**

Tags:
[[C++]]