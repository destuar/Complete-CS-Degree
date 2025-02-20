**Hierarchical [[Clustering]]** is an [[Unsupervised Learning]] method that builds a hierarchy of clusters by either successively merging smaller clusters (agglomerative) or dividing larger clusters (divisive). It provides a tree-like structure of nested clusters called a dendrogram.

### Mathematical Framework
For agglomerative clustering, distance between clusters A and B:

$d(A,B) = \text{linkage}(d(x,y))$ for $x \in A, y \in B$

Common linkage functions:
- Single: $\min_{x \in A, y \in B} d(x,y)$
- Complete: $\max_{x \in A, y \in B} d(x,y)$
- Average: $\frac{1}{|A||B|}\sum_{x \in A}\sum_{y \in B} d(x,y)$
- Ward's: Minimizes within-cluster variance

### Algorithm Steps
1. **Agglomerative (Bottom-up)**
   - Start with singleton clusters
   - Merge closest clusters
   - Update distances
   - Repeat until single cluster

2. **Divisive (Top-down)**
   - Start with one cluster
   - Split clusters recursively
   - Choose optimal splits
   - Continue until singletons

### Properties
1. **Dendrogram**
   - Tree representation
   - Height = merge distance
   - Nested structure
   - Cutting produces clusters

2. **Distance Metrics**
   - Euclidean distance
   - Manhattan distance
   - Correlation-based
   - Custom metrics

### Implementation
1. **Choices**
   - Linkage method
   - Distance metric
   - Cutting height
   - Number of clusters

2. **Computational Aspects**
   - Time complexity O(n³)
   - Space complexity O(n²)
   - Memory requirements
   - Optimization methods

### Advantages and Limitations
**Advantages:**
- No need to specify clusters
- Hierarchical structure
- Visual interpretation
- Deterministic results

**Limitations:**
- Computationally intensive
- Sensitive to noise
- Cannot undo merges/splits
- Memory constraints