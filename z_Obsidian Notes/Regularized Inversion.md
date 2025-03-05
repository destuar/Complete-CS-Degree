Regularized inversion is an enhanced approach to solving inverse problems by incorporating prior information about the solution. This method extends basic [[Least Squares]] by adding regularization terms that enforce desired properties like smoothness or bounded magnitude in the solution.

## Key Concepts

1. **Basic Problem**:
   - Given system $Ax = b$
   - Standard solution may be unstable
   - Need additional constraints on $x$
   - Particularly useful when $A$ has dependent columns

2. **Prior Information**:
   - Solution should not be too large
   - Solution should be smooth
   - Other problem-specific constraints
   - Expressed as secondary objectives

## Mathematical Formulation

1. **Objective Functions**:
   - Primary: $J_1 = \|Ax - b\|^2$ (data fit)
   - Secondary: 
     - Tikhonov: $J_2 = \|x\|^2$ (magnitude constraint)
     - Smoothness: $J_2 = \|Dx\|^2$ (derivative constraint)
   - Combined: $\min_x J_1 + \lambda J_2$

2. **Regularization Parameter**:
   - $\lambda > 0$ controls trade-off
   - Small $\lambda$: better fit, less stable
   - Large $\lambda$: more stable, worse fit
   - Forms [[Pareto Optimal]] solutions

## Solution Methods

1. **Tikhonov Regularization**:
   $$ \min_x \|Ax - b\|^2 + \lambda\|x\|^2 $$
   - Explicit solution: $x(\lambda) = (A^TA + \lambda I)^{-1}A^Tb$
   - Works even with dependent columns
   - Related to [[Ridge Regression]]

2. **Smoothness Regularization**:
   $$ \min_x \|Ax - b\|^2 + \lambda\|Dx\|^2 $$
   - $D$ is difference matrix
   - Penalizes rapid changes
   - Common in signal processing

## Properties

1. **Regularization Path**:
   - Curve of $x(\lambda)$ vs $\lambda$
   - Shows solution evolution
   - Helps in parameter selection
   - Trade-off visualization

2. **Stability**:
   - Improves condition number
   - Reduces sensitivity to noise
   - More robust solutions
   - Better numerical properties

## Important Notes

- Balance between fit and regularization
- Multiple regularization terms possible
- Solution depends on $\lambda$ choice
- Consider problem-specific constraints
- Validate results carefully
- Monitor condition numbers
- Check solution stability
