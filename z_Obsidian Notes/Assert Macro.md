# Assert Macro

The **Assert Macro** (`assert(condition)`) is a debugging tool used to verify assumptions made by the program during execution.

## Behavior
- If `condition` is true: Does nothing.
- If `condition` is false: Aborts the program and prints an error message (file, line number).

## Implementation
```c
#ifdef NDEBUG
  #define assert(cond) (void)0
#else
  #define assert(cond) \
    if (!(cond)) { \
      fprintf(stderr, "Assertion failed: %s, file %s, line %d\n", #cond, __FILE__, __LINE__); \
      abort(); \
    }
#endif
```

## Usage
- **Invariants**: Checking conditions that should logically never be false if the code is correct.
- **stripping**: Can be disabled in production builds (by defining `NDEBUG`) for zero runtime cost.
