# C String

A **C String** is a sequence of characters stored in a contiguous block of memory, terminated by a special **null character**.

## Definition
- **Type**: Simply `char*` or `char[]`.
- **Terminator**: `\0` (ASCII value 0).
- **Length**: Determined by linear search for the null terminator (unlike strings in Java/Python which store length explicitly).

## Common Operations
- `strlen(s)`: Computes length (O(n)).
- `strcpy(dest, src)`: Copies characters. **Unsafe** if dest is too small.
- `strdup(s)`: Allocates new memory (malloc) and copies string.

## Memory Diagram
For "Hi":
```
[ 'H' ] [ 'i' ] [ '\0' ]
Address: 0x100   0x101   0x102
```

## Risks
- **Buffer Overflow**: Writing past the allocated space or missing the `\0`.
- **Manual Management**: Must manually `free` strings allocated with `strdup` or `malloc`.
