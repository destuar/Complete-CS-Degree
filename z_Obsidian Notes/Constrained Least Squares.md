Constrained Least Squares (CLS) extends the standard [[Least Squares]] problem by incorporating equality constraints on the solution. This approach is essential when solutions must satisfy specific linear relationships while still minimizing the residual error.

## Problem Formulation

1. **Basic Definition**:
   - Minimize: $\|Ax - b\|^2$
   - Subject to: $Cx = d$
   - Where:
     - $A$ is an $m \times n$ matrix
     - $b$ is an $m$-vector
     - $C$ is a $p \times n$ matrix
     - $d$ is a $p$-vector
     - $x$ is the $n$-vector to be found

2. **Feasibility**:
   - A vector $x$ is feasible if $Cx = d$
   - The constraint set is the affine subspace of all feasible points
   - Solution exists only if constraints are consistent

## Solution Methods

1. **Lagrange Multipliers**:
   - Form Lagrangian: $L(x, \lambda) = \|Ax - b\|^2 + \lambda^T(Cx - d)$
   - Set gradients to zero:
     $$ \nabla_x L = 2A^T(Ax - b) + C^T\lambda = 0 $$
     $$ \nabla_{\lambda} L = Cx - d = 0 $$
   - Solve the resulting system of equations

2. **Elimination Method**:
   - Parameterize all solutions to $Cx = d$
   - Substitute into unconstrained problem
   - Solve reduced unconstrained problem
   - Map solution back to original space

3. **Null Space Method**:
   - Find matrix $Z$ whose columns span null space of $C$
   - Find particular solution $x_p$ where $Cx_p = d$
   - Express general solution as $x = x_p + Zv$
   - Minimize $\|A(x_p + Zv) - b\|^2$ over $v$

## Explicit Solution

1. **KKT System**:
   $$ \begin{bmatrix} 2A^TA & C^T \\ C & 0 \end{bmatrix} \begin{bmatrix} x \\ \lambda \end{bmatrix} = \begin{bmatrix} 2A^Tb \\ d \end{bmatrix} $$

2. **Direct Formula**:
   $$ \hat{x} = x_{LS} + (C(C^T(AA^T)^{-1}C)^{-1}(d - Cx_{LS}) $$
   where $x_{LS} = A^+b$ is the unconstrained least squares solution

## Relationship to Other Methods

1. **[[Regularized Inversion]]**:
   - Soft constraints vs. hard constraints
   - Trade-off parameter vs. exact satisfaction
   - Both address ill-conditioning

2. **[[Multi-Objective Least Squares]]**:
   - CLS enforces exact constraints
   - Multi-objective balances competing objectives
   - Different philosophical approaches

## Important Properties

1. **Optimality Conditions**:
   - $\hat{x}$ is a solution if:
     - $C\hat{x} = d$ (feasibility)
     - $\|A\hat{x} - b\|^2 \leq \|Ax - b\|^2$ for all $x$ satisfying $Cx = d$
   - Residual $A\hat{x} - b$ is orthogonal to feasible directions

2. **Geometric Interpretation**:
   - Projection of unconstrained solution onto constraint set
   - Orthogonality principles still apply within constraint set
   - Constraint set is an affine subspace

## Important Notes

- Constraints must be consistent for solution to exist
- Fewer constraints than variables ($p < n$) for meaningful problem
- Consider numerical stability in implementation
- Equality constraints can be extended to inequalities
- Dual problem often provides computational advantages
- Sensitivity analysis important for practical applications
