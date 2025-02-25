A **matrix** is a rectangular array of numbers. For example:

$$ B = \begin{pmatrix} 
0 & 1 & -2.3 & 0.1 \\
1.3 & 4 & -0.1 & 0 \\
4.1 & -1 & 0 & 1.7
\end{pmatrix} $$

We also consider an $n$ x $1$ or $1$ x $n$ matrix to be an $n$-[[vector]]. 
## Basic Terminology

1. **Size/Dimensions**:
   - Given by (row dimension) × (column dimension)
   - Example above is a 3 × 4 matrix
   - An $m \times n$ matrix has $m$ rows and $n$ columns

2. **Elements/Entries**:
   - Individual numbers in the matrix are called elements, entries, or coefficients
   - $B_{ij}$ denotes the element in the $i$-th row and $j$-th column
   - Indices start at 1 (not 0)

3. **Special Types**:
   - Square Matrix: number of rows equals number of columns
   - Column Matrix: $n \times 1$ matrix
   - Row Matrix: $1 \times n$ matrix

## Matrix Equality
Two matrices are equal (denoted with =) if:
1. They have the same size (dimensions)
2. All corresponding entries are equal

## Common Matrix Types

1. **Zero Matrix**:
   - All entries are zero
   - Denoted as $0$ or $0_{m\times n}$

2. **Identity Matrix**:
   - Square matrix with 1's on diagonal, 0's elsewhere
   - Denoted as $I$ or $I_n$
   $$ I_3 = \begin{pmatrix}
   1 & 0 & 0 \\
   0 & 1 & 0 \\
   0 & 0 & 1
   \end{pmatrix} $$

3. **Diagonal Matrix**:
   - Square matrix with non-zero elements only on diagonal
   - All off-diagonal elements are zero

4. **Triangular Matrices**:
   - Upper triangular: all elements below diagonal are zero
   - Lower triangular: all elements above diagonal are zero

## Matrix Operations

1. **Addition/Subtraction**:
   - Only defined for matrices of same size
   - Add/subtract corresponding elements

2. **Scalar Multiplication**:
   - Multiply each element by scalar
   - Result has same size as original matrix

3. **Matrix Multiplication**:
   - Requires first matrix columns = second matrix rows
   - Result is sum of row-column products
