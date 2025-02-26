Convolution is a fundamental mathematical operation that combines two sequences to produce a third sequence, representing how the shape of one is modified by the other. It has widespread applications in signal processing, image analysis, and machine learning.

## Definition

For an $n$-vector $\mathbf{a}$ and an $m$-vector $\mathbf{b}$, the convolution $\mathbf{c} = \mathbf{a} * \mathbf{b}$ is the $(n + m - 1)$-vector defined by:

$$c_k = \sum_{i+j=k+1} a_i b_j, \quad k = 1, \ldots, n + m - 1$$

This operation is often denoted with an asterisk: $\mathbf{c} = \mathbf{a} * \mathbf{b}$.

## Example Calculation

For example, with $n = 4$ and $m = 3$, the convolution produces a vector of length 6:

$$c_1 = a_1b_1$$
$$c_2 = a_1b_2 + a_2b_1$$
$$c_3 = a_1b_3 + a_2b_2 + a_3b_1$$
$$c_4 = a_2b_3 + a_3b_2 + a_4b_1$$
$$c_5 = a_3b_3 + a_4b_2$$
$$c_6 = a_4b_3$$

## Numerical Example

Consider the vectors $(1, 0, -1)$ and $(2, 1, -1)$:

$$(1, 0, -1) * (2, 1, -1) = (2, 1, -3, -1, 1)$$

The calculation proceeds as follows:
- $c_1 = 1 \cdot 2 = 2$
- $c_2 = 1 \cdot 1 + 0 \cdot 2 = 1$
- $c_3 = 1 \cdot (-1) + 0 \cdot 1 + (-1) \cdot 2 = -3$
- $c_4 = 0 \cdot (-1) + (-1) \cdot 1 = -1$
- $c_5 = (-1) \cdot (-1) = 1$

## Properties

- Convolution is commutative: $\mathbf{a} * \mathbf{b} = \mathbf{b} * \mathbf{a}$
- Convolution is associative: $(\mathbf{a} * \mathbf{b}) * \mathbf{c} = \mathbf{a} * (\mathbf{b} * \mathbf{c})$
- Convolution is distributive over addition: $\mathbf{a} * (\mathbf{b} + \mathbf{c}) = \mathbf{a} * \mathbf{b} + \mathbf{a} * \mathbf{c}$

## Applications

Convolution is widely used in:
- [[Polynomial Multiplication]]: The coefficients of the product of two polynomials are given by the convolution of their coefficient vectors
- Signal processing for filtering and feature extraction
- Image processing for blurring, sharpening, and edge detection
- [[Convolutional Neural Networks]] for feature learning
- [[Probability Theory]] for calculating distributions of sums of random variables
- Differential equations for solving initial value problems

The discrete convolution operation forms the backbone of many algorithms in computer vision and machine learning, where it enables efficient pattern recognition and feature extraction.
