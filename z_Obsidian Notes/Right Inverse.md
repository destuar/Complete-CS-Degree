A right inverse is a fundamental concept in [[Matrices|matrix]] algebra where a matrix $X$ satisfies $AX = I$ for a given matrix $A$, where $I$ is the identity matrix. This concept is dual to the [[Left Inverse]] and provides important insights into matrix properties and linear transformations.

## Key Concepts

1. **Definition**:
   - For a matrix $A$, a right inverse $X$ satisfies $AX = I$
   - If a right inverse exists, $A$ is called right-invertible
   - Right-invertible matrices must be wide (more columns than rows) or square

2. **Relationship with Transpose**:
   - $A$ is right-invertible if and only if $A^T$ is left-invertible
   - This gives the equivalence: $AX = I \iff (AX)^T = I \iff X^TA^T = I$

## Properties

1. **Existence Conditions**:
   - Matrix must have at least as many columns as rows ($n \geq m$)
   - Matrix must have full row rank
   - Rows must be [[Linear Independence|linearly independent]]
   - For square matrices, right inverse equals left inverse (if either exists)

2. **Key Theorem**:
   A matrix $A$ is right-invertible if and only if its rows are linearly independent

3. **Dimensional Requirements**:
   - For an $m \times n$ matrix:
     - Must be wide ($n \geq m$) or square ($n = m$)
     - Rank must equal the number of rows

## Relationship with Left Inverses

1. **Duality**:
   - Left inverse: $XA = I$ (requires linearly independent columns)
   - Right inverse: $AX = I$ (requires linearly independent rows)

2. **Square Matrices**:
   - For square matrices, if either inverse exists:
     - Left inverse = Right inverse = Regular inverse
     - Matrix is invertible in the usual sense

## Computation

1. **Using [[QR Factorization]]**:
   - Apply QR to $A^T$: $A^T = QR$
   - Right inverse is $(R^{-1}Q^T)^T$

2. **Direct Method**:
   - Solve system $AX = I$
   - Multiple solutions may exist
   - Not recommended for numerical computation

## Important Notes

- Right inverse may not be unique when it exists
- Existence implies [[surjective|surjectivity]] of the associated linear transformation
- For non-square matrices, right and left inverses are generally different
- The concept is crucial in understanding overdetermined vs underdetermined systems
