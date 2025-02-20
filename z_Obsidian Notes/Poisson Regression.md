**Poisson Regression** is a generalized linear model used for modeling count data, where the response variable follows a Poisson distribution. It's particularly useful for analyzing event frequencies and rates.

### Mathematical Framework
The model assumes:
$Y|X \sim \text{Poisson}(\lambda(x))$
$\log(\lambda(x)) = \beta_0 + \beta_1x_1 + ... + \beta_px_p$

where:
- $\lambda(x)$ is the mean count
- $\log$ is the natural logarithm (link function)
- $\beta_i$ are regression coefficients
- $x_i$ are predictor variables

### Properties
1. **Distribution**
   - Mean equals variance: $E(Y|X) = \text{Var}(Y|X) = \lambda(x)$
   - Non-negative integers
   - Right-skewed
   - Discrete distribution

2. **Link Function**
   - Log link: $\log(\lambda) = X\beta$
   - Exponential mean: $\lambda = e^{X\beta}$
   - Ensures positive rates

### Estimation
1. **Maximum Likelihood**
   $\ell(\beta) = \sum_{i=1}^n [y_i(x_i^T\beta) - e^{x_i^T\beta} - \log(y_i!)]$

2. **Iteratively Reweighted Least Squares**
   - Newton-Raphson method
   - Fisher scoring
   - Convergence properties

### Model Diagnostics
1. **Overdispersion**
   - Variance > Mean
   - [[Negative Binomial Regression]]
   - Quasi-Poisson models
   - Scale parameter

2. **Residual Analysis**
   - Deviance residuals
   - Pearson residuals
   - Q-Q plots
   - Influence measures

### Applications
1. **Count Data**
   - Disease incidence
   - Accident frequencies
   - Website visits
   - Event counts

2. **Rate Data**
   - Mortality rates
   - Failure rates
   - Crime rates
   - Exposure adjustment

### Extensions
1. **Zero-Inflation**
   - Zero-inflated Poisson
   - Hurdle models
   - Mixed models
   - Excess zeros

2. **Time Series**
   - Poisson autoregression
   - State-space models
   - Point processes
   - [[Time Series Analysis]]

Tags:
[[Statistical Learning]]
[[Regression Model]]
[[Generalized Additive Models]]
[[Multiple Testing]]
