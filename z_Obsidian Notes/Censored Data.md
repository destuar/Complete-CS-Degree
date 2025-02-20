**Censored Data** occurs in [[Survival Analysis]] when complete information about the time-to-event is not available for all subjects. Understanding censoring mechanisms is crucial for proper statistical analysis of time-to-event data.

### Types of Censoring
1. **Right Censoring**
   - Study termination
   - Loss to follow-up
   - Withdrawal
   - Competing events

2. **Left Censoring**
   - Event before observation
   - Unknown start time
   - Detection limits
   - Historical events

3. **Interval Censoring**
   - Periodic monitoring
   - Visit schedules
   - Discrete observation
   - Window censoring

### Mathematical Framework
For right-censored data:
$(T_i, \delta_i, X_i)$ where:
- $T_i = \min(Y_i, C_i)$
- $\delta_i = I(Y_i \leq C_i)$
- $Y_i$ is true event time
- $C_i$ is censoring time

### Analysis Methods
1. **Non-parametric**
   - [[Kaplan-Meier Curve]]
   - Nelson-Aalen estimator
   - Life tables
   - Turnbull estimator

2. **Semi-parametric**
   - [[Cox Proportional Hazards]]
   - Frailty models
   - Time-varying effects
   - Competing risks

### Statistical Properties
1. **Assumptions**
   - Independent censoring
   - Non-informative censoring
   - Random censoring
   - Identifiability

2. **Likelihood Construction**
   - Contribution of events
   - Contribution of censoring
   - Joint distribution
   - Partial likelihood
