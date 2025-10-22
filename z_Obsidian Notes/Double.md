# Double

A double is **8 bytes (64 bits)** in memory.

## Key Characteristics

- **Size**: 8 bytes or 64 bits
- **Purpose**: Represents floating-point numbers with greater precision than float
- **Format**: Uses IEEE 754 double-precision floating-point standard
  - **Sign bit**: 1 bit
  - **Exponent**: 11 bits
  - **Fractional part (Mantissa)**: 52 bits

## Representation

Double provides significantly more precision and range compared to float:
- The extended exponent allows for a much wider range of values
- The larger mantissa provides greater precision (approximately 15-17 decimal digits)
- Can represent very small numbers (close to zero) and very large numbers

## Float vs Double Comparison

| Feature | Float | Double |
|---------|-------|--------|
| Size | 4 bytes | 8 bytes |
| Exponent | 8 bits | 11 bits |
| Mantissa | 23 bits | 52 bits |
| Precision | ~7 decimal digits | ~15-17 decimal digits |

## When to Use

- Scientific calculations requiring high precision
- Financial calculations where precision is critical
- Default floating-point type in many languages (e.g., Java, Python)
- When the extra memory cost is acceptable for better accuracy

## Related Concepts

- [[Float]] - Lower precision floating-point type (4 bytes)
- [[Struct]] - Can contain doubles as members

