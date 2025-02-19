Inner product is a function that takes in two [[vector]]s from a vector space (usually over the real or complex numbers) and returns a [[scalar]], while satisfying certain properties that generalize the concept of the dot product in $\mathbb{R}^n$.

---

### Definition (Real Vector Spaces)

Let $V$ be a real vector space. An **inner product** on $V$ is a function $\langle \cdot,\cdot \rangle : V \times V \rightarrow \mathbb{R}$ such that for all vectors $\mathbf{u}, \mathbf{v}, \mathbf{w} \in V$ and any scalar $a \in \mathbb{R}$:

1. **Positivity**: $\langle \mathbf{v}, \mathbf{v} \rangle \ge 0$ for all $\mathbf{v}$, and $\langle \mathbf{v}, \mathbf{v} \rangle = 0$ if and only if $\mathbf{v} = \mathbf{0}.$
2. **Linearity (in the first argument)**:
   - $\langle \mathbf{u} + \mathbf{v}, \mathbf{w} \rangle = \langle \mathbf{u}, \mathbf{w} \rangle + \langle \mathbf{v}, \mathbf{w} \rangle.$
   - $\langle a\,\mathbf{u}, \mathbf{v} \rangle = a\,\langle \mathbf{u}, \mathbf{v} \rangle.$
3. **Symmetry**: $\langle \mathbf{u}, \mathbf{v} \rangle = \langle \mathbf{v}, \mathbf{u} \rangle.$

For complex vector spaces, the property of symmetry is replaced by **conjugate symmetry**, and linearity typically applies to the second argument instead (or the first, depending on convention), with the other argument being **conjugate-linear**.

- **Dot Product** (Standard Inner Product in $\mathbb{R}^n$): 
  If $\mathbf{u} = (u_1, u_2, \ldots, u_n)$ and $\mathbf{v} = (v_1, v_2, \ldots, v_n)$, then
  $\langle \mathbf{u}, \mathbf{v} \rangle = u_1 v_1 + u_2 v_2 + \cdots + u_n v_n.$

- **Complex Inner Product** (Standard in $\mathbb{C}^n$):
  $\langle \mathbf{u}, \mathbf{v} \rangle = \sum_{j=1}^{n} u_j \,\overline{v_j},$
  where $\overline{v_j}$ denotes the complex conjugate of $v_j.$

### Geometric Interpretation

**Angle & Orthogonality**: In real vector spaces, the inner product can be used to define the angle between two vectors:$$\cos(\theta) = \frac{\langle \mathbf{u}, \mathbf{v} \rangle}{\|\mathbf{u}\|\|\mathbf{v}\|},$$which generalizes the idea of perpendicular vectors (orthogonality) if their inner product is zero.

**Length**: The length (or norm) of a vector $\mathbf{v}$ can be defined using the inner product as:
   $\|\mathbf{v}\| = \sqrt{\langle \mathbf{v}, \mathbf{v} \rangle}.$
