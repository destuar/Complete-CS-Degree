# Registers

**Registers** are small, incredibly fast storage locations directly inside the CPU.

## Types (x86-64 examples)
1.  **General Purpose**:
    - `RAX`: Accumulator (often stores return values).
    - `RBX`, `RCX`, `RDX`: General data storage.
    - `RDI`, `RSI`: Source/Destination indexes (often used for arguments).
2.  **Pointer/Index**:
    - `RSP` (Stack Pointer): Points to the top of the stack.
    - `RBP` (Base/Frame Pointer): Points to the base of the current [[Activation Record]].
3.  **Instruction Pointer**:
    - `RIP` (Instruction Pointer): Points to the next instruction to execute.

## Usage
- Arithmetic operations (`ADD`, `SUB`) are typically performed on registers.
- Data must be moved from memory (RAM) to registers to be processed, then moved back.

## Relevance
- The fundamental "variables" of [[Assembly Language]].
- Limited resource: Compilers work hard to keep frequently used variables in registers ("Register Allocation").
