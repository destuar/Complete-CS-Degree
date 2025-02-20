**Parametric Models** assume a specific functional form for the relationship between predictors and response, reducing the problem to estimating a finite set of parameters.

### Mathematical Framework
For a parametric model with parameters θ:
$f(X) = g(X; \theta)$ where $\theta \in \mathbb{R}^p$

### Key Characteristics
- Fixed number of parameters
- Strong assumptions about data distribution
- More interpretable
- Less flexible than [[Non-Parametric Models]]
- Efficient with limited data

### Common Examples
1. **Linear Models**
   - [[Simple Linear Regression]]: $Y = \beta_0 + \beta_1X + \epsilon$
   - [[Multiple Linear Regression]]: $Y = \beta_0 + \sum_{j=1}^p \beta_jX_j + \epsilon$
   - [[Logistic Regression]]: $\log\left(\frac{p(X)}{1-p(X)}\right) = \beta_0 + \beta_1X$

2. **Distribution-Based Models**
   - [[Linear Discriminant Analysis]]: $f_k(x) = \frac{1}{(2\pi)^{p/2}|\Sigma|^{1/2}}e^{-\frac{1}{2}(x-\mu_k)^T\Sigma^{-1}(x-\mu_k)}$
   - [[Gaussian Mixture Models]]

### Estimation Methods
1. **Maximum Likelihood**
   - $\hat{\theta}_{\text{MLE}} = \arg\max_{\theta} \sum_{i=1}^n \log f(x_i|\theta)$

2. **Method of Moments**
   - Match sample moments with theoretical moments

3. **Bayesian Approaches**
   - $p(\theta|X) \propto p(X|\theta)p(\theta)$

### Advantages
- Computationally efficient
- Less prone to overfitting
- Clear interpretation of parameters
- Require less data for stable estimates

### Limitations
- Model misspecification risk
- May not capture complex patterns
- Assumptions may be unrealistic
- Limited flexibility
