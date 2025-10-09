# Index

An **Index** (or database index) is an auxiliary data structure built on one or more columns of a database table that enables the query processor to quickly locate tuples satisfying specific conditions without scanning the entire table. Indexes are fundamental to database performance optimization, providing logarithmic or constant-time access to data instead of linear table scans.

## Basic Definition

An index is a data structure that:

- **Accelerates Queries**: Enables fast lookups based on indexed attributes
- **Avoids Full Scans**: Provides direct access to relevant tuples
- **Maintains Ordering**: Often keeps data in sorted order for efficient retrieval
- **Transparently Used**: Query optimizer automatically leverages indexes when beneficial
- **Requires Maintenance**: Must be updated when data changes

## Purpose and Benefits

### **Fast Tuple Location**

The primary purpose of indexes is to allow the query processor to quickly find tuples that satisfy specific conditions without scanning the entire table.

**Without Index** (Full Table Scan):
```sql
SELECT * FROM Students WHERE StudentID = 12345;
-- Must scan all N tuples: O(N) time
```

**With Index** on StudentID:
```sql
SELECT * FROM Students WHERE StudentID = 12345;
-- Direct lookup via index: O(log N) or O(1) time
```

### **Performance Impact**

Indexes can provide **orders of magnitude** performance improvement:

- **Linear to Logarithmic**: O(N) → O(log N) with B-tree indexes
- **Linear to Constant**: O(N) → O(1) with hash indexes
- **Example**: Finding 1 tuple in 1 million-tuple table:
  - Without index: ~1,000,000 comparisons
  - With B-tree index: ~20 comparisons
  - With hash index: ~1 comparison (on average)

### **Applicable Operations**

- **Selection**: `WHERE attribute = value`, `WHERE attribute > value`
- **Joins**: Matching tuples between tables on indexed columns
- **Sorting**: `ORDER BY` on indexed columns
- **Grouping**: `GROUP BY` on indexed columns
- **Aggregation**: `MIN`, `MAX` on indexed columns

## Types of Indexes

### **Single-Column Index**

An index built on a single column of a table.

**Syntax**:
```sql
CREATE INDEX idx_student_name ON Students(StudentName);
```

**Use Cases**:
- Queries filtering on that column: `WHERE StudentName = 'Alice'`
- Sorting by that column: `ORDER BY StudentName`
- Range queries: `WHERE GPA > 3.5`

**Example**:
```sql
-- Index on column A
CREATE INDEX idx_A ON T(A);

-- Optimizes queries like:
SELECT * FROM T WHERE A = 10;
SELECT * FROM T WHERE A BETWEEN 5 AND 15;
SELECT * FROM T ORDER BY A;
```

### **Multi-Column (Composite) Index**

An index built on multiple columns together, creating an ordered structure based on the combination of values.

**Syntax**:
```sql
CREATE INDEX idx_name_gpa ON Students(StudentName, GPA);
```

**Column Order Matters**:
- Index on (A, B) is ordered first by A, then by B
- Efficient for: `WHERE A = x`, `WHERE A = x AND B = y`
- Less efficient for: `WHERE B = y` alone (cannot use leading column)

**Use Cases**:
- Queries with conditions on multiple columns
- Covering indexes (index contains all needed columns)
- Enforcing compound uniqueness

**Example**:
```sql
-- Multi-column index on A and B
CREATE INDEX idx_A_B ON T(A, B);

-- Optimizes queries like:
SELECT * FROM T WHERE A = 10 AND B = 20;
SELECT * FROM T WHERE A = 10 ORDER BY B;

-- Less effective for:
SELECT * FROM T WHERE B = 20;  -- Cannot use leading column A
```

### **Unique Index**

An index that enforces uniqueness constraint while providing fast lookup.

**Syntax**:
```sql
CREATE UNIQUE INDEX idx_email ON Users(Email);
```

**Properties**:
- Prevents duplicate values in indexed column(s)
- Automatically created for PRIMARY KEY and UNIQUE constraints
- Provides both performance and integrity benefits

**Automatic Index Creation**:
Many database systems automatically create indexes on:
- **Primary keys**: Ensures uniqueness and fast lookups
- **Unique constraints**: Enforces uniqueness efficiently
- **Foreign keys** (in some systems): Speeds up joins

## Underlying Data Structures

### **Balanced Trees (B-trees and B+ trees)**

**B-trees** and **B+ trees** are the most common data structures for database indexes.

**Characteristics**:
- **Balanced**: All leaf nodes at same depth, ensuring consistent performance
- **Multi-way Trees**: Each node has many children (high branching factor)
- **Sorted Order**: Keys maintained in sorted order
- **Logarithmic Time**: Operations are O(log N) where N is number of tuples

**Supported Operations**:
- **Equality**: `attribute = value`
- **Range Queries**: `attribute < value`, `attribute > value`, `BETWEEN`
- **Inequality**: `attribute != value`
- **Sorting**: Direct traversal provides sorted order
- **Prefix Matching**: `attribute LIKE 'prefix%'`

**Performance**:
- **Search**: O(log N)
- **Insert**: O(log N)
- **Delete**: O(log N)
- **Range Scan**: O(log N + k) where k is result size

**Example**:
```sql
CREATE INDEX idx_gpa_btree ON Students(GPA);

-- All of these benefit from B-tree:
SELECT * FROM Students WHERE GPA = 3.8;
SELECT * FROM Students WHERE GPA > 3.5;
SELECT * FROM Students WHERE GPA BETWEEN 3.0 AND 4.0;
SELECT * FROM Students ORDER BY GPA;
```

### **Hash Tables**

**Hash tables** provide constant-time lookups for equality conditions.

**Characteristics**:
- **Hash Function**: Maps key values to bucket locations
- **Constant Time**: Well-designed hash tables have O(1) average lookup
- **No Ordering**: Data is not maintained in sorted order
- **Equality Only**: Cannot support range or inequality queries

**Supported Operations**:
- **Equality Only**: `attribute = value`
- **Cannot Support**: Range queries, sorting, inequality, prefix matching

**Performance**:
- **Search (Equality)**: O(1) average case
- **Insert**: O(1) average case
- **Delete**: O(1) average case
- **Range Scan**: Not supported (requires full scan)

**When to Use**:
- Queries only use equality conditions
- No need for range queries or sorting
- Maximum performance for point lookups

**Example**:
```sql
CREATE INDEX idx_id_hash ON Students(StudentID) USING HASH;

-- Optimized (O(1)):
SELECT * FROM Students WHERE StudentID = 12345;

-- NOT optimized (hash index cannot help):
SELECT * FROM Students WHERE StudentID > 12000;
SELECT * FROM Students ORDER BY StudentID;
```

### **B-tree vs. Hash Table Comparison**

| Feature | B-tree | Hash Table |
|---------|--------|------------|
| **Equality Search** | O(log N) | O(1) |
| **Range Queries** | O(log N + k) | Not supported |
| **Inequality** | O(log N + k) | Not supported |
| **Sorting** | Direct traversal | Not supported |
| **Space Overhead** | Moderate | Moderate |
| **Flexibility** | High | Low |
| **Common Usage** | Default choice | Specialized cases |

## SQL Query Examples with Indexes

### **Simple Select Query**

**Query**:
```sql
SELECT * FROM Students WHERE StudentID = 12345;
```

**Index**:
```sql
CREATE INDEX idx_student_id ON Students(StudentID);
```

**Performance**:
- Without index: O(N) - full table scan
- With index: O(log N) with B-tree or O(1) with hash
- **Automatic**: Many systems automatically create index on primary key

### **Multi-Condition Query**

**Query**:
```sql
SELECT * FROM Students 
WHERE StudentName = 'Alice' AND GPA > 3.5;
```

**Index Options**:

**Option 1: Index on StudentName**
```sql
CREATE INDEX idx_name ON Students(StudentName);
-- Use index to find all 'Alice' entries, then filter by GPA
```

**Option 2: Index on GPA**
```sql
CREATE INDEX idx_gpa ON Students(GPA);
-- Use index to find GPA > 3.5, then filter by name
```

**Option 3: Composite Index (Best)**
```sql
CREATE INDEX idx_name_gpa ON Students(StudentName, GPA);
-- Use both conditions efficiently in single index lookup
```

**Performance**:
- Composite index typically provides best performance
- Query optimizer chooses most selective index

### **Join Query**

**Query**:
```sql
SELECT S.StudentName, A.CollegeName
FROM Students S
JOIN Apply A ON S.StudentID = A.StudentID
WHERE S.GPA > 3.5;
```

**Beneficial Indexes**:

```sql
-- Index on GPA for filtering Students
CREATE INDEX idx_student_gpa ON Students(GPA);

-- Index on foreign key for efficient join
CREATE INDEX idx_apply_sid ON Apply(StudentID);

-- Covering index (includes all needed columns)
CREATE INDEX idx_student_cover ON Students(GPA, StudentID, StudentName);
```

**Performance Impact**:
- **Without indexes**: Nested loop join requires O(N × M) comparisons
- **With indexes**: Join can use index lookups, reducing to O(N × log M) or better
- **Foreign key indexes**: Especially critical for join performance

### **Aggregate Query**

**Query**:
```sql
SELECT MAX(GPA) FROM Students WHERE Major = 'CS';
```

**Beneficial Indexes**:

```sql
-- Composite index with GPA first for quick MAX
CREATE INDEX idx_major_gpa ON Students(Major, GPA);
```

**Performance**:
- Index allows direct access to maximum GPA for each major
- Avoids scanning all CS students

## Downsides of Indexes

While indexes provide significant query performance benefits, they come with costs that must be considered.

### **Extra Space (Marginal Downside)**

**Issue**: Indexes consume additional storage space.

**Storage Requirements**:
- **B-tree index**: ~10-30% of table size (varies by key size and branching factor)
- **Hash index**: Similar overhead
- **Multi-column index**: Larger than single-column index

**Considerations**:
- Considered a **marginal downside** in modern systems
- Storage is relatively inexpensive
- Benefits often outweigh space costs
- Can be significant for very large tables with many indexes

**Example**:
- Table: 1 GB
- 5 indexes: ~100-300 MB additional storage
- Total: ~1.1-1.3 GB (10-30% overhead)

### **Creation Overhead (Moderate Downside)**

**Issue**: Building indexes can be a time-consuming operation.

**When Occurs**:
- **Initial Database Loading**: Creating indexes after bulk data load
- **Adding Indexes Later**: Creating new indexes on existing large tables
- **Index Rebuilding**: Reorganizing fragmented indexes

**Time Complexity**:
- **B-tree creation**: O(N log N) - requires sorting
- **Hash index creation**: O(N) - but still slow for large tables

**Mitigation Strategies**:
- Build indexes after bulk data loads, not during
- Schedule index creation during maintenance windows
- Use parallel index building (if supported)
- Consider online index creation for minimal downtime

**Example**:
```sql
-- Load data first without indexes
COPY Students FROM 'data.csv';

-- Then create indexes (faster than indexing during load)
CREATE INDEX idx_student_name ON Students(StudentName);
CREATE INDEX idx_gpa ON Students(GPA);
```

### **Maintenance Overhead (Most Significant Downside)**

**Issue**: Indexes must be updated every time the database is modified, which can slow down INSERT, UPDATE, and DELETE operations.

**Impact on Operations**:

**INSERT**:
- Must insert tuple into table: O(1)
- Must update every index on table: O(log N) per index
- Total: O(1 + k × log N) where k is number of indexes

**UPDATE**:
- If indexed column changes, index must be updated
- May require delete old entry + insert new entry in index
- Multiple indexes may need updates

**DELETE**:
- Must remove tuple from table: O(1)
- Must remove entries from all indexes: O(log N) per index

**Example Impact**:
```sql
-- Table with 5 indexes
INSERT INTO Students VALUES (12345, 'Alice', 'CS', 3.8);
-- Requires:
-- 1. Insert into table
-- 2. Update index on StudentID
-- 3. Update index on StudentName
-- 4. Update index on Major
-- 5. Update index on GPA
-- 6. Update any composite indexes

-- Total: 1 table write + 5 index updates
```

**Performance Degradation**:
- Each index adds overhead to every modification
- High-frequency updates can become bottleneck
- More indexes = slower modifications

**Measurement**:
- Without indexes: INSERT might take 1ms
- With 5 indexes: INSERT might take 5-10ms
- For high-volume OLTP systems, this can be significant

## Cost-Benefit Trade-off

Deciding when and where to build indexes involves balancing query performance benefits against maintenance costs.

### **Factors Influencing Benefit**

**Table Size**:
- **Large tables**: Indexes provide greater benefit (O(N) → O(log N) more significant)
- **Small tables**: Full scan may be fast enough, index overhead not worth it

**Data Distribution**:
- **High cardinality** (many distinct values): Indexes very effective
- **Low cardinality** (few distinct values): Indexes less effective
- Example: Index on `Gender` (2 values) less useful than on `StudentID` (unique)

**Query Frequency**:
- **Frequent queries**: Index pays for itself quickly
- **Rare queries**: Index maintenance cost may exceed benefit

**Update Frequency**:
- **Read-heavy workload**: Indexes highly beneficial (OLAP, data warehouses)
- **Write-heavy workload**: Indexes costly (OLTP with frequent updates)
- **Read-to-write ratio**: Higher ratio favors more indexes

### **Decision Guidelines**

**Create Indexes When**:
- Queries frequently filter or join on column
- Table is large (thousands+ rows)
- Column has high cardinality
- Read-to-write ratio is high
- Query performance is critical

**Avoid Indexes When**:
- Table is very small
- Column has very low cardinality
- Column rarely used in queries
- High frequency of updates on indexed columns
- Write performance is critical

**Index Selection Strategy**:
1. Start with primary key and unique constraints (automatic)
2. Index foreign keys for join performance
3. Index columns frequently used in WHERE clauses
4. Consider composite indexes for multi-condition queries
5. Monitor query performance and add indexes as needed
6. Remove unused indexes to reduce maintenance overhead

## Physical Design Advisor

Many database systems offer a **Physical Design Advisor** (also called Index Advisor or Tuning Advisor) that recommends optimal indexes.

### **Purpose**

Automatically analyze workload and suggest indexes that optimize overall performance while considering trade-offs.

### **Input Requirements**

**Database Statistics**:
- **Table sizes**: Number of tuples in each table
- **Data distributions**: Cardinality of columns, value frequencies
- **Storage statistics**: Data pages, index pages, fragmentation
- **Current indexes**: Existing index structures

**Expected Workload**:
- **Queries**: All queries that will be executed
- **Updates**: INSERT, UPDATE, DELETE operations
- **Frequencies**: How often each operation occurs
- **Weights**: Relative importance of different operations

**Example Input**:
```
Workload:
- Query 1: SELECT * FROM Students WHERE Major = 'CS' (1000 times/hour)
- Query 2: SELECT * FROM Apply WHERE StudentID = ? (5000 times/hour)
- Update 1: INSERT INTO Students VALUES (...) (10 times/hour)
```

### **Process**

1. **Workload Analysis**: Parse queries and identify indexable columns
2. **Candidate Generation**: Generate potential index configurations
3. **Cost Estimation**: Use query optimizer to estimate costs
   - Estimates costs WITHOUT actually running queries
   - Uses statistics and optimizer's cost model
4. **Trade-off Analysis**: Balance query speedup vs. update slowdown
5. **Optimization**: Select indexes that minimize overall workload cost
6. **Recommendation**: Output ranked list of recommended indexes

### **Output**

**Recommended Indexes**:
- Which columns to index
- Single vs. composite indexes
- Priority ranking (most beneficial first)
- Expected performance improvement
- Estimated space requirements

**Example Output**:
```
Recommended Indexes:
1. CREATE INDEX idx_apply_sid ON Apply(StudentID)
   - Speeds up 5000 queries/hour
   - Estimated improvement: 90% reduction in query time
   - Space required: 50 MB

2. CREATE INDEX idx_student_major ON Students(Major)
   - Speeds up 1000 queries/hour
   - Estimated improvement: 75% reduction in query time
   - Space required: 20 MB

3. CREATE INDEX idx_student_gpa ON Students(GPA)
   - Speeds up 500 queries/hour
   - Estimated improvement: 60% reduction in query time
   - Space required: 15 MB
```

### **Benefits**

- **Automated Analysis**: Removes guesswork from index design
- **Workload-Specific**: Recommendations based on actual usage patterns
- **Trade-off Consideration**: Balances read vs. write performance
- **What-If Analysis**: Can test different scenarios without making changes
- **Time Savings**: Much faster than manual analysis

### **Limitations**

- **Requires Representative Workload**: Only as good as input workload
- **Static Analysis**: Doesn't adapt to workload changes over time
- **May Miss Edge Cases**: Automated tools can't capture all nuances
- **Implementation-Specific**: Different systems have different advisors

## SQL Syntax for Indexes

### **Creating Indexes**

**Single-Column Index**:
```sql
CREATE INDEX index_name ON table_name(column_name);
```

**Multi-Column Index**:
```sql
CREATE INDEX index_name ON table_name(column1, column2, column3);
```

**Unique Index**:
```sql
CREATE UNIQUE INDEX index_name ON table_name(column_name);
```

**Specifying Index Type** (database-specific):
```sql
-- B-tree (usually default)
CREATE INDEX idx_name ON table_name(column) USING BTREE;

-- Hash
CREATE INDEX idx_name ON table_name(column) USING HASH;
```

### **Dropping Indexes**

```sql
DROP INDEX index_name;
```

Or in some systems:
```sql
DROP INDEX index_name ON table_name;
```

### **Complete Examples**

```sql
-- Create table
CREATE TABLE Students (
    StudentID INT PRIMARY KEY,        -- Index automatically created
    StudentName VARCHAR(100),
    Major VARCHAR(50),
    GPA DECIMAL(3,2)
);

-- Create single-column indexes
CREATE INDEX idx_student_name ON Students(StudentName);
CREATE INDEX idx_major ON Students(Major);
CREATE INDEX idx_gpa ON Students(GPA);

-- Create composite index
CREATE INDEX idx_major_gpa ON Students(Major, GPA);

-- Create unique index
CREATE UNIQUE INDEX idx_email ON Students(Email);

-- Drop an index
DROP INDEX idx_student_name;
```

## Important Notes

- **Not Part of SQL Standard**: Index syntax varies across database systems
- **Automatic Usage**: Query optimizer decides when to use indexes
- **Invisible to Queries**: Indexes don't change query results, only performance
- **Maintenance**: Periodically rebuild indexes to reduce fragmentation
- **Monitoring**: Regularly analyze index usage and remove unused indexes
- **Testing**: Always test index impact on both query and update performance

## Related Concepts

- **[[Database Management System (DBMS)]]**: Systems that implement and manage indexes
- **[[Relational Database]]**: Indexes optimize query performance in relational databases
- **[[Schema]]**: Index definitions are part of the physical schema
- **[[SQL]]**: Index creation and management using SQL statements
- **[[Hash Table]]**: One of the underlying data structures for indexes
- **[[Balanced Tree]]**: B-trees and B+ trees are primary index structures

