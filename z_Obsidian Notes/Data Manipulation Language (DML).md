# Data Manipulation Language (DML)

A **Data Manipulation Language (DML)** is a subset of SQL that provides commands for retrieving, inserting, updating, and deleting data within database tables. DML statements allow users and applications to interact with the actual data content, performing CRUD operations (Create, Read, Update, Delete) while maintaining data integrity and consistency.

## Basic Definition

DML provides operational statements that manipulate the **data content** of a database system. It enables users to:

- **Retrieve** data through flexible query operations
- **Insert** new records into database tables
- **Update** existing data values and records
- **Delete** records from database tables
- **Maintain** data consistency and referential integrity

## Core DML Commands

### **SELECT Statement**
- **Data Retrieval**: Query and extract data from tables
- **Column Selection**: Choose specific columns or all columns
- **Row Filtering**: Apply conditions to limit results
- **Data Aggregation**: Group and summarize data
- **Sorting**: Order results by specified criteria

### **INSERT Statement**
- **Single Row Insert**: Add one record at a time
- **Multiple Row Insert**: Add multiple records in one statement
- **Bulk Insert**: Load large datasets efficiently
- **Select-based Insert**: Insert data from query results
- **Default Values**: Use system or user-defined defaults

### **UPDATE Statement**
- **Column Updates**: Modify specific column values
- **Conditional Updates**: Update only rows meeting criteria
- **Bulk Updates**: Modify multiple rows simultaneously
- **Join-based Updates**: Update using data from other tables
- **Rollback Support**: Undo changes if needed

### **DELETE Statement**
- **Row Deletion**: Remove specific records from tables
- **Conditional Deletion**: Delete only rows meeting criteria
- **Bulk Deletion**: Remove multiple rows efficiently
- **Referential Integrity**: Maintain foreign key relationships
- **Cascade Operations**: Handle dependent record deletion

## SELECT Query Operations

### **Basic SELECT Syntax**
```sql
SELECT [DISTINCT] column1, column2, ...
FROM table_name
[WHERE condition]
[GROUP BY column1, column2, ...]
[HAVING group_condition]
[ORDER BY column1 [ASC|DESC], ...]
[LIMIT number];
```

### **Column Selection**
- **All Columns**: `SELECT * FROM table_name`
- **Specific Columns**: `SELECT column1, column2 FROM table_name`
- **Calculated Columns**: `SELECT column1, column1 * 2 AS doubled`
- **Column Aliases**: `SELECT column1 AS alias_name`
- **Distinct Values**: `SELECT DISTINCT column1 FROM table_name`

### **WHERE Clause Filtering**
- **Comparison Operators**: `=`, `<>`, `<`, `>`, `<=`, `>=`
- **Logical Operators**: `AND`, `OR`, `NOT`
- **Pattern Matching**: `LIKE`, `ILIKE`, `REGEXP`
- **Range Queries**: `BETWEEN`, `IN`, `EXISTS`
- **Null Handling**: `IS NULL`, `IS NOT NULL`

## Data Insertion Operations

### **INSERT Syntax**
```sql
-- Single row insert
INSERT INTO table_name (column1, column2, ...)
VALUES (value1, value2, ...);

-- Multiple row insert
INSERT INTO table_name (column1, column2, ...)
VALUES 
    (value1a, value2a, ...),
    (value1b, value2b, ...),
    ...;

-- Select-based insert
INSERT INTO table_name (column1, column2, ...)
SELECT column1, column2, ... FROM source_table;
```

### **Insert Strategies**
- **Explicit Columns**: Specify exact columns for insertion
- **Default Values**: Use `DEFAULT` keyword for auto-generated values
- **Null Handling**: Explicitly insert `NULL` or omit columns
- **Auto-increment**: Let system generate primary key values
- **Bulk Loading**: Use specialized tools for large datasets

### **Data Validation**
- **Type Checking**: Ensure data types match column definitions
- **Constraint Validation**: Verify NOT NULL, UNIQUE, CHECK constraints
- **Referential Integrity**: Validate foreign key relationships
- **Business Rules**: Apply custom validation logic
- **Error Handling**: Manage constraint violation errors

## Data Update Operations

### **UPDATE Syntax**
```sql
UPDATE table_name
SET column1 = value1, column2 = value2, ...
[WHERE condition]
[ORDER BY column1, ...]
[LIMIT number];
```

### **Update Patterns**
- **Single Row Update**: Modify one specific record
- **Conditional Updates**: Update rows meeting criteria
- **Bulk Updates**: Modify multiple rows simultaneously
- **Join-based Updates**: Update using data from other tables
- **Incremental Updates**: Modify existing values (e.g., `SET count = count + 1`)

### **Update Considerations**
- **Transaction Safety**: Ensure atomicity of update operations
- **Performance Impact**: Consider index updates and constraint checking
- **Locking Behavior**: Understand row-level and table-level locks
- **Rollback Capability**: Plan for update reversal if needed
- **Audit Trail**: Track what data was changed and when

## Data Deletion Operations

### **DELETE Syntax**
```sql
DELETE FROM table_name
[WHERE condition]
[ORDER BY column1, ...]
[LIMIT number];
```

### **Deletion Strategies**
- **Selective Deletion**: Remove only specific records
- **Bulk Deletion**: Remove large numbers of records efficiently
- **Cascade Deletion**: Handle dependent record removal
- **Soft Deletion**: Mark records as deleted without physical removal
- **Archive Deletion**: Move deleted data to archive tables

### **Deletion Considerations**
- **Referential Integrity**: Maintain foreign key relationships
- **Cascade Rules**: Define behavior for dependent records
- **Performance Impact**: Consider index updates and constraint checking
- **Recovery Options**: Plan for data restoration if needed
- **Storage Reclamation**: Optimize storage after deletions

## Advanced Query Operations

### **JOIN Operations**
- **INNER JOIN**: Return only matching records from both tables
- **LEFT JOIN**: Return all records from left table and matching from right
- **RIGHT JOIN**: Return all records from right table and matching from left
- **FULL JOIN**: Return all records from both tables
- **CROSS JOIN**: Return Cartesian product of both tables

### **Aggregation Functions**
- **COUNT**: Count number of rows or non-null values
- **SUM**: Calculate sum of numeric values
- **AVG**: Calculate average of numeric values
- **MIN/MAX**: Find minimum or maximum values
- **GROUP_CONCAT**: Concatenate values from multiple rows

### **Subqueries & CTEs**
- **Scalar Subqueries**: Return single value for comparison
- **Column Subqueries**: Return single column for IN operations
- **Table Subqueries**: Return result set for FROM clause
- **Common Table Expressions (CTEs)**: Define temporary result sets
- **Recursive CTEs**: Handle hierarchical data structures

## Performance & Optimization

### **Query Performance**
- **Index Usage**: Ensure queries can use appropriate indexes
- **Selectivity**: Choose selective columns for WHERE clauses
- **Join Order**: Optimize table join sequence
- **Column Selection**: Select only needed columns
- **Result Limiting**: Use LIMIT and pagination for large results

### **Bulk Operations**
- **Batch Processing**: Group multiple operations in transactions
- **Bulk Insert**: Use specialized bulk insert tools
- **Batch Updates**: Update multiple rows efficiently
- **Batch Deletes**: Remove multiple rows in single operation
- **Transaction Management**: Balance performance with consistency

### **Memory & Storage**
- **Buffer Management**: Optimize memory usage for large operations
- **Temporary Tables**: Use temp tables for complex operations
- **Partitioning**: Leverage table partitioning for large datasets
- **Compression**: Use data compression for storage efficiency
- **Cleanup Operations**: Regular maintenance for optimal performance

## Data Integrity & Constraints

### **Constraint Enforcement**
- **Primary Key**: Ensure unique identification of records
- **Foreign Key**: Maintain referential integrity between tables
- **Unique Constraints**: Prevent duplicate values in columns
- **Check Constraints**: Validate data against business rules
- **NOT NULL**: Ensure required columns have values

### **Transaction Management**
- **ACID Properties**: Maintain atomicity, consistency, isolation, durability
- **Commit/Rollback**: Control transaction completion or reversal
- **Savepoints**: Create intermediate points within transactions
- **Lock Management**: Handle concurrent access to data
- **Deadlock Prevention**: Avoid circular wait conditions

### **Error Handling**
- **Constraint Violations**: Handle data integrity errors gracefully
- **Type Mismatches**: Manage data type conversion issues
- **Referential Errors**: Handle foreign key constraint violations
- **Business Rule Violations**: Apply custom validation logic
- **Recovery Procedures**: Plan for error recovery scenarios

## Security & Access Control

### **Data Access Control**
- **Row-level Security**: Control access to specific data rows
- **Column-level Security**: Restrict access to sensitive columns
- **View-based Security**: Use views to limit data exposure
- **Stored Procedures**: Encapsulate data access logic
- **Audit Logging**: Track all data manipulation operations

### **Privilege Management**
- **SELECT Privileges**: Control data retrieval permissions
- **INSERT Privileges**: Control data insertion permissions
- **UPDATE Privileges**: Control data modification permissions
- **DELETE Privileges**: Control data removal permissions
- **Role-based Access**: Use roles for permission management

### **Data Protection**
- **Encryption**: Protect sensitive data at rest and in transit
- **Masking**: Hide sensitive data in query results
- **Anonymization**: Remove personally identifiable information
- **Backup Security**: Protect backup data from unauthorized access
- **Compliance**: Meet regulatory requirements for data handling

## Tools & Development

### **DML Development Tools**
- **Query Builders**: Visual tools for constructing DML statements
- **Database Clients**: Interactive tools for executing DML operations
- **ORM Frameworks**: Object-relational mapping for application development
- **ETL Tools**: Extract, transform, and load data processing
- **Monitoring Tools**: Track DML performance and usage patterns

### **Testing & Validation**
- **Data Validation**: Verify data integrity after DML operations
- **Performance Testing**: Assess DML operation performance
- **Regression Testing**: Ensure DML changes don't break existing functionality
- **Data Quality**: Monitor data quality metrics
- **Compliance Testing**: Verify regulatory compliance requirements

### **Monitoring & Maintenance**
- **Performance Monitoring**: Track query execution times and resource usage
- **Error Monitoring**: Monitor and alert on DML operation failures
- **Usage Analytics**: Analyze DML operation patterns and trends
- **Capacity Planning**: Plan for data growth and performance requirements
- **Backup Verification**: Ensure data backup and recovery procedures work correctly

## Applications & Use Cases

### **Application Development**
- **Web Applications**: CRUD operations for user interfaces
- **Mobile Apps**: Data synchronization and local storage
- **Desktop Applications**: Local database management
- **API Services**: Data access for external applications
- **Microservices**: Service-specific data operations

### **Data Management**
- **Data Warehousing**: ETL processes and data loading
- **Business Intelligence**: Data extraction for reporting and analytics
- **Data Migration**: Moving data between systems
- **Data Cleansing**: Improving data quality through updates
- **Data Archiving**: Moving old data to archive storage

### **System Administration**
- **Database Maintenance**: Regular data cleanup and optimization
- **User Management**: Adding, updating, and removing user accounts
- **Configuration Management**: Updating system configuration data
- **Log Management**: Managing audit and system log data
- **Backup Management**: Managing backup and recovery data

## Key Features

### **Data Manipulation Capabilities**
- **CRUD Operations**: Complete Create, Read, Update, Delete functionality
- **Flexible Queries**: Powerful SELECT statements with complex conditions
- **Bulk Operations**: Efficient handling of large datasets
- **Transaction Support**: ACID-compliant data operations
- **Error Handling**: Robust error management and recovery

### **Performance & Scalability**
- **Query Optimization**: Automatic and manual query optimization
- **Index Support**: Efficient data access through indexing
- **Parallel Processing**: Support for concurrent operations
- **Resource Management**: Efficient memory and storage usage
- **Scalability**: Handle growing data volumes and user loads

### **Integration & Interoperability**
- **SQL Standards**: Compliance with industry SQL standards
- **API Support**: Programmatic access through various APIs
- **Tool Integration**: Work with various database tools and utilities
- **Cross-platform**: Support for different operating systems
- **Language Support**: Integration with multiple programming languages

## Important Notes

- **DML vs DDL**: DML manipulates data, DDL defines structure
- **Transaction Safety**: DML operations support ACID properties
- **Performance Impact**: Complex queries can affect system performance
- **Data Integrity**: DML operations enforce data constraints and rules
- **Security**: Implement proper access controls for DML operations

## Related Concepts

- **[[SQL]]**: DML is a subset of SQL for data operations
- **[[Data Definition Language (DDL)]]**: Complementary SQL subset for defining database structure
- **[[Relational Algebra]]**: Mathematical foundation for DML operations
- **[[Database Management System (DBMS)]]**: Software systems that implement DML
