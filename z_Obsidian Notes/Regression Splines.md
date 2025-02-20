**Regression Splines** are piecewise polynomial functions that provide a flexible approach to modeling non-linear relationships. They combine the simplicity of [[Polynomial Regression]] with the flexibility of [[Step Functions]] by dividing the predictor space into regions.

### Mathematical Framework
A cubic spline with K knots can be represented as:

$f(x) = \beta_0 + \beta_1x + \beta_2x^2 + \beta_3x^3 + \sum_{k=1}^K \theta_k(x - \xi_k)^3_+$

where:
- $\xi_k$ are the knot locations
- $(x - \xi_k)^3_+$ are truncated power basis functions
- $\beta_i$ are coefficients for polynomial terms
- $\theta_k$ are coefficients for basis functions

### Key Components
1. **Basis Functions**
   - Truncated power basis
   - B-spline basis
   - Natural spline basis
   - Periodic splines

2. **Knots**
   - Location selection
   - Number of knots
   - Uniform vs. quantile spacing
   - Boundary knots

### Properties
1. **Continuity**
   - Continuous function
   - Continuous derivatives
   - Smoothness at knots
   - Degree of polynomial

2. **Flexibility**
   - Controlled by number of knots
   - Degree of polynomial
   - Boundary constraints
   - [[Bias-Variance Trade-Off]]

### Model Selection
1. **Knot Selection**
   - Number of knots
   - Placement strategy
   - [[Cross-Validation]]
   - Information criteria

2. **Degree Selection**
   - Linear splines
   - Quadratic splines
   - Cubic splines
   - Higher-order splines

### Relationship to Other Methods
- Generalizes [[Polynomial Regression]]
- Basis for [[Smoothing Splines]]
- Related to [[Local Regression]]
- Component of [[Generalized Additive Models]]

### Applications
- Nonlinear trend modeling
- Growth curve analysis
- Environmental data
- Economic forecasting
- Biostatistics

### Advantages and Limitations
**Advantages:**
- Flexible functional form
- Interpretable components
- Efficient computation
- Local adaptivity

**Limitations:**
- Knot selection complexity
- Potential for overfitting
- Boundary effects
- Curse of dimensionality

Tags:
[[Smoothing Splines]]
