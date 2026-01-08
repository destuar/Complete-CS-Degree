# Thread Management

**Thread Management** involves the creation, scheduling, and synchronization of threads within a process.

## Key Concepts
- **Manager/Worker Pattern**: A main "Manager" thread delegates tasks to "Worker" threads (e.g., a web server handling multiple requests).
- **Context Switching**: The process of storing the state of an active thread so that it can be resumed later, allowing multiple threads to share a single CPU.
- **Join**: A function (like `pthread_join`) that allows one thread to wait for another to finish execution.

## Relevance
- Critical for maximizing CPU utilization and responsiveness in [[Concurrent Programming]].
