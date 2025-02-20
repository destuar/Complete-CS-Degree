**The Bias-Variance Trade-Off** is a fundamental concept in [[Statistical Learning]] that describes the relationship between model complexity and prediction error, helping to understand the optimal balance between underfitting and overfitting.

### Mathematical Decomposition
For a given point $x_0$, the expected prediction error can be decomposed as:

$\mathbb{E}[(Y - \hat{f}(x_0))^2] = \text{Bias}[\hat{f}(x_0)]^2 + \text{Var}[\hat{f}(x_0)] + \sigma^2$

where:
- $\text{Bias}[\hat{f}(x_0)] = \mathbb{E}[\hat{f}(x_0)] - f(x_0)$
- $\text{Var}[\hat{f}(x_0)] = \mathbb{E}[\hat{f}(x_0) - \mathbb{E}[\hat{f}(x_0)]]^2$
- $\sigma^2$ is irreducible error

### Components

1. **Bias**
   - Measures systematic error
   - Error from incorrect assumptions
   - High bias = underfitting
   - Common in [[Parametric Models]]

2. **Variance**
   - Measures sensitivity to training data
   - Error from model complexity
   - High variance = overfitting
   - Common in [[Non-Parametric Models]]

3. **Irreducible Error**
   - Inherent noise in the problem
   - Cannot be reduced by any model

### Model Flexibility Effects
- **Low Flexibility**
  - High bias, low variance
  - Example: [[Linear Regression]]
  - Underfits the data

- **High Flexibility**
  - Low bias, high variance
  - Example: [[K-Nearest Neighbors]] with small k
  - Overfits the data

### Optimization Methods
1. **Cross-Validation**
   - [[K-Fold Cross-Validation]]
   - Validation set approach
   - [[Bootstrap]]

2. **Regularization**
   - [[Ridge Regression]]: L2 penalty
   - [[Lasso Regression]]: L1 penalty
   - Early stopping in [[Neural Networks]]

3. **Model Selection**
   - [[AIC]] (Akaike Information Criterion)
   - [[BIC]] (Bayesian Information Criterion)
   - One-standard-error rule

### Applications
- Hyperparameter tuning
- Model complexity selection
- Ensemble method design
- Feature selection

Tags:
[[Statistical Learning]]
[[Machine Learning]]
[[Model Selection]]
[[Cross-Validation]]
[[Overfitting]]
[[Underfitting]]
