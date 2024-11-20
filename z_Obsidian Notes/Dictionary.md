**Data structure used to store data as *key-value pairs*. It allows efficient retrieval, insertion, and deletion of values based on their associated keys.**

- **Key-Value Pair Storage**:
    - Each entry in a dictionary is a pair consisting of a key and a value.
    - Example: `{"name": "Alice", "age": 30}`

- **Unique Keys**:
    - Keys must be unique and immutable (e.g., strings, numbers, tuples).
    - Values can be of any data type and do not have to be unique.

- **Dynamic**:
    - Dictionaries are dynamic, allowing you to add or remove key-value pairs at runtime.

- **Ordered**:
    - In Python 3.7+, dictionaries maintain insertion order.

- **Fast Lookups**:
    - Lookup, insertion, and deletion operations are generally O(1), thanks to their internal use of a hash table.

Tags:
[[Python]]
