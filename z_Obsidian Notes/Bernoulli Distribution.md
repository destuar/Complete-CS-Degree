The Bernoulli Distribution is the simplest discrete probability distribution, modeling a random variable that takes only two possible values (typically 0 and 1). It's a special case of the [[Binomial Distribution]] with n=1.

### Mathematical Definition

The probability mass function (PMF) is:

$$P(X = x) = p^x(1-p)^{1-x}$$

where:
- $x \in \{0,1\}$ is the random variable
- $p$ is the probability of success (x = 1)
- $1-p$ is the probability of failure (x = 0)

### Properties

1. **Moments**
   - Mean: $\mathbb{E}[X] = p$
   - Variance: $\text{Var}(X) = p(1-p)$
   - Skewness: $\frac{1-2p}{\sqrt{p(1-p)}}$
   - Kurtosis: $\frac{1-6p(1-p)}{p(1-p)}$

2. **Key Properties**
   - Member of [[Exponential Family]]
   - Maximum variance at p = 0.5
   - Symmetric when p = 0.5
   - Building block for [[Binomial Distribution]]

3. **Moment Generating Function**
   $$M_X(t) = 1-p+pe^t$$

### Parameter Estimation

1. **Maximum Likelihood**
   - $\hat{p} = \frac{\text{number of successes}}{\text{number of trials}}$
   - MLE is unbiased
   - Efficient estimator

2. **Bayesian Estimation**
   - Beta prior distribution
   - Beta posterior distribution
   - Conjugate prior family
