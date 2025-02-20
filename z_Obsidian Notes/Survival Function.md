**Survival Function** (S(t)) is a fundamental concept in [[Survival Analysis]] that describes the probability that a subject survives longer than time t.

### Mathematical Definition
The survival function S(t) is defined as:
$S(t) = P(T > t) = 1 - F(t)$

where:
- T is the random variable for survival time
- F(t) is the cumulative distribution function
- t is the time point of interest

### Properties
1. **Monotonic**
   - Decreasing function
   - $S(0) = 1$
   - $\lim_{t \to \infty} S(t) = 0$

2. **Relationship to Hazard Function**
   $S(t) = \exp(-\int_0^t h(u)du)$
   where h(u) is the hazard function

### Applications
- Patient survival analysis
- Equipment reliability
- Customer churn prediction
- Time-to-event analysis

### Estimation Methods
1. **Non-parametric**
   - [[Kaplan-Meier Curve]]
   - Nelson-Aalen estimator

2. **Parametric**
   - Exponential distribution
   - Weibull distribution
   - Log-normal distribution

### Related Concepts
- Hazard function
- Cumulative hazard function
- [[Censored Data]]
- [[Cox Proportional Hazards]]

Tags:
[[Survival Analysis]]
[[Probability Distribution Function]]
