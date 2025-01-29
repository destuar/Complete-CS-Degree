*Power [[series]] expansions are crucial for efficiently approximating and computing complex functions, which underlie optimization algorithms, machine learning models, and large-scale simulations.*

A **power series** is an infinite series of the form  $\sum_{n=0}^{\infty} c_{n}\bigl(x - a\bigr)^{n}$,  where $a$ is the **center** of the series and $c_{n}$ are real or complex coefficients. Power series are central to many topics in calculus and analysis because they allow functions to be expressed as infinite polynomials.

- **Radius of Convergence**
    - There is a distance $R$ from $a$ (called the **radius of convergence**) within which the series converges absolutely.
    - Outside the interval $|x - a| > R$, the series diverges.
    - On the boundary $|x - a| = R$, the series may converge or diverge depending on the specific function and coefficients.

- **Interval of Convergence**
    - For real $x$, the **interval of convergence** is the set of $x$ values for which the series converges.
    - It is typically expressed as $\bigl(a - R,, a + R\bigr)$ or a variant that may include the endpoints if the series converges there.

- **Representation of Functions**
    - Many elementary and advanced functions can be written as power series in a neighborhood around a certain point.
    - For instance, a **Taylor series** is a special type of power series where $c_{n} = \frac{f^{(n)}(a)}{n!}$ for some function $f$.
    - Power series expansions are used to approximate functions, often making them easier to integrate, differentiate, or evaluate numerically.

- **Uniform Convergence**
    - Within the open interval of convergence (i.e., where $|x - a| < R$), a power series converges uniformly on any closed sub-interval strictly inside its radius of convergence.
    - Uniform convergence is important because it allows term-by-term differentiation and integration.

Tags:
[[Convergence & Divergence]]