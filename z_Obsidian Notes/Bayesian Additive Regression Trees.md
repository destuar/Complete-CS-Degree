**Bayesian Additive Regression Trees (BART)** is a Bayesian ensemble method that combines multiple regression trees with regularization priors to create a flexible [[Non-Parametric Models|non-parametric]] model for regression and [[Classification]].

### Mathematical Framework

For response Y and predictors X:
$Y = \sum_{j=1}^m g(X; T_j, M_j) + \epsilon$

where:
- g(X; T, M) is a regression tree
- T represents tree structure
- M represents terminal node parameters
- $\epsilon \sim N(0, \sigma^2)$

### Prior Specification

1. **Tree Structure**
   - Prior on depth
   - Prior on splitting rules
   - Regularizes complexity

2. **Terminal Node Parameters**
   - $\mu_{ij} \sim N(0, \sigma_\mu^2/m)$ (Normal [[Probability Distribution Function]])
   - Shrinkage through σ_μ
   - Shared across trees

3. **Error Variance**
   - $\sigma^2 \sim \text{InvGamma}(\nu/2, \nu\lambda/2)$
   - Data-driven choice of ν, λ
   - Robust to misspecification

### Inference

1. **MCMC Algorithm**
   - Gibbs sampling steps
   - Metropolis-Hastings updates
   - Particle filtering options

2. **Posterior Quantities**
   - Point predictions ([[Expected Value]])
   - Credible intervals
   - Variable importance

### Properties

1. **Model Characteristics**
   - Non-parametric flexibility
   - Automatic variable selection
   - Uncertainty quantification
   - Handles non-linearity

2. **Computational Aspects**
   - Parallel implementation
   - Memory efficient
   - Scales with data size

### Advantages
- Full posterior distribution
- Handles mixed variable types
- No manual tuning required
- Natural uncertainty estimates
- Robust to overfitting

### Limitations
- Computationally intensive
- Memory requirements
- Limited to moderate dimensions
- MCMC convergence issues
- Complex implementation

### Applications
- Response surface modeling
- Causal inference
- Treatment effects
- Risk assessment
- Prediction with uncertainty

### Diagnostics
- MCMC convergence
- Residual analysis
- Posterior predictive checks
- Variable importance plots
- Partial dependence plots

Tags:
[[Non-Parametric Models]]
[[Classification]]
