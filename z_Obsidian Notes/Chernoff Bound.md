The Chernoff bound is a probabilistic bound that provides exponentially decreasing bounds on the tail probabilities of a sum of independent random variables. Used for concentration inequalities— helping to bound the probability that a random variable deviates significantly from its expectation.

#### **General Form of Chernoff Bound**

For a sum of **independent** random variables $X_1, X_2, ..., X_n$​, let:
$$S = \sum_{i=1}^{n} X_i$$
If $X_i$ are **independent** Bernoulli random variables with mean $\mathbb{E}[X_i] = p$, then the expected value of $S$ is:
$$\mathbb{E}[S] = \mu = np$$

Then, Chernoff bounds state that for any $\delta > 0$:

#### **Upper Tail Bound (Deviation Above the Mean)**
$$P(S \geq (1+\delta) \mu) \leq \exp\left(-\frac{\delta^2 \mu}{3}\right) \quad \text{for } 0 < \delta \leq 1$$$$P(S \geq (1+\delta) \mu) \leq \exp\left(-\frac{\delta \mu}{3}\right) \quad \text{for } \delta > 1$$
#### **Lower Tail Bound (Deviation Below the Mean)**

$$P(S \leq (1-\delta) \mu) \leq \exp\left(-\frac{\delta^2 \mu}{2}\right) \quad \text{for } 0 < \delta < 1$$

Chernoff bounds show that the probability of deviating from the mean decreases exponentially as the deviation increases.

Tags:
[[Standard Deviation]]
[[Variance]]
[[Random Variable]]