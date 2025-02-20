Kernel Regression is a non-parametric technique that uses kernel functions to estimate the conditional expectation of a random variable. It's a flexible approach that can capture non-linear relationships in data.

### Mathematical Foundation
The Nadaraya-Watson estimator:

$$\hat{m}(x) = \frac{\sum_{i=1}^n K_h(x - x_i)y_i}{\sum_{i=1}^n K_h(x - x_i)}$$

where:
- $K_h(u) = \frac{1}{h}K(\frac{u}{h})$ is the scaled kernel
- $h$ is the bandwidth parameter
- $(x_i, y_i)$ are training data points
- $K(·)$ is the kernel function

### Common Kernel Functions
1. **Gaussian Kernel**
   $$K(u) = \frac{1}{\sqrt{2\pi}}e^{-\frac{u^2}{2}}$$
   - Smooth estimates
   - Infinite support
   - Most commonly used

2. **Epanechnikov Kernel**
   $$K(u) = \frac{3}{4}(1-u^2)1_{|u|\leq 1}$$
   - Optimal in mean squared error
   - Finite support
   - Computationally efficient

3. **Uniform Kernel**
   $$K(u) = \frac{1}{2}1_{|u|\leq 1}$$
   - Simplest form
   - Local averaging
   - Box smoothing

### Bandwidth Selection
1. **Cross-Validation**
   - Leave-one-out CV
   - K-fold CV
   - Minimize prediction error
   - [[Cross-Validation]]

2. **Rule of Thumb**
   - Silverman's rule
   - Scott's rule
   - Data-driven approaches
   - Quick approximations

### Properties
1. **Advantages**
   - Non-parametric flexibility
   - No functional form assumptions
   - Local adaptivity
   - Interpretable

2. **Limitations**
   - [[Curse of Dimensionality]]
   - Computational complexity
   - Boundary effects
   - Bandwidth sensitivity
