# Isolation Levels

## Purpose

Isolation levels control how transactions interact during concurrent execution, balancing **consistency** vs. **performance/concurrency**.

**Serializability** ensures interleaved execution behaves as if transactions run in serial order, but comes with overhead and reduced concurrency. Weaker isolation levels trade consistency for higher concurrency and lower overhead.

## SQL Standard Isolation Levels

### **Read Uncommitted** (Weakest)

**Allows Dirty Reads**: Can read values modified by uncommitted transactions
- Highest concurrency, lowest overhead
- Risk: May read data that is later rolled back
- **Use Case**: When approximate values are acceptable

### **Read Committed**

**Prevents Dirty Reads**: Only reads committed data
- Still doesn't guarantee global serializability
- Issue: Transaction may read different values of same item if another transaction commits between reads
- **Non-repeatable Reads**: Same query returns different results within transaction

### **Repeatable Read**

**Prevents Dirty & Non-repeatable Reads**: Same item always returns same value within transaction
- Stronger than read committed
- Still doesn't guarantee global serializability
- Issue: **Phantom Tuples** - new rows inserted by other transactions can appear in subsequent reads
- **Default** for Oracle and MySQL (prioritizes performance)

### **Serializable** (Strongest)

**Full Consistency**: Equivalent to serial execution
- Prevents dirty reads, non-repeatable reads, and phantom tuples
- Lowest concurrency, highest overhead
- **Guarantee**: Concurrent transactions behave as if executed sequentially

## Key Characteristics

- **Set per transaction**: Each transaction can specify its own isolation level
- **Primarily affects reads**: Controls what values can be seen
- **Trade-off**: Consistency ↔ Performance/Concurrency

## Isolation Level Comparison

| Level | Dirty Reads | Non-repeatable Reads | Phantom Tuples | Performance |
|-------|-------------|----------------------|----------------|-------------|
| Read Uncommitted | ✓ Allowed | ✓ Allowed | ✓ Allowed | Highest |
| Read Committed | ✗ Prevented | ✓ Allowed | ✓ Allowed | High |
| Repeatable Read | ✗ Prevented | ✗ Prevented | ✓ Allowed | Medium |
| Serializable | ✗ Prevented | ✗ Prevented | ✗ Prevented | Lowest |

## Related Concepts

- [[Transactions]]
- [[Concurrency]]
- [[Database Management System (DBMS)]]

