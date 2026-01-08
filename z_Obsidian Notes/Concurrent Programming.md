# Concurrent Programming

**Concurrent Programming** is a paradigm concerned with the execution of multiple sequences of operations (processes or threads) that overlap in time.

## Basic Definitions
- **Concurrency**: The composition of independently executing processes. (Dealing with multiple things at once).
- **Parallelism**: The simultaneous execution of computation. (Doing multiple things at once).
- **Thread**: The smallest sequence of programmed instructions that can be managed independently by a scheduler.

## Key Challenges
- **Synchronization**: Coordinating access to shared resources to prevent race conditions.
- **Deadlock**: A state where processes are unable to proceed because each is waiting for the other to release a resource.
- **Race Condition**: Behavior depends on the relative timing of events.

## Mechanisms
- **Locks/Mutexes**: Enforce limits on access to a resource.
- **Semaphores**: Variable or abstract data type used to control access to a common resource by multiple processes.

## Relations
- Often contrasts with sequential [[Procedural Programming]].

## Applications
- Server handling multiple client requests.
- User interfaces remaining responsive during background computation.
