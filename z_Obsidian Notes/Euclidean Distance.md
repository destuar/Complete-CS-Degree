Euclidean distance between two points (or vectors) $\mathbf{x}$ and $\mathbf{y}$ in $\mathbb{R}^n$ is defined as:

$$
d(\mathbf{x}, \mathbf{y}) \;=\; \|\mathbf{x} - \mathbf{y}\|_2 \;=\; \sqrt{(x_1 - y_1)^2 + (x_2 - y_2)^2 + \cdots + (x_n - y_n)^2}.
$$

- The [[Euclidean norm]] $\|\mathbf{v}\|_2$ of a vector $\mathbf{v}$ in $\mathbb{R}^n$ is its distance from the origin:
  $$
  \|\mathbf{v}\|_2 \;=\; \sqrt{v_1^2 + v_2^2 + \cdots + v_n^2}.
  $$
- The **Euclidean distance** between $\mathbf{x}$ and $\mathbf{y}$ is simply the norm of their difference, $\|\mathbf{x} - \mathbf{y}\|_2$.

### Geometric Interpretation

1. **Physical Distance**: In 2D or 3D, the Euclidean distance is the usual “straight-line” distance—like measuring the length of a ruler between two points.
2. **In $n$-Dimensions**: Generalizes this concept to higher dimensions, still capturing the *shortest path* between two vectors/points.

### Properties

1. **Non-Negativity**: $d(\mathbf{x}, \mathbf{y}) \ge 0$, and $d(\mathbf{x}, \mathbf{y}) = 0$ if and only if $\mathbf{x} = \mathbf{y}$.
2. **Symmetry**: $d(\mathbf{x}, \mathbf{y}) = d(\mathbf{y}, \mathbf{x})$.
3. **Triangle Inequality**: $d(\mathbf{x}, \mathbf{z}) \le d(\mathbf{x}, \mathbf{y}) + d(\mathbf{y}, \mathbf{z})$.

