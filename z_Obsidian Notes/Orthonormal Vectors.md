A [[set]] of n-[[vector]]s $a_1, \ldots, a_k$ is called **orthonormal** if it satisfies two conditions:

1. **Orthogonality**: The vectors are (mutually) orthogonal, meaning:
   - $a_i \perp a_j$ for all $i \neq j$ 

2. **Normalization**: Each vector has unit length:
   - $\|a_i\| = 1$ for $i = 1, \ldots, k$

## Mathematical Representation

Using inner products, orthonormality can be expressed elegantly as:

$$ a_i^Ta_j = \begin{cases} 
1 & \text{if } i = j \\
0 & \text{if } i \neq j
\end{cases} $$

## Key Properties

1. **Linear Independence**:
   - All orthonormal sets of vectors are [[linear independence |linearly independent]]
   - This follows directly from the orthogonality condition

2. **Size Limitation**:
   - By the independence-dimension inequality, must have $k \leq n$
   - In an n-dimensional space, can't have more than n orthonormal vectors

3. **Orthonormal Basis**:
   - When $k = n$, the vectors $a_1, \ldots, a_n$ form an orthonormal basis
   - This is a particularly nice type of [[basis]] with special properties

## Advantages of Orthonormal Bases

1. **Simple Coordinates**:
   - For any vector $v$, its coordinates in an orthonormal basis are given by inner products
   - The $i$-th coordinate is simply $a_i^Tv$

2. **Computational Efficiency**:
   - Calculations involving orthonormal bases are typically more stable
   - Transformations between orthonormal bases preserve lengths and angles
