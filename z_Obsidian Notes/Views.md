# Views

A **view** is a virtual table defined by a query over existing tables or other views. It provides a logical abstraction layer on top of base relations without storing actual data.

## Three-Level Database Architecture

1. **Physical Layer**: Actual data stored on disk
2. **Conceptual Layer**: Data abstracted into relations (tables)
3. **Logical Layer**: Further abstraction into views (queries over relations)

## Benefits

### **Data Hiding**
- Hide specific data from certain users
- Provide granular access control beyond entire tables
- Security and privacy control

### **Query Simplification**
- Make complex queries easier and more natural
- Query over views instead of complex joins on base tables
- Reduce query complexity for end users

### **Modularity**
- Views act as modules for organized database access
- Provide specific portions of database to applications
- Easier maintenance and updates

## SQL Syntax

```sql
-- Basic syntax
CREATE VIEW view_name AS query;

-- With explicit attributes
CREATE VIEW view_name(attr1, attr2, ...) AS query;

-- Drop view
DROP VIEW view_name;
```

## View Execution

### **Conceptual Execution**
When query references a view:
1. Temporary table with view's contents is created
2. Query runs over this temporary table
3. Results returned

### **Actual Execution**
What really happens:
1. Query is rewritten to directly use base tables
2. View definition substituted into the query
3. Optimized into simpler, more efficient query
4. **No intermediate table stored** (views are logical, not physical)

## Related Concepts

- [[SQL]]
- [[Relational Database]]
- [[Database Management System (DBMS)]]

