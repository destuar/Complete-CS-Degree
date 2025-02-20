**Recurrent Neural Networks** (RNNs) are a class of [[Neural Networks]] designed to process sequential data by maintaining an internal state (memory) that captures information about previous inputs. They are particularly effective for tasks involving time series, natural language, and other sequential patterns.

### Mathematical Framework
The basic RNN updates its hidden state according to:

$h_t = \tanh(W_{hh}h_{t-1} + W_{xh}x_t + b_h)$
$y_t = W_{hy}h_t + b_y$

where:
- $h_t$ is the hidden state at time t
- $x_t$ is the input at time t
- $y_t$ is the output at time t
- $W_{hh}, W_{xh}, W_{hy}$ are weight matrices
- $b_h, b_y$ are bias vectors

### Architectures
1. **Simple RNN**
   - Single layer of recurrent units
   - Basic memory capabilities
   - Prone to vanishing gradients

2. **LSTM (Long Short-Term Memory)**
   - Forget gate: $f_t = \sigma(W_f[h_{t-1}, x_t] + b_f)$
   - Input gate: $i_t = \sigma(W_i[h_{t-1}, x_t] + b_i)$
   - Output gate: $o_t = \sigma(W_o[h_{t-1}, x_t] + b_o)$
   - Cell state: $c_t = f_t \odot c_{t-1} + i_t \odot \tanh(W_c[h_{t-1}, x_t] + b_c)$

3. **GRU (Gated Recurrent Unit)**
   - Reset gate
   - Update gate
   - Simpler than LSTM
   - Often similar performance

### Training Methods
1. **Backpropagation Through Time (BPTT)**
   - Unroll network in time
   - Compute gradients
   - Update weights
   - Truncation for long sequences

2. **Optimization Techniques**
   - Gradient clipping
   - Layer normalization
   - [[Stochastic Gradient Descent]]
   - Adaptive learning rates

### Applications
1. **Natural Language Processing**
   - Machine translation
   - Text generation
   - Sentiment analysis
   - Named entity recognition

2. **Time Series Analysis**
   - Forecasting
   - Anomaly detection
   - Signal processing
   - Financial modeling

### Challenges and Solutions
1. **Vanishing/Exploding Gradients**
   - LSTM/GRU architectures
   - Gradient clipping
   - Skip connections
   - Proper initialization

2. **Long-term Dependencies**
   - Attention mechanisms
   - Memory networks
   - Transformer architectures
   - Bidirectional processing

Tags:
[[Neural Networks]]
[[Deep Learning]]
[[Statistical Learning]]
[[Time Series Analysis]]
