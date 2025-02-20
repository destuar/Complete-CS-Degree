**Lasso (Least Absolute Shrinkage and Selection Operator) Regression** is a regularization method that adds an L1 penalty to the [[Multiple Linear Regression]] loss function, enabling both shrinkage and variable selection.

### Mathematical Framework

Minimizes:
$\text{RSS}(\lambda) = \sum_{i=1}^n(y_i - \beta_0 - \sum_{j=1}^p\beta_jx_{ij})^2 + \lambda\sum_{j=1}^p|\beta_j|$

where:
- λ ≥ 0 is the tuning parameter
- Second term is the L1 penalty
- $\beta_0$ is not penalized

### Solution Properties

Unlike [[Ridge Regression]], no closed form solution exists.
Solved via:
- Coordinate descent
- LARS (Least Angle Regression)
- Proximal gradient methods

### Variable Selection

1. **Sparsity**
   - Some coefficients exactly zero
   - Automatic feature selection
   - Due to L1 geometry

2. **Selection Process**
   - As λ increases, more coefficients → 0
   - Creates sparse models
   - Path is piecewise linear

### Standardization

Before fitting:
1. Center response: $y_i - \bar{y}$
2. Standardize predictors: $\frac{x_{ij} - \bar{x}_j}{s_j}$
   where $s_j^2 = \frac{1}{n}\sum_{i=1}^n(x_{ij} - \bar{x}_j)^2$

### Effect of λ

1. **λ = 0**
   - Ordinary least squares
   - No shrinkage/selection

2. **λ → ∞**
   - All $\hat{\beta}_j \to 0$ (except intercept)
   - Null model

3. **Optimal λ**
   - Selected via [[Cross-Validation]]
   - Balance between sparsity and fit

### Geometric Interpretation

1. **Constraint Region**
   - L1 ball: $\sum_{j=1}^p|\beta_j| \leq t$
   - Diamond-shaped constraint

2. **Solution**
   - First point where contours of RSS meet constraint
   - Often occurs at corners (sparsity)

### Comparison with Other Methods

1. **vs [[Ridge Regression]]**
   - Lasso: L1 penalty (variable selection)
   - Ridge: L2 penalty (shrinkage only)
   - Lasso better when true model is sparse

2. **vs [[Subset Selection]]**
   - Lasso: Continuous process
   - Subset: Discrete selection
   - Lasso computationally efficient

### Advantages
- Performs variable selection
- Yields sparse models
- Computationally efficient
- Good for high-dimensional data
- Interpretable results

### Limitations
- No closed-form solution
- Unstable with correlated predictors
- Selects at most n variables when p > n
- Can be sensitive to scaling

### Extensions

1. **Elastic Net**
   - Combines L1 and L2 penalties
   - $\lambda(\alpha\sum_{j=1}^p|\beta_j| + (1-\alpha)\sum_{j=1}^p\beta_j^2)$
   - Better with correlated predictors

2. **Group Lasso**
   - Selects groups of variables
   - Useful for categorical variables
   - Maintains hierarchical structure

### Applications
- Gene selection
- Signal processing
- Compressed sensing
- High-dimensional modeling

Tags:
[[Statistical Learning]]
[[Regularization]]
[[Multiple Linear Regression]]
[[Model Selection]]
[[Shrinkage Methods]]
[[Variable Selection]]
