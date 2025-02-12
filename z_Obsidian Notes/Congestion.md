In [[graph theory]] and network flow, **congestion** at a vertex (or edge) refers to the **maximum number of paths that pass through it**. This concept is important in analyzing network bottlenecks, traffic distribution, and load balancing.

**Formal Definition:**

Given a graph $G = (V, E)$, the **congestion** of a vertex $v$ is defined as:

$$C(v) = \max_{P} | \{ p \in P \mid v \in p \} |$$
where:

- $P$ is a set of paths in the network.
- $C(v)$ represents the **maximum number of paths that pass through $v$**.