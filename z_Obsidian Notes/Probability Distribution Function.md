**Probability Distribution Function** (PDF) describes the likelihood of a [[Random Variables|random variable]] taking on different values. It is fundamental to statistical modeling and inference.

### Types of Distributions

1. **Discrete Probability Mass Function (PMF)**
   - For discrete random variables
   - $P(X = x)$ gives probability of exact value
   - Properties:
     - $P(X = x) \geq 0$ for all x
     - $\sum_x P(X = x) = 1$

2. **Continuous Probability Density Function (PDF)**
   - For continuous random variables
   - $f(x)$ gives relative likelihood
   - Properties:
     - $f(x) \geq 0$ for all x
     - $\int_{-\infty}^{\infty} f(x)dx = 1$
     - $P(a \leq X \leq b) = \int_a^b f(x)dx$

### Common Distributions

1. **Continuous**
   - [[Normal Distribution]]: $f(x) = \frac{1}{\sigma\sqrt{2\pi}}e^{-\frac{(x-\mu)^2}{2\sigma^2}}$
   - [[Exponential Distribution]]: $f(x) = \lambda e^{-\lambda x}$
   - [[Gamma Distribution]]: $f(x) = \frac{\beta^\alpha}{\Gamma(\alpha)}x^{\alpha-1}e^{-\beta x}$

2. **Discrete**
   - [[Bernoulli Distribution]]: $P(X = 1) = p$, $P(X = 0) = 1-p$
   - [[Poisson Distribution]]: $P(X = k) = \frac{\lambda^k e^{-\lambda}}{k!}$
   - [[Binomial Distribution]]: $P(X = k) = \binom{n}{k}p^k(1-p)^{n-k}$

### Distribution Properties

1. **Location Parameters**
   - [[Expected Value]]: $\mathbb{E}[X]$
   - Median
   - Mode

2. **Spread Parameters**
   - [[Variance]]: $\text{Var}(X) = \mathbb{E}[(X-\mu)^2]$
   - Standard Deviation: $\sigma = \sqrt{\text{Var}(X)}$
   - Range and Interquartile Range

3. **Shape Parameters**
   - Skewness: $\mathbb{E}[(\frac{X-\mu}{\sigma})^3]$
   - Kurtosis: $\mathbb{E}[(\frac{X-\mu}{\sigma})^4]$

### Applications in Statistical Learning

1. **Model Assumptions**
   - Error distributions in [[Regression Model|regression]]
   - Class probabilities in [[Classification]]
   - Prior distributions in [[Bayesian]] methods

2. **Likelihood Functions**
   - Maximum Likelihood Estimation
   - [[Logistic Regression]]
   - [[Linear Discriminant Analysis]]

3. **Sampling Distributions**
   - [[Bootstrap]] resampling
   - [[Cross-Validation]]
   - Hypothesis testing

Tags:
[[Statistical Learning]]
[[Probability Theory]]
[[Random Variables]]
[[Statistics]]
[[Distribution]]