# Relational Algebra

**Relational Algebra** is a formal mathematical system for manipulating relations (tables) in relational databases. It provides a theoretical foundation for database query languages like SQL, offering a set of operations that can be combined to express complex queries. Relational algebra operations are closed, meaning they take relations as input and produce relations as output, enabling composition and optimization of database queries.

## Basic Definition

Relational algebra consists of a set of **operators** that operate on relations and produce relations as results. Each operator is a function that takes one or more relations as input and returns a new relation. The algebra is:

- **Closed**: All operations return relations
- **Composable**: Operations can be combined to form expressions
- **Mathematical**: Based on set theory and predicate logic
- **Optimizable**: Expressions can be transformed for efficiency
- **Language-independent**: Theoretical foundation for SQL and other query languages

## Core Operations

### **Unary Operations** (Single Relation Input)

#### **Selection ($\sigma$)** - Row Filtering
- **Definition**: $\sigma_{condition}(R)$ filters tuples from relation $R$ based on a condition
- **Purpose**: Extract rows that satisfy specific criteria
- **Mathematical**: $\sigma_{condition}(R) = \{t \in R \mid condition(t)\}$
- **SQL Equivalent**: `WHERE` clause
- **Example**: $\sigma_{age > 25}(Students)$ selects students older than 25

#### **Projection ($\pi$)** - Column Selection
- **Definition**: $\pi_{attributes}(R)$ extracts specified attributes from relation $R$
- **Purpose**: Select specific columns and eliminate duplicates
- **Mathematical**: $\pi_{A_1, A_2, ..., A_n}(R) = \{t[A_1, A_2, ..., A_n] \mid t \in R\}$
- **SQL Equivalent**: `SELECT` clause
- **Example**: $\pi_{name, age}(Students)$ projects only name and age columns

#### **Rename ($\rho$)** - Attribute/Relation Naming
- **Definition**: $\rho_{new\_name}(R)$ or $\rho_{new\_name(A_1, A_2, ..., A_n)}(R)$
- **Purpose**: Change relation or attribute names
- **Mathematical**: $\rho_{S}(R)$ creates relation $S$ with same content as $R$
- **SQL Equivalent**: `AS` alias
- **Example**: $\rho_{YoungStudents}(Students)$ renames relation

### **Binary Operations** (Two Relation Inputs)

#### **Set Operations** (Union-compatible relations required)

**Union ($\cup$)**
- **Definition**: $R \cup S$ combines all tuples from both relations
- **Requirements**: Same schema (union-compatible)
- **Mathematical**: $R \cup S = \{t \mid t \in R \lor t \in S\}$
- **SQL Equivalent**: `UNION`
- **Properties**: Commutative, associative, idempotent

**Intersection ($\cap$)**
- **Definition**: $R \cap S$ finds common tuples between relations
- **Mathematical**: $R \cap S = \{t \mid t \in R \land t \in S\}$
- **SQL Equivalent**: `INTERSECT`
- **Properties**: Commutative, associative, idempotent

**Difference ($-$)**
- **Definition**: $R - S$ finds tuples in $R$ but not in $S$
- **Mathematical**: $R - S = \{t \mid t \in R \land t \notin S\}$
- **SQL Equivalent**: `EXCEPT` or `MINUS`
- **Properties**: Not commutative, not associative

**Cartesian Product ($\times$)**
- **Definition**: $R \times S$ creates all possible combinations of tuples
- **Mathematical**: $R \times S = \{(r, s) \mid r \in R \land s \in S\}$
- **SQL Equivalent**: `CROSS JOIN`
- **Cardinality**: $|R \times S| = |R| \times |S|$

#### **Join Operations**

**Natural Join ($\bowtie$)**
- **Definition**: $R \bowtie S$ joins on common attributes with same names
- **Mathematical**: $R \bowtie S = \pi_{R.*, S.*}(\sigma_{R.A = S.A}(R \times S))$
- **SQL Equivalent**: `NATURAL JOIN`
- **Properties**: Eliminates duplicate join columns

**Theta Join ($\bowtie_\theta$)**
- **Definition**: $R \bowtie_\theta S$ joins based on arbitrary condition $\theta$
- **Mathematical**: $R \bowtie_\theta S = \sigma_\theta(R \times S)$
- **SQL Equivalent**: `JOIN ... ON condition`
- **Example**: $R \bowtie_{R.A > S.B} S$ joins where $R.A > S.B$

**Equijoin**
- **Definition**: Theta join with equality conditions only
- **Mathematical**: $R \bowtie_{R.A = S.B} S$
- **SQL Equivalent**: `JOIN ... ON R.A = S.B`
- **Properties**: Most common join type in practice

**Outer Joins**
- **Left Outer Join**: Include all tuples from left relation
- **Right Outer Join**: Include all tuples from right relation  
- **Full Outer Join**: Include all tuples from both relations
- **Mathematical**: Extend natural join with NULL values for non-matches

**Semi-join ($\ltimes$)**
- **Definition**: $R \ltimes S$ includes only matching tuples from $R$
- **Mathematical**: $R \ltimes S = \pi_{R.*}(R \bowtie S)$
- **Purpose**: Filter $R$ based on existence in $S$

**Anti-join ($\triangleright$)**
- **Definition**: $R \triangleright S$ includes tuples from $R$ not in $S$
- **Mathematical**: $R \triangleright S = R - \pi_{R.*}(R \bowtie S)$
- **Purpose**: Find tuples in $R$ without matches in $S$

#### **Division ($\div$)**
- **Definition**: $R \div S$ finds tuples in $R$ that appear with all tuples in $S$
- **Mathematical**: $R \div S = \{t \mid \forall s \in S, (t, s) \in R\}$
- **Purpose**: "For all" queries and universal quantification
- **Example**: Find students enrolled in all required courses

## Extended Operations

### **Aggregation Functions**
- **COUNT**: Count number of tuples or non-NULL values
- **SUM**: Sum of numeric values
- **AVG**: Average of numeric values
- **MIN/MAX**: Minimum and maximum values
- **GROUP BY**: Group tuples by attribute values
- **HAVING**: Filter groups based on aggregate conditions

### **Recursive Operations**
- **Transitive Closure**: Find all reachable nodes in a graph
- **Recursive CTEs**: Handle hierarchical data structures
- **Fixed-point Operations**: Iterative computation until convergence

### **Window Functions**
- **Row Number**: Assign sequential numbers to rows
- **Rank**: Assign ranks with gaps for ties
- **Dense Rank**: Assign ranks without gaps
- **Lag/Lead**: Access previous/next row values
- **Running Totals**: Cumulative aggregations

## Mathematical Properties

### **Algebraic Laws**
- **Commutativity**: $R \cup S = S \cup R$, $R \cap S = S \cap R$
- **Associativity**: $(R \cup S) \cup T = R \cup (S \cup T)$
- **Distributivity**: $R \bowtie (S \cup T) = (R \bowtie S) \cup (R \bowtie T)$
- **Idempotence**: $R \cup R = R$, $R \cap R = R$
- **De Morgan's Laws**: $\sigma_{\neg(P \land Q)}(R) = \sigma_{\neg P \lor \neg Q}(R)$

### **Optimization Rules**
- **Selection Pushdown**: $\sigma_P(R \bowtie S) = \sigma_P(R) \bowtie S$ (if $P$ only involves $R$)
- **Projection Pushdown**: $\pi_A(R \bowtie S) = \pi_A(\pi_{A \cup B}(R) \bowtie \pi_{A \cup C}(S))$
- **Join Commutativity**: $R \bowtie S = S \bowtie R$
- **Join Associativity**: $(R \bowtie S) \bowtie T = R \bowtie (S \bowtie T)$

### **Complexity Analysis**
- **Selection**: $O(n)$ where $n$ is number of tuples
- **Projection**: $O(n)$ with duplicate elimination
- **Join**: $O(n \times m)$ for nested loops, $O(n + m)$ with indexes
- **Set Operations**: $O(n \log n)$ for sorting-based approaches
- **Aggregation**: $O(n)$ for single pass, $O(n \log n)$ for grouping

## Query Optimization

### **Query Execution Plans**
- **Logical Plan**: Relational algebra expression
- **Physical Plan**: Specific algorithms and data structures
- **Cost Estimation**: CPU, I/O, and memory costs
- **Plan Selection**: Choose optimal execution strategy

### **Optimization Techniques**
- **Predicate Pushdown**: Apply filters early in query execution
- **Join Reordering**: Optimize join sequence for minimal intermediate results
- **Index Usage**: Leverage indexes for fast data access
- **Materialization**: Store intermediate results for reuse
- **Parallelization**: Distribute work across multiple processors

### **Heuristic Rules**
- **Selection First**: Apply selections before joins when possible
- **Projection Early**: Eliminate unnecessary columns early
- **Join Ordering**: Start with smallest relations
- **Index Selection**: Choose most selective indexes
- **Memory Management**: Minimize intermediate result sizes

## Practical Applications

### **SQL Translation**
- **SELECT**: Projection and selection operations
- **FROM**: Relation specification and joins
- **WHERE**: Selection conditions
- **GROUP BY**: Aggregation grouping
- **HAVING**: Group-level selection
- **ORDER BY**: Result ordering (not part of relational algebra)

### **Database Design**
- **Normalization**: Use functional dependencies to eliminate anomalies
- **View Definition**: Create virtual relations using algebra expressions
- **Constraint Checking**: Verify data integrity through algebra operations
- **Query Analysis**: Understand query behavior and performance

### **Query Processing**
- **Parser**: Convert SQL to relational algebra
- **Optimizer**: Transform algebra expressions for efficiency
- **Executor**: Evaluate algebra operations on data
- **Result**: Return formatted results to user

## Advanced Concepts

### **Multiset Algebra**
- **Bag Semantics**: Allow duplicate tuples in results
- **Duplicate Handling**: Count-based operations on multisets
- **SQL Semantics**: Most SQL operations use multiset algebra
- **Set vs Bag**: Mathematical vs practical database operations

### **Temporal Algebra**
- **Time-varying Relations**: Relations that change over time
- **Valid Time**: When facts are true in reality
- **Transaction Time**: When facts are stored in database
- **Temporal Operators**: Snapshot, temporal join, temporal selection

### **Probabilistic Algebra**
- **Uncertain Data**: Relations with probability distributions
- **Probabilistic Operations**: Handle uncertainty in query results
- **Confidence Intervals**: Quantify result reliability
- **Applications**: Sensor data, machine learning, data integration

## Implementation Considerations

### **Storage Models**
- **Row-oriented**: Store complete tuples together
- **Column-oriented**: Store attribute values separately
- **Hybrid**: Combine both approaches for different workloads
- **Compression**: Reduce storage requirements

### **Indexing Strategies**
- **B-tree**: Balanced tree for range queries
- **Hash**: Direct access for equality queries
- **Bitmap**: Efficient for low-cardinality attributes
- **Composite**: Multiple attribute combinations

### **Memory Management**
- **Buffer Pool**: Cache frequently accessed data
- **Sorting**: In-memory vs external sorting
- **Hashing**: Hash-based join and aggregation
- **Pipelining**: Stream results between operations

## Key Features

### **Theoretical Foundation**
- **Mathematical Rigor**: Based on set theory and logic
- **Completeness**: Can express any relational query
- **Optimization**: Algebraic laws enable query transformation
- **Language Independence**: Foundation for SQL, QBE, etc.

### **Practical Utility**
- **Query Understanding**: Analyze complex SQL queries
- **Performance Tuning**: Identify optimization opportunities
- **Database Design**: Validate schema designs
- **Education**: Teach database concepts systematically

### **Extensibility**
- **Custom Operators**: Define domain-specific operations
- **Aggregation**: Extend with statistical functions
- **Temporal**: Handle time-varying data
- **Probabilistic**: Manage uncertain information

## Important Notes

- **Closure Property**: All operations return relations, enabling composition
- **Optimization**: Algebraic laws enable automatic query optimization
- **SQL Mapping**: Most SQL constructs have direct algebra equivalents
- **Performance**: Physical implementation affects actual performance
- **Extensions**: Modern databases extend algebra with additional operations

## Related Concepts

- **[[Relational Database]]**: Database systems based on relational model
- **[[Database Management System (DBMS)]]**: Software implementing relational algebra
- **[[Data Model]]**: Conceptual framework for data organization
- **[[Collection]]**: Abstract data type for grouping data items
- **[[Array]]**: Basic data structure for organizing related data elements
