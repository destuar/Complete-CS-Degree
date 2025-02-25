An $m \times n$ **selector matrix** is a special [[Matrices|matrix]] where each row is a unit [[vector]] (transposed). It can be written as:

$$ A = \begin{bmatrix} e_{k_1}^T \\ e_{k_2}^T \\ \vdots \\ e_{k_m}^T \end{bmatrix} = \begin{bmatrix} 
0 & \cdots & 1 & \cdots & 0 \\
0 & \cdots & 1 & \cdots & 0 \\
\vdots & \ddots & \vdots & \ddots & \vdots \\
0 & \cdots & 1 & \cdots & 0
\end{bmatrix} $$

where each $e_{k_i}$ is a standard unit vector.

## Key Properties

1. **Selection Operation**:
   - Multiplying by $A$ selects entries of a vector $x$:
   $$ Ax = (x_{k_1}, x_{k_2}, \ldots, x_{k_m}) $$
   - Each row selects one component of the input vector

2. **Structure**:
   - Each row contains exactly one 1 and the rest 0s
   - The position of the 1 in each row determines which element is selected

## Important Example: Down-sampling Matrix

The $m \times 2m$ down-sampling matrix:
$$ A = \begin{bmatrix} 
1 & 0 & 0 & 0 & \cdots & 0 & 0 \\
0 & 0 & 1 & 0 & \cdots & 0 & 0 \\
\vdots & \vdots & \vdots & \vdots & \ddots & \vdots & \vdots \\
0 & 0 & 0 & 0 & \cdots & 1 & 0
\end{bmatrix} $$

When applied to a $2m$-vector $x$, it produces:
$$ y = Ax = (x_1, x_3, \ldots, x_{2m-1}) $$

This effectively "down-samples" the vector by 2, keeping only odd-indexed entries.

## Properties

1. **Sparsity**:
   - Selector matrices are very sparse (mostly zeros)
   - Efficient for computational operations

2. **Composition**:
   - Multiple selections can be composed
   - The product of selector matrices is another selector matrix

3. **Special Cases**:
   - Identity matrix is a special selector matrix
   - Permutation matrices are square selector matrices with exactly one 1 in each row and column
