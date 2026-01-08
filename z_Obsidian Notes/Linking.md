# Linking

**Linking** is the final stage of the build process, taking one or more object files (`.o`) and libraries to produce a final executable.

## Responsibilities
- **Symbol Resolution**: Matches function calls (e.g., `printf`) with their definitions in other files or libraries.
- **Relocation**: Adjusts internal addresses now that all code segments are being combined.

## Types
- **Static Linking**: Copies library code directly into the executable at build time.
- **Dynamic Linking**: References shared libraries (`.dll`, `.so`) that are loaded at runtime.

## Common Errors
- **Undefined Reference**: The linker cannot find a definition for a declared function.
- **Multiple Definition**: The same symbol is defined in multiple object files.
