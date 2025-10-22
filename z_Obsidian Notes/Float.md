# Float

A float is **4 bytes (32 bits)** in memory.

## Key Characteristics

- **Size**: 4 bytes or 32 bits
- **Purpose**: Represents numbers with fractional parts (decimal values)
- **Format**: Uses IEEE 754 floating-point standard
  - **Sign bit**: 1 bit
  - **Exponent**: 8 bits
  - **Fractional part (Mantissa)**: 23 bits

## Representation

Unlike integers, floats use a specific format to represent both very small and very large numbers:
- The sign bit determines if the number is positive or negative
- The exponent allows for a wide range of magnitudes
- The mantissa stores the precision of the number

This format allows floats to represent a wide range of values, from very small to very large numbers.

## Related Concepts

- [[Double]] - Higher precision floating-point type (8 bytes)
- [[Int]] - Same size but for whole numbers (4 bytes)
- [[Struct]] - Can contain floats as members

