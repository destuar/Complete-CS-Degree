**Non-Parametric Models** make minimal assumptions about the underlying data distribution, allowing the model complexity to grow with the data size to capture complex patterns.

### Mathematical Framework
Instead of assuming a fixed functional form, these models estimate:
$f(x) = \mathbb{E}[Y|X=x]$ directly from the data

### Key Characteristics
- No fixed number of parameters
- Minimal distributional assumptions
- More flexible than [[Parametric Models]]
- Require more data for reliable estimates
- Higher risk of overfitting

### Common Examples
1. **Kernel Methods**
   - [[K-Nearest Neighbors]]: $\hat{f}(x) = \frac{1}{k}\sum_{i \in \mathcal{N}_k(x)} y_i$
   - [[Kernel Regression]]: $\hat{f}(x) = \frac{\sum_{i=1}^n K_h(x-x_i)y_i}{\sum_{i=1}^n K_h(x-x_i)}$
   - [[Support Vector Machines]] with non-linear kernels

2. **Smoothing Methods**
   - [[Local Regression]]
   - [[Smoothing Splines]]
   - [[Regression Splines]]

3. **Tree-Based Methods**
   - [[Random Forests]]
   - [[Boosting]]
   - [[Regression Trees]]

### Tuning Parameters
- Bandwidth/window size
- Number of neighbors (k)
- Kernel function choice
- Degree of smoothing
- Tree depth/complexity

### Advantages
- Flexibility in capturing patterns
- Fewer assumptions
- Can model complex relationships
- Adaptive to local structure

### Limitations
- Require larger datasets
- Computationally intensive
- Risk of overfitting
- Less interpretable
- [[Curse of Dimensionality]]

### Selection Considerations
1. **Sample Size**
   - Small n: Consider parametric
   - Large n: Non-parametric viable

2. **Dimensionality**
   - High p: Structured models preferred
   - Low p: Non-parametric methods work well

3. **Signal-to-Noise Ratio**
   - High noise: Simpler models better
   - Clear signal: Can use flexible methods
