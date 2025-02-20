**Linear Discriminant Analysis (LDA)** is a [[Parametric Models|parametric]] method for [[Classification]] that models the distribution of predictors separately in each response class and uses [[Bayes Theorem]] for classification.

### Mathematical Framework

For class k, assume:
$X|Y=k \sim N(\mu_k, \Sigma)$ 

Prior probability:
$\pi_k = P(Y=k)$

Posterior probability using Bayes' Theorem:
$P(Y=k|X=x) = \frac{f_k(x)\pi_k}{\sum_{l=1}^K f_l(x)\pi_l}$

where $f_k(x)$ is the multivariate normal density:
$f_k(x) = \frac{1}{(2\pi)^{p/2}|\Sigma|^{1/2}}e^{-\frac{1}{2}(x-\mu_k)^T\Sigma^{-1}(x-\mu_k)}$

### Discriminant Functions

Linear discriminant function for class k:
$\delta_k(x) = x^T\Sigma^{-1}\mu_k - \frac{1}{2}\mu_k^T\Sigma^{-1}\mu_k + \log(\pi_k)$

Decision rule:
Assign x to class k if $\delta_k(x) > \delta_l(x)$ for all $l \neq k$

### Parameter Estimation

1. **Class Means**
   $\hat{\mu}_k = \frac{1}{n_k}\sum_{i:y_i=k} x_i$

2. **Shared Covariance Matrix**
   $\hat{\Sigma} = \frac{1}{n-K}\sum_{k=1}^K\sum_{i:y_i=k} (x_i-\hat{\mu}_k)(x_i-\hat{\mu}_k)^T$

3. **Prior Probabilities**
   $\hat{\pi}_k = \frac{n_k}{n}$

### Decision Boundaries

- Linear boundaries between classes
- Equation: $\{x: \delta_k(x) = \delta_l(x)\}$
- Perpendicular to direction $\Sigma^{-1}(\mu_k - \mu_l)$

### Advantages
- More stable than [[Logistic Regression]] when classes are well-separated
- Works well with small sample sizes
- Provides explicit probability estimates
- Can handle multiple classes naturally

### Limitations
- Assumes normal distribution of predictors
- Assumes homoscedasticity (shared covariance)
- Sensitive to outliers
- Requires continuous predictors

### Relationship to Other Methods

1. **vs [[Logistic Regression]]**
   - LDA: Generative model (models class distributions)
   - Logistic: Discriminative model (models decision boundary)

2. **vs [[Quadratic Discriminant Analysis]]**
   - LDA: Shared covariance matrix
   - QDA: Class-specific covariance matrices

### Applications
- Face recognition
- Marketing customer segmentation
- Medical diagnosis
- Text classification
- Dimensionality reduction

### Diagnostics
- QQ plots for normality
- Box's M test for homogeneity of covariance
- Cross-validation error rates
- Confusion matrices

Tags:
[[Statistical Learning]]
[[Classification]]
[[Parametric Models]]
[[Multivariate Normal Distribution]]
[[Bayes Theorem]]
