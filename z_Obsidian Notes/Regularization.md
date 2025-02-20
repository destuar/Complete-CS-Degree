Regularization is a technique used to prevent overfitting in machine learning models by adding a penalty term to the loss function. It helps control model complexity and improve generalization performance.

### Common Types
1. **L1 Regularization (Lasso)**
   - Adds absolute value of coefficients to loss function
   - Loss: $L(\beta) + \lambda\sum_{j=1}^p |\beta_j|$
   - Promotes sparsity (feature selection)
   - See: [[Lasso Regression]]

2. **L2 Regularization (Ridge)**
   - Adds squared magnitude of coefficients
   - Loss: $L(\beta) + \lambda\sum_{j=1}^p \beta_j^2$
   - Shrinks coefficients toward zero
   - See: [[Ridge Regression]]

3. **Elastic Net**
   - Combines L1 and L2 regularization
   - Loss: $L(\beta) + \lambda_1\sum_{j=1}^p |\beta_j| + \lambda_2\sum_{j=1}^p \beta_j^2$
   - Balances sparsity and coefficient shrinkage

### Other Techniques
1. **Dropout**
   - Randomly deactivates neurons during training
   - Common in [[Neural Networks]]
   - Acts as model averaging

2. **Early Stopping**
   - Stops training when validation error increases
   - Prevents overfitting to training data
   - Uses [[Cross-Validation]]

3. **Weight Decay**
   - Gradually reduces weights during training
   - Similar to L2 regularization
   - Common in deep learning

### Selection of λ
- Use [[Cross-Validation]] to select regularization strength
- Balance between bias and variance
- Consider problem-specific requirements:
  - Sparsity needs (L1)
  - Stability needs (L2)
  - Computational constraints
