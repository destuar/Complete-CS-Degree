**Ridge Regression** is a regularization method that adds an L2 penalty to the [[Multiple Linear Regression]] loss function to handle multicollinearity and prevent overfitting.

### Mathematical Framework

Minimizes:
$\text{RSS}(\lambda) = \sum_{i=1}^n(y_i - \beta_0 - \sum_{j=1}^p\beta_jx_{ij})^2 + \lambda\sum_{j=1}^p\beta_j^2$

where:
- λ ≥ 0 is the tuning parameter
- Second term is the L2 penalty
- $\beta_0$ is not penalized

### Matrix Form

$\hat{\boldsymbol{\beta}}_{\text{ridge}} = (\mathbf{X}^T\mathbf{X} + \lambda\mathbf{I})^{-1}\mathbf{X}^T\mathbf{y}$

Properties:
- Always unique solution (strictly convex)
- Continuous shrinkage
- No variable selection

### Standardization

Before fitting:
1. Center response: $y_i - \bar{y}$
2. Standardize predictors: $\frac{x_{ij} - \bar{x}_j}{s_j}$
   where $s_j^2 = \frac{1}{n}\sum_{i=1}^n(x_{ij} - \bar{x}_j)^2$

### Effect of λ

1. **λ = 0**
   - Ordinary least squares
   - No shrinkage

2. **λ → ∞**
   - $\hat{\beta}_j \to 0$
   - Maximum shrinkage

3. **Optimal λ**
   - Selected via [[Cross-Validation]]
   - Balance between bias and variance

### Geometric Interpretation

1. **Constraint Region**
   - L2 ball: $\sum_{j=1}^p\beta_j^2 \leq t$
   - Circular/spherical constraint

2. **Solution**
   - First point where contours of RSS meet constraint
   - Smooth shrinkage toward zero

### Relationship to Other Methods

1. **vs [[Lasso Regression]]**
   - Ridge: L2 penalty
   - Lasso: L1 penalty
   - Ridge keeps all variables

2. **vs [[Subset Selection]]**
   - Ridge: Continuous shrinkage
   - Subset: Discrete selection

### Advantages
- Handles multicollinearity
- Continuous shrinkage
- Computationally efficient
- Stable solutions
- Good for many small effects

### Limitations
- No variable selection
- Not sparse
- Scale dependent
- Biased estimator

### Implementation

1. **Choosing λ**
   - Grid of λ values
   - k-fold cross-validation
   - One-standard-error rule

2. **Scaling Considerations**
   - Must standardize predictors
   - Can use different penalties per variable

### Applications
- High-dimensional data
- Multicollinear predictors
- Signal processing
- Genomics

Tags:
[[Statistical Learning]]
[[Regularization]]
[[Multiple Linear Regression]]
[[Model Selection]]
[[Shrinkage Methods]]
