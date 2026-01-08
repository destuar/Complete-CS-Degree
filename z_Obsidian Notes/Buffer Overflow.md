# Buffer Overflow

A **Buffer Overflow** is a vulnerability where a program writes data past the end of an allocated buffer in memory.

## Mechanism
- **Stack Overflow**: Overwriting the **return address** on the [[Activation Record]].
    - Can redirect control flow to execute malicious shellcode.
- **Heap Overflow**: Overwriting metadata in the [[Heap Allocator]] headers.

## Causes
- Unsafe string functions in C: `strcpy`, `gets`, `strcat` (they don't check lengths).
- Missing bounds checks in loops.

## Consequences
- **Crash (Segmentation Fault)**: Accessing invalid memory.
- **Security Exploit**: Remote Code Execution (RCE).
- **Silent Data Corruption**: Changing variable values without crashing.

## Relevance
- Major security topic in systems programming. Can be mitigated by Stack Canaries and ASLR.
