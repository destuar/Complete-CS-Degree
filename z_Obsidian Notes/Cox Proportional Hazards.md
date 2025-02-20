**Cox Proportional Hazards** model is a semi-parametric method for analyzing survival data that allows estimation of treatment effects while accounting for covariates, without specifying a baseline hazard function.

### Mathematical Framework
The hazard function is modeled as:

$h(t|X) = h_0(t)\exp(\beta_1X_1 + ... + \beta_pX_p)$

where:
- $h_0(t)$ is baseline hazard
- $X_i$ are covariates
- $\beta_i$ are coefficients
- Proportional hazards assumption

### Properties
1. **Semi-parametric**
   - Unspecified baseline hazard
   - Parametric covariate effects
   - Flexible time dependence
   - Efficient estimation

2. **Hazard Ratio**
   - Time-independent
   - Multiplicative effects
   - Interpretable results
   - Confidence intervals

### Estimation
1. **Partial Likelihood**
   $L(\beta) = \prod_{i:C_i=1} \frac{\exp(X_i^T\beta)}{\sum_{j \in R(t_i)} \exp(X_j^T\beta)}$

2. **Numerical Methods**
   - Newton-Raphson
   - Profile likelihood
   - Tied data handling
   - Robust variance

### Model Diagnostics
1. **Assumptions**
   - Proportional hazards
   - Linearity
   - Independence
   - Residual analysis

2. **Testing**
   - Schoenfeld residuals
   - Martingale residuals
   - Score tests
   - Global tests
