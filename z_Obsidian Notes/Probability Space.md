A **probability space** is a mathematical framework used in probability theory to describe **random experiments**. It consists of three components:

1. **Sample Space** $S$ (or $\Omega$) – The set of all possible outcomes.
2. **Event Space** $\mathcal{F}$ – A collection of subsets of $S$ that are considered as events.
3. **Probability Measure** $P$ – A function that assigns a probability to each event in $\mathcal{F}$.

A probability space is formally written as:

$$(S, \mathcal{F}, P)$$
where:

- $S$ is the **[[sample space]]** (all possible outcomes).
- $\mathcal{F}$ is the **sigma-algebra** (set of measurable events).
- $P: \mathcal{F} \to [0,1]$ is the **probability function**, satisfying:
    - $P(S) = 1$ (total probability is 1).
    - $P(A) \geq 0$ for all events $A$.
    - If events $A$ and $B$ are **disjoint** ($A \cap B = \emptyset$), then: $$P(A \cup B) = P(A) + P(B)$$