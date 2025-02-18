Mutual independence extends the concept of independent events to more than two events. A set of events $A_1, A_2, ..., A_n$​ is mutually independent if every subset of these events is independent.

This means that for any subset of events, knowing that some of them occurred **does not affect the probability of the others occurring**.

---

A collection of events $A_1, A_2, ..., A_n$​ is **mutually independent** if:

1. **[[Pairwise Independence]]** (For every two events):
    $$P(A_i \cap A_j) = P(A_i) P(A_j) \quad \text{for all } i \neq j$$
    
2. **Triple Independence** (For every three events):
    $$P(A_i \cap A_j \cap A_k) = P(A_i) P(A_j) P(A_k) \quad \text{for all } i, j, k \text{ distinct}$$
    
3. **General Case for $n$ Events** (For all subsets):
    $$P(A_1 \cap A_2 \cap \dots \cap A_n) = P(A_1) P(A_2) \dots $$
    
This condition must hold for **all** possible subsets, not just pairs.