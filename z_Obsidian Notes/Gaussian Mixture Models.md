Gaussian Mixture Models (GMMs) are probabilistic models that represent data as a mixture of multiple [[Normal Distribution|Gaussian distributions]]. They are powerful tools for density estimation and clustering.

### Mathematical Definition

The probability density function of a GMM with K components:

$$p(x) = \sum_{k=1}^K \pi_k \mathcal{N}(x|\mu_k,\Sigma_k)$$

where:
- $\pi_k$ are mixing coefficients ($\sum_{k=1}^K \pi_k = 1$)
- $\mu_k$ are mean vectors
- $\Sigma_k$ are covariance matrices
- $\mathcal{N}(x|\mu_k,\Sigma_k)$ is the Gaussian PDF

### Parameter Estimation

1. **Expectation-Maximization (EM) Algorithm**
   - E-step: Compute responsibilities
   - M-step: Update parameters
   - Iterate until convergence
   - Guaranteed to increase likelihood

2. **Update Equations**
   - Responsibilities: $\gamma_{nk} = \frac{\pi_k\mathcal{N}(x_n|\mu_k,\Sigma_k)}{\sum_j \pi_j\mathcal{N}(x_n|\mu_j,\Sigma_j)}$
   - Means: $\mu_k = \frac{\sum_n \gamma_{nk}x_n}{\sum_n \gamma_{nk}}$
   - Covariances: $\Sigma_k = \frac{\sum_n \gamma_{nk}(x_n-\mu_k)(x_n-\mu_k)^T}{\sum_n \gamma_{nk}}$
   - Mixing coefficients: $\pi_k = \frac{\sum_n \gamma_{nk}}{N}$

### Model Selection

1. **Number of Components**
   - [[Akaike Information Criterion (AIC)]]
   - [[Bayesian Information Criterion (BIC)]]
   - Cross-validation
   - Elbow method

2. **Covariance Structure**
   - Full covariance
   - Diagonal covariance
   - Spherical covariance
   - Tied covariance
