# Byte Addressability

**Byte Addressability** refers to a hardware architecture where the smallest unit of memory that can be individually addressed is a **byte** (typically 8 bits).

## Basic Definitions
- **Address Space**: The range of discrete addresses in memory.
- **Byte**: 8 bits. The fundamental unit of storage in modern architectures.
- **Word**: A natural unit of data used by a particular processor design (e.g., 32-bit or 64-bit).

## How It Works
- Each address in memory points to a specific 8-bit byte. 
- To store a 32-bit integer (4 bytes), the system uses 4 consecutive memory addresses.
- **Pointer Arithmetic**: In languages like C/C++, adding 1 to a pointer advances it by `sizeof(type)` bytes, not just 1 byte.

## Endianness
- **Big-Endian**: The most significant byte is stored at the smallest address.
- **Little-Endian**: The least significant byte is stored at the smallest address.

## Relevance
- Fundamental to understanding [[Memory Layout]] and [[Pointers]].
- Critical in [[C++]] and Systems Programming.
