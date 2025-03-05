Multi-objective least squares extends the concept of [[Least Squares]] to problems where multiple competing objectives need to be simultaneously minimized. This approach is particularly useful in problems where different criteria need to be balanced against each other.

## Problem Formulation

1. **Objective Functions**:
   For $k$ different objectives:
   $$ J_i = \|A_ix - b_i\|^2, \quad i = 1,\ldots,k $$
   where:
   - $A_i$ is an $m_i \times n$ matrix
   - $b_i$ is an $m_i$-vector
   - $x$ is the $n$-vector we want to find

2. **Goal**:
   - Find $x$ that makes all objectives "small"
   - No single solution typically minimizes all objectives
   - Trade-offs between objectives must be considered

## Solution Approaches

1. **Weighted Sum Method**:
   $$ \min_x \sum_{i=1}^k w_i\|A_ix - b_i\|^2 $$
   - $w_i$ are non-negative weights
   - Different weights yield different trade-offs
   - Related to [[Ridge Regression]] when regularization is included

2. **Pareto Optimization**:
   - Solution $x$ is Pareto optimal if no objective can be improved
   - Without making at least one other objective worse
   - Forms a Pareto frontier of optimal solutions

3. **Constraint Method**:
   - Minimize one objective
   - Subject to constraints on others:
   $$ \begin{align*}
   \min_x & \quad \|A_1x - b_1\|^2 \\
   \text{subject to} & \quad \|A_ix - b_i\|^2 \leq \epsilon_i, \quad i = 2,\ldots,k
   \end{align*} $$

## Solution Methods

1. **Direct Methods**:
   - Normal equations for weighted sum
   - [[QR Factorization]] for stability
   - [[Pseudo-Inverse]] approaches

## Important Notes

- No unique "best" solution typically exists
- Choice of weights is problem-dependent
- Consider problem structure when choosing method
- Balance computational cost with solution quality
- Validate solutions across all objectives
- Consider robustness to parameter changes
