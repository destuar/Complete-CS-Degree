**Integration by parts** is a method used to solve integrals involving a product of functions. It simplifies complex [[integral]]s by reducing them into simpler components. The formula is:

$\int u , dv = uv - \int v , du$

Integration by parts is directly used in data science to derive properties of probability density functions (e.g., moments, expected values) and to solve integrals in Bayesian inference, such as calculating posterior distributions. It also appears in signal processing for deriving Fourier transforms, which are essential in analyzing time-series data and speech recognition models.

1. Identify the two components:
    
    - $u$: A function that simplifies when differentiated.
    - $dv$: A function that is easy to integrate.
2. Compute:
    
    - $du = \frac{du}{dx} , dx$
    - $v = \int dv$
3. Substitute into the formula: $\int u , dv = uv - \int v , du$

---

### **Example**

Evaluate $\int x e^x , dx$:

1. Let $u = x$, so $du = dx$.
2. Let $dv = e^x dx$, so $v = e^x$.
3. Apply the formula: $\int x e^x , dx = x e^x - \int e^x , dx$
4. Solve: $\int x e^x , dx = x e^x - e^x + C$