**Probability Theory** is the mathematical framework for analyzing random phenomena, quantifying uncertainty, and making statistical inferences. It forms the foundation for statistical analysis and machine learning.

### Fundamental Concepts
1. **Sample Space and Events**
   - Sample space (Ω): Set of all possible outcomes
   - Events: Subsets of sample space
   - Event operations: union, intersection, complement

2. **Probability Axioms**
   - Non-negativity: $P(A) \geq 0$
   - Normalization: $P(\Omega) = 1$
   - Additivity: $P(A \cup B) = P(A) + P(B)$ for disjoint events

### Key Concepts
1. **Conditional Probability**
   - Definition: $P(A|B) = \frac{P(A \cap B)}{P(B)}$
   - [[Bayes Theorem]]: $P(A|B) = \frac{P(B|A)P(A)}{P(B)}$
   - Chain rule: $P(A_1 \cap ... \cap A_n) = P(A_1)P(A_2|A_1)...P(A_n|A_1,...,A_{n-1})$

2. **Independence**
   - [[Mutual Independence]]
   - [[Pairwise Independence]]
   - Conditional independence

### Random Variables
1. **Types**
   - Discrete
   - Continuous
   - Mixed

2. **Properties**
   - [[Expected Value]]
   - [[Variance]]
   - Moments
   - [[Probability Distribution Function]]

### Important Theorems
1. **Limit Theorems**
   - Law of Large Numbers
   - Central Limit Theorem
   - [[Chebyshev's Theorem]]
   - [[Markov's Theorem]]

2. **Inequalities**
   - [[Chebyshev's Inequality]]
   - [[Chernoff Bound]]
   - Jensen's inequality
   - Hoeffding's inequality

### Applications
1. **Statistical Inference**
   - Parameter estimation
   - Hypothesis testing
   - Confidence intervals
   - [[Multiple Testing]]

2. **Machine Learning**
   - [[Supervised Learning]]
   - [[Unsupervised Learning]]
   - Probabilistic models
   - Bayesian inference

### Advanced Topics
1. **Stochastic Processes**
   - Markov chains
   - Poisson processes
   - Brownian motion
   - Martingales

2. **Measure Theory**
   - σ-algebras
   - Measure spaces
   - Lebesgue integration
   - Probability measures

Tags:
[[Random Variable]]
[[Probability Distribution Function]]
