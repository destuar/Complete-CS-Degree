The Binomial Distribution models the number of successes in n independent [[Bernoulli Distribution|Bernoulli trials]], each with the same probability of success p. It's a fundamental discrete probability distribution in statistics.

### Mathematical Definition

The probability mass function (PMF) is:

$$P(X = k) = \binom{n}{k}p^k(1-p)^{n-k}$$

where:
- $k$ is the number of successes
- $n$ is the number of trials
- $p$ is the probability of success
- $\binom{n}{k}$ is the binomial coefficient

### Properties

1. **Moments**
   - Mean: $\mathbb{E}[X] = np$
   - Variance: $\text{Var}(X) = np(1-p)$
   - Skewness: $\frac{1-2p}{\sqrt{np(1-p)}}$
   - Kurtosis: $3 + \frac{1-6p(1-p)}{np(1-p)}$

2. **Key Properties**
   - Sum of independent Bernoullis
   - Member of [[Exponential Family]]
   - Approaches [[Normal Distribution]] as n→∞
   - Reproductive property for fixed p

3. **Moment Generating Function**
   $$M_X(t) = (1-p+pe^t)^n$$

### Parameter Estimation

1. **Maximum Likelihood**
   - $\hat{p} = \frac{\text{number of successes}}{n}$
   - MLE is unbiased
   - Efficient estimator

2. **Bayesian Estimation**
   - Beta prior for p
   - Beta posterior
   - Conjugate prior family
