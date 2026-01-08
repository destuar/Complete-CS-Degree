# Integer Representation

**Integer Representation** refers to how integer data types are encoded in binary within a computer's memory.

## Basic Definitions
- **Unsigned Integer**: Represents only non-negative numbers ($0$ to $2^n - 1$).
- **Signed Integer**: Represents both positive and negative numbers (typically $-2^{n-1}$ to $2^{n-1} - 1$).
- **Bit Width**: The number of bits used (e.g., 8-bit `char`, 32-bit `int`).

## Encoding Schemes
### 1. Unsigned
- Direct binary translation.
- Example (4-bit): $0011_2 = 3_{10}$.

### 2. Sign-Magnitude
- Most significant bit (MSB) is the sign ($0$ for +, $1$ for -).
- Issues: Two zeros ($+0$ and $-0$).

### 3. Two's Complement (Standard)
- To negate a number: Flip all bits and add 1.
- **MSB**: Still acts as a sign bit ($1$ is negative).
- **Advantages**: Single zero, simplifies arithmetic (addition works normally for both signed/unsigned).

## Ranges (for $n$ bits)
| Type | Range |
| :--- | :--- |
| Unsigned | $[0, 2^n - 1]$ |
| Signed (2's Comp) | $[-2^{n-1}, 2^{n-1} - 1]$ |

## Relevance
- Critical for understanding overflows and bitwise operations in [[C++]] and C.
- Explains behavior of casting between signed and unsigned types.
