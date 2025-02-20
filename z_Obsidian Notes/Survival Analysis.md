**Survival Analysis** is a statistical method for analyzing time-to-event data, where the outcome is the time until an event occurs. It handles censored observations and time-varying covariates.

### Key Concepts

1. **Survival Function**
   $S(t) = P(T > t) = 1 - F(t)$
   - Probability of surviving past time t
   - Monotone decreasing
   - S(0) = 1, S(∞) = 0

2. **Hazard Function**
   $h(t) = \lim_{\Delta t \to 0} \frac{P(t \leq T < t + \Delta t | T \geq t)}{\Delta t}$
   - Instantaneous rate of event
   - $h(t) = \frac{f(t)}{S(t)}$
   - Also called hazard rate

### Censoring Types

1. **Right Censoring**
   - Event occurs after observation period
   - Most common type
   - Example: study ends before event

2. **Left Censoring**
   - Event occurs before first observation
   - Less common
   - Example: disease onset before study

3. **Interval Censoring**
   - Event occurs between observations
   - Common in medical studies
   - Example: monthly check-ups

### Non-Parametric Methods

1. **Kaplan-Meier Estimator**
   $\hat{S}(t) = \prod_{t_i \leq t} (1 - \frac{d_i}{n_i})$
   - $d_i$ = events at time i
   - $n_i$ = at risk at time i
   - Product-limit estimator

2. **Nelson-Aalen Estimator**
   $\hat{H}(t) = \sum_{t_i \leq t} \frac{d_i}{n_i}$
   - Cumulative hazard
   - Alternative to KM
   - Better for small samples

### Semi-Parametric Models

1. **Cox Proportional Hazards**
   $h(t|X) = h_0(t)\exp(\beta^TX)$
   - $h_0(t)$ = baseline hazard
   - No distributional assumptions
   - Proportional hazards assumption

2. **Time-Varying Covariates**
   $h(t|X(t)) = h_0(t)\exp(\beta^TX(t))$
   - Covariates change over time
   - Extended Cox model
   - More complex estimation

### Parametric Models

1. **Exponential**
   - Constant hazard rate
   - $h(t) = \lambda$
   - Memoryless property

2. **Weibull**
   - $h(t) = \lambda\gamma t^{\gamma-1}$
   - Monotone hazard
   - Generalizes exponential

3. **Log-Normal**
   - Non-monotone hazard
   - More flexible
   - Better for some applications

### Model Diagnostics

1. **Proportional Hazards**
   - Schoenfeld residuals
   - Log-log plots
   - Time-varying coefficients

2. **Model Fit**
   - Cox-Snell residuals
   - Martingale residuals
   - Deviance residuals

### Applications
- Medical survival studies
- Reliability engineering
- Customer churn analysis
- Credit risk modeling
- Equipment failure analysis

### Extensions

1. **Competing Risks**
   - Multiple event types
   - Cause-specific hazards
   - Cumulative incidence

2. **Frailty Models**
   - Unobserved heterogeneity
   - Random effects
   - Clustered data

Tags:
[[Statistical Learning]]
[[Time-to-Event Analysis]]
[[Censored Data]] 