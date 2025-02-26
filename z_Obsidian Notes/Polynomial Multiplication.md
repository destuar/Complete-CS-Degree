Polynomial multiplication is a fundamental algebraic operation that computes the product of two polynomials, resulting in a new polynomial whose degree is the sum of the degrees of the original polynomials. This operation has deep connections to [[Convolution]] and appears in various computational applications.

## Definition

Given two polynomials:

$$p(x) = a_1 + a_2x + \cdots + a_nx^{n-1}$$
$$q(x) = b_1 + b_2x + \cdots + b_mx^{m-1}$$

The product polynomial $p(x)q(x)$ is defined as:

$$p(x)q(x) = c_1 + c_2x + \cdots + c_{n+m-1}x^{n+m-2}$$

Where the coefficients $c_k$ are determined by the [[Convolution]] of the coefficient vectors $\mathbf{a}$ and $\mathbf{b}$:

$$c_k = \sum_{i+j=k+1} a_i b_j, \quad k = 1, \ldots, n + m - 1$$

This means that $\mathbf{c} = \mathbf{a} * \mathbf{b}$, where $*$ denotes the convolution operation.

## Properties

The connection between polynomial multiplication and convolution provides simple proofs for many properties:

1. Commutativity: $\mathbf{a} * \mathbf{b} = \mathbf{b} * \mathbf{a}$, which corresponds to $p(x)q(x) = q(x)p(x)$
2. Distributivity: $(\mathbf{a} + \mathbf{b}) * \mathbf{c} = \mathbf{a} * \mathbf{c} + \mathbf{b} * \mathbf{c}$, which corresponds to $(p(x) + q(x))r(x) = p(x)r(x) + q(x)r(x)$
3. Zero product: $\mathbf{a} * \mathbf{b} = \mathbf{0}$ only if $\mathbf{a} = \mathbf{0}$ or $\mathbf{b} = \mathbf{0}$, which corresponds to the fact that $p(x)q(x) = 0$ only if $p(x) = 0$ or $q(x) = 0$

## Computational Aspects

The naive approach to polynomial multiplication requires $O(nm)$ operations, where $n$ and $m$ are the degrees of the polynomials. However, more efficient algorithms exist:

1. **Fast Fourier Transform (FFT)**: Reduces the complexity to $O((n+m)\log(n+m))$ by transforming the polynomials to the frequency domain, multiplying pointwise, and transforming back.

2. **Karatsuba algorithm**: A divide-and-conquer approach with complexity $O(n^{\log_2 3}) \approx O(n^{1.585})$.

The connection between polynomial multiplication and [[Convolution]] provides a powerful framework for understanding both operations and developing efficient algorithms for their computation.
