**Logistic Regression** is a [[Parametric Models|parametric]] method for [[Classification]] that models the probability of a binary outcome using the logistic function. Despite its name, it's used for classification rather than regression.

### Mathematical Framework

For binary classification (Y ∈ {0,1}):

$P(Y=1|X=x) = \frac{e^{\beta_0 + \beta_1x_1 + ... + \beta_px_p}}{1 + e^{\beta_0 + \beta_1x_1 + ... + \beta_px_p}} = \frac{1}{1 + e^{-(\beta_0 + \beta_1x_1 + ... + \beta_px_p)}}$

The logit (log-odds) transformation:
$\log\left(\frac{P(Y=1|X)}{1-P(Y=1|X)}\right) = \beta_0 + \beta_1x_1 + ... + \beta_px_p$

### Parameter Estimation

**Maximum Likelihood Estimation**:
$L(\beta) = \prod_{i=1}^n p(x_i)^{y_i}(1-p(x_i))^{1-y_i}$

Log-likelihood:
$\ell(\beta) = \sum_{i=1}^n [y_i\log(p(x_i)) + (1-y_i)\log(1-p(x_i))]$

Solved using:
- Newton-Raphson method
- Gradient descent
- Iteratively Reweighted Least Squares (IRLS)

### Statistical Inference

1. **Coefficient Estimates**
   - Standard Errors: $SE(\hat{\beta}_j)$
   - z-statistics: $z_j = \frac{\hat{\beta}_j}{SE(\hat{\beta}_j)}$
   - p-values: $2\cdot P(|Z| > |z_j|)$

2. **Model Assessment**
   - Deviance
   - AIC (Akaike Information Criterion)
   - BIC (Bayesian Information Criterion)

### Decision Boundary
- Default threshold = 0.5
- Predict Y = 1 if $P(Y=1|X) > \text{threshold}$
- Can adjust threshold based on:
  - Class imbalance
  - Cost of misclassification
  - Desired sensitivity/specificity

### Model Evaluation

1. **Performance Metrics**
   - Accuracy
   - Precision
   - Recall
   - F1-Score
   - ROC curve and AUC
   - Confusion matrix

2. **Validation Methods**
   - [[Cross-Validation]]
   - Hold-out validation
   - Bootstrap

### Extensions

1. **Regularization**
   - L1 (Lasso): $\lambda\sum_{j=1}^p |\beta_j|$
   - L2 (Ridge): $\lambda\sum_{j=1}^p \beta_j^2$
   - Elastic Net: Combination of L1 and L2

2. **Multinomial Logistic Regression**
   For K > 2 classes:
   $P(Y=k|X=x) = \frac{e^{\beta_{k0} + \beta_{k1}x_1 + ... + \beta_{kp}x_p}}{\sum_{l=1}^K e^{\beta_{l0} + \beta_{l1}x_1 + ... + \beta_{lp}x_p}}$

### Assumptions
- Linear relationship between logit and predictors
- Independent observations
- No perfect multicollinearity
- Large sample size relative to predictors

Tags:
[[Classification]]
[[Parametric Models]]
[[Generalized Linear Models]]
