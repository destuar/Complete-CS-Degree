**Multinomial Logistic Regression** extends [[Logistic Regression]] to handle classification problems with more than two categories. It models the probabilities of multiple class outcomes using a set of logistic functions.

### Mathematical Framework
For K classes, the model computes probabilities:

$P(Y=k|X=x) = \frac{e^{\beta_k^T x}}{\sum_{j=1}^K e^{\beta_j^T x}}$

where:
- $\beta_k$ are coefficient vectors for each class k
- One class serves as reference (usually $\beta_1 = 0$)
- x is the feature vector
- K is the number of classes

### Properties
1. **Model Structure**
   - K-1 independent binary models
   - Simultaneous parameter estimation
   - Reference class coding
   - Linear decision boundaries

2. **Probability Properties**
   - Sum to one: $\sum_{k=1}^K P(Y=k|X) = 1$
   - Non-negative: $P(Y=k|X) \geq 0$
   - Softmax transformation
   - Maximum entropy solution

### Estimation
1. **Maximum Likelihood**
   $\ell(\beta) = \sum_{i=1}^n \sum_{k=1}^K y_{ik}\log(P(Y_i=k|x_i))$

2. **Optimization**
   - Newton-Raphson method
   - IRLS algorithm
   - Coordinate descent
   - Stochastic methods

### Model Diagnostics
1. **Goodness of Fit**
   - Deviance
   - Pearson chi-square
   - Classification accuracy
   - Confusion matrix

2. **Residual Analysis**
   - Standardized residuals
   - Leverage measures
   - Cook's distance
   - ROC curves

### Applications
1. **Social Sciences**
   - Voting behavior
   - Educational choices
   - Career paths
   - Consumer preferences

2. **Medical Research**
   - Disease diagnosis
   - Treatment outcomes
   - Patient categorization
   - Risk assessment

### Extensions
1. **Regularization**
   - L1 penalty (Lasso)
   - L2 penalty (Ridge)
   - Elastic net
   - Group penalties

2. **Advanced Methods**
   - Mixed effects models
   - Bayesian approaches
   - Neural networks
   - Tree-based methods

Tags:
[[Statistical Learning]]
[[Classification]]
[[Logistic Regression]]
[[Supervised Learning]]
