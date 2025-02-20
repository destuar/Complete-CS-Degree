**Linear Transformation** is a function between two vector spaces that preserves [[vector]] addition and [[scalar]] multiplication. In statistical learning, it's fundamental to many methods including dimensionality reduction and feature engineering.

### Mathematical Definition
A transformation $T: \mathbb{R}^n \rightarrow \mathbb{R}^m$ is linear if for all vectors $\mathbf{x}, \mathbf{y}$ and scalar $c$:
1. $T(\mathbf{x} + \mathbf{y}) = T(\mathbf{x}) + T(\mathbf{y})$ (Additivity)
2. $T(c\mathbf{x}) = cT(\mathbf{x})$ (Homogeneity)

### Matrix Representation
For finite-dimensional vector spaces, every linear transformation can be represented as a matrix multiplication:
$T(\mathbf{x}) = A\mathbf{x}$

where:
- $A$ is an $m \times n$ matrix
- $\mathbf{x}$ is an $n \times 1$ vector
- $T(\mathbf{x})$ is an $m \times 1$ vector
