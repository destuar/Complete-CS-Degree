Control theory deals with the behavior of dynamical systems where inputs (actions) can be manipulated to achieve desired outputs (results). The fundamental model is often expressed through [[Linear Transformation|linear]] relationships between inputs and outputs, with optimization objectives governing the choice of control actions.

## Basic Framework

1. **System Model**:
   - Input vector $x \in \mathbb{R}^n$ (actions/controls)
   - Output vector $y \in \mathbb{R}^m$ (results/measurements)
   - Affine input-output relationship:
   $$ y = Ax + b $$
   where:
   - $A$ is the system matrix
   - $b$ is the offset vector
   - Both $A$ and $b$ are known from models or data

2. **Control Objectives**:
   - Multiple competing goals on $x$ and $y$
   - Often formulated as [[Multi-Objective Least Squares]] problem
   - Trade-offs analyzed using [[Pareto Optimal]] solutions

## System Types

1. **Linear Systems**:
   - Affine model: $y = Ax + b$
   - [[Linear Dynamics]] for time-varying systems
   - Superposition principle applies
   - Most common in practice

2. **State Space Models**:
   - Internal state representation
   - [[State Sequence]] evolution
   - Input-state-output relationships
   - More detailed system description

## Control Methods

1. **Open-Loop Control**:
   - Predetermined control sequence
   - No feedback from measurements
   - Simple but sensitive to disturbances
   - Based on system model accuracy

2. **Closed-Loop Control**:
   - Uses output measurements
   - Feedback incorporated
   - More robust to uncertainties
   - Adaptive to changing conditions

## Optimization Approaches

1. **Single Objective**:
   - Minimize specific performance metric
   - Example: minimize energy use
   - Solution via [[Least Squares]]
   - Unique optimal control exists

2. **Multiple Objectives**:
   - Balance competing goals
   - Examples:
     - Performance vs. cost
     - Speed vs. accuracy
     - Robustness vs. efficiency
   - [[Pareto Optimal]] solutions

## Important Notes

- Model accuracy affects control quality
- Consider system constraints
- Balance multiple objectives
- Account for uncertainties
- Validate control strategies
- Monitor system performance
- Plan for failure modes
