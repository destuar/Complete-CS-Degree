**Multiple Linear Regression** extends [[Simple Linear Regression]] to model the relationship between multiple predictor variables and a continuous response variable.

### Mathematical Framework

$Y = \beta_0 + \beta_1X_1 + \beta_2X_2 + ... + \beta_pX_p + \epsilon$

In matrix notation:
$\mathbf{Y} = \mathbf{X}\boldsymbol{\beta} + \boldsymbol{\epsilon}$

where:
- $\mathbf{Y}$ is the $n \times 1$ response vector
- $\mathbf{X}$ is the $n \times (p+1)$ design matrix
- $\boldsymbol{\beta}$ is the $(p+1) \times 1$ coefficient vector
- $\boldsymbol{\epsilon}$ is the $n \times 1$ error vector, $\boldsymbol{\epsilon} \sim N(\mathbf{0}, \sigma^2\mathbf{I})$

### Parameter Estimation

**Least Squares Solution**:
$\hat{\boldsymbol{\beta}} = (\mathbf{X}^T\mathbf{X})^{-1}\mathbf{X}^T\mathbf{Y}$

Minimizes:
$\text{RSS} = (\mathbf{Y} - \mathbf{X}\boldsymbol{\beta})^T(\mathbf{Y} - \mathbf{X}\boldsymbol{\beta})$

### Statistical Inference

1. **Coefficient Estimates**
   - Standard Errors: $SE(\hat{\beta}_j) = \sqrt{\sigma^2[(\mathbf{X}^T\mathbf{X})^{-1}]_{jj}}$
   - t-statistics: $t_j = \frac{\hat{\beta}_j}{SE(\hat{\beta}_j)}$
   - p-values: $2\cdot P(|T| > |t_j|)$

2. **Model Fit**
   - $R^2 = 1 - \frac{\text{RSS}}{\text{TSS}}$
   - Adjusted $R^2 = 1 - \frac{\text{RSS}/(n-p-1)}{\text{TSS}/(n-1)}$
   - F-statistic: $F = \frac{(\text{TSS}-\text{RSS})/p}{\text{RSS}/(n-p-1)}$

### Key Assumptions

1. **Linearity**
   - Linear relationship between each predictor and response
   - Check: Partial residual plots

2. **Independence**
   - Independent observations
   - Check: Durbin-Watson test

3. **Homoscedasticity**
   - Constant error variance
   - Check: Breusch-Pagan test

4. **Normality**
   - Normal distribution of errors
   - Check: Q-Q plots

5. **No Multicollinearity**
   - Predictors not highly correlated
   - Check: VIF (Variance Inflation Factor)

### Variable Selection

1. **Subset Selection**
   - Best subset
   - Forward stepwise
   - Backward stepwise

2. **Shrinkage Methods**
   - [[Ridge Regression]]
   - [[Lasso Regression]]

3. **Dimension Reduction**
   - [[Principal Components Regression]]
   - [[Partial Least Squares]]

### Interaction Terms
$Y = \beta_0 + \beta_1X_1 + \beta_2X_2 + \beta_3(X_1X_2) + \epsilon$

### Polynomial Terms
$Y = \beta_0 + \beta_1X + \beta_2X^2 + ... + \beta_dX^d + \epsilon$

### Diagnostics

1. **Residual Analysis**
   - Standardized residuals
   - Studentized residuals
   - PRESS residuals

2. **Influence Measures**
   - Leverage values
   - Cook's distance
   - DFFITS, DFBETAS
