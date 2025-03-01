QR Factorization is a fundamental [[Matrices|matrix]] decomposition that factors a matrix $A$ into a product $A = QR$, where $Q$ is an orthogonal matrix and $R$ is an upper triangular matrix with positive diagonal entries. This decomposition provides a powerful way to solve linear systems and compute matrix properties.

## Key Properties

1. **Decomposition Structure**:
   - For a matrix $A \in \mathbb{R}^{m \times n}$:
   - $Q \in \mathbb{R}^{m \times m}$ is orthogonal ($Q^TQ = QQ^T = I$)
   - $R \in \mathbb{R}^{m \times n}$ is upper triangular
   - The columns of $Q$ form an [[Orthonormal Vectors|orthonormal]] basis

2. **Uniqueness**:
   - For a full-rank matrix $A$, the QR factorization is unique if we require:
     - Diagonal elements of $R$ to be positive
     - $Q$ to be orthogonal

## Computation

1. **[[Gram-Schmidt Algorithm]]**:
   - The classical method for computing QR factorization
   - Converts a set of linearly independent vectors into orthonormal vectors
   - These vectors form the columns of $Q$

2. **Modified Gram-Schmidt**:
   - Numerically more stable version
   - Produces the same results in exact arithmetic
   - Preferred in practical implementations

## Important Notes

- QR factorization is computationally more stable than [[Matrix Multiplication|direct matrix]] operations
- For large matrices, specialized algorithms like Householder transformations are preferred
- The decomposition exists for any real matrix, even if not full rank
- Memory-efficient implementations can store $Q$ in factored form

## Computational Complexity

- Classical Gram-Schmidt: $O(mn^2)$ operations for $m \times n$ matrix
- Modified Gram-Schmidt: Same complexity but better numerical properties
- Householder method: $O(mn^2 - \frac{n^3}{3})$ operations
