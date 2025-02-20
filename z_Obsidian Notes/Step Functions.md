**Step Functions** are piecewise constant functions that take discrete values over different intervals. They are fundamental in [[Non-Parametric Models]] and serve as building blocks for more complex functions.

### Mathematical Definition
A step function $s(x)$ can be written as:

$s(x) = \sum_{i=1}^n c_i \cdot I(a_i \leq x < b_i)$

where:
- $c_i$ are constants
- $I(\cdot)$ is the indicator function
- $[a_i, b_i)$ are intervals
- $n$ is the number of steps

### Properties
1. **Characteristics**
   - Discontinuous at jump points
   - Constant between jumps
   - Right-continuous or left-continuous
   - Finite number of discontinuities

2. **Integration**
   $\int_a^b s(x)dx = \sum_{i=1}^n c_i(b_i - a_i)$
   where intervals are within $[a,b]$

### Applications
1. **Statistics**
   - Empirical distribution functions
   - [[Survival Function]] estimation
   - [[Kaplan-Meier Curve]]
   - Histogram construction

2. **Signal Processing**
   - Quantization
   - Digital signals
   - Threshold detection

### Relationship to Other Functions
- Basis for [[Regression Splines]]
- Component of [[Generalized Additive Models]]
- Used in [[Survival Analysis]]
- Foundation for [[Local Regression]]

### Advantages and Limitations
**Advantages:**
- Simple to interpret
- Computationally efficient
- Non-parametric flexibility
- Exact integration

**Limitations:**
- Discontinuous
- Limited smoothness
- May overfit with too many steps
- Sensitive to interval choice

Tags:
[[Non-Parametric Models]]
