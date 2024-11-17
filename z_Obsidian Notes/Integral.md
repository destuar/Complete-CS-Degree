Conceptually, the idea that "adding up tiny slopes gives you the area" comes from a concept called **accumulating change** and is how an integral is calculated.
### What Is a Tiny Slope?
A "tiny slope" here means looking at the rate of change of a function at very small intervals. When we talk about the "slope" of $f(x)$ over a tiny interval, we’re really talking about how $f(x)$ changes at a specific point, which is the [[Derivative]] $f'(x)$.
### Connecting Slopes and Area
Instead of thinking of "slope" directly, each tiny part of $f(x)$ is a very thin rectangle. The height of this rectangle at a small point $x$ is $f(x)$, and its width is an infinitesimally small change in $x$, written as $dx$.

The area of each tiny rectangle is therefore:$$
f(x) \cdot dx
$$
### Adding Up All the Tiny Rectangles
By adding up (integrating) these infinitely thin rectangles from point $a$ to $b$, we get an approximation of the total area under $f(x)$ over that interval. As the width of these rectangles gets smaller and smaller, this sum becomes an exact area. This can be done with the [[Riemann's Formula]].

Mathematically, this sum of tiny rectangles is represented as:$$
\int_a^b f(x) \, dx
$$This is the **definite integral** of $f(x)$ from $a$ to $b$, which gives the exact area under $f(x)$ between those points.