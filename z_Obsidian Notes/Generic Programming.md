# Generic Programming

**Generic Programming** is a paradigm where algorithms are written in terms of types to-be-specified-later that are then instantiated when needed for specific types.

## C vs. C++
### In [[C++]] (Templates)
- Uses **Templates** (e.g., `template <typename T>`).
- **Compile-time** mechanism.
- Type-safe: Compiler generates specialized code for each type.
- Example: `std::vector<int>`, `std::sort`.

### In C (`void*`)
- Uses **Void Pointers** (`void*`) and manual memory size handling.
- **Runtime** mechanism (effectively).
- **Not Type-safe**: Relies on the programmer to pass correct sizes and function pointers (e.g., comparison functions).
- Example: `qsort`, `bsearch`.

## Key Concepts
- **Polymorphism**: The ability to present the same interface for differing underlying forms (data types).
- **Code Reusability**: Write a sorting algorithm once, use it for integers, strings, structs, etc.
- **Comparison Function**: In C generics, a function pointer is often passed to define "ordering" or "equality".

## Relevance
- Fundamental to the Standard Template Library (STL) in C++.
- Critical for writing reusable system libraries in C.
