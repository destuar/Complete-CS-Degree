# SQL (Structured Query Language)

**SQL (Structured Query Language)** is a standardized programming language designed for managing and manipulating relational databases. It provides a declarative interface for defining database structures, inserting and modifying data, and retrieving information through powerful query capabilities. SQL serves as the primary language for relational database management systems (RDBMS) and is essential for data professionals, developers, and database administrators.

## Basic Definition

SQL is a **declarative language** that allows users to specify what data they want rather than how to retrieve it. The language consists of several sublanguages:

- **DDL (Data Definition Language)**: Define and modify database structure
- **DML (Data Manipulation Language)**: Insert, update, delete, and query data
- **DCL (Data Control Language)**: Control access and permissions
- **TCL (Transaction Control Language)**: Manage database transactions
- **DQL (Data Query Language)**: Retrieve and analyze data

## Core SQL Concepts

### **Database Objects**
- **Tables**: Primary storage units with rows and columns
- **Views**: Virtual tables based on stored queries
- **Indexes**: Data structures for fast data retrieval
- **Stored Procedures**: Pre-compiled SQL code blocks
- **Functions**: Reusable calculation routines
- **Triggers**: Automatic actions on data changes

### **Data Types**
- **Numeric**: INTEGER, DECIMAL(p,s), FLOAT, DOUBLE, BIGINT
- **Character**: CHAR(n), VARCHAR(n), TEXT, CLOB, NCHAR(n)
- **Date/Time**: DATE, TIME, TIMESTAMP, INTERVAL, YEAR
- **Binary**: BLOB, BINARY(n), VARBINARY(n), BIT
- **Boolean**: BOOLEAN, BIT(1), TINYINT(1)
- **JSON/XML**: Semi-structured data support

### **Constraints & Integrity**
- **NOT NULL**: Attribute cannot contain NULL values
- **UNIQUE**: Attribute values must be unique across tuples
- **PRIMARY KEY**: Unique identifier for each tuple
- **FOREIGN KEY**: Reference to primary key in another table
- **CHECK**: Custom validation rules for attribute values
- **DEFAULT**: Automatic value when no value is specified

## Data Definition Language (DDL)

### **Database & Schema Management**
```sql
-- Create database
CREATE DATABASE database_name
[CHARACTER SET charset_name]
[COLLATE collation_name];

-- Create schema
CREATE SCHEMA schema_name
[AUTHORIZATION user_name];

-- Use database/schema
USE database_name;
SET search_path TO schema_name;
```

### **Table Creation & Modification**
```sql
-- Create table
CREATE TABLE table_name (
    column1 data_type [constraints],
    column2 data_type [constraints],
    ...
    [table_constraints]
);

-- Alter table
ALTER TABLE table_name
ADD COLUMN column_name data_type [constraints];

ALTER TABLE table_name
MODIFY COLUMN column_name new_data_type;

-- Drop table
DROP TABLE [IF EXISTS] table_name;
```

### **Index Management**
```sql
-- Create index
CREATE [UNIQUE] INDEX index_name
ON table_name (column1, column2, ...);

-- Create composite index
CREATE INDEX idx_name_age ON users (last_name, age);

-- Drop index
DROP INDEX index_name ON table_name;
```

### **View Definition**
```sql
-- Create view
CREATE [OR REPLACE] VIEW view_name AS
SELECT column1, column2, ...
FROM table_name
WHERE condition;

-- Create materialized view
CREATE MATERIALIZED VIEW view_name AS
SELECT column1, column2, ...
FROM table_name
WHERE condition;
```

## Data Manipulation Language (DML)

### **SELECT Queries**
```sql
-- Basic SELECT
SELECT [DISTINCT] column1, column2, ...
FROM table_name
[WHERE condition]
[GROUP BY column1, column2, ...]
[HAVING group_condition]
[ORDER BY column1 [ASC|DESC], ...]
[LIMIT number];

-- Column selection examples
SELECT * FROM employees;                    -- All columns
SELECT name, salary FROM employees;         -- Specific columns
SELECT name, salary * 1.1 AS new_salary;   -- Calculated columns
SELECT DISTINCT department FROM employees;  -- Unique values
```

### **WHERE Clause Filtering**
```sql
-- Comparison operators
SELECT * FROM employees WHERE salary > 50000;
SELECT * FROM employees WHERE age BETWEEN 25 AND 65;
SELECT * FROM employees WHERE department IN ('IT', 'HR', 'Sales');

-- Pattern matching
SELECT * FROM employees WHERE name LIKE 'John%';      -- Starts with
SELECT * FROM employees WHERE name LIKE '%son';       -- Ends with
SELECT * FROM employees WHERE name LIKE '%oh%';       -- Contains
SELECT * FROM employees WHERE name REGEXP '^J.*n$';   -- Regex

-- Logical operators
SELECT * FROM employees 
WHERE (department = 'IT' OR department = 'HR')
  AND salary > 40000
  AND NOT terminated;
```

### **JOIN Operations**
```sql
-- INNER JOIN
SELECT e.name, d.department_name
FROM employees e
INNER JOIN departments d ON e.dept_id = d.id;

-- LEFT JOIN (preserves left table)
SELECT e.name, d.department_name
FROM employees e
LEFT JOIN departments d ON e.dept_id = d.id;

-- RIGHT JOIN (preserves right table)
SELECT e.name, d.department_name
FROM employees e
RIGHT JOIN departments d ON e.dept_id = d.id;

-- FULL JOIN (preserves both tables)
SELECT e.name, d.department_name
FROM employees e
FULL JOIN departments d ON e.dept_id = d.id;

-- Self join
SELECT e1.name AS employee, e2.name AS manager
FROM employees e1
LEFT JOIN employees e2 ON e1.manager_id = e2.id;
```

### **Aggregation & Grouping**
```sql
-- Aggregate functions
SELECT 
    COUNT(*) AS total_employees,
    AVG(salary) AS avg_salary,
    MIN(salary) AS min_salary,
    MAX(salary) AS max_salary,
    SUM(salary) AS total_salary
FROM employees;

-- GROUP BY with HAVING
SELECT 
    department,
    COUNT(*) AS emp_count,
    AVG(salary) AS avg_salary
FROM employees
GROUP BY department
HAVING COUNT(*) > 5
ORDER BY avg_salary DESC;
```

### **Subqueries & CTEs**
```sql
-- Subquery in WHERE clause
SELECT name, salary
FROM employees
WHERE salary > (SELECT AVG(salary) FROM employees);

-- Subquery in FROM clause
SELECT dept_name, avg_sal
FROM (
    SELECT d.name AS dept_name, AVG(e.salary) AS avg_sal
    FROM departments d
    JOIN employees e ON d.id = e.dept_id
    GROUP BY d.id, d.name
) AS dept_stats;

-- Common Table Expression (CTE)
WITH dept_stats AS (
    SELECT dept_id, AVG(salary) AS avg_salary
    FROM employees
    GROUP BY dept_id
)
SELECT e.name, e.salary, ds.avg_salary
FROM employees e
JOIN dept_stats ds ON e.dept_id = ds.dept_id
WHERE e.salary > ds.avg_salary;
```

### **INSERT Operations**
```sql
-- Single row insert
INSERT INTO employees (name, email, salary, dept_id)
VALUES ('John Doe', 'john@company.com', 50000, 1);

-- Multiple row insert
INSERT INTO employees (name, email, salary, dept_id)
VALUES 
    ('Jane Smith', 'jane@company.com', 55000, 1),
    ('Bob Johnson', 'bob@company.com', 48000, 2);

-- Insert from SELECT
INSERT INTO employee_archive (name, email, salary, dept_id)
SELECT name, email, salary, dept_id
FROM employees
WHERE hire_date < '2020-01-01';
```

### **UPDATE Operations**
```sql
-- Basic update
UPDATE employees
SET salary = salary * 1.05
WHERE department = 'IT';

-- Update with JOIN
UPDATE employees e
JOIN departments d ON e.dept_id = d.id
SET e.salary = e.salary * 1.10
WHERE d.location = 'New York';

-- Conditional update
UPDATE employees
SET 
    salary = CASE 
        WHEN years_service > 10 THEN salary * 1.15
        WHEN years_service > 5 THEN salary * 1.10
        ELSE salary * 1.05
    END;
```

### **DELETE Operations**
```sql
-- Basic delete
DELETE FROM employees WHERE terminated = 1;

-- Delete with JOIN
DELETE e FROM employees e
JOIN departments d ON e.dept_id = d.id
WHERE d.name = 'Discontinued';

-- Delete with LIMIT
DELETE FROM log_entries 
WHERE created_date < '2020-01-01'
LIMIT 1000;
```

## Advanced SQL Features

### **Window Functions**
```sql
-- Row numbering
SELECT 
    name,
    department,
    salary,
    ROW_NUMBER() OVER (PARTITION BY department ORDER BY salary DESC) AS dept_rank
FROM employees;

-- Running totals
SELECT 
    name,
    salary,
    SUM(salary) OVER (ORDER BY hire_date) AS running_total
FROM employees;

-- Lag/Lead functions
SELECT 
    name,
    salary,
    LAG(salary, 1) OVER (ORDER BY hire_date) AS prev_salary,
    LEAD(salary, 1) OVER (ORDER BY hire_date) AS next_salary
FROM employees;
```

### **Recursive CTEs**
```sql
-- Hierarchical data (employee hierarchy)
WITH RECURSIVE emp_hierarchy AS (
    -- Base case: top-level employees
    SELECT id, name, manager_id, 1 AS level
    FROM employees
    WHERE manager_id IS NULL
    
    UNION ALL
    
    -- Recursive case: subordinates
    SELECT e.id, e.name, e.manager_id, eh.level + 1
    FROM employees e
    JOIN emp_hierarchy eh ON e.manager_id = eh.id
)
SELECT * FROM emp_hierarchy;
```

### **JSON Operations**
```sql
-- JSON extraction
SELECT 
    name,
    JSON_EXTRACT(metadata, '$.skills') AS skills,
    JSON_EXTRACT(metadata, '$.experience') AS experience
FROM employees
WHERE JSON_EXTRACT(metadata, '$.department') = 'IT';

-- JSON aggregation
SELECT 
    department,
    JSON_ARRAYAGG(name) AS employee_names
FROM employees
GROUP BY department;
```

## Data Control Language (DCL)

### **User & Permission Management**
```sql
-- Create user
CREATE USER 'username'@'hostname' IDENTIFIED BY 'password';

-- Grant permissions
GRANT SELECT, INSERT, UPDATE ON database_name.* TO 'username'@'hostname';
GRANT ALL PRIVILEGES ON database_name.* TO 'username'@'hostname';

-- Revoke permissions
REVOKE INSERT ON database_name.* FROM 'username'@'hostname';

-- Create role
CREATE ROLE 'developer_role';
GRANT SELECT, INSERT, UPDATE ON database_name.* TO 'developer_role';
GRANT 'developer_role' TO 'username'@'hostname';
```

## Transaction Control Language (TCL)

### **Transaction Management**
```sql
-- Start transaction
START TRANSACTION;
-- or
BEGIN;

-- Commit transaction
COMMIT;

-- Rollback transaction
ROLLBACK;

-- Savepoints
SAVEPOINT savepoint_name;
ROLLBACK TO savepoint_name;
RELEASE SAVEPOINT savepoint_name;
```

## Performance & Optimization

### **Query Optimization**
- **Index Usage**: Ensure queries can use appropriate indexes
- **Selectivity**: Choose selective columns for WHERE clauses
- **Join Order**: Optimize table join sequence
- **Column Selection**: Select only needed columns
- **Result Limiting**: Use LIMIT and pagination for large results

### **Indexing Strategies**
- **Single Column**: Create indexes on frequently queried columns
- **Composite**: Index multiple columns for multi-column queries
- **Covering**: Include all needed columns in index
- **Partial**: Index only subset of rows (e.g., WHERE active = 1)
- **Functional**: Index on function results (e.g., UPPER(name))

### **Query Analysis**
```sql
-- Explain query execution plan
EXPLAIN SELECT * FROM employees WHERE department = 'IT';

-- Show query performance
SHOW PROFILES;
SHOW PROFILE FOR QUERY 1;

-- Analyze table statistics
ANALYZE TABLE employees;
```

## Best Practices

### **SQL Writing Standards**
- **Consistent Naming**: Use clear, descriptive names for tables and columns
- **Proper Indentation**: Format queries for readability
- **Comment Usage**: Add comments for complex queries
- **Error Handling**: Use appropriate error handling in applications
- **Security**: Prevent SQL injection with parameterized queries

### **Performance Guidelines**
- **Avoid SELECT ***: Specify only needed columns
- **Use EXISTS over IN**: More efficient for subqueries
- **Limit Result Sets**: Use LIMIT and pagination
- **Optimize JOINs**: Ensure proper join conditions and order
- **Regular Maintenance**: Update statistics and rebuild indexes

### **Security Considerations**
- **Parameterized Queries**: Prevent SQL injection attacks
- **Principle of Least Privilege**: Grant minimal necessary permissions
- **Input Validation**: Validate all user inputs
- **Audit Logging**: Track database access and changes
- **Encryption**: Encrypt sensitive data at rest and in transit

## Database-Specific Features

### **MySQL/MariaDB**
- **AUTO_INCREMENT**: Auto-incrementing primary keys
- **ENGINE**: Storage engine selection (InnoDB, MyISAM)
- **CHARACTER SET**: Character encoding specification
- **Stored Procedures**: PL/SQL-like procedural language

### **PostgreSQL**
- **Advanced Data Types**: Arrays, JSON, geometric types
- **Table Inheritance**: Object-oriented table design
- **Custom Functions**: PL/pgSQL, PL/Python, PL/Java
- **Full-Text Search**: Built-in text search capabilities

### **SQL Server**
- **T-SQL**: Microsoft's SQL dialect extensions
- **Common Table Expressions**: Advanced CTE features
- **Window Functions**: Comprehensive window function support
- **Integration Services**: ETL and data integration tools

### **Oracle**
- **PL/SQL**: Procedural language extensions
- **Materialized Views**: Advanced view optimization
- **Partitioning**: Table and index partitioning
- **Real Application Clusters**: High availability features

## Applications & Use Cases

### **Data Analysis & Reporting**
- **Business Intelligence**: Generate reports and dashboards
- **Data Warehousing**: Extract, transform, and load data
- **Ad-hoc Queries**: Explore data for insights
- **Performance Monitoring**: Track system metrics and KPIs

### **Application Development**
- **Web Applications**: Backend data access layer
- **Mobile Apps**: Local and cloud database operations
- **API Services**: Data retrieval and manipulation endpoints
- **Microservices**: Service-specific data operations

### **Database Administration**
- **Schema Management**: Create and modify database structures
- **Data Migration**: Move data between systems
- **Backup & Recovery**: Database maintenance operations
- **Performance Tuning**: Optimize database performance

## Key Features

### **Declarative Language**
- **What vs How**: Specify desired results, not implementation
- **Automatic Optimization**: Database engine optimizes execution
- **Portable**: Works across different database systems
- **Standards-based**: ANSI SQL compliance

### **Powerful Query Capabilities**
- **Complex Joins**: Multiple table relationships
- **Aggregation**: Statistical and summary functions
- **Subqueries**: Nested query capabilities
- **Window Functions**: Advanced analytical operations

### **Data Integrity**
- **Constraints**: Enforce data validation rules
- **Transactions**: ACID-compliant operations
- **Referential Integrity**: Maintain relationships
- **Data Types**: Strong typing system

## Important Notes

- **SQL Standards**: ANSI SQL provides portability across systems
- **Dialect Differences**: Each database has unique extensions
- **Performance**: Query optimization varies by database engine
- **Security**: SQL injection remains a critical security concern
- **Scalability**: Consider performance implications for large datasets

## Related Concepts

- **[[Constraint]]**: Integrity rules enforced through SQL declarations
- **[[Trigger]]**: Event-Condition-Action rules defined using SQL
- **[[Index]]**: Data structures for optimizing SQL query performance
- **[[Data Manipulation Language (DML)]]**: SQL subset for data operations
- **[[Data Definition Language (DDL)]]**: SQL subset for structure definition
- **[[Relational Database]]**: Database systems that use SQL
- **[[Database Management System (DBMS)]]**: Software implementing SQL
- **[[Relational Algebra]]**: Mathematical foundation for SQL operations
