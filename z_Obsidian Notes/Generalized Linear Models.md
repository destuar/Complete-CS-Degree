Generalized Linear Models (GLMs) extend linear regression by allowing for response variables that have non-normal error distribution models. They provide a unified framework for various types of regression analysis.

### Components
1. **Random Component**
   - Response variable Y follows an [[Exponential Family]] distribution
   - Common distributions:
     - [[Normal Distribution]] (Linear regression)
     - [[Binomial Distribution]] (Logistic regression)
     - [[Poisson Distribution]] (Count data)
     - [[Gamma Distribution]] (Positive continuous data)

2. **Systematic Component**
   - Linear predictor: $\eta = X\beta$
   - X: matrix of predictors
   - β: vector of parameters

3. **Link Function**
   - $g(\mu) = \eta$
   - Connects mean response to linear predictor
   - Common links:
     - Identity: $g(\mu) = \mu$
     - Logit: $g(\mu) = \log(\frac{\mu}{1-\mu})$
     - Log: $g(\mu) = \log(\mu)$

### Common GLM Types
1. **[[Simple Linear Regression|Linear Regression]]**
   - Normal distribution
   - Identity link
   - Continuous response

2. **[[Logistic Regression]]**
   - Binomial distribution
   - Logit link
   - Binary response

3. **[[Poisson Regression]]**
   - Poisson distribution
   - Log link
   - Count data

4. **[[Gamma Regression]]**
   - Gamma distribution
   - Log/inverse link
   - Positive continuous data

### Model Fitting
1. **Maximum Likelihood Estimation**
   - Iteratively Reweighted Least Squares (IRLS)
   - Newton-Raphson method
   - Fisher scoring

2. **Model Selection**
   - [[Akaike Information Criterion (AIC)]]
   - [[Bayesian Information Criterion (BIC)]]
   - Deviance analysis

### Diagnostics
1. **Residual Analysis**
   - Deviance residuals
   - Pearson residuals
   - Standardized residuals

2. **Influence Measures**
   - Cook's distance
   - Leverage values
   - DFBETAS