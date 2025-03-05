The Levenberg-Marquardt Algorithm is a robust optimization method for solving nonlinear least squares problems, combining the advantages of gradient descent and Gauss-Newton methods to efficiently find solutions even with poor initial estimates.

## Basic Idea

- Minimizes the sum of squared residuals: $\|f(x)\|^2$
- At any point $z$ we can form the affine approximation:
  $$ \hat{f}(x; z) = f(z) + Df(z)(x - z) $$
- $\hat{f}(x; z) \approx f(x)$ provided $x$ is near $z$
- We can minimize $\|\hat{f}(x; z)\|^2$ using [[Least Squares]]
- We iterate, with $z$ being the current iterate

## Algorithm Formulation

1. **Damped Gauss-Newton Update**:
   - Iteration: $x_{k+1} = x_k - (J(x_k)^T J(x_k) + \lambda_k I)^{-1} J(x_k)^T f(x_k)$
   - Where:
     - $J(x_k)$ is the Jacobian matrix at $x_k$
     - $\lambda_k$ is the damping parameter
     - $I$ is the identity matrix

2. **Damping Parameter Adjustment**:
   - If the iteration reduces the error, decrease $\lambda$ (more Gauss-Newton-like)
   - If the iteration increases the error, increase $\lambda$ (more gradient descent-like)
   - Typical update: multiply or divide $\lambda$ by a factor (e.g., 10)

3. **Interpolation Between Methods**:
   - When $\lambda \to 0$: Behaves like Gauss-Newton method
   - When $\lambda \to \infty$: Behaves like gradient descent with small step size
   - Automatically adjusts based on progress

## Implementation Considerations

1. **Initialization**:
   - Starting point $x_0$ should be reasonable estimate
   - Initial damping parameter $\lambda_0$ often set to 0.001-0.1
   - Scaling of variables may improve performance

2. **Termination Criteria**:
   - Small gradient: $\|J(x_k)^T f(x_k)\| < \epsilon_1$
   - Small parameter change: $\|x_{k+1} - x_k\| < \epsilon_2$
   - Small residual: $\|f(x_k)\| < \epsilon_3$
   - Maximum iterations reached

3. **Numerical Stability**:
   - Use QR decomposition or SVD for solving linear system
   - Consider variable scaling
   - Implement careful update of damping parameter

## Advantages and Limitations

1. **Advantages**:
   - Robust to poor initial guesses
   - Fast convergence near solution
   - Self-adapting between exploration and exploitation
   - Works well for many practical problems

2. **Limitations**:
   - Requires Jacobian computation (expensive for large problems)
   - May converge to local minima
   - Memory intensive for large problems
   - Parameter $\lambda$ requires careful tuning
