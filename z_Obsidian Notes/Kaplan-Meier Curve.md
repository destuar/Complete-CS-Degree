**Kaplan-Meier Curve** (KM curve) is a non-parametric estimator of the [[Survival Function]] that handles [[Censored Data]] in survival analysis. It provides a visual and quantitative way to estimate survival probabilities over time.

### Mathematical Framework
The KM estimator at time t is:

$\hat{S}(t) = \prod_{t_i \leq t} (1 - \frac{d_i}{n_i})$

where:
- $t_i$ are ordered event times
- $d_i$ is number of events at time $t_i$
- $n_i$ is number at risk at time $t_i$
- Product is over all event times ≤ t

### Properties
1. **Statistical Properties**
   - Step function
   - Right-continuous
   - Maximum likelihood estimator
   - Consistent estimator

2. **Variance Estimation**
   - Greenwood's formula:
   $\text{Var}(\hat{S}(t)) = \hat{S}(t)^2 \sum_{t_i \leq t} \frac{d_i}{n_i(n_i-d_i)}$
   - Confidence intervals
   - Standard errors

### Applications
1. **Medical Research**
   - Patient survival analysis
   - Treatment comparison
   - Clinical trials
   - Disease progression

2. **Other Fields**
   - Equipment reliability
   - Customer churn
   - Time to event analysis
   - Failure time studies

### Extensions
1. **Comparisons**
   - Log-rank test
   - Wilcoxon test
   - Fleming-Harrington test
   - Stratified analysis

2. **Advanced Methods**
   - Weighted KM estimates
   - Competing risks
   - Time-dependent covariates
   - Multiple events

### Relationship to Other Methods
- Foundation for [[Cox Proportional Hazards]]
- Alternative to [[Survival Function]]
- Handles [[Censored Data]]
- Input for [[Survival Analysis]]

### Implementation
1. **Data Requirements**
   - Event times
   - Censoring indicators
   - Group variables
   - Follow-up times

2. **Visualization**
   - Survival curves
   - Confidence bands
   - Risk tables
   - Censoring marks

### Advantages and Limitations
**Advantages:**
- Non-parametric method
- Handles right censoring
- Easy interpretation
- Visual presentation

**Limitations:**
- Step function output
- Requires large samples
- Limited by censoring
- No covariate adjustment

Tags:
[[Survival Analysis]]
[[Statistical Learning]]
[[Non-Parametric Models]]
[[Censored Data]]
