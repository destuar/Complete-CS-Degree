A system of linear equations is a collection of one or more linear equations involving the same variables. These systems form the foundation of linear algebra and have widespread applications in optimization, data fitting, and scientific computing.

## Definition

A system of $m$ linear equations in $n$ variables $x_1, \ldots, x_n$ takes the form:

$$\begin{align*}
A_{11}x_1 + A_{12}x_2 + \cdots + A_{1n}x_n &= b_1 \\
A_{21}x_1 + A_{22}x_2 + \cdots + A_{2n}x_n &= b_2 \\
&\vdots \\
A_{m1}x_1 + A_{m2}x_2 + \cdots + A_{mn}x_n &= b_m
\end{align*}$$

Where:
- $x = [x_1, \ldots, x_n]^T$ is the vector of unknowns (variables)
- $A_{ij}$ are the coefficients
- $b_i$ are the values on the right-hand side
- $A$ is the coefficient matrix containing all $A_{ij}$
- $b$ is the right-hand side vector containing all $b_i$

## Matrix Form

The system can be expressed compactly in matrix notation as:

$$A\mathbf{x} = \mathbf{b}$$

Where:
- $A$ is an $m \times n$ [[Matrices|matrix]]
- $\mathbf{x}$ is an $n$-dimensional column vector
- $\mathbf{b}$ is an $m$-dimensional column vector

## Types of Solutions

A system of linear equations can have:

1. **Unique solution**: The system has exactly one solution
2. **No solution**: The system is inconsistent
3. **Infinite solutions**: The system has infinitely many solutions

The type of solution depends on the relationship between:
- Rank of the coefficient matrix $A$
- Rank of the augmented matrix $[A|\mathbf{b}]$
- Number of variables $n$
- Number of equations $m$

## Solution Methods

Several methods exist for solving systems of linear equations:

1. **Direct Methods**:
   - Gaussian elimination
   - LU decomposition
   - Cholesky decomposition (for symmetric positive definite matrices)
   - [[Matrices#Matrix Operations|Matrix inversion]] (when $A$ is square and invertible)

2. **Iterative Methods**:
   - Jacobi method
   - Gauss-Seidel method
   - Conjugate gradient method (for symmetric positive definite matrices)

## Properties

1. **Existence**: A solution exists if and only if $\text{rank}(A) = \text{rank}([A|\mathbf{b}])$

2. **Uniqueness**: If a solution exists, it is unique if and only if $\text{rank}(A) = n$

3. **[[Linear Independence|Linear independence]]**: The columns of $A$ must be linearly independent for a unique solution to exist
