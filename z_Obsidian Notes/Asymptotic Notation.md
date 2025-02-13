Describes the **growth rate** of functions, commonly used in **algorithm analysis** to classify the efficiency of an algorithm as input size **$n$** increases. 

It provides a way to compare algorithms without focusing on hardware or specific implementation details.

**1. Common Asymptotic Notations**

1. **[[Big O-Notation]] ($O$)**
    - **Upper bound**: Describes the worst-case growth rate.
    - Example:  
        $f(n)=O(g(n))$  
        means that $f(n)$ grows at most as fast as $g(n)$ for large $n$.
    - **Example Complexity Classes:**
        - $O(1)$ → Constant time
        - $O(\log n)$ → Logarithmic time
        - $O(n)$ → Linear time
        - $O(n^2)$ → Quadratic time

2. **[[Big Omega-Notation]] ($\Omega$)**
    - **Lower bound**: Describes the best-case growth rate.
    - Example:  
        $f(n)=Ω(g(n))$  
        means that $f(n)$ grows at least as fast as $g(n)$ for large $n$.

3. **[[Big Theta-Notation]] ($\Theta$)**
    - **Tight bound**: When $f(n)$ grows at the same rate as $g(n)$.
    - Example:  
        $f(n) = \Theta(g(n))$
        means that $f(n)$ is both $O(g(n))$ and $\Omega(g(n))$.