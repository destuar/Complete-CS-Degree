**Stores key-value pairs, where each key is unique, and values can be retrieved efficiently using the key.**

Internally, `HashMap` uses a hashing mechanism to organize and access data.

- **Key-Value Pair Storage**:
    - Each entry in a `HashMap` consists of a key and a corresponding value.
    - Example: `{ "Apple": 10, "Banana": 20 }`

- **Unique Keys**:
    - Keys must be unique. Adding a new key with an existing key overwrites the old value.

- **Allows Null**:
    - `HashMap` allows one `null` key and multiple `null` values.

- **Unordered**:
    - `HashMap` does not maintain any order for its keys or values.

- **Fast Lookups**:
    - Provides constant-time performance (O(1)) for basic operations like `put()` and `get()`, assuming a good hash function.

- Implemented using a special array called a [[Hash Table]]
	- very fest, but keys are stored in unpredictable order
	- *the keys' type must have a hashCode function (but most types have one)*

Tags:
[[Java]]