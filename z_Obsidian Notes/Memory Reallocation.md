# Memory Reallocation

**Memory Reallocation** involves resizing a previously allocated memory block, typically to accommodate more data (e.g., in a dynamic array or [[Generic Stack]]).

## `realloc` Function
- **Prototype**: `void* realloc(void* ptr, size_t new_size);`
- **Behavior**:
    1.  Allocates a new block of `new_size` bytes.
    2.  Copies data from the old block to the new block (up to the minimum of old/new sizes).
    3.  Frees the old block.
    4.  Returns pointer to the new block.
- **Optimization**: If there is free space immediately after the current block, it may just extend the current block and return the same pointer.

## Efficiency Strategy
- **Doubling Strategy**: When resizing a dynamic array, double its capacity ($2N$).
- **Amortized Cost**: Makes insertion $O(1)$ on average, rather than $O(N)$ if resizing by 1 each time.

## Risks
- **Memory Leaks**: If `realloc` fails (returns NULL), the original pointer is still valid. Assigning directly to the original variable (`p = realloc(p, ...)` ) risks losing the reference if it fails.

## Relevance
- Fundamental for implementing dynamic data structures in C.
