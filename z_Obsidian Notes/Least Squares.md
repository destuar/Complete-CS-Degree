Least squares is a mathematical optimization technique for finding the best-fitting solution to an overdetermined system of [[Linear Equations]] by minimizing the sum of squared differences between the observed and predicted values. This method is fundamental in [[Simple Linear Regression|regression analysis]] and data fitting.

## Key Concepts

1. **Problem Setup**:
   - Given an $m \times n$ matrix $A$ where $m > n$ (tall matrix)
   - System $Ax = b$ is overdetermined
   - For most $b$, no exact solution exists
   - Goal: Find $\hat{x}$ that minimizes $\|Ax - b\|_2^2$

2. **Residual**:
   - Defined as $r = Ax - b$
   - Measures the error between prediction and observation
   - Least squares minimizes $\|r\|_2^2$

## Mathematical Formulation

1. **Objective Function**:
   $$ \min_x \|Ax - b\|_2^2 = \min_x \sum_{i=1}^m (a_i^Tx - b_i)^2 $$
   where $a_i^T$ is the $i$-th row of $A$

2. **Solution Characterization**:
   - $\hat{x}$ is a least squares solution if:
   $$ \|A\hat{x} - b\|^2 \leq \|Ax - b\|^2 $$
   for all vectors $x$

## Solution Methods

1. **Normal Equations**:
   - Set gradient to zero: $A^T(Ax - b) = 0$
   - Solve: $(A^TA)\hat{x} = A^Tb$
   - Solution: $\hat{x} = (A^TA)^{-1}A^Tb$

2. **[[Pseudo-Inverse]]**:
   - Solution can be written as: $\hat{x} = A^+b$
   - Where $A^+ = (A^TA)^{-1}A^T$ is the pseudo-inverse
   - More numerically stable than normal equations

3. **QR Factorization**:
   - Decompose $A = QR$
   - Solve $R\hat{x} = Q^Tb$
   - More efficient than normal equations

## Important Properties

1. **Geometric Interpretation**:
   - Solution projects $b$ onto column space of $A$
   - Residual is orthogonal to column space
   - $A\hat{x}$ is closest point to $b$ in range(A)

2. **Statistical Properties**:
   - Under certain conditions, provides BLUE (Best Linear Unbiased Estimator)
   - Maximum likelihood estimator for Gaussian noise
   - Minimizes variance of parameter estimates

## Numerical Considerations

1. **Conditioning**:
   - Condition number of $A^TA$ is square of $A$'s
   - Normal equations can be numerically unstable
   - QR or SVD methods preferred for stability

2. **Implementation**:
   - Avoid explicit computation of $A^TA$
   - Use stable orthogonalization methods
   - Consider regularization for ill-conditioned problems

## Important Notes

- Solution exists but may not be unique
- Sensitive to outliers due to squared error
- Forms basis for many statistical methods
- Computationally efficient for large datasets
- Foundation for more advanced regression techniques
