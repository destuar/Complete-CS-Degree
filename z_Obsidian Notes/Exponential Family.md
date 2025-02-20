**Exponential Family** is a class of probability distributions that share a common mathematical form and properties. It includes many important distributions used in statistics and forms the basis for generalized linear models.

### Mathematical Framework
The general form is:

$f(x|\theta) = h(x)\exp(\eta(\theta)T(x) - A(\theta))$

where:
- $h(x)$ is the base measure
- $\eta(\theta)$ is the natural parameter
- $T(x)$ is the sufficient statistic
- $A(\theta)$ is the log-normalizer

### Common Members
1. **Discrete Distributions**
   - [[Bernoulli Distribution|Bernoulli]]
   - [[Poisson Regression|Poisson]]
   - [[Binomial Distribution|Binomial]]
   - [[Negative Binomial Regression|Negative Binomial]]

2. **Continuous Distributions**
   - [[Normal Distribution|Normal]] (Gaussian)
   - [[Gamma Regression|Gamma]]
   - Beta
   - [[Exponential Distribution|Exponential]]
   
### Properties
1. **Statistical Properties**
   - Sufficient statistics
   - Maximum likelihood existence
   - Conjugate priors
   - Moment generating functions

2. **Mean and Variance**
   - $E[T(X)] = \nabla_\eta A(\eta)$
   - $\text{Var}(T(X)) = \nabla^2_\eta A(\eta)$
   - Natural parameterization
   - Canonical form
