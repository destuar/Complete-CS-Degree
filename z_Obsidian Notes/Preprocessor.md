# Preprocessor

The **Preprocessor** is the first step in the build process for C/C++ programs, handling directives that begin with `#` before actual compilation begins.

## Key Directives
- `#define`: Performs text substitution. Used for constants and macros.
- `#include`: Pastes the contents of another file (header file) into the current file.
- `#ifdef` / `#ifndef` / `#endif`: Conditional compilation.

## Macros
- **Glorified Find and Replace**: `#define MAX_WIDTH 100` replaces all instances of `MAX_WIDTH` with `100`.
- **Function-like Macros**: `#define MAX(a,b) ((a) > (b) ? (a) : (b))`
    - *Danger*: Arguments with side effects (e.g., `MAX(x++, y)`) can be evaluated multiple times, causing bugs.

## Relevance
- Essential for cross-platform support, conditional debugging (stripping `assert`s), and code organization.
