A **block matrix** (or partitioned matrix) is a [[Matrices|matrix]] that is divided into smaller submatrices (called blocks). For example:

$$ A = \begin{bmatrix} B & C \\ D & E \end{bmatrix} $$

where $B$, $C$, $D$, and $E$ are matrices (called submatrices or blocks of $A$).

## Rules for Block Structure

1. **Row Compatibility**:
   - Matrices in each block row must have the same height (row dimension)
   - Example: If $B$ has 2 rows, $C$ must also have 2 rows

2. **Column Compatibility**:
   - Matrices in each block column must have the same width (column dimension)
   - Example: If $B$ has 3 columns, $D$ must have 3 columns

## Example
Given the following blocks:
- $B = \begin{bmatrix} 0 & 2 & 3 \end{bmatrix}$
- $C = \begin{bmatrix} -1 \end{bmatrix}$
- $D = \begin{bmatrix} 2 & 2 & 1 \\ 1 & 3 & 5 \end{bmatrix}$
- $E = \begin{bmatrix} 4 \\ 4 \end{bmatrix}$

The resulting block matrix is:

$$ \begin{bmatrix} B & C \\ D & E \end{bmatrix} = \begin{bmatrix} 
0 & 2 & 3 & -1 \\
2 & 2 & 1 & 4 \\
1 & 3 & 5 & 4
\end{bmatrix} $$

## Operations with Block Matrices

1. **Addition/Subtraction**:
   $$ \begin{bmatrix} A_{11} & A_{12} \\ A_{21} & A_{22} \end{bmatrix} \pm \begin{bmatrix} B_{11} & B_{12} \\ B_{21} & B_{22} \end{bmatrix} = \begin{bmatrix} A_{11} \pm B_{11} & A_{12} \pm B_{12} \\ A_{21} \pm B_{21} & A_{22} \pm B_{22} \end{bmatrix} $$

2. **Block Multiplication**:
   $$ \begin{bmatrix} A_{11} & A_{12} \\ A_{21} & A_{22} \end{bmatrix} \begin{bmatrix} B_{11} & B_{12} \\ B_{21} & B_{22} \end{bmatrix} = \begin{bmatrix} A_{11}B_{11} + A_{12}B_{21} & A_{11}B_{12} + A_{12}B_{22} \\ A_{21}B_{11} + A_{22}B_{21} & A_{21}B_{12} + A_{22}B_{22} \end{bmatrix} $$
