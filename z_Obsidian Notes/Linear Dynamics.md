Linear dynamics describes the evolution of systems where the next state is a linear function of the current state. These systems form a fundamental class of [[State Sequence|state sequences]] that are both mathematically tractable and widely applicable in practice.

## Definition

A linear dynamical system is defined by the recursive equation:

$$\mathbf{x}_{t+1} = A_t\mathbf{x}_t, \quad t = 1, 2, \ldots$$

Where:
- $\mathbf{x}_t$ is the state vector at time $t$
- $A_t$ is an $n \times n$ dynamics matrix
- The $(A_t)_{ij}$ entry represents the contribution to $(\mathbf{x}_{t+1})_i$ from $(\mathbf{x}_t)_j$

## Time-Invariant Systems

A linear dynamical system is called **time-invariant** if $A_t = A$ for all $t$, meaning the dynamics matrix doesn't depend on time. In this case, the system simplifies to:

$$\mathbf{x}_{t+1} = A\mathbf{x}_t$$

This leads to the explicit solution:
$$\mathbf{x}_t = A^t\mathbf{x}_0$$
where $\mathbf{x}_0$ is the initial state.

## Properties

1. **Superposition**: For any states $\mathbf{x}$ and $\mathbf{y}$ and scalars $\alpha$ and $\beta$:
   $$A(\alpha\mathbf{x} + \beta\mathbf{y}) = \alpha A\mathbf{x} + \beta A\mathbf{y}$$

2. **Stability**: The system is stable if all eigenvalues of $A$ have magnitude less than 1

3. **Periodicity**: The system is periodic with period $p$ if $A^p = I$ (identity matrix)

## Analysis Methods

1. **Eigenvalue Analysis**:
   - Eigenvalues determine growth/decay rates
   - Eigenvectors determine principal directions of motion
   - The spectral radius determines long-term behavior

2. **Jordan Decomposition**:
   $$A = PJP^{-1}$$
   where:
   - $P$ contains the generalized eigenvectors
   - $J$ is in Jordan canonical form

3. **Phase Space Analysis**:
   - Fixed points: $A\mathbf{x} = \mathbf{x}$
   - Periodic orbits: $A^p\mathbf{x} = \mathbf{x}$
   - Attractors and repellers

## Extensions

1. **Forced Systems**:
   $$\mathbf{x}_{t+1} = A\mathbf{x}_t + B\mathbf{u}_t$$
   where $\mathbf{u}_t$ is an external input or control

2. **Noisy Systems**:
   $$\mathbf{x}_{t+1} = A\mathbf{x}_t + \mathbf{w}_t$$
   where $\mathbf{w}_t$ is random noise

3. **Observed Systems**:
   $$\mathbf{y}_t = C\mathbf{x}_t + \mathbf{v}_t$$
   where $\mathbf{y}_t$ is the observation and $\mathbf{v}_t$ is measurement noise
