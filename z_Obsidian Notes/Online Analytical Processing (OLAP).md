# Online Analytical Processing (OLAP)

## Definition

**OLAP** systems are designed for complex data analysis, data mining, and decision support, optimized for read-heavy analytical queries over large datasets.

## Characteristics

**Long, Complex Transactions**: Data analysis and mining queries
- Touches large portions of data
- **Infrequent Updates**: Read-mostly workload, sometimes no updates at all
- Examples: Sales analysis, trend identification, business intelligence

## Related Architecture

### **Data Warehousing**
Consolidates data from various operational (OLTP) sources into single large warehouse for analysis
- Central repository for enterprise data
- Optimized for analytical queries

### **Decision Support Systems (DSS)**
Infrastructure for large-scale data analysis
- Built on data warehouses
- Tuned for OLAP queries
- Supports business intelligence and reporting

## Star Schema

**Common OLAP Schema Design**: Central fact table surrounded by dimension tables

### **Fact Table**
Very large, append-only table containing business events
- **Dimension Attributes**: Foreign keys to dimension tables
- **Dependent Attributes**: Measures (quantity, price, revenue)
- Examples: Sales transactions, student enrollments, page views

### **Dimension Tables**
Smaller, stable tables updated infrequently
- Provide descriptive information about entities
- Examples: Stores, items, customers, students, courses, web pages, users, advertisers
- **Star Name**: Visual representation shows dimension tables radiating from central fact table

## OLAP Queries

### **Common Operations**
1. **Joining**: Fact table with dimension tables
2. **Filtering**: Based on dimension or dependent attributes
3. **GROUP BY and Aggregation**: Sum, average, count, etc.

```sql
SELECT d1.category, d2.region, SUM(f.sales)
FROM fact_table f
JOIN dimension1 d1 ON f.dim1_id = d1.id
JOIN dimension2 d2 ON f.dim2_id = d2.id
WHERE d1.year = 2024
GROUP BY d1.category, d2.region;
```

### **Performance Optimization**
- **Special Indexing**: Techniques for large-scale data
- **Query Processing**: Optimized for complex analytical queries
- **Materialized Views**: Pre-computed aggregates for read-heavy workload

## Data Cube (Multi-dimensional OLAP)

### **Conceptual Model**
N-dimensional cube where:
- **Dimensions**: Form the axes (time, product, location, etc.)
- **Cells**: Contain fact data (dependent attributes)
- **Aggregates**: On faces, edges, and corners based on predefined aggregate function

### **Example: 3D Cube**
- **Axes**: Time, Product, Store
- **Cell**: Total sales for specific time/product/store
- **Face**: Aggregated by 2 dimensions (e.g., product+store across all time)
- **Edge**: Aggregated by 1 dimension (e.g., store across all time+product)
- **Corner**: Grand total (aggregated across all dimensions)

## Drill Down & Roll Up

### **Drill Down**
Examine summary data → Add grouping attribute for more detail
- Move from higher-level aggregate to lower-level detail
- Example: Yearly sales → Monthly sales → Daily sales

### **Roll Up**
Summarize data → Remove grouping attribute for less detail
- Move from lower-level detail to higher-level aggregate
- Example: Daily sales → Monthly sales → Yearly sales

## SQL Constructs for OLAP

### **WITH CUBE**
Adds all possible aggregations (faces, edges, corner) to query result
- Uses NULL for unconstrained attributes
```sql
SELECT product, store, SUM(sales)
FROM fact_table
GROUP BY product, store WITH CUBE;
```

### **WITH ROLLUP**
Generates subset of aggregations for hierarchical dimensions
- Useful for hierarchical dimensions (year → quarter → month)
```sql
SELECT year, quarter, month, SUM(sales)
FROM fact_table
GROUP BY year, quarter, month WITH ROLLUP;
```

## Use Cases

- Business intelligence and reporting
- Sales trend analysis
- Financial forecasting
- Customer behavior analysis
- Market basket analysis
- Performance dashboards

## Related Concepts

- [[Online Transaction Processing (OLTP)]]
- [[Views]]
- [[Database Management System (DBMS)]]

