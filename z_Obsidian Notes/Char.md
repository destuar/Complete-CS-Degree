# Char

A char is typically **1 byte (8 bits)** in memory.

## Key Characteristics

- **Size**: 1 byte or 8 bits
- **Possible Values**: Can distinguish between 2^8 (256) different values
- **Purpose**: Primarily used to store single characters (letters, digits, symbols)
- **Encoding**: Typically uses ASCII or extended ASCII character encoding
- **Sign**: Can be signed or unsigned depending on the implementation
  - Signed char: -128 to 127
  - Unsigned char: 0 to 255

## Common Uses

- Storing individual characters ('A', 'z', '!', etc.)
- Small integer values when memory is a concern
- Byte-level data manipulation
- Character arrays for strings in C

## Note

In C, a string is represented as an array of chars terminated by a null character (`'\0'`).

## Related Concepts

- [[Short]] - Larger integer type (2 bytes)
- [[Int]] - Even larger integer type (4 bytes)
- [[Struct]] - Can contain chars as members

