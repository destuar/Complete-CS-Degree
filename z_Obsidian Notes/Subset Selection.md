**Subset Selection** refers to methods for selecting a subset of predictors in [[Multiple Linear Regression]] and other statistical models to improve prediction accuracy and interpretability.

### Best Subset Selection
1. **Algorithm**
   - Fit all possible $2^p$ models
   - For each size k = 1,...,p:
     - Find best model with k predictors
     - Compute criterion (RSS, $R^2$, Cp, BIC, AIC)
   - Select optimal model across all sizes

2. **Computational Complexity**
   - Total models: $\sum_{k=1}^p \binom{p}{k}$
   - Infeasible for large p
   - NP-hard optimization problem

### Forward Stepwise Selection
1. **Algorithm**
   - Start with null model (intercept only)
   - Iteratively add most significant predictor
   - Stop when criterion no longer improves
   - Total models considered: $1 + \frac{p(p+1)}{2}$

2. **Selection Criterion**
   $\text{RSS}_k = \sum_{i=1}^n(y_i - \hat{y}_i)^2$
   or F-statistic for new variable

### Backward Stepwise Selection
1. **Algorithm**
   - Start with full model (all predictors)
   - Iteratively remove least significant predictor
   - Stop when all remaining predictors significant
   - Requires n > p

2. **Selection Criterion**
   - t-statistics or p-values
   - AIC, BIC, or other information criteria

### Model Selection Criteria
1. **Cp (Mallows' Cp)**
   $C_p = \frac{1}{n}(\text{RSS} + 2d\hat{\sigma}^2)$

2. **AIC (Akaike Information Criterion)**
   $\text{AIC} = -2\log L + 2d$

3. **BIC (Bayesian Information Criterion)**
   $\text{BIC} = -2\log L + \log(n)d$

where:
- d = number of parameters
- L = likelihood
- n = sample size

### Hybrid Methods
1. **Stepwise Selection**
   - Combination of forward and backward
   - Can both add and remove at each step
   - More flexible than pure forward/backward

2. **Sequential Replacement**
   - Consider replacing each predictor
   - More thorough than stepwise
   - Still computationally feasible

### Validation Approaches
1. **[[Cross-Validation]]**
   - k-fold CV for each model size
   - Select size with minimum CV error

2. **[[Bootstrap]]**
   - Stability selection
   - Variable importance measures

### Limitations
1. **Statistical Issues**
   - No guarantee of optimality
   - Instability of selection
   - Multiple testing problems
   - Biased coefficient estimates

2. **Computational Issues**
   - Best subset selection computationally intensive
   - May be infeasible for large p

### Alternatives
- [[Ridge Regression]]
- [[Lasso Regression]]
- [[Principal Components Regression]]