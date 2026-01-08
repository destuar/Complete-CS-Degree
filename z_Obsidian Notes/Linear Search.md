# Linear Search

**Linear Search** is a simple search algorithm that checks every element in a detailed list sequentially until a match is found or the whole list has been searched.

## Algorithm
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(1)$ (Iterative)

## Generic Implementation (C)
In [[Generic Programming]], linear search is implemented to work on any data type using `void*` and a client-provided comparison function.

```c
void* lsearch(void* key, void* base, int n, int elemSize, int (*cmp)(void*, void*)) {
    for (int i = 0; i < n; i++) {
        // Calculate address of the ith element: base + i * elemSize
        void* elemAddr = (char*)base + i * elemSize;
        if (cmp(key, elemAddr) == 0) {
            return elemAddr; // Found
        }
    }
    return NULL; // Not found
}
```

## Comparisons
- **Vs. Binary Search**: Linear search is slower ($O(n)$ vs $O(\log n)$) but requires no pre-sorting. Binary search (like `bsearch`) requires the array to be sorted.

## Relevance
- Fundamental example of generic algorithms in C.
- demonstrator of [[Pointer Arithmetic]].
