Pareto optimality is a fundamental concept in multi-objective optimization where no objective can be improved without degrading at least one other objective. This concept is particularly important in [[Multi-Objective Least Squares]] and other optimization problems with competing objectives.

## Key Concepts

1. **Definition**:
   - A solution $x$ is Pareto optimal if no feasible solution exists that:
     - Improves at least one objective
     - Without making any other objective worse
   - Mathematically, no point $z$ exists where:
   $$ J_i(z) < J_i(x) \text{ for all } i $$

2. **Bi-Criterion Case**:
   - Two competing objectives $J_1$ and $J_2$
   - For optimal solution $\hat{x}(\lambda)$:
   $$ \min_x \lambda J_1 + (1-\lambda)J_2, \quad \lambda \in [0,1] $$
   - Trade-off curve: $(J_1(\hat{x}(\lambda)), J_2(\hat{x}(\lambda)))$

## Properties

1. **Optimal Trade-off Curve**:
   - Represents all Pareto optimal solutions
   - Each point is optimal for some weighting
   - Convex for convex objective functions
   - Often called the Pareto frontier

2. **Dominance Relations**:
   - Solution $x$ dominates $y$ if:
     - $J_i(x) \leq J_i(y)$ for all $i$
     - $J_i(x) < J_i(y)$ for at least one $i$
   - Pareto optimal solutions are non-dominated

## Finding Pareto Optimal Solutions

1. **Weighted Sum Method**:
   $$ \min_x \sum_{i=1}^k w_i J_i(x), \quad w_i \geq 0 $$
   - Each weight vector yields a Pareto optimal point
   - Not all Pareto optimal points may be found
   - Common in [[Multiple Linear Regression]] with regularization

2. **ε-Constraint Method**:
   $$ \begin{align*}
   \min_x & \quad J_1(x) \\
   \text{subject to} & \quad J_i(x) \leq \epsilon_i, \quad i = 2,\ldots,k
   \end{align*} $$
   - Converts multi-objective to single-objective
   - Can find non-convex Pareto optimal points

## Important Properties

1. **Existence**:
   - At least one Pareto optimal solution exists
   - Usually infinitely many solutions
   - Forms a continuous curve in bi-criterion case

2. **Convexity**:
   - Pareto frontier is convex if objectives are convex
   - Simplifies computation and analysis
   - Important for optimization algorithms

## Important Notes

- No single "best" solution exists
- Choice depends on preference between objectives
- All Pareto optimal solutions are candidates
- Trade-offs must be evaluated in context
- Consider robustness of solutions
- Visualization helpful for two objectives
- Higher dimensions require careful analysis
