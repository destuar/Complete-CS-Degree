**Support Vector Classifier** (SVC) is a linear classification method that finds the optimal hyperplane to separate classes with the maximum margin. It is the linear precursor to [[Support Vector Machines]].

### Mathematical Framework
The optimization problem for SVC:

$\min_{\beta_0, \beta, \epsilon} \frac{1}{2}\|\beta\|^2 + C\sum_{i=1}^n \epsilon_i$

subject to:
$y_i(\beta_0 + \beta^T x_i) \geq 1 - \epsilon_i$ for all $i$
$\epsilon_i \geq 0$ for all $i$

where:
- $\beta_0$ is the intercept
- $\beta$ is the normal vector to the hyperplane
- $\epsilon_i$ are slack variables
- $C$ is the cost parameter

### Key Components
1. **Margin**
   - Distance between decision boundary and nearest points
   - Maximizing margin improves generalization
   - Width = $\frac{2}{\|\beta\|}$

2. **Support Vectors**
   - Points that lie on margin boundaries
   - Define the decision boundary
   - Subset of training data

### Properties
- Linear decision boundary
- Maximum margin separation
- Robust to outliers
- Handles overlapping classes
- Foundation for kernel methods

### Relationship to Other Methods
- Generalizes to [[Support Vector Machines]] with kernels
- Related to [[Linear Discriminant Analysis]]
- Connection to [[Logistic Regression]]

### Applications
- Binary classification
- Text categorization
- Image classification
- Bioinformatics
