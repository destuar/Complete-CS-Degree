# OS Multithreading

**OS Multithreading** refers to the operating system's ability to manage multiple threads of execution within a single process.

## Key Concepts
- **Kernel-Level Threads**: Managed directly by the OS kernel. Slower creation but blocking calls don't block the entire process.
- **User-Level Threads**: Managed by a library in user space. Fast creation but the kernel sees them as a single process.
- **Scheduler**: The OS component that decides which thread runs on which CPU core and for how long.
- **Preemption**: The ability of the OS to interrupt a running thread to run another.

## Relevance
- The foundation for [[Concurrent Programming]].
- CS107 focuses on how we *use* these threads (via standard libraries) and the synchronization challenges that arise.
