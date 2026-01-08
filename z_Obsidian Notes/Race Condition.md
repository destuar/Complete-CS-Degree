# Race Condition

A **Race Condition** involves behavior where the output of a system depends on the sequence or timing of other non-deterministic events (like thread scheduling).

## Example
Two threads trying to increment the same counter:
1.  Thread A reads `x` (value 10).
2.  Thread B reads `x` (value 10).
3.  Thread A increments to 11 and writes back.
4.  Thread B increments to 11 and writes back.
**Result**: `x` is 11, should be 12.

## Prevention
- **Locks/Mutexes**: Ensure mutual exclusion.
- **Atomic Operations**: Hardware instructions that complete in a single step.
- **Semaphores**: Control access to shared resources.

## Relevance
- Major bug source in [[Concurrent Programming]].
