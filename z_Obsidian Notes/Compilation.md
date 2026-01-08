# Compilation

**Compilation** is the process of translating source code (e.g., `.c` files) into machine code (object files, `.o`), after preprocessing but before linking.

## Key Concepts
- **Translation Unit**: The output of the preprocessor (source file + included headers).
- **Symbol Table**: Keeps track of variable and function names.
- **Syntax Checking**: Ensures code follows language rules.
- **Output**: An object file containing machine instructions but with unresolved references to external functions (like `printf`).

## vs. Linking
- Compilation works on one file at a time.
- [[Linking]] combines multiple object files into a single executable.
