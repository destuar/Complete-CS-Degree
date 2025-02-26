A state [[sequence]] is an ordered [[collection]] of n-dimensional [[vector]]s that describe the evolution of a system over time. This concept is fundamental to dynamical systems, [[time series analysis]], and state-space modeling.

## Definition

A state sequence consists of n-vectors $\mathbf{x}_1, \mathbf{x}_2, \ldots$ where:
- $t$ denotes time or period
- $\mathbf{x}_t$ is called the **state** at time $t$
- The complete sequence $\{\mathbf{x}_t\}$ is called the **state trajectory**

For any current time $t$:
- $\mathbf{x}_t$ represents the current state
- $\mathbf{x}_{t-1}$ represents the previous state
- $\mathbf{x}_{t+1}$ represents the next state

## State Vector Components

The state vector $\mathbf{x}_t$ typically contains all relevant information needed to describe the system at time $t$. Components might include:
- Position
- Velocity
- Temperature
- Pressure
- Population counts
- Economic indicators

## State Space Models

State sequences often appear in state space models, which consist of:

1. **State Equation**:
   $$\mathbf{x}_{t+1} = f(\mathbf{x}_t, \mathbf{u}_t, t)$$
   where:
   - $f$ is the state transition function
   - $\mathbf{u}_t$ is the input or control vector

2. **Observation Equation**:
   $$\mathbf{y}_t = h(\mathbf{x}_t, t)$$
   where:
   - $h$ is the observation function
   - $\mathbf{y}_t$ is the observed output

## Properties

1. **Markov Property**: In many applications, the next state depends only on the current state, not on the entire history:
   $$P(\mathbf{x}_{t+1}|\mathbf{x}_t,\mathbf{x}_{t-1},\ldots,\mathbf{x}_1) = P(\mathbf{x}_{t+1}|\mathbf{x}_t)$$

2. **Stationarity**: A sequence is stationary if its statistical properties don't change over time

3. **Ergodicity**: Time averages converge to ensemble averages as time approaches infinity

## Analysis Methods

Several techniques are used to analyze state sequences:

1. **State Estimation**:
   - Kalman filtering
   - Particle filtering
   - Moving average methods

2. **Stability Analysis**:
   - Lyapunov stability theory
   - Linear stability analysis
   - Phase space analysis

3. **Control Design**:
   - Optimal control
   - Feedback control
   - Model predictive control
