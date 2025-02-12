The **butterfly structure** is a network topology commonly used in **parallel computing, communication networks, and fast algorithms**. It is a structured, multi-stage graph where data flows efficiently through multiple layers.

The [[switch]] is **uniquely** identified by its row and column ([[bit]] and level index).

![[Butterfly Network.png]]

A **$k$-level butterfly network** consists of:

- **$2^k$ input nodes** and **2$^k$ output nodes**.
- **$k+1$ layers** of nodes.
- **Each node in layer $i$ is connected to two nodes in layer $i+1$**.

The network forms a pattern resembling a **butterfly's wings**, and **connections forming a structured, recursive pattern** that helps to minimize [[congestion]] by bit swapping layer by layer.

Tags:
[[Recursion]]
