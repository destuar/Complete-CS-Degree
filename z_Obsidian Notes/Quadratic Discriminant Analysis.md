**Quadratic Discriminant Analysis (QDA)** extends [[Linear Discriminant Analysis]] by allowing each class to have its own covariance matrix, resulting in quadratic decision boundaries.

### Mathematical Framework

For class k, assume:
$X|Y=k \sim N(\mu_k, \Sigma_k)$ 

Prior probability:
$\pi_k = P(Y=k)$

Posterior probability using [[Bayes Theorem]]:
$P(Y=k|X=x) = \frac{f_k(x)\pi_k}{\sum_{l=1}^K f_l(x)\pi_l}$

where $f_k(x)$ is the class-specific multivariate normal density:
$f_k(x) = \frac{1}{(2\pi)^{p/2}|\Sigma_k|^{1/2}}e^{-\frac{1}{2}(x-\mu_k)^T\Sigma_k^{-1}(x-\mu_k)}$

### Discriminant Functions

Quadratic discriminant function for class k:
$\delta_k(x) = -\frac{1}{2}\log|\Sigma_k| - \frac{1}{2}(x-\mu_k)^T\Sigma_k^{-1}(x-\mu_k) + \log(\pi_k)$

Decision rule:
Assign x to class k if $\delta_k(x) > \delta_l(x)$ for all $l \neq k$

### Parameter Estimation

1. **Class Means**
   $\hat{\mu}_k = \frac{1}{n_k}\sum_{i:y_i=k} x_i$

2. **Class-Specific Covariance Matrices**
   $\hat{\Sigma}_k = \frac{1}{n_k-1}\sum_{i:y_i=k} (x_i-\hat{\mu}_k)(x_i-\hat{\mu}_k)^T$

3. **Prior Probabilities**
   $\hat{\pi}_k = \frac{n_k}{n}$

### Decision Boundaries

- Quadratic boundaries between classes
- Equation: $\{x: \delta_k(x) = \delta_l(x)\}$
- Can form ellipses, parabolas, or hyperbolas

### Comparison with LDA

1. **Flexibility**
   - QDA: More flexible due to class-specific covariances
   - LDA: More rigid with shared covariance

2. **Parameter Count**
   - QDA: $O(Kp^2)$ parameters
   - LDA: $O(p^2)$ parameters

3. **Sample Size Requirements**
   - QDA: Needs larger sample size
   - LDA: Works well with smaller samples

### When to Use QDA

1. **Large Sample Size**
   - Sufficient data to estimate separate covariance matrices

2. **Heteroscedasticity**
   - When classes have different variances/correlations

3. **Non-Linear Boundaries**
   - When class boundaries appear curved

### Advantages
- More flexible than LDA
- Can capture non-linear class boundaries
- Still provides explicit probability estimates
- Often outperforms LDA when assumptions hold

### Limitations
- Requires more training data than LDA
- Risk of overfitting with small samples
- Computationally more intensive
- More parameters to estimate

### Diagnostics
- QQ plots for normality within each class
- Covariance matrix condition numbers
- Cross-validation error rates
- Confusion matrices

Tags:
[[Statistical Learning]]
[[Classification]]
[[Parametric Models]]
[[Linear Discriminant Analysis]]
[[Multivariate Normal Distribution]]
[[Bayes Theorem]]
