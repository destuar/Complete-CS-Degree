**Backpropagation** is an algorithm for efficiently computing gradients in [[Neural Networks]] through recursive application of the chain rule. It enables gradient-based optimization of network parameters.

### Mathematical Framework

1. **Forward Pass**
   For layer l:
   $\mathbf{z}^{(l)} = \mathbf{W}^{(l)}\mathbf{a}^{(l-1)} + \mathbf{b}^{(l)}$
   $\mathbf{a}^{(l)} = f(\mathbf{z}^{(l)})$

2. **Backward Pass**
   Error gradients:
   $\delta^{(L)} = \nabla_a L \odot f'(\mathbf{z}^{(L)})$ (output layer)
   $\delta^{(l)} = ((\mathbf{W}^{(l+1)})^T\delta^{(l+1)}) \odot f'(\mathbf{z}^{(l)})$ (hidden layers)

### Gradient Computation

1. **Weight Updates**
   $\frac{\partial L}{\partial \mathbf{W}^{(l)}} = \delta^{(l)}(\mathbf{a}^{(l-1)})^T$

2. **Bias Updates**
   $\frac{\partial L}{\partial \mathbf{b}^{(l)}} = \delta^{(l)}$

### Implementation Steps

1. **Forward Propagation**
   - Input → Hidden layers → Output
   - Store activations and pre-activations
   - Compute loss

2. **Backward Propagation**
   - Compute output layer error
   - Propagate error backward
   - Compute parameter gradients
   - Update weights and biases

### Computational Considerations

1. **Memory Requirements**
   - Store intermediate activations
   - Cache pre-activation values
   - Gradient matrices

2. **Numerical Stability**
   - Gradient vanishing/exploding
   - Activation function choice
   - Weight initialization

### Optimization Techniques

1. **Gradient Descent Variants**
   - Stochastic GD
   - Mini-batch GD
   - Momentum methods

2. **Learning Rate Strategies**
   - Fixed learning rate
   - Learning rate schedules
   - Adaptive methods (Adam, RMSprop)

### Common Issues

1. **Vanishing Gradients**
   - Deep networks
   - Sigmoid/tanh activations
   - Long sequences

2. **Exploding Gradients**
   - Unstable training
   - Large weight updates
   - Gradient clipping needed

### Solutions and Improvements

1. **Architectural**
   - Skip connections
   - Batch normalization
   - Residual blocks

2. **Algorithmic**
   - Better initializations
   - Gradient clipping
   - Layer normalization

### Applications

1. **Supervised Learning**
   - Classification
   - Regression
   - Sequence prediction

2. **Transfer Learning**
   - Fine-tuning
   - Feature extraction
   - Domain adaptation

Tags:
[[Neural Networks]]
[[Optimization]]
[[Gradient Descent]]
