A [[set]] of n-[[vector]]s ${a_1, \ldots, a_k}$ (where $k \geq 1$) is **linearly independent** if it is not [[linear dependence |linearly dependent]], i.e.,

$$ \beta_1a_1 + \cdots + \beta_ka_k = 0 $$

holds only when $\beta_1 = \cdots = \beta_k = 0$.

## Key Concepts

1. **Equivalent Definition**: A set of vectors is linearly independent if no vector in the set can be expressed as a linear combination of the others.

2. **Linear Independence Statement**: When we say "$a_1, \ldots, a_k$ are linearly independent", it means the only way to satisfy the equation above is with all zero coefficients.

## Important Examples

1. **Unit Vectors**: The standard unit n-vectors $e_1, \ldots, e_n$ are linearly independent
   - For example, in $\mathbb{R}^3$: $e_1 = (1,0,0)$, $e_2 = (0,1,0)$, $e_3 = (0,0,1)$

## Properties

1. **Subset Property**: 
   - Any subset of a linearly independent set is also linearly independent
   - Adding a vector to a linearly independent set may or may not preserve independence

2. **Zero Vector Property**:
   - Any set containing the zero vector is linearly dependent
   - Therefore, a linearly independent set cannot contain the zero vector

3. **Size Limitation**:
   - In an n-dimensional vector space, any set of more than n vectors must be linearly dependent
   - A linearly independent set can have at most n vectors
