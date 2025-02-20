The Exponential Distribution is a continuous probability distribution that describes the time between events in a [[Poisson Distribution]] process. It's characterized by a constant hazard rate and is a member of the [[Exponential Family]].

### Mathematical Definition

The probability density function (PDF) is:

$$f(x|\lambda) = \lambda e^{-\lambda x}$$

where:
- $x \geq 0$ is the random variable
- $\lambda > 0$ is the rate parameter
- Alternative parameterization: $\beta = \frac{1}{\lambda}$ (scale parameter)

### Properties

1. **Moments**
   - Mean: $\mathbb{E}[X] = \frac{1}{\lambda}$
   - Variance: $\text{Var}(X) = \frac{1}{\lambda^2}$
   - Median: $\frac{\ln(2)}{\lambda}$
   - Mode: 0

2. **Key Properties**
   - Memoryless: $P(X > s + t|X > s) = P(X > t)$
   - Constant hazard rate: $h(t) = \lambda$
   - Minimum of independent exponentials is exponential
   - Special case of [[Gamma Distribution]] with $\alpha = 1$

3. **Cumulative Distribution Function**
   $$F(x|\lambda) = 1 - e^{-\lambda x}$$

### Parameter Estimation

1. **Maximum Likelihood**
   - $\hat{\lambda} = \frac{1}{\bar{x}}$
   - MLE is unbiased and efficient

2. **Method of Moments**
   - Same as MLE for exponential
   - $\hat{\lambda} = \frac{1}{\bar{x}}$

