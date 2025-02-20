**Neural Networks** are flexible non-linear models inspired by biological neural systems. They learn hierarchical representations of data through multiple layers of interconnected nodes, each applying non-linear transformations.

### Mathematical Framework

1. **Single Layer**
   Output for one neuron:
   $z = f(\mathbf{w}^T\mathbf{x} + b)$

   where:
   - f is activation function
   - w is weight vector
   - b is bias term

2. **Multi-Layer Network**
   Layer l output:
   $\mathbf{z}^{(l)} = f(\mathbf{W}^{(l)}\mathbf{a}^{(l-1)} + \mathbf{b}^{(l)})$

   where:
   - $\mathbf{a}^{(l-1)}$ is previous layer activation
   - $\mathbf{W}^{(l)}$ is weight matrix
   - $\mathbf{b}^{(l)}$ is bias vector

### Activation Functions

1. **Common Choices**
   - ReLU: $f(x) = \max(0,x)$
   - Sigmoid: $f(x) = \frac{1}{1+e^{-x}}$
   - Tanh: $f(x) = \tanh(x)$
   - Softmax: $f_i(\mathbf{x}) = \frac{e^{x_i}}{\sum_j e^{x_j}}$

2. **Properties**
   - Non-linearity
   - Differentiability
   - Range constraints
   - Gradient behavior

### Training Process

1. **Forward Propagation**
   - Input → Hidden layers → Output
   - Compute activations sequentially
   - Generate predictions

2. **Backpropagation**
   - Compute gradients using chain rule
   - Update weights and biases
   - Minimize loss function

### Loss Functions

1. **Regression**
   - MSE: $\frac{1}{n}\sum_{i=1}^n (y_i - \hat{y}_i)^2$
   - MAE: $\frac{1}{n}\sum_{i=1}^n |y_i - \hat{y}_i|$

2. **Classification**
   - Cross-entropy: $-\sum_{i=1}^n \sum_{k=1}^K y_{ik}\log(\hat{p}_{ik})$
   - Binary cross-entropy: $-\sum_{i=1}^n [y_i\log(\hat{p}_i) + (1-y_i)\log(1-\hat{p}_i)]$

### Optimization

1. **Gradient Descent Variants**
   - Stochastic GD
   - Mini-batch GD
   - Adam, RMSprop, etc.

2. **Regularization**
   - Dropout
   - L1/L2 penalties
   - Early stopping
   - Batch normalization

### Architecture Design

1. **Layer Types**
   - Dense (fully connected)
   - Convolutional
   - Recurrent
   - Attention

2. **Hyperparameters**
   - Number of layers
   - Neurons per layer
   - Learning rate
   - Batch size

### Advantages
- Universal approximation
- Automatic feature learning
- Handles complex patterns
- Scalable to large datasets
- Flexible architecture

### Limitations
- Requires large data
- Computationally intensive
- Many hyperparameters
- Black box nature
- Prone to overfitting

### Applications
- Image recognition
- Natural language processing
- Time series prediction
- Reinforcement learning
- Generative modeling

### Diagnostics
- Learning curves
- Validation metrics
- Gradient norms
- Layer activations
- Weight distributions

Tags:
[[Deep Learning]]