# Void Pointer

A **Void Pointer** (`void*`) is a generic pointer type in C and C++ that has **no associated data type**. It can hold the address of any data type.

## Key Characteristics
- **Generic Storage**: Can point to an `int`, `float`, struct, or any other type.
- **No Dereference**: You cannot directly dereference a `void*` because the compiler doesn't know the size or interpretation of the data.
- **No Pointer Arithmetic**: You cannot perform arithmetic (e.g., `ptr + 1`) directly, as the step size is unknown.

## Usage
- **Casting**: Must be cast to a specific type before use.
  ```c
  void* ptr = &myInt;
  int val = *(int*)ptr; // Cast to int* then dereference
  ```
- **Generic Functions**: Used to create polymorphic functions in C (e.g., `qsort`, `memcpy`, `swap`).

## Example: Generic Swap
```c
void swap(void* vp1, void* vp2, int size) {
    char buffer[size]; 
    memcpy(buffer, vp1, size);
    memcpy(vp1, vp2, size);
    memcpy(vp2, buffer, size);
}
```

## Relevance
- Essential for [[Generic Programming]] in C.
- Basis for low-level memory manipulation functions like `malloc` (which returns `void*`).
