# Semaphore

A **Semaphore** is a synchronization primitive used to control access to a common resource by multiple processes/threads. It maintains a counter.

## Operations
1.  **Wait (`P`)**:
    - Decrements the counter.
    - If counter < 0, block the thread.
2.  **Signal (`V`)**:
    - Increments the counter.
    - If there are blocked threads, wake one up.

## Types
- **Binary Semaphore (Mutex)**: Value is 0 or 1. Used for mutual exclusion (like a lock).
- **Counting Semaphore**: Value > 1. Used to control access to a pool of resources (e.g., 5 connections allowed).

## Analogy
A library with 5 study rooms.
- Counter = 5.
- Student enters -> value--.
- Student leaves -> value++.
- If value is 0, next student waits.

## Relevance
- Classic synchronization tool in [[Concurrent Programming]].
