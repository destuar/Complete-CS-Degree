Kosaraju's Two-Pass Algorithm is an efficient method for computing the Strongly Connected Components (SCCs) of a directed graph $G=(V, E)$. An SCC is a maximal subset of vertices such that for every pair of vertices $u, v$ in the subset, there is a directed path from $u$ to $v$ and a directed path from $v$ to $u$.

## Theorem

- The algorithm computes all SCCs of a directed graph $G$ in $O(m+n)$ time, where $n = |V|$ is the number of vertices and $m = |E|$ is the number of edges. This is linear time with respect to the size of the graph representation (e.g., adjacency list).

## Algorithm Steps

Given a directed graph $G=(V, E)$:

1.  **First Pass (Compute "Magical Ordering")**:
    a.  Construct the **reversed graph** $G^{rev} = (V, E^{rev})$, where $E^{rev} = \{(v, u) | (u, v) \in E\}$. This means reversing the direction of all arcs in $G$.
    b.  Run a **[[Depth-First Search (DFS)]]-Loop** on $G^{rev}$. The primary goal of this pass is to compute the "finishing time" $f(v)$ for each vertex $v \in V$. The finishing time typically corresponds to the order in which the recursive DFS call for a vertex completes.

2.  **Second Pass (Discover SCCs)**:
    a.  Run a **DFS-Loop** on the original graph $G$.
    b.  Process the vertices in **decreasing order** of their finishing times $f(v)$ as computed in the first pass. When the main DFS loop considers vertices, it should pick the unvisited vertex with the largest finishing time.
    c.  Each tree rooted by a starting vertex in this second DFS pass corresponds to exactly one SCC. All vertices visited during the DFS call initiated from a starting vertex $s$ (the "leader") belong to the same SCC as $s$.

## Key Concepts

- **Finishing Times**: The order in which vertices finish their exploration in the first DFS pass on $G^{rev}$ is crucial. This "magical ordering" ensures that the second DFS pass correctly identifies the SCCs. When processing nodes in decreasing order of finishing times in the second pass, the algorithm guarantees that once it starts exploring from a node $s$, it will discover the entire SCC containing $s$ before moving to a node outside that SCC.
- **Leaders**: In the second DFS pass, the root of each DFS tree (the vertex chosen by the main loop in decreasing order of finishing time) can be considered the "leader" of the SCC discovered by that tree. All nodes visited under a specific leader belong to the same SCC. 
- **Two Passes**: The algorithm requires two full traversals (DFS loops) of the graph, hence the name "Two-Pass". The first pass gathers ordering information, and the second pass uses this information to partition the vertices into SCCs.

## Implementation Details

- Both passes typically involve a standard DFS implementation.
- Pass 1 needs to record finishing times (or an equivalent topological sort order of the component graph).
- Pass 2 needs to iterate through vertices based on the finishing times from Pass 1 and maintain visited status to identify the start of new SCCs. A mapping from finishing order back to vertex ID might be needed.
- Storing the graph often uses adjacency lists for $O(m+n)$ performance. Constructing $G^{rev}$ also takes $O(m+n)$ time.

## Correctness Intuition

The vertex $v$ with the highest finishing time in the first pass (on $G^{rev}$) must belong to a "sink" SCC in the original graph $G$ (an SCC with no edges leaving it to go to another SCC). The second DFS pass starts at such a vertex $v$, finds its entire SCC, and marks its vertices as visited. It then picks the unvisited vertex with the next highest finishing time, which must belong to another sink SCC in the remaining graph, and so on. This process correctly peels off SCCs one by one.
