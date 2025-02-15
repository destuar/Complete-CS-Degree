The product rule in calculus is a way to find the [[Derivative]] of a product of two functions. 

First take the derivative of the first function and multiply it by the second function (as it is). Then, take the first function (as it is) and multiply it by the derivative of the second function. Finally, add these two results together. This combined result is the derivative of the product of the two functions.
## Calculus:
$$\frac{d}{dx} [f(x) \cdot g(x)] = f(x) \cdot g'(x) + g(x) \cdot f'(x)$$

## Probability Theory:

The **General Product Rule** in probability theory provides a way to compute the probability of multiple events occurring sequentially by breaking them down into conditional probabilities.

For two events $A$ and $B$, the probability of both occurring is:

$$P(A \cap B) = P(A) P(B \mid A)$$

For three events $A$, $B$, and $C$:

$$P(A \cap B \cap C) = P(A) P(B \mid A) P(C \mid A \cap B)$$

More generally, for **$n$ events** $A_1, A_2, ..., A_n$​, the probability of all occurring is:

$$P(A_1 \cap A_2 \cap \dots \cap A_n) = P(A_1) P(A_2 \mid A_1) P(A_3 \mid A_1 \cap A_2) \dots P(A_n \mid A_1 \cap A_2 \cap \dots \cap A_{n-1})$$
Tags:
[[Conditional Probability]]