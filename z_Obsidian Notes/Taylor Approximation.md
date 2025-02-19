Taylor approximation (or Taylor expansion) is a way to approximate a (sufficiently smooth) function $f(x)$ around a specific point, usually denoted $a$. In its simplest form, the *Taylor polynomial of degree $n$* is:

$$
f(x) \approx f(a) \;+\; f'(a)\,(x - a) \;+\; \frac{f''(a)}{2!}\,(x - a)^2 \;+\; \cdots \;+\; \frac{f^{(n)}(a)}{n!}\,(x - a)^n.
$$

This polynomial can provide a local approximation to $f(x)$ near $x = a$.

1. **Local Behavior**: The function $f$ is approximated by matching *all derivatives up to order $n$* at the point $x = a$.  
2. **Polynomials**: Because polynomials are simpler to evaluate and differentiate, the Taylor polynomial can be used for numerical approximations, series expansions, or analysis of functions.

![[Taylor Approx Image.png]]