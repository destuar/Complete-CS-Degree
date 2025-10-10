# Transactions

## ACID Properties

Transactions provide crucial guarantees for handling concurrency control and system failures in databases.

### **Atomicity**

**All-or-Nothing Execution**: Transaction is a single, indivisible unit
- Either all operations complete successfully, or none are applied
- **Rollback/Abort**: Partial effects undone if crash occurs during transaction
- **Application Awareness**: Applications may receive errors and need to restart transactions
- **Client-initiated Rollback**: Applications can manually rollback transactions

### **Consistency**

**Maintains Integrity Constraints**: Database moves between valid states
- If database starts in consistent state (all constraints met)
- Each transaction guarantees constraints hold at its end
- Database remains consistent even with interleaved transactions (due to serializability)
- **Constraint Types**: Referential integrity, domain constraints, business rules

### **Isolation**

**Appears to Run in Isolation**: Concurrent transactions don't interfere with each other
- Multiple transactions appear to execute independently
- **Serializability**: Interleaved operations produce results equivalent to some sequential order
- Final result is same as if transactions ran one-at-a-time
- Examples: Concurrent updates to enrollment, student records, GPA modifications

### **Durability**

**Permanent Storage**: Committed changes survive system failures
- Once transaction commits, changes are permanently stored
- Survives crashes, power outages, and other failures
- Changes persist after system recovery
- **Guarantee**: Committed data will be present when system restarts

## Purpose

Transactions provide a formally understood solution for:
- **Concurrency Control**: Multiple clients accessing data simultaneously
- **System Failure Management**: Maintaining consistency despite crashes
- **Reliable Operations**: Essential for critical database operations

## Related Concepts

- [[Concurrency]]
- [[Database Management System (DBMS)]]
- [[SQL]]

