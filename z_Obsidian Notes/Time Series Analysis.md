**Time Series Analysis** involves studying data points collected over time to understand underlying patterns, make predictions, and analyze temporal dependencies. It combines statistical methods with domain-specific considerations of time-ordered data.

### Components

1. **Trend**
   - Long-term direction
   - Can be linear or non-linear
   - Often removed via differencing

2. **Seasonality**
   - Regular periodic patterns
   - Fixed and known frequency
   - Examples: daily, weekly, yearly

3. **Cyclical**
   - Irregular fluctuations
   - Variable period length
   - Business cycles

4. **Random**
   - Unexplained variation
   - Noise component
   - Stochastic process

### Basic Models

1. **Autoregressive (AR)**
   $X_t = c + \sum_{i=1}^p \phi_i X_{t-i} + \epsilon_t$
   - p is order of AR process
   - $\phi_i$ are parameters
   - $\epsilon_t$ is white noise

2. **Moving Average (MA)**
   $X_t = \mu + \epsilon_t + \sum_{i=1}^q \theta_i \epsilon_{t-i}$
   - q is order of MA process
   - $\theta_i$ are parameters
   - $\epsilon_t$ is white noise

3. **ARIMA(p,d,q)**
   - p: AR order
   - d: Differencing order
   - q: MA order
   - Combines AR and MA with differencing

### Stationarity

1. **Requirements**
   - Constant mean
   - Constant variance
   - Time-invariant autocorrelation
   
2. **Testing**
   - Augmented Dickey-Fuller
   - KPSS test
   - Phillips-Perron test

### Model Selection

1. **Identification**
   - ACF plots
   - PACF plots
   - Information criteria (AIC, BIC)
   - Cross-validation

2. **Diagnostic Checks**
   - Residual analysis
   - Q-Q plots
   - Ljung-Box test
   - Heteroscedasticity tests

### Forecasting

1. **Point Forecasts**
   - Conditional expectation
   - Maximum likelihood
   - Recursive computation

2. **Interval Forecasts**
   - Prediction intervals
   - Bootstrap methods
   - Fan charts

### Advanced Methods

1. **State Space Models**
   - Kalman filtering
   - Hidden Markov Models
   - Structural models

2. **Neural Networks**
   - RNNs/LSTMs
   - Temporal CNNs
   - Attention mechanisms

### Preprocessing

1. **Transformations**
   - Log transform
   - Box-Cox
   - Differencing
   - Deseasonalization

2. **Missing Data**
   - Interpolation
   - Forward/backward fill
   - Model-based imputation

### Applications
- Financial forecasting
- Demand prediction
- Weather forecasting
- Economic indicators
- Sensor data analysis

### Diagnostics
- Residual plots
- Forecast accuracy metrics
- Model stability tests
- Parameter significance
- Cross-validation errors