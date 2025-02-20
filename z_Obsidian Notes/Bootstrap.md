**Bootstrap** is a resampling method that estimates the sampling distribution of a statistic by repeatedly sampling with replacement from the observed data. It's particularly useful when the theoretical distribution is unknown or difficult to derive.

### Mathematical Framework

For a statistic $\theta = s(F)$ where F is the true distribution:
- Sample estimate: $\hat{\theta} = s(\hat{F})$
- Bootstrap estimate: $\hat{\theta}^* = s(F^*)$

where:
- $\hat{F}$ is the empirical distribution
- $F^*$ is the bootstrap distribution
- $\hat{\theta}^*$ is computed B times

### Basic Algorithm

1. Given data $X = \{x_1, ..., x_n\}$
2. For b = 1 to B:
   - Draw n samples with replacement from X
   - Compute statistic $\hat{\theta}^{*(b)}$ on bootstrap sample
3. Use empirical distribution of $\{\hat{\theta}^{*(1)}, ..., \hat{\theta}^{*(B)}\}$

### Standard Error Estimation

Bootstrap Standard Error:
$SE_B(\hat{\theta}^*) = \sqrt{\frac{1}{B-1}\sum_{b=1}^B(\hat{\theta}^{*(b)} - \bar{\theta}^*)^2}$

where $\bar{\theta}^* = \frac{1}{B}\sum_{b=1}^B\hat{\theta}^{*(b)}$

### Confidence Intervals

1. **Percentile Method**
   - $(\hat{\theta}^*_{(\alpha/2)}, \hat{\theta}^*_{(1-\alpha/2)})$
   - Simple but may have poor coverage

2. **Basic Bootstrap**
   - $2\hat{\theta} - \hat{\theta}^*_{(1-\alpha/2)}, 2\hat{\theta} - \hat{\theta}^*_{(\alpha/2)}$
   - Corrects for bias

3. **BCa (Bias-Corrected and Accelerated)**
   - Adjusts for bias and skewness
   - More accurate but computationally intensive

### Applications

1. **Model Assessment**
   - Prediction error estimation
   - Variable importance
   - Model stability

2. **Parameter Uncertainty**
   - Standard errors
   - Confidence intervals
   - Hypothesis tests

3. **Model Selection**
   - [[Cross-Validation]] with bootstrapping
   - Stability selection
   - Ensemble methods

### Variations

1. **Parametric Bootstrap**
   - Sample from fitted parametric model
   - Useful when distribution family is known

2. **Wild Bootstrap**
   - Resamples residuals with modifications
   - Handles heteroscedasticity

3. **Block Bootstrap**
   - For dependent data (time series)
   - Maintains temporal structure

### Theoretical Properties

1. **Consistency**
   - Bootstrap distribution converges to true sampling distribution
   - Requires B → ∞ and n → ∞

2. **Coverage**
   - Asymptotic coverage of confidence intervals
   - Different methods have different finite-sample properties

### Limitations
- Computationally intensive
- Sensitive to outliers
- May fail for heavy-tailed distributions
- Requires independence assumption (unless modified)

Tags:
[[Resampling Methods]]
[[Cross-Validation]]
