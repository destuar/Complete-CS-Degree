A univariate function describes a relationship between one independent variable and one dependent variable. Understanding different types of fits for univariate functions is fundamental to data analysis, [[Simple Linear Regression|regression]], and statistical modeling.

## Types of Fits

1. **Constant Fit**:
   - Simplest possible fit: $f(x) = \beta$
   - Minimizes $\sum_{i=1}^n (y_i - \beta)^2$
   - Solution: $\hat{\beta} = \bar{y}$ (sample mean)
   - Useful baseline for comparing more complex models
   - [[Least Squares]] solution is the arithmetic mean

2. **Linear Fit** (Straight Line):
   - Model: $f(x) = \beta_0 + \beta_1x$
   - Minimizes $\sum_{i=1}^n (y_i - \beta_0 - \beta_1x_i)^2$
   - Solutions:
     $$ \hat{\beta}_1 = \frac{\sum(x_i - \bar{x})(y_i - \bar{y})}{\sum(x_i - \bar{x})^2} $$
     $$ \hat{\beta}_0 = \bar{y} - \hat{\beta}_1\bar{x} $$
   - Most common form of [[Simple Linear Regression]]

3. **Polynomial Fit**:
   - Model: $f(x) = \beta_0 + \beta_1x + \beta_2x^2 + ... + \beta_px^p$
   - Degree $p$ determines complexity
   - Special cases:
     - $p=1$: linear fit
     - $p=2$: quadratic fit
     - $p=3$: cubic fit

4. **Step Function Fit**:
   - Piecewise constant function
   - Divides x-axis into intervals
   - Constant value within each interval
   - Useful for categorical or discretized data

## Goodness of Fit Measures

1. **Residual Sum of Squares (RSS)**:
   $$ RSS = \sum_{i=1}^n (y_i - f(x_i))^2 $$
   - Measures total squared deviation
   - Used in [[Least Squares]] optimization

2. **R-squared ($R^2$)**:
   $$ R^2 = 1 - \frac{RSS}{\sum(y_i - \bar{y})^2} $$
   - Proportion of variance explained
   - Range: [0,1], higher is better
   - Caution: Can be misleading for polynomial fits

## Model Selection

1. **[[Bias-Variance Trade-off]]**:
   - Simple models (low complexity): high bias, low variance
   - Complex models (high complexity): low bias, high variance
   - Need to balance model complexity with data size

2. **[[Cross-Validation]]**:
   - Split data into training and validation sets
   - Fit model on training data
   - Evaluate performance on validation data
   - Helps prevent [[Bias-Variance Trade-Off|overfitting]]

## Important Notes

- Always plot the data before choosing a fit
- Consider the underlying process generating the data
- More complex fits aren't always better
- Watch for overfitting with high-degree polynomials
- Consider [[Ridge Regression]] or [[Lasso Regression]] for regularization
