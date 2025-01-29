A **Taylor [[series]]** represents a sufficiently differentiable function $f(x)$ around a point $a$ as an infinite polynomial expansion:

$f(x) = \sum_{n=0}^{\infty} \frac{f^{(n)}(a)}{n!},(x - a)^{n}$.

Taylor series expansions are often used for approximating complex functions near a chosen point, which can simplify optimization, enable gradient-based methods to converge more efficiently, and provide local linear or higher-order approximations that underlie many machine learning algorithms.

- **Maclaurin Series**: A special case of the Taylor series when $a = 0$, i.e.  
    $f(x) = \sum_{n=0}^{\infty} \frac{f^{(n)}(0)}{n!},x^{n}$.

- **Radius (or Interval) of Convergence**: Each Taylor (or Maclaurin) series converges in some interval around $a$. The size of this interval depends on where the function stops being analytic (or ceases to satisfy the needed differentiability conditions).

- **Remainder Term**: Truncating a Taylor series after $N$ terms leaves an error known as the remainder. One common form is the Lagrange remainder:  
    $R_{N}(x) = \frac{f^{(N+1)}(\xi)}{(N+1)!},\bigl(x - a\bigr)^{N+1}$,  
    for some $\xi$ between $a$ and $x$. This tells us how accurate the partial sum is.

- **Common Taylor Expansions**:
    - $e^x = \sum_{n=0}^{\infty} \frac{x^{n}}{n!}$.
    - $\sin x = \sum_{n=0}^{\infty} \bigl(-1\bigr)^{n} \frac{x^{2n+1}}{(2n+1)!}$.
    - $\cos x = \sum_{n=0}^{\infty} \bigl(-1\bigr)^{n} \frac{x^{2n}}{(2n)!}$.
    - $\ln(1 + x) = \sum_{n=1}^{\infty} \bigl(-1\bigr)^{n+1} \frac{x^{n}}{n}$ for $|x| < 1$.
