The Bayesian Information Criterion (BIC) is a criterion for model selection that penalizes model complexity more strongly than [[Akaike Information Criterion (AIC)]]. It's derived from Bayesian probability theory and approximates the Bayes factor.

### Mathematical Definition

For a model with k parameters and n observations:

$$BIC = \ln(n)k - 2\ln(\hat{L})$$

where:
- $k$ is the number of parameters
- $n$ is sample size
- $\hat{L}$ is maximum likelihood

For linear regression with normally distributed errors:

$$BIC = n\ln(RSS/n) + k\ln(n)$$

where:
- $RSS$ is residual sum of squares

### Properties

1. **Interpretation**
   - Lower BIC values indicate better models
   - Stronger penalty for complexity than AIC
   - Consistent (selects true model as n→∞)
   - Favors simpler models than AIC

2. **Comparison with AIC**
   - BIC penalty: $\ln(n)k$
   - AIC penalty: $2k$
   - BIC > AIC for n > 7
   - More conservative in model selection

3. **Limitations**
   - Assumes true model is in candidate set
   - Requires large sample sizes
   - May underfit with small samples
   - Sensitive to model parameterization

### Implementation

1. **Steps**
   - Fit candidate models
   - Calculate BIC for each
   - Compare BIC values
   - Select lowest BIC model

2. **Best Practices**
   - Consider multiple criteria
   - Use with [[Cross-Validation]]
   - Check model assumptions
   - Consider practical significance

Tags:
[[Model Selection]]
