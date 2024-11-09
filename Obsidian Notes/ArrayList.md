An **ArrayList** in [[Java]] is a resizable array-like data structure. Unlike standard arrays, which have a fixed size, an ArrayList can grow and shrink dynamically, making it ideal for situations where the number of elements may vary over time.

### Key Features of ArrayList

1. **Dynamic Sizing**: Unlike arrays, ArrayLists automatically adjust their size as elements are added or removed.
2. **Indexed Access**: ArrayLists allow fast access to elements using an index, similar to arrays.
3. **Allows Duplicates**: ArrayLists can contain duplicate elements and maintain insertion order.

### Basic Syntax

To use an ArrayList, import it from `java.util` and specify the type of elements it will hold (using generics).

`import java.util.ArrayList;  
`ArrayList<Type> listName = new ArrayList<>();`

- `Type` is the data type of elements the ArrayList will store (e.g., `Integer`, `String`, `CustomObject`).
- `listName` is the name you assign to the ArrayList.

### Common Methods

1. **`add(element)`**: Adds an element to the end of the list.
2. **`add(index, element)`**: Adds an element at a specific position in the list.
3. **`get(index)`**: Retrieves the element at the specified index.
4. **`remove(element)` or `remove(index)`**: Removes the specified element or the element at a specific index.
5. **`size()`**: Returns the number of elements in the ArrayList.
6. **`isEmpty()`**: Checks if the ArrayList is empty.
7. **`clear()`**: Removes all elements from the ArrayList.