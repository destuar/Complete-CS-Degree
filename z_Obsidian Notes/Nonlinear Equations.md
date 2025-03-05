Nonlinear Equations represent systems of equations where the unknown variables appear in non-linear forms. These systems are fundamental in modeling complex phenomena across various domains where linear approximations are insufficient.

## Basic Definition

- A set of $m$ nonlinear equations in $n$ unknowns $x_1, \ldots, x_n$:
  $$ f_i(x_1, \ldots, x_n) = 0, \quad i = 1, \ldots, m $$

- $f_i(x) = 0$ is the $i$th equation; $f_i(x)$ is the $i$th residual

- $n$-vector of unknowns $x = (x_1, \ldots, x_n)$

- Can be written as vector equation $f(x) = 0$ where $f: \mathbb{R}^n \to \mathbb{R}^m$:
  $$ f(x) = (f_1(x), \ldots, f_m(x)) $$

- When $f$ is affine (i.e., $f(x) = Ax + b$), reduces to a set of $m$ linear equations

- System classification:
  - Over-determined if $m > n$
  - Under-determined if $m < n$
  - Square if $m = n$

## Solution Methods

1. **Newton's Method**:
   - Iterative approach: $x_{k+1} = x_k - J(x_k)^{-1}f(x_k)$
   - Where $J(x)$ is the Jacobian matrix of $f$ at $x$
   - Requires good initial guess
   - Quadratic convergence near solution

2. **Gauss-Newton Method**:
   - For nonlinear least squares problems
   - Minimizes $\|f(x)\|^2$ when no exact solution exists
   - Iteration: $x_{k+1} = x_k - (J(x_k)^T J(x_k))^{-1} J(x_k)^T f(x_k)$
   - Connection to [[Least Squares]]

3. **Fixed-Point Iteration**:
   - Rewrite as $x = g(x)$
   - Iterate $x_{k+1} = g(x_k)$
   - Converges if $g$ is a contraction mapping

4. **[[Gradient Descent]]**:
   - For minimizing $\|f(x)\|^2$
   - Iteration: $x_{k+1} = x_k - \alpha \nabla \|f(x_k)\|^2$
   - Where $\alpha$ is step size

## Challenges and Properties

1. **Existence and Uniqueness**:
   - Solutions may not exist
   - Multiple solutions may exist
   - Implicit Function Theorem provides conditions for local existence

2. **Convergence Issues**:
   - Sensitive to initial conditions
   - May converge to local minima
   - May diverge or oscillate

3. **Linearization**:
   - Local approximation: $f(x + \Delta x) \approx f(x) + J(x)\Delta x$
   - Basis for Newton-type methods
   - Connection to [[Constrained Least Squares]] when linearized

4. **Conditioning**:
   - Sensitivity to perturbations in input
   - Measured by condition number of Jacobian
   - Ill-conditioning leads to numerical instability

## Numerical Considerations

1. **Stopping Criteria**:
   - $\|f(x_k)\| < \epsilon$ (residual small)
   - $\|x_{k+1} - x_k\| < \delta$ (solution not changing)
   - Maximum iterations reached

2. **Globalization Strategies**:
   - Line search methods
   - Trust region methods
   - Continuation/homotopy methods

3. **Handling Singularities**:
   - Regularization techniques
   - Connection to [[Regularized Inversion]]
   - Pseudo-inverse approaches
