Lagrange Multipliers are mathematical tools used to find extrema (maxima or minima) of a function subject to constraints. They transform constrained optimization problems into unconstrained problems by incorporating the constraints directly into the objective function.

## Basic Definition

- The Lagrangian of a constrained problem is the function:
  $$ L(x, z) = \|f(x)\|^2 + z_1 g_1(x) + \cdots + z_p g_p(x) $$
  $$ = \|f(x)\|^2 + g(x)^T z $$

- $p$-vector $z = (z_1, \ldots, z_p)$ is the [[vector]] of Lagrange multipliers

- Method of Lagrange multipliers: if $\hat{x}$ is a solution, then there exists $\hat{z}$ with:
  $$ \frac{\partial L}{\partial x_i}(\hat{x}, \hat{z}) = 0, \quad i = 1, \ldots, n $$
  $$ \frac{\partial L}{\partial z_i}(\hat{x}, \hat{z}) = 0, \quad i = 1, \ldots, p $$
  (provided the gradients $\nabla g_1(\hat{x}), \ldots, \nabla g_p(\hat{x})$ are linearly independent)

- $\hat{z}$ is called an optimal Lagrange multiplier

## Constrained Nonlinear Least Squares

1. **Problem Formulation**:
   - Minimize: $\|f(x)\|^2$ (sum of squared residuals)
   - Subject to: $g_i(x) = 0, \quad i = 1, \ldots, p$ (equality constraints)
   - Where:
     - $f: \mathbb{R}^n \to \mathbb{R}^m$ is a nonlinear function
     - $g_i: \mathbb{R}^n \to \mathbb{R}$ are constraint functions
     - Connection to [[Nonlinear Equations]] and [[Constrained Least Squares]]

2. **Optimality Conditions**:
   - First-order necessary conditions (KKT conditions):
     $$ \nabla_x L(x, z) = 2J(x)^T f(x) + \sum_{i=1}^p z_i \nabla g_i(x) = 0 $$
     $$ \nabla_z L(x, z) = g(x) = 0 $$
   - Where $J(x)$ is the Jacobian matrix of $f$ at $x$

3. **Geometric Interpretation**:
   - At the solution, the gradient of the objective function is a linear combination of the constraint gradients
   - The Lagrange multipliers represent the "weights" in this linear combination
   - The constraints define a manifold, and the solution occurs where the objective function's level curves are tangent to this manifold

## Solution Methods

1. **Direct KKT System**:
   - Solve the nonlinear system of equations formed by the KKT conditions
   - Can be approached using [[Nonlinear Equations]] solution methods

2. **Sequential Quadratic Programming (SQP)**:
   - Iteratively solve quadratic approximations of the original problem
   - Update Lagrange multipliers at each iteration
   - Effective for constrained nonlinear least squares

3. **Augmented Lagrangian Methods**:
   - Add penalty terms to the Lagrangian
   - Iteratively update the penalty parameters and Lagrange multipliers
   - Often more stable than direct KKT approaches

4. **Interior Point Methods**:
   - Transform inequality constraints into equality constraints using slack variables
   - Add barrier terms to prevent constraint violations
   - Update barrier parameters and Lagrange multipliers iteratively

## Properties of Lagrange Multipliers

1. **Sensitivity Interpretation**:
   - Lagrange multipliers represent the sensitivity of the optimal objective value to changes in the constraints
   - $z_i$ indicates how much the objective would improve if constraint $g_i$ were relaxed

2. **Dual Problem**:
   - Lagrange multipliers are the variables in the dual optimization problem
   - Strong duality holds under certain conditions (e.g., convexity)

3. **Constraint Qualification**:
   - Linear independence of constraint gradients ensures existence of Lagrange multipliers
   - Other constraint qualifications exist for more general cases

4. **Second-Order Conditions**:
   - For a minimum, the Hessian of the Lagrangian must be positive semidefinite on the tangent space of the constraints
