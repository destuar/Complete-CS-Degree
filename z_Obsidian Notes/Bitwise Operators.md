# Bitwise Operators

**Bitwise Operators** perform operations on integer data at the individual [[Bit]] level.

## Operators (in C/C++)
| Operator | Symbol | Description | Example ($A=1010, B=1100$) |
| :--- | :--- | :--- | :--- |
| **AND** | `&` | 1 if both bits are 1 | `A & B` = $1000$ |
| **OR** | `|` | 1 if at least one bit is 1 | `A | B` = $1110$ |
| **XOR** | `^` | 1 if bits are different | `A ^ B` = $0110$ |
| **NOT** | `~` | Inverts all bits | `~A` = $0101$ |
| **Left Shift** | `<<` | Shifts bits left (multiply by $2^n$) | `A << 1` = $10100$ |
| **Right Shift** | `>>` | Shifts bits right (divide by $2^n$) | `A >> 1` = $0101$ |

## Applications
- **Masking**: Extracting specific bits (e.g., getting RGB values from a color integer).
- **Flags**: Efficiently storing boolean states in a single integer.
- **Performance**: Shift operations are often faster than multiplication/division.

## Relevance
- Essential for low-level systems programming and optimizing [[Integer Representation]].
