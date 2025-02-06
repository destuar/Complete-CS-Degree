Euclid's algorithm is a method for finding the **greatest common divisor (GCD)** of two integers. The GCD of two numbers $a$ and $b$ is the largest number that divides both $a$ and $b$ without leaving a remainder.

---

 **The Algorithm**

The algorithm is based on the principle:

$$ \gcd(a, b) = \gcd(b, a \mod b) $$

until $b = 0$, at which point:

$$ \gcd(a, 0) = a $$

---

 **Steps of the Algorithm**

1. **Base Case**: If $b = 0$, the algorithm returns $a$ as the GCD.
2. **Recursive Step**: Replace $a$ with $b$ and $b$ with $a \mod b$, then repeat.

---

 **Example Calculation**

Find the GCD of $252$ and $105$:

1. Compute $\gcd(252, 105)$:
    
    $$252\mod 105 = 42$$
    
    so: $$ \gcd(252, 105) = \gcd(105, 42) $$
    
2. Compute $\gcd(105, 42)$:
    
     $$105\mod 42 = 21$$
    
    so: $$ \gcd(105, 42) = \gcd(42, 21) $$
    
3. Compute $\gcd(42, 21)$:
    
	 $$42\mod 21 = 0$$
    
    so: $$ \gcd(42, 21) = 21 $$
    

Thus, the GCD of $252$ and $105$ is $$21$$
Tags:
[[Recursion]]
[[Number Theory]]