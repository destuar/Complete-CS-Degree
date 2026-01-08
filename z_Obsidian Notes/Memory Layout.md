# Memory Layout

**Memory Layout** describes how a program's virtual address space is organized during execution.

## Segments (Low to High Address)
1.  **Text (Code) Segment**: Contains the compiled machine instructions. Read-only.
2.  **Data Segment**: Contains global and static variables.
    - **Initialized Data**: Explicitly initialized (e.g., `int globals = 10;`).
    - **Uninitialized Data (BSS)**: Zero-initialized by default.
3.  **Heap**: Dynamically allocated memory (via `malloc` in C, `new` in C++). Grows upward.
4.  **Stack**: Contains **Activation Records** (Stack Frames) for function calls. Grows downward (high to low addresses).

## Key Concepts
- **Activation Record**: A block of memory on the stack storing local variables, parameters, and return addresses for a single function call.
- **Heap vs. Stack**: Stack is fast, automatic, LIFO. Heap is flexible, manual, requires management.

## Relevance
- Understanding layout is crucial for `buffer overflow` exploitation and debugging `segmentation faults`.
