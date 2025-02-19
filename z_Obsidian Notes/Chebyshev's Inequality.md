**Chebyshev’s Inequality** states that for a [[random variable]] $X$ with mean $\mu$ and variance $\sigma^2$ (so $\sigma$ is the [[standard deviation]]), for any real $k > 0$: $$ \Pr\bigl(\,\lvert X - \mu \rvert \,\geq\, k\,\sigma \bigr) \;\le\; \frac{1}{k^2}. $$ Equivalently, $$ \Pr\bigl(\,\lvert X - \mu \rvert \,<\; k\,\sigma \bigr) \;\ge\; 1 - \frac{1}{k^2}. $$
![[Chebyshev Inequality Image.png]]
**Bounds Deviations from the Mean**: 
- Chebyshev’s inequality gives a *general* bound on how likely (or unlikely) it is for a random variable to deviate from its mean by more than $k$ standard deviations. 

**No Distributional Assumptions**: 
- Unlike the empirical rule (which relies on normality), Chebyshev’s holds for *any* distribution, as long as the mean and variance are defined. 

**Conservative Bound**: 
- Often yields a *looser* bound compared to the normal-based rules (e.g., the 68-95-99.7 rule), but it’s universally applicable.

Tags:
[[Chebyshev's Theorem]]