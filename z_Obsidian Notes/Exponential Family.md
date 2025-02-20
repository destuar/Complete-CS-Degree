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
   - Bernoulli
   - [[Poisson Regression|Poisson]]
   - Binomial
   - [[Negative Binomial Regression|Negative Binomial]]

2. **Continuous Distributions**
   - Normal (Gaussian)
   - [[Gamma Regression|Gamma]]
   - Beta
   - Exponential

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

### Applications
1. **Statistical Modeling**
   - Generalized linear models
   - [[Generalized Additive Models]]
   - Maximum entropy
   - Natural exponential families

2. **Machine Learning**
   - Classification
   - Regression
   - Neural networks
   - Probabilistic models

### Relationship to Other Concepts
1. **Model Families**
   - [[Simple Linear Regression]]
   - [[Logistic Regression]]
   - [[Poisson Regression]]
   - [[Gamma Regression]]

2. **Statistical Theory**
   - Maximum likelihood
   - Sufficient statistics
   - Information geometry
   - Statistical inference

### Extensions
1. **Advanced Topics**
   - Curved exponential families
   - Mixed models
   - Hierarchical models
   - Multiparameter families

2. **Modern Applications**
   - Deep learning
   - Variational inference
   - Graphical models
   - Natural gradients

Tags:
[[Probability Distribution Function]]
[[Parametric Models]]
