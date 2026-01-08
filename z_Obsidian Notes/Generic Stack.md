# Generic Stack

A **Generic Stack** is a stack data structure implemented to store elements of any data type, typically using `void*` in C.

## Implementation Details
1.  **Struct Definition**:
    ```c
    typedef struct {
        void* elems;
        int elemSize;
        int logicalLen;
        int allocLen;
    } Stack;
    ```
2.  **Push**:
    - Checks if space is available (reallocates if full).
    - Calculates target address: `(char*)elems + logicalLen * elemSize`.
    - Copies data using `memcpy`.
3.  **Pop**:
    - Decrements `logicalLen`.
    - Copies data back to client-supplied buffer using `memcpy`.

## Key Challenges
- **Memory Management**: Must correctly handle allocation and deallocation of the internal buffer.
- **Deep Copies**: If elements are pointers, a custom disposal function (free function) is often needed to clean up what the elements point to.

## Relevance
- Classic example of [[Generic Programming]] in C.
- Demonstrates manual memory management and [[Pointer Arithmetic]].
