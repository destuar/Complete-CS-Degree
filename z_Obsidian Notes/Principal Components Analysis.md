**Principal Components Analysis (PCA)** is an [[Unsupervised Learning]] method that finds a low-dimensional representation of a dataset that explains a maximal amount of variance. It uses [[Linear Transformation|linear transformations]] to create uncorrelated features.

### Mathematical Framework

For centered data matrix $\mathbf{X}$ (n × p):

First Principal Component:
$\mathbf{z}_1 = \mathbf{X}\mathbf{w}_1$

where $\mathbf{w}_1$ solves:
$\mathbf{w}_1 = \arg\max_{\|\mathbf{w}\|=1} \{\mathbf{w}^T\mathbf{X}^T\mathbf{X}\mathbf{w}\}$

### Computation Methods

1. **Eigendecomposition**
   - Compute covariance matrix: $\mathbf{S} = \frac{1}{n-1}\mathbf{X}^T\mathbf{X}$
   - Find eigenvectors and eigenvalues: $\mathbf{S}\mathbf{w} = \lambda\mathbf{w}$
   - Principal components are eigenvectors

2. **Singular Value Decomposition (SVD)**
   - $\mathbf{X} = \mathbf{U}\mathbf{D}\mathbf{V}^T$
   - Principal components are right singular vectors (V)
   - Scores are left singular vectors (U) scaled by singular values (D)

### Properties

1. **Orthogonality**
   - Principal components are orthogonal
   - $\mathbf{w}_i^T\mathbf{w}_j = 0$ for $i \neq j$

2. **Variance Explained**
   - Proportion: $\frac{\lambda_k}{\sum_{j=1}^p \lambda_j}$
   - Cumulative: $\sum_{k=1}^K \frac{\lambda_k}{\sum_{j=1}^p \lambda_j}$

3. **Reconstruction**
   - $\hat{\mathbf{X}} = \sum_{k=1}^K \mathbf{z}_k\mathbf{w}_k^T$
   - K ≤ p components
   - Minimizes reconstruction error

### Preprocessing

1. **Centering**
   - Subtract mean: $x_{ij} - \bar{x}_j$
   - Required for PCA

2. **Scaling**
   - Standardize: $\frac{x_{ij} - \bar{x}_j}{s_j}$
   - Important when variables on different scales

### Applications

1. **Dimensionality Reduction**
   - Feature extraction
   - Data compression
   - Visualization

2. **Preprocessing**
   - Remove multicollinearity
   - Noise reduction
   - [[Principal Components Regression]]

3. **Pattern Recognition**
   - Face recognition
   - Image compression
   - Signal processing

### Selecting Number of Components

1. **Scree Plot**
   - Plot eigenvalues vs. component number
   - Look for "elbow"

2. **Proportion of Variance**
   - Choose K to explain desired % of variance
   - Common thresholds: 80%, 90%

3. **Cross-Validation**
   - For supervised learning applications
   - Balance complexity vs. performance

### Limitations

1. **Linear Assumptions**
   - Only captures linear relationships
   - May miss nonlinear patterns

2. **Scale Sensitivity**
   - Results depend on scaling
   - Variables must be comparable

3. **Interpretability**
   - Components may be hard to interpret
   - Linear combinations of all features

### Extensions

1. **Kernel PCA**
   - Nonlinear dimensionality reduction
   - Uses kernel trick

2. **Sparse PCA**
   - Enforces sparsity in loadings
   - More interpretable components

3. **Robust PCA**
   - Handles outliers
   - Separates low-rank and sparse components

Tags:
[[Dimensionality Reduction]]
[[Unsupervised Learning]]
