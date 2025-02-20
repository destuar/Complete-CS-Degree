**Support Vector Machines (SVM)** is a supervised learning method that finds an optimal hyperplane to separate classes in a high-dimensional space. It extends from the [[Maximal Margin Classifier]] through the use of kernels for non-linear classification.

### Mathematical Framework
For binary classification with labels yi ∈ {-1,1}:

1. **Linear SVM**
   Minimize:
   $\frac{1}{2}\|\mathbf{w}\|^2 + C\sum_{i=1}^n \xi_i$

   Subject to:
   $y_i(\mathbf{w}^T\mathbf{x}_i + b) \geq 1 - \xi_i$
   $\xi_i \geq 0$

   where:
   - w is the normal vector to hyperplane
   - b is the bias term
   - $\xi_i$ are slack variables
   - C controls regularization

2. **Dual Formulation**
   Maximize:
   $\sum_{i=1}^n \alpha_i - \frac{1}{2}\sum_{i=1}^n\sum_{j=1}^n \alpha_i\alpha_j y_i y_j \mathbf{x}_i^T\mathbf{x}_j$

   Subject to:
   $0 \leq \alpha_i \leq C$
   $\sum_{i=1}^n \alpha_i y_i = 0$

### Kernel Methods
1. **Kernel Function**
   $K(\mathbf{x}_i, \mathbf{x}_j) = \langle\phi(\mathbf{x}_i), \phi(\mathbf{x}_j)\rangle$

2. **Common Kernels**
   - Linear: $K(\mathbf{x}, \mathbf{z}) = \mathbf{x}^T\mathbf{z}$
   - Polynomial: $K(\mathbf{x}, \mathbf{z}) = (1 + \mathbf{x}^T\mathbf{z})^d$
   - RBF: $K(\mathbf{x}, \mathbf{z}) = \exp(-\gamma\|\mathbf{x}-\mathbf{z}\|^2)$
   - Sigmoid: $K(\mathbf{x}, \mathbf{z}) = \tanh(\kappa\mathbf{x}^T\mathbf{z} + c)$

### Decision Function
$f(\mathbf{x}) = \text{sign}\left(\sum_{i=1}^n \alpha_i y_i K(\mathbf{x}_i, \mathbf{x}) + b\right)$

### Properties

1. **Support Vectors**
   - Points with $\alpha_i > 0$
   - Define the decision boundary
   - Typically small subset of data

2. **Margin**
   - Distance to decision boundary
   - Maximized by optimization
   - Controls model complexity

### Advantages
- Effective in high dimensions
- Memory efficient
- Versatile (different kernels)
- Theoretically well-founded
- Good generalization

### Limitations
- Sensitive to feature scaling
- Choice of kernel critical
- Not directly probabilistic
- Computationally intensive
- Parameter tuning needed

### Implementation
1. **Preprocessing**
   - Feature scaling essential
   - Missing value handling
   - Categorical encoding

2. **Parameter Selection**
   - C (regularization)
   - Kernel parameters
   - Class weights
   - Cache size

### Multi-class Extension
1. **One-vs-Rest**
   - K binary classifiers
   - Each class vs all others
   - Most common approach

2. **One-vs-One**
   - $\binom{K}{2}$ classifiers
   - Vote for final prediction
   - More robust, more expensive

### Diagnostics
- Cross-validation error
- ROC curves
- Confusion matrices
- Support vector analysis
- Decision boundary plots
