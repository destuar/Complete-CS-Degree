**Negative Binomial Regression** extends [[Poisson Regression]] to handle over dispersed count data by introducing an additional parameter that allows the variance to exceed the mean. It's particularly useful when the Poisson assumption of equal mean and variance is violated.

### Mathematical Framework
The model assumes:
$Y|X \sim \text{NegBin}(\mu(x), r)$
$\log(\mu(x)) = \beta_0 + \beta_1x_1 + ... + \beta_px_p$

where:
- $\mu(x)$ is the mean count
- $r$ is the dispersion parameter
- Variance: $\text{Var}(Y|X) = \mu + \frac{\mu^2}{r}$
- $\beta_i$ are regression coefficients

### Properties
1. **Distribution**
   - Generalizes Poisson distribution
   - Variance > Mean (overdispersion)
   - Mixture of Poisson distributions
   - Gamma mixing distribution

2. **Link Function**
   - Log link: $\log(\mu) = X\beta$
   - Exponential mean: $\mu = e^{X\beta}$
   - Flexible variance structure

### Estimation
1. **Maximum Likelihood**
   $\ell(\beta,r) = \sum_{i=1}^n [\log \Gamma(y_i + r) - \log \Gamma(r) - \log(y_i!) + r\log(r) + y_i\log(\mu_i) - (r+y_i)\log(r+\mu_i)]$

2. **Iterative Methods**
   - Newton-Raphson
   - Fisher scoring
   - EM algorithm
   - Profile likelihood

### Model Selection
1. **Dispersion Testing**
   - Score test
   - Likelihood ratio test
   - Comparison with [[Poisson Regression]]
   - Residual analysis

2. **Variable Selection**
   - Information criteria
   - [[Cross-Validation]]
   - Stepwise procedures
   - Regularization

### Diagnostics
1. **Residual Analysis**
   - Deviance residuals
   - Pearson residuals
   - Leverage measures
   - Cook's distance

2. **Model Checking**
   - Goodness-of-fit
   - Overdispersion test
   - Zero-inflation check
   - Influence analysis

Tags:
[[Generalized Additive Models]]
