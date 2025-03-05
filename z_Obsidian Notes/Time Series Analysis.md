Time Series Analysis involves studying data points collected over time to understand underlying patterns, make predictions, and analyze temporal dependencies.

## Components

1. **Trend**:
   - Long-term direction in the data
   - Can be linear or non-linear
   - Often removed via differencing
   - Examples: economic growth, population increase

2. **Seasonality**:
   - Regular periodic patterns
   - Fixed and known frequency

3. **Cyclical Component**:
   - Irregular fluctuations
   - Variable period length
   - No fixed frequency

4. **Random Component**:
   - Unexplained variation
   - Noise in the data
   - Often modeled as a stochastic process
   - Assumes certain probability distributions

## Basic Models

1. **Autoregressive (AR)**:
   $$ X_t = c + \sum_{i=1}^p \phi_i X_{t-i} + \epsilon_t $$
   - $p$ is order of AR process
   - $\phi_i$ are parameters
   - $\epsilon_t$ is white noise
   - Models dependency on past values

2. **Moving Average (MA)**:
   $$ X_t = \mu + \epsilon_t + \sum_{i=1}^q \theta_i \epsilon_{t-i} $$
   - $q$ is order of MA process
   - $\theta_i$ are parameters
   - Models dependency on past errors

3. **ARIMA(p,d,q)**:
   - Combines AR and MA models
   - $p$: AR order
   - $d$: Differencing order
   - $q$: MA order
   - Most versatile classical model

## Stationarity

1. **Requirements**:
   - Constant mean
   - Constant variance
   - Time-invariant autocorrelation
   - Essential for many analyses

2. **Testing Methods**:
   - Augmented Dickey-Fuller test
   - KPSS test
   - Phillips-Perron test
   - Visual inspection of plots

## Model Selection

1. **Identification Tools**:
   - ACF (Autocorrelation Function) plots
   - PACF (Partial Autocorrelation) plots
   - Information criteria:
     - AIC (Akaike)
     - BIC (Bayesian)
   - [[Cross-Validation]] techniques

2. **Diagnostic Checks**:
   - Residual analysis
   - Q-Q plots for normality
   - Ljung-Box test
   - Heteroscedasticity tests

## Advanced Methods

1. **State Space Models**:
   - Kalman filtering
   - [[Linear Dynamics]]
   - Hidden Markov Models
   - Structural decomposition

2. **Neural Network Approaches**:
   - [[Recurrent Neural Networks]]
   - LSTMs (Long Short-Term Memory)
   - Temporal CNNs
   - Attention mechanisms