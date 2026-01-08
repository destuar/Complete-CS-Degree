# Pointer Arithmetic

**Pointer Arithmetic** refers to the set of valid arithmetic operations that can be performed on pointers.

## Step Size
- Adding `1` to a pointer advances the address by `sizeof(T)` bytes, where `T` is the type the pointer points to.
- `int* p; p + 1` increases the address by 4 bytes (on 32-bit systems).
- `char* p; p + 1` increases the address by 1 byte.

## Generic Pointer Arithmetic
Because `void*` has no size, arithmetic on it is illegal in standard C (though GCC allows it as 1-byte). To perform arithmetic on `void*` (e.g., in [[Linear Search]]), one must cast to `char*` first.

### Formula
To access the $i$-th element of a generic array:
$$Address = (char*)base + (i \times elemSize)$$

## Subtraction
- `ptr2 - ptr1` returns the **number of elements** between the two pointers, not the number of bytes.

## Relevance
- Critical for manual memory management and navigating arrays/buffers in C.
- Core concept in implementing generic algorithms.
