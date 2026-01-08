# Assembly Language

**Assembly Language** is a low-level programming language that has a strong correspondence between the instructions in the language and the architecture's machine code instructions.

## Key Characteristics
- **Human-Readable**: Uses mnemonics (like `MOV`, `ADD`, `SUB`) instead of raw binary.
- **Architecture-Specific**: x86 assembly is different from ARM or MIPS assembly.
- **Registers**: Operates directly on CPU registers rather than variables.

## Common x86 Instructions
- `MOV src, dest`: Copies data.
- `ADD src, dest`: Adds `src` to `dest`.
- `PUSH src`: Pushes value onto the stack.
- `POP dest`: Pops value from the stack.
- `CALL target`: Calls a function (pushes return address).
- `RET`: Returns from a function (pops return address).

## Relevance
- Understanding assembly is crucial for reverse engineering, optimizing performance-critical code, and understanding how High-Level Languages (C/C++) map to hardware.
