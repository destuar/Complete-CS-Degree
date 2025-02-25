A [[set]] of n-[[vector]]s ${a_1, \ldots, a_k}$ (where $k \geq 1$) is **linearly dependent** if:

$$ \beta_1a_1 + \cdots + \beta_ka_k = 0 $$

holds for some $\beta_1, \ldots, \beta_k$ that are not all zero.

## Key Concepts

1. **Equivalent Definition**: A set of vectors is linearly dependent if at least one vector in the set can be expressed as a [[linear combination]] of the others.

2. **Linear Dependence Statement**: When we say "$a_1, \ldots, a_k$ are linearly dependent", it means there exists a non-trivial linear combination that equals zero.

## Special Cases

1. **Single Vector**: 
   - A set containing a single vector ${a_1}$ is linearly dependent if and only if $a_1 = 0$

2. **Two Vectors**: 
   - A set ${a_1, a_2}$ is linearly dependent if and only if one vector is a scalar multiple of the other

3. **More Than Two Vectors**: 
   - For three or more vectors, there is no simple condition to determine linear dependence
   - Must check if any vector can be written as a linear combination of the others

## Important Notes

- Linear dependence implies that at least one vector in the set is "redundant"
- If vectors are linearly dependent, at least one vector can be eliminated without losing any spanning capabilities
- The zero vector is always linearly dependent with any set of vectors
- Linear independence is the opposite of linear dependence (no non-trivial linear combination equals zero)
