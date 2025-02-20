**Bayes Theorem** is a fundamental rule in probability theory that describes how to update the probability of a hypothesis given new evidence. It forms the basis for many Statistical Learning methods.

### Mathematical Framework

For events A and B:
$P(A|B) = \frac{P(B|A)P(A)}{P(B)}$

where:
- P(A|B) is posterior probability
- P(B|A) is likelihood
- P(A) is prior probability
- P(B) is evidence

### Components

1. **Prior Probability**
   - Initial belief P(A)
   - Based on previous knowledge
   - Can be subjective or objective

2. **Likelihood**
   - P(B|A): probability of data given hypothesis
   - Measures fit of data to hypothesis
   - Model-dependent term

3. **Evidence**
   - P(B) = ∑P(B|Ai)P(Ai)
   - Normalizing constant
   - Marginal likelihood

### Applications

1. **Classification**
   - [[Naive Bayes]]
   - [[Linear Discriminant Analysis]]
   - Probabilistic classifiers

2. **Parameter Estimation**
   - Bayesian inference
   - Posterior distributions
   - Credible intervals

3. **Model Selection**
   - Bayesian model averaging
   - Model evidence comparison
   - Prior model probabilities

### Properties

1. **Chain Rule Extension**
   $P(A_n|B) = \frac{P(B|A_n)P(A_n)}{\sum_{i=1}^k P(B|A_i)P(A_i)}$

2. **Independence**
   If A ⊥ B, then:
   $P(A|B) = P(A)$

### Advantages
- Incorporates prior knowledge
- Handles uncertainty naturally
- Provides full probability distributions
- Updates beliefs systematically
- Works with incomplete data

### Limitations
- Prior selection can be subjective
- Computational complexity
- May require large samples
- Interpretation challenges
- Sensitivity to assumptions
