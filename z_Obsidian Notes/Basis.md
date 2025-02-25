A [[set]] of $n$ [[Linear Independence|linearly independent]] n-[[vector]]s $a_1, \ldots, a_n$ is called a **basis** if any n-vector $b$ can be expressed as a [[linear combination]] of them:

$$ b = \beta_1a_1 + \cdots + \beta_na_n $$

for some coefficients $\beta_1, \ldots, \beta_n$.

## Key Properties

1. **Uniqueness**: 
   - The coefficients $\beta_1, \ldots, \beta_n$ in the expansion are unique
   - This means there is exactly one way to write any vector as a linear combination of basis vectors

2. **Expansion**: 
   - The formula above is called the "expansion of $b$ in the $a_1, \ldots, a_n$ basis"
   - The coefficients $\beta_i$ are called the coordinates of $b$ in this basis

## Important Examples

1. **Standard Basis**: 
   - The unit vectors $e_1, \ldots, e_n$ form a basis
   - For example, in $\mathbb{R}^3$: $e_1 = (1,0,0)$, $e_2 = (0,1,0)$, $e_3 = (0,0,1)$
   - Any vector $b = (b_1, b_2, b_3)$ has the expansion: $b = b_1e_1 + b_2e_2 + b_3e_3$

## Essential Properties

1. **Spanning Property**:
   - A basis spans the entire vector space
   - Every vector in the space can be written as a linear combination of basis vectors

2. **Independence Property**:
   - Basis vectors are linearly independent
   - No basis vector can be written as a linear combination of the others

3. **Dimension**:
   - All bases of a vector space have the same number of vectors
   - This number is called the dimension of the vector space
