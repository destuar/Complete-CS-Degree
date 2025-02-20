**Partial Least Squares (PLS)** is a supervised dimension reduction method that finds components that explain both response and predictor variation. Unlike [[Principal Components Regression]], it considers the response when constructing components.

### Mathematical Framework

For response Y and predictors X:

1. **First Direction**
   $\mathbf{w}_1 = \arg\max_{\|\mathbf{w}\|=1} \text{Cov}^2(\mathbf{X}\mathbf{w}, \mathbf{y})$

2. **Component Construction**
   $\mathbf{z}_1 = \mathbf{X}\mathbf{w}_1$

3. **Subsequent Directions**
   - Deflate X matrix
   - Repeat process on residuals

### Algorithm (NIPALS)

1. **Initialization**
   - Center X and y
   - Set $\mathbf{X}_1 = \mathbf{X}$

2. **For m = 1 to M:**
   - $\mathbf{w}_m = \mathbf{X}_m^T\mathbf{y}/\|\mathbf{X}_m^T\mathbf{y}\|$
   - $\mathbf{z}_m = \mathbf{X}_m\mathbf{w}_m$
   - $\theta_m = \mathbf{z}_m^T\mathbf{y}/(\mathbf{z}_m^T\mathbf{z}_m)$
   - $\mathbf{p}_m = \mathbf{X}_m^T\mathbf{z}_m/(\mathbf{z}_m^T\mathbf{z}_m)$
   - $\mathbf{X}_{m+1} = \mathbf{X}_m - \mathbf{z}_m\mathbf{p}_m^T$

### Properties

1. **Supervised Nature**
   - Components maximize covariance with response
   - More directly related to prediction
   - Often needs fewer components than PCR

2. **Orthogonality**
   - Score vectors $\mathbf{z}_m$ are orthogonal
   - Loading vectors $\mathbf{p}_m$ not necessarily orthogonal

### Advantages

1. **Prediction Performance**
   - Often better than PCR
   - Especially good when X-Y relationship strong
   - Works well with noisy X variables

2. **Dimension Reduction**
   - Handles multicollinearity
   - Works when p > n
   - Supervised reduction more relevant

3. **Interpretability**
   - Components directly related to response
   - Can interpret variable importance
   - Natural variable selection

### Limitations

1. **Overfitting Risk**
   - Can overfit if too many components
   - Requires careful cross-validation
   - May not generalize well

2. **Theoretical Properties**
   - Less well-understood than PCR
   - Optimality conditions unclear
   - No clear population analog

### Implementation

1. **Component Selection**
   - Cross-validation crucial
   - PRESS statistic
   - VIP scores (Variable Importance in Projection)

2. **Variants**
   - SIMPLS algorithm
   - Kernel PLS
   - Sparse PLS

### Comparison with Other Methods

1. **vs [[Principal Components Regression]]**
   - PLS: Supervised components
   - PCR: Unsupervised components
   - PLS often needs fewer components

2. **vs [[Ridge Regression]]**
   - PLS: Dimension reduction
   - Ridge: Shrinkage
   - Different regularization approach

3. **vs [[Lasso Regression]]**
   - PLS: Soft variable selection
   - Lasso: Hard variable selection
   - Different sparsity approaches

### Applications
- Chemometrics
- Spectroscopy
- Metabolomics
- Process monitoring
- Quality control

Tags:
[[Statistical Learning]]
[[Dimensionality Reduction]]
[[Regression Model]]
[[Supervised Learning]]
[[Model Selection]]
