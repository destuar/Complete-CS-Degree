The Akaike Information Criterion (AIC) is a mathematical method for evaluating how well a model fits the data while penalizing complexity. It helps in model selection by balancing goodness of fit against model simplicity.

### Mathematical Definition
For a statistical model with k parameters:

$$AIC = 2k - 2\ln(\hat{L})$$

where:
- $k$ is the number of parameters in the model
- $\hat{L}$ is the maximum value of the likelihood function

For linear regression with normally distributed errors:

$$AIC = n\ln(RSS/n) + 2k$$

where:
- $n$ is sample size
- $RSS$ is residual sum of squares

### Properties
1. **Interpretation**
   - Lower AIC values indicate better models
   - Relative measure (only meaningful when comparing models)
   - Penalizes overfitting through complexity term

2. **Corrected AIC (AICc)**
   - For small sample sizes: $AICc = AIC + \frac{2k(k+1)}{n-k-1}$
   - Recommended when $n/k < 40$

3. **Limitations**
   - Assumes large sample size
   - May not work well with small samples
   - Only valid for comparing models with same response variable

### Comparison with Other Criteria
- [[Bayesian Information Criterion (BIC)]]
- [[Cross-Validation]]
- Mallows' Cp
