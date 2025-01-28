### **1. Type 1: Infinite Limits of Integration**

When one or both limits of integration are infinite, the integral is called a **Type 1 improper [[integral]]**.

#### **Definition**

If a function $f(x)$ is defined on the interval $[a, \infty)$, the improper integral is:

$\int_a^\infty f(x) , dx = \lim_{b \to \infty} \int_a^b f(x) , dx$

If $f(x)$ is defined on $(-\infty, b]$, the improper integral is:

$\int_{-\infty}^b f(x) , dx = \lim_{a \to -\infty} \int_a^b f(x) , dx$

---

#### **Example**

Evaluate $\int_1^\infty \frac{1}{x^2} , dx$:

$\int_1^\infty \frac{1}{x^2} , dx = \lim_{b \to \infty} \int_1^b \frac{1}{x^2} , dx$

The antiderivative of $\frac{1}{x^2}$ is $-\frac{1}{x}$, so:

$\lim_{b \to \infty} \left[ -\frac{1}{x} \right]_1^b = \lim_{b \to \infty} \left( -\frac{1}{b} + \frac{1}{1} \right) = 1$

---

### **2. Type 2: Discontinuous Integrand**

When the function $f(x)$ has a discontinuity within the interval of integration, the integral is called a **Type 2 improper integral**.

#### **Definition**

If $f(x)$ is discontinuous at $x = c$, where $c \in [a, b]$, the improper integral is defined as:

$\int_a^b f(x) , dx = \lim_{c \to c^+} \int_a^c f(x) , dx + \lim_{c \to c^-} \int_c^b f(x) , dx$

---

#### **Example**

Evaluate $\int_0^1 \frac{1}{\sqrt{x}} , dx$:

$\int_0^1 \frac{1}{\sqrt{x}} , dx = \lim_{a \to 0^+} \int_a^1 \frac{1}{\sqrt{x}} , dx$

The antiderivative of $\frac{1}{\sqrt{x}}$ is $2\sqrt{x}$, so:

$\lim_{a \to 0^+} \left[ 2\sqrt{x} \right]_a^1 = \lim_{a \to 0^+} \left( 2\sqrt{1} - 2\sqrt{a} \right) = 2$