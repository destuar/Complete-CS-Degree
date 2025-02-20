**Simple Linear Regression** is the most basic form of [[Regression Model]] that models the relationship between a single predictor variable and a continuous response variable using a linear function.

### Mathematical Framework

$Y = \beta_0 + \beta_1X + \epsilon$

where:
- $Y$ is the response variable
- $X$ is the predictor variable
- $\beta_0$ is the intercept (value of Y when X = 0)
- $\beta_1$ is the slope (change in Y for unit change in X)
- $\epsilon$ is the random error term, $\epsilon \sim N(0, \sigma^2)$

### Parameter Estimation

**Least Squares Method**:
Minimizes the Residual Sum of Squares (RSS):
$\text{RSS} = \sum_{i=1}^n (y_i - \beta_0 - \beta_1x_i)^2$

Solutions:
$\hat{\beta}_1 = \frac{\sum_{i=1}^n (x_i - \bar{x})(y_i - \bar{y})}{\sum_{i=1}^n (x_i - \bar{x})^2}$

$\hat{\beta}_0 = \bar{y} - \hat{\beta}_1\bar{x}$

### Model Assessment

1. **Fit Statistics**
   - $R^2 = 1 - \frac{\sum(y_i - \hat{y}_i)^2}{\sum(y_i - \bar{y})^2}$
   - RSE (Residual Standard Error): $\sqrt{\frac{\sum(y_i - \hat{y}_i)^2}{n-2}}$

2. **Inference**
   - Standard Errors: $SE(\hat{\beta}_1)$, $SE(\hat{\beta}_0)$
   - t-statistics: $t = \frac{\hat{\beta}_j}{SE(\hat{\beta}_j)}$
   - Confidence Intervals: $\hat{\beta}_j \pm t_{\alpha/2,n-2} \cdot SE(\hat{\beta}_j)$

### Key Assumptions

1. **Linearity**
   - Relationship between X and Y is linear
   - Check: Residual plots

2. **Independence**
   - Observations are independent
   - Check: Time series plots, Durbin-Watson test

3. **Homoscedasticity**
   - Constant variance of errors
   - Check: Scale-location plots

4. **Normality**
   - Residuals follow normal distribution
   - Check: Q-Q plots, Shapiro-Wilk test

### Diagnostics

1. **Residual Plots**
   - vs. Fitted values
   - vs. Predictors
   - Q-Q plots
   - Scale-location plots

2. **Influence Measures**
   - Leverage
   - Cook's distance
   - DFBETAS
   - DFFITS

### Limitations
- Assumes linear relationship
- Sensitive to outliers
- Cannot capture complex patterns
- May oversimplify real relationships

### Extensions
- [[Multiple Linear Regression]]
- [[Polynomial Regression]]
- [[Ridge Regression]]
- [[Lasso Regression]]

Tags:
[[Statistical Learning]]
[[Linear Models]]
[[Regression Model]]
[[Least Squares]]
[[Model Diagnostics]]
