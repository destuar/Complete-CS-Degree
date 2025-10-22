# Struct

**A lightweight class; a template for related data (*+ behavior?*).**

A struct (short for structure) is a **user-defined data type** that groups together related variables, potentially of different data types, under a single name. It allows you to create a custom data structure that can hold a collection of related data.

## Key Characteristics

- **User-defined**: You create your own custom data types
- **Composite**: Can contain multiple variables of different types
- **Members are public by default** (in C++)
- **Memory efficient**: Variables are packed together in memory

## Declaration

A struct is declared using the `struct` keyword, followed by the struct's name and a block of member variable declarations.

### Example
```c
struct fraction {
    int n;
    int denom;
};
```

## Memory Organization

### Memory Allocation
When a variable of a struct type is declared, enough memory is allocated to hold all its member variables. The total size is typically the **sum of the sizes of its parts**.

For the `fraction` struct example:
- [[Int]] is 4 bytes
- `fraction` struct takes **8 bytes** total (4 bytes for `n` + 4 bytes for `denom`)

### Memory Layout
The member variables are **packed together as tightly as possible** in memory:
- The address of the entire struct is the **same as the address of its first field**
- Subsequent fields are located at **offsets** from this base address

```
Memory Layout Example for fraction:
+-------------------+
| n (4 bytes)       |  ← Address of struct = Address of n
+-------------------+
| denom (4 bytes)   |  ← At offset +4 from base address
+-------------------+
Total: 8 bytes
```

## Usage

Structs are used to:
- Group related data together logically
- Create custom data types that represent real-world entities
- Organize code and improve readability
- Pass multiple related values as a single unit

## Related Concepts

- [[Int]] - Common member type
- [[Float]] - Common member type for decimal values
- [[Double]] - Common member type for high-precision decimals
- [[Char]] - Common member type for character data
- [[Short]] - Common member type for smaller integers
