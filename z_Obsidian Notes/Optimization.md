# Optimization

**Optimization** is the process of modifying a system to make it work more efficiently or use fewer resources (time, memory).

## Key Concepts
- **Static vs Dynamic Instruction Count**: Code size vs. actual instructions executed at runtime.
- **Common Compiler Optimizations (GCC)**:
    - **Dead Code Elimination**: Removing code that does not affect logic.
    - **Constant Folding**: Pre-calculating constant expressions ($3 + 5 \to 8$).
    - **Loop Unrolling**: Reducing loop control overhead by executing string bodies multiple times per iteration.
    - **Inline Expansion**: Replacing a function call with the body of the function.

## Trade-offs
- Optimization often reduces readability.
- "Premature optimization is the root of all evil" (Knuth) - Focus on correctness first, then optimize critical paths.

## Relevance
- Crucial for systems programming and embedded systems.
