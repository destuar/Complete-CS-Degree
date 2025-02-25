Given n-[[vector]]s $a_1, \ldots, a_k$, the Gram-Schmidt algorithm proceeds as follows:

For $i = 1, \ldots, k$:

1. **Orthogonalization**:
   $$ \tilde{q}_i = a_i - \sum_{j=1}^{i-1} (a_i^Tq_j)q_j $$
   where $a_i^Tq_j$ is the projection of $a_i$ onto $q_j$

2. **Linear Dependence Test**:
   - If $\tilde{q}_i = 0$, quit (vectors are [[linear dependence |linearly dependent]])
   - Otherwise, continue to step 3

3. **Normalization**:
   $$ q_i = \frac{\tilde{q}_i}{\|\tilde{q}_i\|} $$

## Properties

1. **Linear Independence Test**:
   - If G-S does not stop early (in step 2), then $a_1, \ldots, a_k$ are [[linear independence|linearly independent]]
   - If G-S stops early in iteration $i = j$, then $a_j$ is a linear combination of $a_1, \ldots, a_{j-1}$ (so $a_1, \ldots, a_k$ are linearly dependent)

2. **Output Properties**:
   - The resulting vectors $q_1, \ldots, q_k$ are [[Orthonormal Vectors|orthonormal]]
   - span$\{q_1, \ldots, q_i\}$ = span$\{a_1, \ldots, a_i\}$ for each $i$

## Implementation Notes

1. **Numerical Stability**:
   - The classical Gram-Schmidt can be numerically unstable
   - Modified Gram-Schmidt (MGS) is preferred in practice
   - Double orthogonalization can improve accuracy

2. **Computational Cost**:
   - For $k$ vectors in $\mathbb{R}^n$: $O(kn^2)$ operations
   - Memory requirement: $O(kn)$

## Applications

1. **Basis Construction**:
   - Converting a linearly independent set to an orthonormal [[basis]]
   - QR decomposition of matrices
   - Computing orthonormal bases for subspaces

2. **Numerical Linear Algebra**:
   - Solving least squares problems
   - Computing matrix factorizations
   - Eigenvalue algorithms

## Example
For vectors in $\mathbb{R}^2$:
- Input: $a_1 = (1,0)$, $a_2 = (1,1)$
- After normalization: $q_1 = (1,0)$
- Orthogonalization: $\tilde{q}_2 = (1,1) - ((1,1)\cdot(1,0))(1,0) = (0,1)$
- Final result: $q_2 = (0,1)$
