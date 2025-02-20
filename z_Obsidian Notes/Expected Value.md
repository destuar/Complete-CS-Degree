**Expected Value** (or expectation, mean) is a fundamental concept in probability theory that describes the long-run average value of a random variable or function under repeated sampling.

### Mathematical Definition

1. **Discrete Case**
For a discrete random variable X:
$\mathbb{E}[X] = \sum_{x} x \cdot P(X = x)$

2. **Continuous Case**
For a continuous random variable X with probability density function f(x):
$\mathbb{E}[X] = \int_{-\infty}^{\infty} x f(x) dx$

### Properties

1. **Linearity**
   - $\mathbb{E}[aX + b] = a\mathbb{E}[X] + b$
   - $\mathbb{E}[X + Y] = \mathbb{E}[X] + \mathbb{E}[Y]$

2. **Independence**
   If X and Y are independent:
   - $\mathbb{E}[XY] = \mathbb{E}[X]\mathbb{E}[Y]$

3. **Conditional Expectation**
   - $\mathbb{E}[X] = \mathbb{E}[\mathbb{E}[X|Y]]$ (Law of Total Expectation)
   - $\mathbb{E}[X|Y]$ is itself a random variable

### Applications in Statistical Learning

1. **Model Evaluation**
   - Mean Squared Error: $\mathbb{E}[(Y - \hat{f}(X))^2]$
   - [[Bias-Variance Trade-Off]]: $\mathbb{E}[(Y - \hat{f}(x_0))^2]$

2. **Parameter Estimation**
   - Maximum Likelihood: $\mathbb{E}[\log L(\theta; X)]$
   - Method of Moments: $\mathbb{E}[X^k]$ (kth moment)

3. **Risk Assessment**
   - Expected Loss: $\mathbb{E}[L(Y, \hat{Y})]$
   - Expected Prediction Error

### Common Expected Values

1. **Common Distributions**
   - [[Normal Distribution]]: $\mathbb{E}[X] = \mu$
   - [[Poisson Distribution]]: $\mathbb{E}[X] = \lambda$
   - [[Exponential Distribution]]: $\mathbb{E}[X] = \frac{1}{\lambda}$
   - [[Bernoulli Distribution]]: $\mathbb{E}[X] = p$

2. **Sample Statistics**
   - Sample Mean: $\mathbb{E}[\bar{X}] = \mu$
   - Sample Variance: $\mathbb{E}[S^2] = \sigma^2$

### Relationship to Other Concepts
- [[Variance]]: $\text{Var}(X) = \mathbb{E}[(X - \mathbb{E}[X])^2]$
- [[Covariance]]: $\text{Cov}(X,Y) = \mathbb{E}[(X - \mathbb{E}[X])(Y - \mathbb{E}[Y])]$
- [[Probability Distribution Function]]
- Moment Generating Function