Dimensionality Reduction refers to techniques for reducing the number of features in a dataset while preserving important information. It's crucial for dealing with high-dimensional data and the [[Curse of Dimensionality]].

### Linear Methods
1. **Principal Component Analysis (PCA)**
   - [[Principal Components Analysis]]
   - Finds orthogonal directions of maximum variance
   - Transforms data into uncorrelated components
   - Linear combinations of original features

2. **Linear Discriminant Analysis (LDA)**
   - [[Linear Discriminant Analysis]]
   - Supervised technique
   - Maximizes class separability
   - Useful for classification tasks

3. **Factor Analysis**
   - [[Factor Analysis]]
   - Models correlations using latent variables
   - Assumes underlying factor structure
   - Common in psychology and social sciences

### Non-linear Methods
1. **t-SNE (t-Distributed Stochastic Neighbor Embedding)**
   - Preserves local structure
   - Good for visualization
   - Computationally intensive
   - Non-parametric

2. **UMAP (Uniform Manifold Approximation and Projection)**
   - Faster than t-SNE
   - Better preserves global structure
   - Based on topological theory
   - Scalable to large datasets

3. **Autoencoders**
   - [[Neural Networks]] based
   - Learn compressed representations
   - Can capture non-linear relationships
   - Unsupervised learning

### Evaluation Metrics
1. **Reconstruction Error**
   - Measure information loss
   - Compare original vs. reconstructed data

2. **Explained Variance**
   - Proportion of variance retained
   - Guide for choosing dimensions
