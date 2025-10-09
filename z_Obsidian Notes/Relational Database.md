# Relational Database

A **Relational Database** is a database system based on the relational model of data, which organizes information into tables (relations) with rows (tuples) and columns (attributes). It provides a structured approach to data storage and retrieval using mathematical set theory and predicate logic, with SQL as the standard language for data manipulation and querying.

## Basic Definition

A relational database represents data as a collection of **relations** (tables), where each relation is a set of **tuples** (rows) that share the same **attributes** (columns). The model is founded on:

- **Set Theory**: Relations are mathematical sets of tuples
- **Predicate Logic**: Data integrity through logical constraints
- **Normalization**: Eliminating data redundancy and anomalies
- **Referential Integrity**: Maintaining relationships between tables
- **ACID Properties**: Ensuring transaction reliability

## Core Relational Concepts

### **Relation (Table)**
- **Mathematical Definition**: A subset of the Cartesian product of domains
- **Structure**: Two-dimensional table with rows and columns
- **Properties**: No duplicate rows, unordered rows, unordered columns
- **Notation**: $R(A_1, A_2, ..., A_n)$ where $A_i$ are attributes
- **Cardinality**: Number of tuples in the relation

### **Attribute (Column)**
- **Definition**: Named column representing a data element
- **Domain**: Set of valid values for the attribute
- **Data Type**: Specification of storage format and constraints
- **Constraints**: Rules that limit attribute values
- **Metadata**: Information about the attribute's purpose and usage

### **Tuple (Row)**
- **Definition**: Ordered collection of attribute values
- **Uniqueness**: Each tuple must be unique within the relation
- **Order**: Tuples have no inherent ordering
- **Completeness**: All attributes must have values (or NULL)
- **Integrity**: Must satisfy all relation constraints

### **Domain**
- **Definition**: Set of atomic values from which attributes draw values
- **Atomicity**: Values cannot be further subdivided
- **Data Types**: Integer, string, date, boolean, etc.
- **Constraints**: Range, format, and validation rules
- **Nullability**: Whether NULL values are allowed

## Data Types & Constraints

### **Basic Data Types**
- **Numeric**: INTEGER, DECIMAL(p,s), FLOAT, DOUBLE, BIGINT
- **Character**: CHAR(n), VARCHAR(n), TEXT, CLOB, NCHAR(n)
- **Date/Time**: DATE, TIME, TIMESTAMP, INTERVAL, YEAR
- **Binary**: BLOB, BINARY(n), VARBINARY(n), BIT
- **Boolean**: BOOLEAN, BIT(1), TINYINT(1)

### **Constraint Types**
- **NOT NULL**: Attribute cannot contain NULL values
- **UNIQUE**: Attribute values must be unique across tuples
- **PRIMARY KEY**: Unique identifier for each tuple
- **FOREIGN KEY**: Reference to primary key in another relation
- **CHECK**: Custom validation rules for attribute values
- **DEFAULT**: Automatic value when no value is specified

### **Referential Integrity**
- **Foreign Key**: Attribute that references primary key in another relation
- **Referenced Relation**: The relation containing the referenced primary key
- **Referencing Relation**: The relation containing the foreign key
- **Cascade Rules**: Behavior when referenced tuple is modified/deleted
- **Referential Cycle**: Circular references between relations

## Relational Algebra Operations

### **Set Operations**
- **Union ($\cup$)**: Combine tuples from two relations
- **Intersection ($\cap$)**: Find common tuples between relations
- **Difference ($-$)**: Find tuples in first but not second relation
- **Cartesian Product ($\times$)**: All possible combinations of tuples

### **Relational Operations**
- **Selection ($\sigma$)**: Filter tuples based on conditions
- **Projection ($\pi$)**: Extract specific attributes from tuples
- **Join ($\bowtie$)**: Combine tuples from related relations
- **Division ($\div$)**: Find tuples that satisfy all conditions
- **Rename ($\rho$)**: Change relation or attribute names

### **Join Types**
- **Natural Join**: Join on common attributes with same names
- **Theta Join**: Join based on arbitrary conditions
- **Equijoin**: Join using equality conditions
- **Outer Join**: Include tuples without matches
- **Semi-join**: Include only matching tuples from first relation

## Normalization & Design

### **Normal Forms**
- **First Normal Form (1NF)**: Atomic values, no repeating groups
- **Second Normal Form (2NF)**: 1NF + no partial dependencies
- **Third Normal Form (3NF)**: 2NF + no transitive dependencies
- **Boyce-Codd Normal Form (BCNF)**: Stronger than 3NF
- **Fourth Normal Form (4NF)**: Handle multi-valued dependencies
- **Fifth Normal Form (5NF)**: Handle join dependencies

### **Functional Dependencies**
- **Definition**: $X \rightarrow Y$ means $Y$ is functionally dependent on $X$
- **Trivial**: $Y \subseteq X$ (always true)
- **Non-trivial**: $Y \not\subseteq X$ (business rule)
- **Partial**: Dependency on subset of composite key
- **Transitive**: $X \rightarrow Y \rightarrow Z$ implies $X \rightarrow Z$

### **Design Principles**
- **Entity Integrity**: Each relation has unique primary key
- **Referential Integrity**: Foreign keys reference valid primary keys
- **Domain Integrity**: Attribute values conform to defined domains
- **User-defined Integrity**: Custom business rules and constraints
- **Minimal Redundancy**: Eliminate unnecessary data duplication

## NULL Values & Handling

### **NULL Semantics**
- **Unknown Value**: Represents missing or unknown information
- **Not Applicable**: Value doesn't apply to this tuple
- **Not Yet Known**: Value will be known in the future
- **Three-valued Logic**: TRUE, FALSE, UNKNOWN
- **Comparison Rules**: NULL compared to anything yields UNKNOWN

### **NULL Operations**
- **Arithmetic**: Any operation with NULL yields NULL
- **Comparison**: NULL = NULL yields UNKNOWN, not TRUE
- **Aggregation**: NULL values are typically ignored in functions
- **Sorting**: NULL values can be treated as highest or lowest
- **Indexing**: NULL values may or may not be indexed

### **NULL Handling Strategies**
- **Default Values**: Provide meaningful defaults for missing data
- **Constraints**: Use NOT NULL when appropriate
- **Business Rules**: Define when NULL is acceptable
- **Documentation**: Clearly specify NULL semantics
- **Application Logic**: Handle NULL values in application code

## Relational Database Design

### **Entity-Relationship Modeling**
- **Entities**: Real-world objects or concepts
- **Attributes**: Properties or characteristics of entities
- **Relationships**: Connections between entities
- **Cardinality**: One-to-one, one-to-many, many-to-many
- **Participation**: Total or partial involvement in relationships

### **Logical Design**
- **Entity Tables**: Convert entities to relations
- **Relationship Tables**: Convert relationships to relations
- **Attribute Mapping**: Map entity attributes to table columns
- **Key Identification**: Determine primary and foreign keys
- **Constraint Definition**: Define business rules and constraints

### **Physical Design**
- **Storage Engine**: Choose appropriate storage mechanism
- **Indexing Strategy**: Optimize query performance
- **Partitioning**: Distribute data across storage units
- **Compression**: Reduce storage requirements
- **Clustering**: Organize data for optimal access patterns

## Query Processing & Optimization

### **Query Execution**
- **Parsing**: Convert SQL to parse tree
- **Validation**: Check syntax and semantic correctness
- **Optimization**: Generate efficient execution plan
- **Execution**: Retrieve and process data
- **Result**: Return formatted results to user

### **Query Optimization**
- **Cost-based**: Estimate execution costs for different plans
- **Rule-based**: Apply transformation rules
- **Index Selection**: Choose appropriate access methods
- **Join Ordering**: Optimize table join sequence
- **Statistics**: Use table and index statistics for optimization

### **Performance Factors**
- **Index Usage**: Ensure queries can use appropriate indexes
- **Join Strategies**: Choose efficient join algorithms
- **Sorting**: Minimize sorting operations
- **Memory Usage**: Optimize buffer and cache usage
- **Parallelism**: Leverage multiple processors when possible

## Transaction Management

### **ACID Properties**
- **Atomicity**: All operations in transaction succeed or fail together
- **Consistency**: Database moves between valid states
- **Isolation**: Concurrent transactions don't interfere
- **Durability**: Committed transactions persist after failures

### **Concurrency Control**
- **Locking**: Control access to data items
- **Timestamp Ordering**: Order transactions by timestamp
- **Optimistic Concurrency**: Assume conflicts are rare
- **Multi-version Concurrency**: Maintain multiple versions of data
- **Deadlock Prevention**: Avoid circular wait conditions

### **Recovery Mechanisms**
- **Logging**: Record all changes for recovery
- **Checkpointing**: Periodic save points for faster recovery
- **Rollback**: Undo incomplete transactions
- **Rollforward**: Redo committed transactions
- **Crash Recovery**: Restore system after failures

## Advanced Features

### **Views & Virtual Tables**
- **Simple Views**: Single table with column selection
- **Complex Views**: Multiple tables with joins and aggregations
- **Materialized Views**: Pre-computed results for performance
- **Indexed Views**: Views with indexes for faster access
- **Partitioned Views**: Views spanning multiple tables

### **Stored Procedures & Functions**
- **Stored Procedures**: Pre-compiled SQL code blocks
- **User-defined Functions**: Custom calculation functions
- **Triggers**: Automatic actions on data changes
- **Packages**: Grouped procedures and functions
- **PL/SQL**: Procedural language extensions

### **Advanced Data Types**
- **JSON/XML**: Semi-structured data support
- **Arrays**: Multi-valued attributes
- **User-defined Types**: Custom data type definitions
- **Enumerated Types**: Limited set of valid values
- **Composite Types**: Structured data types

## Applications & Use Cases

### **Business Applications**
- **OLTP Systems**: Transaction processing applications
- **ERP Systems**: Enterprise resource planning
- **CRM Systems**: Customer relationship management
- **Financial Systems**: Banking and accounting applications
- **Healthcare Systems**: Patient records and medical data

### **Data Warehousing**
- **OLAP Systems**: Analytical processing and reporting
- **Data Marts**: Subject-specific data warehouses
- **ETL Processes**: Extract, transform, and load operations
- **Business Intelligence**: Reporting and analytics
- **Data Mining**: Pattern discovery and prediction

### **Web & Mobile Applications**
- **E-commerce**: Product catalogs and transactions
- **Social Media**: User profiles and interactions
- **Content Management**: Articles and media storage
- **API Services**: Data access for external applications
- **Mobile Apps**: Local and cloud data synchronization

## Key Features

### **Data Integrity & Consistency**
- **Constraint Enforcement**: Automatic validation of data rules
- **Referential Integrity**: Maintain relationships between tables
- **Transaction Safety**: ACID-compliant operations
- **Data Validation**: Ensure data quality and consistency
- **Audit Trail**: Track all data changes and access

### **Performance & Scalability**
- **Indexing**: Fast data access through optimized indexes
- **Query Optimization**: Automatic and manual query tuning
- **Partitioning**: Scale to large data volumes
- **Parallel Processing**: Leverage multiple processors
- **Caching**: Optimize frequently accessed data

### **Standards & Interoperability**
- **SQL Standards**: Compliance with industry standards
- **ODBC/JDBC**: Standard database connectivity
- **API Support**: Programmatic access through various interfaces
- **Cross-platform**: Work across different operating systems
- **Tool Ecosystem**: Rich set of supporting tools and utilities

## Important Notes

- **Relational vs Non-relational**: Choose based on data structure and query patterns
- **Normalization Trade-offs**: Balance normalization with performance requirements
- **NULL Handling**: Carefully consider NULL semantics and handling
- **Performance Tuning**: Regular monitoring and optimization required
- **Data Modeling**: Invest time in proper logical and physical design

## Related Concepts

- **[[Database Management System (DBMS)]]**: Software systems that implement relational databases
- **[[Data Model]]**: Relational database implements the relational data model
- **[[Schema]]**: Formal specification of relational database structure
- **[[SQL]]**: Standard language for relational database operations
- **[[Relational Design]]**: Process of creating well-structured relational schemas
- **[[Normal Form]]**: Design criteria for eliminating redundancy and anomalies
- **[[Functional Dependencies]]**: Constraints that guide normalization
- **[[Unified Modeling Language (UML)]]**: Visual notation for designing relational database schemas
- **[[Index]]**: Data structures for optimizing query performance
- **[[Constraint]]**: Integrity constraints that ensure data validity
- **[[Trigger]]**: Event-driven mechanisms for maintaining data integrity
- **[[Relational Algebra]]**: Mathematical foundation for relational operations
