# Activation Record

An **Activation Record** (or **Stack Frame**) is a block of memory on the call stack that stores information for a single function execution.

## Contents (Typical)
1.  **Return Address**: Where execution should resume after the function returns.
2.  **Saved Frame Pointer**: The previous value of `RBP` (to restore the caller's frame).
3.  **Parameters**: Arguments passed to the function (if they don't fit in registers).
4.  **Local Variables**: Variables declared within the function.
5.  **Spilled Registers**: Temporary storage for registers that need to be preserved.

## Lifecycle
1.  **Setup (Prologue)**: Allocated when a function is called (`PUSH RBP`, `MOV RBP, RSP`, `SUB RSP, size`).
2.  **Usage**: Accessed via offsets from the Frame Pointer (`RBP`).
3.  **Teardown (Epilogue)**: Deallocated when the function returns (`MOV RSP, RBP`, `POP RBP`, `RET`).

## Relevance
- Explains how recursion works (each call gets its own record).
- Explains buffer overflows (overwriting the Return Address).
