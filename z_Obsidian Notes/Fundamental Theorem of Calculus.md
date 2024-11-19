The high-level concept is that the [[Derivative]] of the [[Integral]] of a function is equal to the function. In some sense, the derivative "undoes" the integral and inverse operations.

If $f(x)$ is continuous over $[a, b]$, then the function $$g(x) = \int_{a}^{x} f(t) \, dt$$ is continuous on $[a, b]$ and differentiable on $(a, b)$, with $$g'(x) = f(x)$$ for $a \leq x \leq b$. 

This theorem shows that the derivative of the integral function $g(x)$ recovers the original function $f(x)$, connecting them directly.

Part 2 of this theorem shows that if $f$ is continuous on $[a, b]$, then $$\int_{a}^{b} f(x) \, dx = F(b) - F(a)$$ where $F$ is any [[Antiderivative]] of $f$, that is $F$ is any function such that $F' = f$.

At a high level, this means that the integral of the derivative is equal to the original function and that integrals can be computed by finding antiderivatives and evaluating them ($F(b) - F(a)$), instead of attempting to compute the Riemann Sum using the [[Riemann's Formula]].