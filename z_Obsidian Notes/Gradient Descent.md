Gradient Descent is an iterative optimization algorithm for finding the minimum of a differentiable function. It's fundamental to many machine learning algorithms, particularly in training [[Neural Networks]] and optimizing loss functions.

### Mathematical Foundation

The update rule for parameters θ:

$$\theta_{t+1} = \theta_t - \alpha \nabla J(\theta_t)$$

where:
- $\theta_t$ is the parameter vector at iteration t
- $\alpha$ is the learning rate
- $\nabla J(\theta_t)$ is the gradient of the objective function
- $J(\theta)$ is the objective function to minimize

### Variants

1. **Batch Gradient Descent**
   - Uses entire dataset
   - Update rule: $\theta = \theta - \alpha \nabla_\theta J(\theta)$
   - Stable convergence
   - Computationally expensive

2. **Stochastic Gradient Descent (SGD)**
   - Uses single sample
   - Update rule: $\theta = \theta - \alpha \nabla_\theta J(\theta; x^{(i)}, y^{(i)})$
   - Faster iterations
   - Noisy updates

3. **Mini-batch Gradient Descent**
   - Uses batch size b samples
   - Balance between batch and SGD
   - Common in deep learning
   - Vectorization benefits

### Advanced Techniques

1. **Momentum**
   - Adds velocity term
   - $v_t = \beta v_{t-1} + \nabla J(\theta_t)$
   - $\theta_{t+1} = \theta_t - \alpha v_t$
   - Helps escape local minima

2. **Adam Optimizer**
   - Adaptive learning rates
   - Momentum and RMSprop combined
   - Bias correction
   - Default choice for deep learning

3. **Learning Rate Scheduling**
   - Decay schedules
   - Adaptive rates
   - Warm-up periods
   - Cyclical learning rates

### Practical Considerations

1. **Hyperparameter Tuning**
   - Learning rate selection
   - Batch size choice
   - Momentum parameters
   - Schedule design

2. **Convergence Issues**
   - Local minima
   - Saddle points
   - Vanishing gradients
   - Exploding gradients

Tags:
[[Stochastic Gradient Descent]]
