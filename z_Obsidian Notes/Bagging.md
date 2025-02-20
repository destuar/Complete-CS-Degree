**Bagging (Bootstrap Aggregating)** is an ensemble learning method that combines multiple models trained on [[Bootstrap]] samples to reduce variance and prevent overfitting. It's a key component of [[Random Forests]] and other [[ensemble methods]].

### Mathematical Framework
For training set D = {(xi, yi)}:
1. Create B bootstrap samples D1, ..., DB
2. Train model fb on each sample
3. Aggregate predictions:
   - Regression: $\hat{f}_{bag}(x) = \frac{1}{B}\sum_{b=1}^B \hat{f}_b(x)$
   - Classification: $\hat{C}_{bag}(x) = \text{mode}\{\hat{C}_b(x)\}_{b=1}^B$

### Properties
1. **Variance Reduction**
   - Independent bootstrapped models
   - Averaging reduces variance
   - Maintains bias level

2. **Out-of-Bag Error**
   - ~37% of data not in bootstrap
   - Natural validation set
   - Unbiased error estimate

### Implementation
1. **Bootstrap Sampling**
   - Sample with replacement
   - Same size as original
   - Independent samples

2. **Base Learners**
   - Usually same model type
   - Independent training
   - Parallel computation possible

### Advantages
- Reduces overfitting
- Parallel implementation
- Built-in error estimation
- Maintains model interpretability
- Robust to outliers

### Limitations
- No bias reduction
- Computationally intensive
- Memory requirements
- Limited by base learner
- May lose interpretability

### Variants
1. **Random Subspace Method**
   - Sample features instead of observations
   - Useful for high dimensions
   - Reduces correlation

2. **Random Patches**
   - Sample both rows and columns
   - More diversity
   - Better for large datasets

### Tuning Parameters
1. **Number of Models (B)**
   - Usually 50-500
   - Until error stabilizes
   - Computational budget

2. **Sample Size**
   - Usually n (original size)
   - Can be smaller
   - Affects diversity

### Diagnostics
- OOB error curves
- Model diversity measures
- Individual model performance
- Aggregation effectiveness
- Computational efficiency
