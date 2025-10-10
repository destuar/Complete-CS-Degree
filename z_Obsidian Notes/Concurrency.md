# Database Concurrency & Transactions

## Concurrency Problems

**Single Attribute Level**: Multiple clients modifying same attribute → lost updates

**Tuple Level**: Clients modifying different attributes of same record → interleaved operations lose changes

**Table Level**: Interleaved operations on related tables → order of updates matters for consistency

**Multiple Tables**: Interrupted sequences across tables → inconsistent states

## System Failures

- Crash during bulk loading → half-loaded inconsistent state
- Failure during multi-step operations → data duplication/loss
- Crash before in-memory modifications written to disk → inconsistent state

## Transactions: The Solution

**Definition**: Sequence of one or more operations treated as a unit

**Key Properties**:
- **Isolation**: Each transaction appears to run in isolation from others
- **Atomicity**: Transaction is either executed entirely or not at all (all-or-nothing)

**SQL Implementation**:
- Begins with first SQL statement
- Ends with `COMMIT`, session termination, or AUTOCOMMIT mode
- AUTOCOMMIT: Each statement is its own transaction

**Goal**: Clients execute statements without worrying about concurrent activities while maintaining high performance

## Related Concepts

- [[Database Management System (DBMS)]]
- [[SQL]]
- [[Relational Database]]
