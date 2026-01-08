# Function Pointers

A **Function Pointer** is a variable that stores the memory address of a function, allowing it to be called dynamically.

## Syntax
`ReturnType (*PointerName)(ParameterTypes);`
- Example: `int (*compare)(const void*, const void*)`

## Applications
1.  **Callbacks**: Passing a function to another function to be executed later (e.g., event handlers).
2.  **Generic Algorithms**:
    - `qsort` and `bsearch` use function pointers for custom comparisons.
    - `lsearch` uses it to define equality.
3.  **Polymorphism in C**: Simulating virtual methods by storing function pointers in structs.

## Example
```c
int add(int a, int b) { return a + b; }

int main() {
    int (*func_ptr)(int, int) = add;
    int result = func_ptr(2, 3); // Calls add(2, 3)
}
```

## Relevance
- Core to enabling flexibility in [[Generic Programming]].
