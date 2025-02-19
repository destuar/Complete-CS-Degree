Affine function refers to a function that is *linear* up to an added constant term. Concretely, for vectors $\mathbf{x}$ in a vector space (e.g., $\mathbb{R}^n$), an affine function $f$ can be written as: $$ f(\mathbf{x}) = A\,\mathbf{x} + \mathbf{b}, $$ where $A$ is a (linear) transformation (often represented by a matrix) and $\mathbf{b}$ is a fixed “offset” or “translation” [[vector]]. 

![[Affine Function Image.png]]
### Affine vs. Linear 

**Linear Function**: A function $g$ is linear if $g(\mathbf{x}) = A\,\mathbf{x}$ (no constant term). 

**Affine Function**: Has an *extra* constant term $\mathbf{b}$, which “shifts” the linear function. If $\mathbf{b} = \mathbf{0}$, then $f$ reduces to a linear function. 

**1D Case**: For real numbers, $f(x) = 2x + 3$ is affine; if it had no “$+3$” term, it would be linear. 

**Matrix Form**: In $\mathbb{R}^2$, $f(\mathbf{x}) = A\mathbf{x} + \mathbf{b}$ could look like $$ \begin{pmatrix} y_1 \\ y_2 \end{pmatrix} = \begin{pmatrix} 1 & -1 \\ 2 & 1 \end{pmatrix} \begin{pmatrix} x_1 \\ x_2 \end{pmatrix} + \begin{pmatrix} 3 \\ -1 \end{pmatrix}. $$
### Geometric Interpretation

**Translation + Linear Transformation**: An affine map can be seen as first applying a linear transformation (stretching, rotating, etc.) and then translating by $\mathbf{b}$. 

**Preserves Parallelism**: One key property: affine functions preserve straight lines and parallelism. If two lines are parallel before applying an affine map, they remain parallel after.