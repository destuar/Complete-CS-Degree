The Gamma Distribution is a continuous probability distribution that models positive-valued random variables. It's particularly useful for modeling waiting times, lifetimes, and other positive-valued phenomena.

### Mathematical Definition

The probability density function (PDF) is:

$$f(x|\alpha,\beta) = \frac{\beta^\alpha}{\Gamma(\alpha)}x^{\alpha-1}e^{-\beta x}$$

where:
- $x > 0$ is the random variable
- $\alpha > 0$ is the shape parameter
- $\beta > 0$ is the rate parameter
- $\Gamma(\alpha)$ is the gamma function

### Properties

1. **Moments**
   - Mean: $\mathbb{E}[X] = \frac{\alpha}{\beta}$
   - Variance: $\text{Var}(X) = \frac{\alpha}{\beta^2}$
   - Skewness: $\frac{2}{\sqrt{\alpha}}$
   - Kurtosis: $3 + \frac{6}{\alpha}$

2. **Special Cases**
   - Chi-squared: $\chi^2(k) = \text{Gamma}(\frac{k}{2}, \frac{1}{2})$
   - [[Exponential Distribution]]: $\text{Exp}(\lambda) = \text{Gamma}(1, \lambda)$
   - Erlang: Gamma with integer shape parameter

3. **Properties**
   - Member of [[Exponential Family]]
   - Closed under scaling
   - Sum of independent gammas with same β is gamma

### Parameter Estimation

1. **Maximum Likelihood**
   - No closed form solution
   - Numerical methods required
   - Newton-Raphson algorithm

2. **Method of Moments**
   - $\hat{\alpha} = \frac{\bar{x}^2}{s^2}$
   - $\hat{\beta} = \frac{\bar{x}}{s^2}$
