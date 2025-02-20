**K-Means Clustering** is an iterative algorithm that partitions data into K distinct, non-overlapping clusters by minimizing within-cluster variation. It is a fundamental method in [[Unsupervised Learning]] and [[Clustering]].

### Mathematical Framework
The algorithm minimizes:

$\min_{C_1,...,C_K} \sum_{k=1}^K \sum_{i \in C_k} \|x_i - \mu_k\|^2$

where:
- $C_k$ are the clusters
- $\mu_k$ is the centroid of cluster k
- $x_i$ are data points
- $K$ is the number of clusters

### Algorithm Steps
1. **Initialization**
   - Choose K cluster centers
   - Random initialization
   - K-means++
   - Strategic seeding

2. **Iteration**
   - Assign points to nearest center
   - Update cluster centers
   - Repeat until convergence
   - Check for stability

### Properties
1. **Convergence**
   - Always converges locally
   - Not guaranteed global optimum
   - Sensitive to initialization
   - Usually fast convergence

2. **Characteristics**
   - Spherical clusters
   - Equal variance assumption
   - Distance-based
   - Centroid representation

### Implementation
1. **Distance Metrics**
   - Euclidean distance
   - Manhattan distance
   - Cosine similarity
   - Custom metrics

2. **Parameter Selection**
   - Number of clusters K
   - Initialization method
   - Convergence criteria
   - Multiple restarts

### Applications
1. **Data Analysis**
   - Customer segmentation
   - Image compression
   - Document clustering
   - Pattern recognition

2. **Feature Learning**
   - Vector quantization
   - Feature extraction
   - Dimensionality reduction
   - Prototype learning

### Extensions
1. **Variants**
   - K-medoids
   - Fuzzy K-means
   - Kernel K-means
   - Mini-batch K-means

2. **Related Methods**
   - [[Hierarchical Clustering]]
   - Gaussian mixture models
   - Spectral clustering
   - DBSCAN

### Advantages and Limitations
**Advantages:**
- Simple to understand
- Easy to implement
- Scalable to large datasets
- Guaranteed convergence

**Limitations:**
- Requires specifying K
- Sensitive to outliers
- Assumes spherical clusters
- Local optima issues

Tags:
[[Unsupervised Learning]]
[[Clustering]]
