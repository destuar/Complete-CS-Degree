**Linear Transformation** is a function between two [[Vector Space|vector spaces]] that preserves vector addition and scalar multiplication. In statistical learning, it's fundamental to many methods including dimensionality reduction and feature engineering.

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

### Key Properties
1. **Kernel (Nullspace)**
   - Set of vectors mapped to zero: $\text{ker}(T) = \{\mathbf{x} : T(\mathbf{x}) = \mathbf{0}\}$
   - Dimension: $\dim(\text{ker}(T)) + \dim(\text{range}(T)) = n$

2. **Range (Image)**
   - Set of all possible outputs: $\text{range}(T) = \{T(\mathbf{x}) : \mathbf{x} \in \mathbb{R}^n\}$
   - For matrix $A$: column space of $A$

3. **Rank**
   - Dimension of range space
   - For matrix $A$: number of linearly independent columns/rows

### Applications in Statistical Learning

1. **Feature Engineering**
   - Standardization: $z = \frac{x - \mu}{\sigma}$
   - Scaling: $x_{\text{new}} = ax + b$
   - [[Principal Components Analysis]]

2. **Model Transformations**
   - [[Linear Regression]]: $\hat{y} = X\beta$
   - [[Linear Discriminant Analysis]]
   - [[Support Vector Machines]]

3. **Dimensionality Reduction**
   - [[Principal Components Analysis]]: $Z = XW$
   - [[Linear Discriminant Analysis]]
   - [[Factor Analysis]]

### Important Examples
1. **Rotation**
   - Preserves distances and angles
   - Orthogonal matrices: $A^TA = AA^T = I$

2. **Projection**
   - Projects vectors onto subspace
   - Idempotent: $P^2 = P$
   - Used in [[Regression Model|regression]] and [[Principal Components Analysis]]

3. **Scaling**
   - Changes vector magnitude
   - Diagonal matrices
   - Used in feature normalization

Tags:
[[Linear Algebra]]
[[Statistical Learning]]
[[Matrix]]
[[Vector Space]]
[[Dimensionality Reduction]]
