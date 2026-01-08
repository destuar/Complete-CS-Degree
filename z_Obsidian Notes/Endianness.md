# Endianness

**Endianness** describes the order in which a sequence of bytes is stored in computer memory for multi-byte data types (like `int`, `float`).

## Types
### 1. Big-Endian
- The **Most Significant Byte (MSB)** is stored at the **lowest** memory address.
- "Big end first".
- Analogous to reading English numbers (left to right).
- Network Byte Order (TCP/IP) is Big-Endian.

### 2. Little-Endian
- The **Least Significant Byte (LSB)** is stored at the **lowest** memory address.
- "Little end first".
- Used by x86 and x86-64 architectures (Intel/AMD).

## Example
Value: `0x12345678` (32-bit integer) stored at address `0x100`.

| Address | Big-Endian | Little-Endian |
| :--- | :--- | :--- |
| `0x100` | `12` | `78` |
| `0x101` | `34` | `56` |
| `0x102` | `56` | `34` |
| `0x103` | `78` | `12` |

## Relevance
- Crucial when casting pointers between types of different sizes.
- Important for network programming and file format parsing.
