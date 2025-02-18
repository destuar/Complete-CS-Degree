A Probability Distribution Function (PDF) describes how probability is distributed over the possible values of a **[[random variable]]** and provides a way to quantify uncertainty in probabilistic models.

There are two types of probability distributions:
1. **For Discrete Random Variables** → **Probability Mass Function (PMF)**
2. **For Continuous Random Variables** → **Probability Density Function (PDF)**

In both cases, a **[[cumulative distribution function]] (CDF)** gives the probability that $X$ is **less than or equal to** a certain value:

$$F(x) = P(X \leq x)$$

For a **discrete variable**, it is computed as:

$$F(x) = \sum_{k \leq x} P(X = k)$$

For a **continuous variable**, it is obtained by integrating the PDF:

$$F(x) = \int_{-\infty}^{x} f(t) dt$$