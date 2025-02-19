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


