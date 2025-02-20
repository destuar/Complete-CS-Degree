A **regression model** seeks to describe how a response (dependent) variable changes based on one or more explanatory (independent) variables.

	Prediction: Estimate the value of the dependent variable given new or 
	unseen values of the independent variables.

	Inference: Understand how changes in the independent variables influence 
	the dependent variable (e.g., which variables are most significant or how 
	strong their impact is).

In many regression problems, the *prediction* $\hat{y}$ is modeled as an **[[affine function]]** of the feature vector $\mathbf{x}$. Mathematically,

$$
\hat{y} = \mathbf{x}^T \boldsymbol{\beta} + v,
$$

where:

- $\mathbf{x}$ is the **feature vector** (its individual elements $x_i$ are often called *regressors*).
- $\boldsymbol{\beta}$ is an $n$-dimensional **weight vector** (or coefficient vector).
- $v$ (sometimes called intercept, offset, or bias) is a **[[scalar]]**.
- $\hat{y}$ is the **predicted** (or **fitted**) value of the true outcome $y$ (the **dependent variable**).

This function is called an *affine* function because it is a linear function of $\mathbf{x}$ plus a constant term $v$. If $v = 0$, the model would be purely linear (passing through the origin).

![[Regression Model Image.png]]

### Mathematical Framework
For response Y and predictors X:
$Y = f(X) + \epsilon$

where:
- $f(X)$ is the systematic component (signal)
- $\epsilon$ is the random error component (noise)
- $\epsilon \sim N(0, \sigma^2)$ typically assumed

### Types of Regression Models

1. **Linear Models**
   - [[Simple Linear Regression]]: $Y = \beta_0 + \beta_1X + \epsilon$
   - [[Multiple Linear Regression]]: $Y = \beta_0 + \beta_1X_1 + \beta_2X_2 + ... + \beta_pX_p + \epsilon$
   - [[Ridge Regression]]: Adds L2 penalty $\lambda\sum_{j=1}^p \beta_j^2$
   - [[Lasso Regression]]: Adds L1 penalty $\lambda\sum_{j=1}^p |\beta_j|$

2. **Non-Linear Models**
   - [[Polynomial Regression]]
   - [[Regression Splines]]
   - [[Smoothing Splines]]
   - [[Local Regression]]
   - [[Generalized Additive Models]]

3. **Tree-Based Methods**
   - [[Regression Trees]]
   - [[Random Forests]]
   - [[Boosting]]
   - [[Bayesian Additive Regression Trees]]

### Model Evaluation
1. **Error Metrics**
   - Mean Squared Error (MSE): $\frac{1}{n}\sum_{i=1}^n(y_i - \hat{y}_i)^2$
   - Root MSE: $\sqrt{\text{MSE}}$
   - R-squared: $1 - \frac{\sum(y_i - \hat{y}_i)^2}{\sum(y_i - \bar{y})^2}$

2. **Validation Methods**
   - [[Cross-Validation]]
   - [[Bootstrap]]
   - Train-Test Split

