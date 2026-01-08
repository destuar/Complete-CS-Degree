# Double Pointer

A **Double Pointer** (`Type**`) is a pointer that holds the address of another pointer.

## Usage Scenarios
1.  **Modifying a Pointer**: To change where a pointer points within a function, you must pass the address of that pointer (a double pointer).
    ```c
    void allocate(int** p) {
        *p = malloc(sizeof(int));
    }
    ```
2.  **Arrays of Pointers**: Used to represent arrays of strings (`char** argv`) or 2D dynamic arrays.
3.  **Output Parameters**: Allowing a function to return a pointer via a parameter.

## Dereferencing
- `p`: The double pointer itself (address of the single pointer).
- `*p`: The single pointer (address of the data).
- `**p`: The actual data.

## Relevance
- Essential for manipulating recursive data structures (like trees) or handling [[Generic Stack]] implementations where elements might be Pointers.
