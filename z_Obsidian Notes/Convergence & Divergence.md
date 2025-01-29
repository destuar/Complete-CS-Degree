
*Determining whether a series $\sum a_{n}$ converges is critical for ensuring that iterative algorithms and infinite expansions in models yield stable, reliable results rather than diverging and producing meaningless outputs.*

**Convergence and Divergence of Series**
**Definition**: A [[series]] $\sum_{n=1}^{\infty} a_{n}$ **converges** if its sequence of **partial sums**  $\displaystyle S_{N} = \sum_{n=1}^{N} a_{n}$ approaches a finite limit as $N$ goes to infinity. Otherwise, the series **diverges**.

- **$n$th-Term Test**: If $\lim_{n \to \infty} a_{n} \neq 0$, then the series $\sum_{n=1}^{\infty} a_{n}$ **diverges**.  
    (Note that $\lim_{n \to \infty} a_{n} = 0$ **does not** guarantee convergence; it is only a necessary condition.)

- **Comparison Test**:
    - **Direct Comparison**: If $0 \leq a_{n} \leq b_{n}$ for large $n$, then
        - If $\sum b_{n}$ converges, so does $\sum a_{n}$.
        - If $\sum a_{n}$ diverges, so does $\sum b_{n}$.
    - **Limit Comparison**: If $a_{n} > 0$ and $b_{n} > 0$ for large $n$, and  
        $\displaystyle \lim_{n \to \infty} \frac{a_{n}}{b_{n}} = c$, where $c$ is a finite positive number, then $\sum a_{n}$ and $\sum b_{n}$ either both converge or both diverge.

- **[[Integral]] Test**: If $a_{n} = f(n)$ for some positive, continuous, and decreasing function $f(x)$, then the series $\sum_{n=1}^{\infty} a_{n}$  converges or diverges **together** with the improper integral $$\displaystyle \int_{1}^{\infty} f(x)\, dx$$
- **$p$-Series**: The series $\sum_{n=1}^{\infty} \frac{1}{n^{p}}$ converges if $p > 1$ and diverges otherwise. This is a direct application of the integral test and is often used for comparison with other series.

- **Ratio Test**: For a series $\sum_{n=1}^{\infty} a_{n}$, define $\displaystyle L = \lim_{n \to \infty} \left|\frac{a_{n+1}}{a_{n}}\right|$
    
    - If $L < 1$, the series **converges absolutely**.
    - If $L > 1$, the series **diverges**.
    - If $L = 1$, the test is **inconclusive**.

- **Root Test**: For a series $\sum_{n=1}^{\infty} a_{n}$, define $\displaystyle L = \lim_{n \to \infty} \sqrt[n]{\bigl|a_{n}\bigr|}$.
    
    - If $L < 1$, the series **converges absolutely**.
    - If $L > 1$, the series **diverges**.
    - If $L = 1$, the test is **inconclusive**.

- **Alternating Series Test (Leibniz Test)**: For a series of the form  
    $\sum_{n=1}^{\infty} (-1)^{n} b_{n}$  (or with $\pm$ signs in an alternating pattern), if $b_{n}$ is **non-increasing** and  
    $\displaystyle \lim_{n \to \infty} b_{n} = 0$, then the series **converges**.

- **Absolute vs. Conditional Convergence**:
    - A series $\sum a_{n}$ is **absolutely convergent** if $\sum |a_{n}|$ converges.
    - If $\sum a_{n}$ converges but $\sum |a_{n}|$ diverges, then $\sum a_{n}$ is said to be **conditionally convergent**.