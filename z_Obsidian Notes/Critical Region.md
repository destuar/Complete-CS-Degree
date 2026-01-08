# Critical Region

A **Critical Region** (or Critical Section) is a piece of code that accesses a shared resource (data structure, device, connection) that must not be concurrently accessed by more than one thread of execution.

## Requirements
1.  **Mutual Exclusion**: Only one thread at a time inside the critical region.
2.  **Progress**: If no thread is in the critical region, one seeking to enter must be allowed.
3.  **Bounded Waiting**: A thread cannot be kept waiting indefinitely to enter.

## Implementation
- Usually protected by **Locks**, **Semaphores**, or **Monitors**.
- `lock.acquire();` -> Critical Region -> `lock.release();`

## Relevance
- Fundamental concept in [[OS Multithreading]] and [[Concurrent Programming]].
