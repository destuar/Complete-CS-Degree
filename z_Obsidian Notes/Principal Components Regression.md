**Principal Components Regression (PCR)** combines [[Principal Components Analysis]] with [[Multiple Linear Regression]] by first performing dimensionality reduction and then using the principal components as predictors.

### Mathematical Framework

1. **PCA Step**
   - Center and scale X
   - Compute principal components: $\mathbf{Z} = \mathbf{X}\mathbf{W}$
   where $\mathbf{W}$ contains first M principal component loadings

2. **Regression Step**
   - Fit regression using M components:
   $Y = \theta_0 + \mathbf{Z}\boldsymbol{\theta} + \epsilon$
   - Transform back to original space:
   $\hat{\boldsymbol{\beta}} = \mathbf{W}\hat{\boldsymbol{\theta}}$

### Algorithm

1. **Preprocessing**
   - Center response: $y_i - \bar{y}$
   - Standardize predictors: $\frac{x_{ij} - \bar{x}_j}{s_j}$

2. **Component Selection**
   - Choose M ≤ p components
   - Often via [[Cross-Validation]]
   - Balance variance explained vs. model complexity

3. **Fitting Process**
   - Compute PCA of X
   - Select first M components
   - Regress Y on these components
   - Transform coefficients back

### Properties

1. **Bias-Variance Trade-off**
   - Small M: High bias, low variance
   - Large M: Low bias, high variance
   - M = p: Equivalent to OLS

2. **Regularization Effect**
   - Shrinks coefficients in directions of low variance
   - Different from [[Ridge Regression]] shrinkage
   - Can handle p > n case

### Advantages

1. **Dimension Reduction**
   - Handles multicollinearity
   - Works when p > n
   - Reduces noise

2. **Interpretability**
   - Can interpret components
   - Reveals underlying structure
   - Visual diagnostics possible

3. **Computational**
   - Fast after PCA
   - Stable solutions
   - Easy to update

### Limitations

1. **Component Selection**
   - Choice of M critical
   - May miss important predictors
   - Components not chosen for prediction

2. **Interpretability Issues**
   - Components may be hard to interpret
   - Original variables obscured
   - No variable selection

3. **Assumptions**
   - Linearity
   - Principal components capture relevant structure
   - Scale sensitivity

### Comparison with Other Methods

1. **vs [[Ridge Regression]]**
   - PCR: Discrete shrinkage
   - Ridge: Continuous shrinkage
   - Similar prediction accuracy

2. **vs [[Partial Least Squares]]**
   - PCR: Unsupervised dimension reduction
   - PLS: Supervised dimension reduction
   - PLS often more efficient

3. **vs [[Lasso Regression]]**
   - PCR: No variable selection
   - Lasso: Sparse solutions
   - Different use cases

### Implementation

1. **Cross-Validation**
   - Choose M components
   - Grid search over M
   - Consider prediction error

2. **Diagnostics**
   - Scree plot
   - Variance explained
   - Residual analysis
   - Component plots

### Applications
- Spectroscopy
- Chemometrics
- Gene expression analysis
- Economic forecasting

Tags:
[[Dimensionality Reduction]]
[[Principal Components Analysis]]
