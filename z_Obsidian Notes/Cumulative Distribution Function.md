A Cumulative Distribution Function (CDF) describes the **probability that a random variable $X$ takes a value less than or equal to $x$**. It provides a way to understand the cumulative probability up to a certain point.

The **CDF** of a random variable $X$ is defined as:

$$F(x) = P(X \leq x)$$

where $F(x)$ gives the probability that $X$ is at most $x$.

For a **discrete variable**, it is computed as:

$$F(x) = \sum_{k \leq x} P(X = k)$$

For a **continuous variable**, it is obtained by integrating the PDF:

$$F(x) = \int_{-\infty}^{x} f(t) dt$$