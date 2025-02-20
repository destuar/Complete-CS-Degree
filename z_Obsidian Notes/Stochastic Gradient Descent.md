**Stochastic Gradient Descent** (SGD) is an optimization algorithm that estimates the gradient using a single randomly selected data point at each iteration, making it computationally efficient for large-scale machine learning problems.

### Mathematical Framework
For objective function $f(\theta)$ with parameters $\theta$:

$\theta_{t+1} = \theta_t - \eta_t \nabla f_i(\theta_t)$

where:
- $\theta_t$ is the parameter at iteration t
- $\eta_t$ is the learning rate
- $f_i$ is the loss for a single random sample i
- $\nabla f_i$ is the gradient of the loss

### Key Properties
1. **Convergence**
   - Noisy but faster iterations
   - Requires decreasing learning rate
   - $\eta_t \propto \frac{1}{\sqrt{t}}$ or $\frac{1}{t}$

2. **Variants**
   - Mini-batch SGD
   - Momentum SGD
   - Adam optimizer
   - RMSprop

### Advantages
- Lower memory requirements
- Faster iterations
- Can escape local minima
- Online learning capability
- Suitable for large datasets

### Challenges
- Noisy gradient estimates
- Learning rate tuning
- Non-deterministic behavior
- Requires careful monitoring
### Implementation Considerations
- Shuffling data
- Batch size selection
- Learning rate schedules
- Convergence criteria
- Regularization

Tags:
[[Neural Networks]]
