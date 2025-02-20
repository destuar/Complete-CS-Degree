**Clustering** is an [[Unsupervised Learning]] method that groups similar observations together based on their feature values. It discovers natural groupings in data without labeled responses.

### K-means Clustering

1. **Algorithm**
   - Initialize K centroids randomly
   - Repeat until convergence:
     1. Assign points to nearest centroid
     2. Update centroids as cluster means

2. **Objective Function**
   Minimize:
   $\sum_{k=1}^K \sum_{i \in C_k} \|\mathbf{x}_i - \boldsymbol{\mu}_k\|^2$

   where:
   - $C_k$ is the kth cluster
   - $\boldsymbol{\mu}_k$ is the centroid of cluster k

### Hierarchical Clustering

1. **Agglomerative (Bottom-up)**
   - Start: each point is a cluster
   - Repeatedly merge closest clusters
   - Stop: single cluster or criterion met

2. **Distance Measures**
   - Single linkage: $\min_{i \in A, j \in B} d(i,j)$
   - Complete linkage: $\max_{i \in A, j \in B} d(i,j)$
   - Average linkage: $\frac{1}{|A||B|}\sum_{i \in A}\sum_{j \in B} d(i,j)$
   - Ward's method: minimize variance increase

### Gaussian Mixture Models

1. **Model**
   $p(\mathbf{x}) = \sum_{k=1}^K \pi_k \mathcal{N}(\mathbf{x}|\boldsymbol{\mu}_k, \boldsymbol{\Sigma}_k)$

2. **EM Algorithm**
   - E-step: Compute responsibilities
   - M-step: Update parameters
   - Iterate until convergence

### Evaluation Metrics

1. **Internal Metrics**
   - Silhouette coefficient
   - Davies-Bouldin index
   - Calinski-Harabasz index
   - Within-cluster sum of squares

2. **External Metrics**
   - Rand index
   - Adjusted Rand index
   - Mutual information
   - V-measure

### Choosing K

1. **Methods**
   - Elbow method
   - Silhouette analysis
   - Gap statistic
   - Information criteria

2. **Considerations**
   - Domain knowledge
   - Computational resources
   - Purpose of clustering

### Preprocessing

1. **Feature Scaling**
   - Standardization
   - Min-max scaling
   - Robust scaling

2. **Dimensionality Reduction**
   - [[Principal Components Analysis]]
   - t-SNE
   - UMAP

### Challenges

1. **Data Issues**
   - High dimensionality
   - Mixed feature types
   - Missing values
   - Outliers

2. **Algorithm Issues**
   - Local optima
   - Sensitivity to initialization
   - Non-convex optimization
   - Computational complexity

### Applications
- Customer segmentation
- Document clustering
- Image segmentation
- Anomaly detection
- Pattern discovery

### Diagnostics
- Cluster visualization
- Stability analysis
- Feature importance
- Cluster profiles
- Validation indices

Tags:
[[Unsupervised Learning]] 