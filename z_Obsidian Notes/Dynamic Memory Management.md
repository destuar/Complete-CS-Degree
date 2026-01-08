# Dynamic Memory Management

**Dynamic Memory Management** refers to the manual allocation and deallocation of memory from the **Heap** at runtime.

## Core Functions (in C)
1.  **`malloc(size_t size)`**: Allocates `size` bytes of uninitialized memory. Returns `void*` or `NULL` if failed.
2.  **`free(void* ptr)`**: Deallocates the memory pointed to by `ptr`.
    - **Rule**: Every `malloc` must have a corresponding `free`.
    - **Double Free**: Calling `free` on the same pointer twice is undefined behavior (often crashes).
3.  **`realloc`**: Resizes an existing block. (See [[Memory Reallocation]]).
4.  **`calloc(n, size)`**: Allocates memory for an array of `n` elements of `size` bytes and **initializes them to zero**.

## Common Errors
- **Memory Leak**: Failing to free memory that is no longer needed.
- **Dangling Pointer**: Accessing memory after it has been freed.
- **Heap Corruption**: Writing past the boundaries of an allocated block.

## Relevance
- Critical for systems programming.
- Contrasts with automatic stack allocation (managed by compiler).
