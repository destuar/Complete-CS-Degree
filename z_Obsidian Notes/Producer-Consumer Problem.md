# Producer-Consumer Problem

The **Producer-Consumer Problem** is a classic synchronization problem where two types of threads share a fixed-size buffer.

## Roles
- **Producer**: Generates data and puts it into the buffer.
- **Consumer**: Takes data out of the buffer.

## Constraints
1.  Producer must not add data if the buffer is full.
2.  Consumer must not remove data if the buffer is empty.
3.  Access to the buffer must be mutually exclusive.

## Solution
- Typically implemented using **Semaphores** (one for "empty slots", one for "full slots") and a **Mutex** (for buffer access).

## Relevance
- A foundational pattern in [[Concurrent Programming]] and OS design (e.g., pipes, message queues).
