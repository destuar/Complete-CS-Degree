# Heap Allocator

A **Heap Allocator** is a system library (like `malloc`/`free` in C) that manages the dynamic allocation of memory from the **Heap segment**.

## Key Responsibilities
1.  **throughput**: Maximize the number of requests processed per second.
2.  **Memory Utilization**: Minimize fragmentation (wasted space).

## Implementation Concepts
- **Explicit Free List**: A linked list of free blocks embedded within the free memory itself.
- **Block Header**: A small data structure stored just before the payload of each block (allocated or free) containing the size and status (free/allocated).
- **Coalescing**: Merging adjacent free blocks to form larger blocks and reduce fragmentation.
- **Splitting**: Dividing a large free block into an allocated block and a smaller free block.

## Fragmentation Types
- **Internal Fragmentation**: Wasted space *inside* an allocated block (e.g., padding for alignment).
- **External Fragmentation**: Wasted space *between* allocated blocks (free blocks exist but are too small for a request).

## Relevance
- Writing a heap allocator (writing `malloc`) is a standard advanced systems assignment.
- Understanding this explains why `free` doesn't take a size parameter (it's in the header).
