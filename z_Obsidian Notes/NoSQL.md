# NoSQL

**"Not Only SQL"**: Alternative to traditional relational database management systems (RDBMS)
- Misleading name: Doesn't mean "no SQL language"
- Addresses new data management challenges where RDBMS aren't the best fit
- RDBMS still suitable for many problems

## Why NoSQL?

### **Advantages**
**Flexible Schema**: More flexible than rigid relational model
- Useful when data doesn't easily structure into tables
- Handles unstructured/semi-structured data

**Quicker & Cheaper Setup**: Faster deployment for specific applications

**Massive Scalability**: Designed for enormous data volumes and highly efficient operations
- Critical for modern applications (social media, big data)

**Relaxed Consistency**: Trade transactional guarantees for higher performance and availability

### **Trade-offs/Downsides**
**No Declarative Query Language**: More direct programming involved
- Ad-hoc querying more challenging
- Less intuitive than SQL

**Fewer Guarantees**: Relaxed consistency means less strict data consistency or serializability

## Four Categories of NoSQL Systems

### **1. MapReduce Framework**

**Use Case**: Online Analytical Processing (OLAP) - analyze large amounts of data

**Key Features**:
- **Origin**: Developed by Google; **Hadoop** is widely-used open-source implementation
- **Data Model**: No inherent data model; data stored in files (Google File System/HDFS)
- **System Responsibilities**: Handles data processing, fault tolerance, scalability

**Core Functions**:
- **Map Function**: Divides data analysis into sub-problems, produces key-value pairs from input
- **Reduce Function**: Takes key and list of values, produces zero or more records
- **Combiner Function** (optional): Pre-aggregates data at mapper node for efficiency

**Example**: Counting web log accesses per domain
```
Map: Extract domain from each log entry → (domain, 1)
Reduce: Sum counts for each domain → (domain, total_count)
```

**Higher-Level Languages**: 
- **Hive** and **Pig** sit on top of Hadoop
- Offer schemas and more declarative query capabilities

**Limitation**: Joining separate datasets is difficult in native MapReduce

### **2. Key-Value Stores**

**Use Case**: Online Transaction Processing (OLTP) - many small operations on specific data parts

**Data Model**: Simple pairs of keys and values

**Basic Operations**:
- Insert, fetch, update, delete records by key
- Some support fetching on range of keys

**Focus**: 
- Extreme efficiency, scalability, fault tolerance
- Massive databases with stringent performance requirements

**Implementation**:
- Records distributed based on keys
- Often replicated across nodes

**Transactions**: 
- Single operations are transactions
- **Eventual Consistency** model

**Extensions**: Some incorporate "columns" within values

**Examples**: Google BigTable, Amazon Dynamo, Cassandra, Voldemort, HBase

### **3. Document Stores**

**Use Case**: Managing collections of documents with mixed structure

**Data Model**: Similar to key-value stores, but value is a document
- Documents contain structured formats (JSON, XML)
- Mix of structured (key-value pairs) and unstructured (text) data

**Operations**:
- Similar to key-value stores
- **Additional**: Fetch based on document contents

**Example Use Case**: Wikipedia pages
- Info boxes (structured key-value pairs)
- Large text volumes (unstructured)
- Consistency often not critical

**Examples**: CouchDB, MongoDB, SimpleDB

### **4. Graph Database Systems**

**Use Case**: Storing and querying large graphs (social networks, relationships)

**Data Model**:
- **Nodes**: Objects/entities with properties (ID, name, grade, etc.)
- **Edges**: Connections between nodes with labels/roles

**Advantages**:
- Complex queries involving relationships (friends of friends)
- Avoid inefficient joins in traditional RDBMS
- Approximate solutions and relaxed consistency acceptable

**Example**: Social network where nodes are users, edges are friendships

**Interfaces**: Currently vary widely with no standardization
- Range from single-step queries to full recursion

**Related**: 
- **RDF (Resource Description Framework)**: Can be mapped to graph databases
- **RDF Triple Stores**: Related technology

**Examples**: Neo4j, FlockDB, Pregel

## Comparison: NoSQL vs RDBMS

| Feature | RDBMS | NoSQL |
|---------|-------|-------|
| Schema | Rigid, fixed | Flexible |
| Query Language | Declarative SQL | Programming-based |
| Consistency | Strong ACID | Eventual consistency |
| Scalability | Vertical | Horizontal (massive) |
| Transactions | Full ACID support | Limited/single operation |
| Setup | Complex | Quick, cost-effective |

[[SQL]]

