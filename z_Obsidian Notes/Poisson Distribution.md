The Poisson Distribution is a discrete probability distribution that models the number of events occurring in a fixed interval of time or space, given a constant mean rate of occurrence. It's a member of the [[Exponential Family]].

### Mathematical Definition

The probability mass function (PMF) is:

$$P(X = k) = \frac{\lambda^k e^{-\lambda}}{k!}$$

where:
- $k$ is the number of occurrences $(k = 0, 1, 2, ...)$
- $\lambda$ is the mean rate parameter
- $e$ is Euler's number

### Properties

1. **Moments**
   - Mean: $\mathbb{E}[X] = \lambda$
   - Variance: $\text{Var}(X) = \lambda$
   - Skewness: $\frac{1}{\sqrt{\lambda}}$
   - Kurtosis: $1 + \frac{1}{\lambda}$

2. **Key Properties**
   - Equidispersion: mean equals variance
   - Sum of independent Poissons is Poisson
   - Limit of [[Binomial Distribution]] as n→∞, p→0
   - Memoryless property for inter-arrival times

### Parameter Estimation

1. **Maximum Likelihood**
   - $\hat{\lambda} = \bar{x}$ (sample mean)
   - MLE is unbiased and efficient

2. **Hypothesis Testing**
   - Score test
   - Likelihood ratio test
   - Pearson chi-square test
