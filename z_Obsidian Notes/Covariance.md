Covariance is a measure of the joint variability between two random variables. It indicates the direction of the linear relationship between variables and is fundamental to many statistical and machine learning concepts.

### Mathematical Definition

For two random variables X and Y:

$$\text{Cov}(X,Y) = \mathbb{E}[(X - \mathbb{E}[X])(Y - \mathbb{E}[Y])]$$

Sample covariance for n observations:

$$\text{Cov}(X,Y) = \frac{1}{n-1}\sum_{i=1}^n (x_i - \bar{x})(y_i - \bar{y})$$

### Properties

1. **Basic Properties**
   - $\text{Cov}(X,X) = \text{Var}(X)$
   - $\text{Cov}(X,Y) = \text{Cov}(Y,X)$
   - $\text{Cov}(aX,bY) = ab\text{Cov}(X,Y)$
   - $\text{Cov}(X+a,Y+b) = \text{Cov}(X,Y)$

2. **Interpretation**
   - Positive: Variables tend to move in same direction
   - Negative: Variables tend to move in opposite directions
   - Zero: Variables are uncorrelated

3. **Covariance Matrix**
   For random vectors $\mathbf{X} = [X_1,\ldots,X_n]^T$:
   $$\Sigma_{ij} = \text{Cov}(X_i,X_j)$$

### Related Concepts
- [[Variance]]
