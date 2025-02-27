Matrix multiplication is a fundamental operation in linear algebra that combines two matrices to produce a third matrix, with applications ranging from solving [[Linear Equations]] to transforming data in machine learning. The operation is non-commutative and follows specific dimensional requirements.

## Definition

For an $m \times p$ matrix $A$ and a $p \times n$ matrix $B$, their product $C = AB$ is an $m \times n$ matrix where each element $C_{ij}$ is computed as:

$$C_{ij} = \sum_{k=1}^p A_{ik}B_{kj} = A_{i1}B_{1j} + A_{i2}B_{2j} + \cdots + A_{ip}B_{pj}$$

for $i = 1,\ldots,m$ and $j = 1,\ldots,n$

## Computation Method

To compute element $C_{ij}$:
1. Take the $i$th row of matrix $A$
2. Take the $j$th column of matrix $B$
3. Multiply corresponding elements and sum the results

## Example

Consider the multiplication:

$$\begin{bmatrix} -1.5 & 3 & 2 \\ 1 & -1 & 0 \end{bmatrix} \begin{bmatrix} -1 & -1 \\ 0 & -2 \\ 1 & 0 \end{bmatrix} = \begin{bmatrix} 3.5 & -4.5 \\ -1 & 1 \end{bmatrix}$$

For element $C_{11} = 3.5$:
$(-1.5)(-1) + (3)(0) + (2)(1) = 1.5 + 0 + 2 = 3.5$

## Properties

1. **Dimension Compatibility**: 
   - To multiply $A_{m\times p}$ and $B_{p\times n}$, the number of columns in $A$ must equal the number of rows in $B$
   - The resulting matrix $C$ will be $m\times n$

2. **Non-commutativity**: 
   - In general, $AB \neq BA$
   - Even when both products exist, they may be different

3. **Distributivity**:
   - Over addition: $A(B + C) = AB + AC$
   - Scalar multiplication: $\alpha(AB) = (\alpha A)B = A(\alpha B)$

4. **Associativity**: 
   - $(AB)C = A(BC)$

## Computational Considerations

1. **Complexity**:
   - Standard algorithm: $O(mnp)$ operations
   - Strassen's algorithm: $O(n^{2.807})$ for square matrices
   - Various optimizations exist for sparse matrices

2. **Numerical Stability**:
   - Accumulation of floating-point errors
   - Condition number affects stability
   - Block matrix methods can improve stability

## Special Cases

1. **Identity Matrix $I$**:
   - $AI = IA = A$ for any compatible matrix $A$

2. **Zero Matrix $O$**:
   - $AO = OA = O$ for any compatible matrix $A$

3. **Diagonal Matrices**:
   - Multiplication is element-wise on the diagonal
   - Often used for scaling operations
