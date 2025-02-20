**Local Regression** (LOESS/LOWESS) is a non-parametric approach that fits multiple regression models to localized subsets of the data to construct a function that describes the deterministic part of the variation in the data.

### Mathematical Framework
For a point x, the local estimate is:

$\hat{f}(x) = \hat{\beta}_0(x) + \hat{\beta}_1(x)(X-x)$

where coefficients minimize:
$\sum_{i=1}^n K_\lambda(x, x_i)(y_i - \beta_0 - \beta_1(x_i-x))^2$

where:
- $K_\lambda$ is a kernel function
- $\lambda$ is the bandwidth parameter
- $(x_i, y_i)$ are data points
- Weights decrease with distance from x

### Key Components
1. **Kernel Functions**
   - Tricube: $K(u) = (1-|u|^3)^3$ for $|u| \leq 1$
   - Epanechnikov kernel
   - Gaussian kernel
   - Rectangular kernel

2. **Bandwidth Selection**
   - Controls smoothness
   - [[Cross-Validation]]
   - Plug-in methods
   - Rule of thumb

### Properties
1. **Smoothing**
   - Adaptive to local structure
   - Handles non-linear patterns
   - Robust to outliers
   - [[Bias-Variance Trade-Off]]

2. **Computational Aspects**
   - Local weighted least squares
   - Iterative reweighting
   - Fast implementations
   - Memory requirements

### Extensions
1. **Robust Methods**
   - Iterative reweighting
   - M-estimators
   - Outlier detection
   - Influence functions

2. **Multivariate Extensions**
   - Local polynomial regression
   - Additive models
   - Surface smoothing
   - Projection pursuit

### Applications
1. **Data Analysis**
   - Trend estimation
   - Seasonal adjustment
   - Residual analysis
   - Exploratory analysis

2. **Specific Fields**
   - Environmental monitoring
   - Economic forecasting
   - Signal processing
   - Quality control

### Relationship to Other Methods
- Similar to [[Kernel Regression]]
- Related to [[Smoothing Splines]]
- Component of [[Generalized Additive Models]]
- Alternative to [[Polynomial Regression]]

### Advantages and Limitations
**Advantages:**
- No functional form assumption
- Adapts to local structure
- Robust to outliers
- Visual interpretability

**Limitations:**
- Computationally intensive
- Curse of dimensionality
- Boundary effects
- Parameter selection complexity

Tags:
[[Smoothing Splines]]
