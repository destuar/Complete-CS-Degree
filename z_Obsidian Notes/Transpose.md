The **transpose** of an $m \times n$ [[Matrices|matrix]] $A$ is denoted $A^T$ and defined by:

$$ (A^T)_{ij} = A_{ji} \quad \text{for } i = 1,\ldots,n, \; j = 1,\ldots,m $$

In other words, the $(i,j)$ entry of $A^T$ is the $(j,i)$ entry of $A$.

## Example
$$ \begin{bmatrix} 0 & 4 \\ 7 & 0 \\ 3 & 1 \end{bmatrix}^T = \begin{bmatrix} 0 & 7 & 3 \\ 4 & 0 & 1 \end{bmatrix} $$

## Key Properties

1. **Dimension Change**:
   - If $A$ is $m \times n$, then $A^T$ is $n \times m$
   - Rows become columns and columns become rows

2. **Vector Conversion**:
   - Transpose converts column vectors to row vectors and vice versa
   - Example: $\begin{bmatrix} a \\ b \\ c \end{bmatrix}^T = \begin{bmatrix} a & b & c \end{bmatrix}$

3. **Double Transpose**:
   - $(A^T)^T = A$
   - Transposing twice returns the original matrix

## Properties with Operations

1. **Addition/Subtraction**:
   - $(A \pm B)^T = A^T \pm B^T$

2. **Scalar Multiplication**:
   - $(cA)^T = cA^T$ for any scalar $c$

3. **Matrix Multiplication**:
   - $(AB)^T = B^T A^T$
   - Note the order reversal

## Special Cases

1. **Symmetric Matrices**:
   - A matrix $A$ is symmetric if $A^T = A$
   - All entries satisfy $a_{ij} = a_{ji}$
   - Example: $\begin{bmatrix} 1 & 2 \\ 2 & 3 \end{bmatrix}$

2. **Skew-Symmetric Matrices**:
   - A matrix $A$ is skew-symmetric if $A^T = -A$
   - All entries satisfy $a_{ij} = -a_{ji}$
   - Diagonal elements must be zero
   - Example: $\begin{bmatrix} 0 & 2 \\ -2 & 0 \end{bmatrix}$

Tags:
[[Inner Product]]