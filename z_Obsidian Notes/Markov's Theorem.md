**Markov’s Inequality** provides an upper bound on the probability that a **non-negative** random variable deviates significantly from its expected value.

#### **Statement of Markov’s Inequality**

Let $R$ be a **non-negative** random variable (i.e., $R \geq 0$ always). Then for any $a > 0$:
$$P(R \geq a) \leq \frac{E[R]}{a}$$​
where:

- $P(R \geq a)$ is the probability that $R$ is at least $a$.
- $E[R]$ is the expected value (mean) of $R$.
- $a$ is any positive threshold.

Markov’s inequality states that if the **[[expected value]]** of $R$ is small, then the probability that $R$ takes on large values must also be small.

It provides a loose but general bound that does not require knowledge of the full probability distribution of $R$, just its expected value.