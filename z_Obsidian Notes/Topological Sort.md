A topological sort is a linear ordering of the vertices of a directed acyclic graph (DAG) such that for every directed edge $(u,v)$, vertex $u$ comes before vertex $v$ in the ordering.

**Relationship Between Partial and Total Order**

- A **partial order** is a relation where some elements are **not comparable** (e.g., a [[Hasse diagram]]).
- A **total order** extends this by **comparing every pair** of elements.

**Topological sorting** provides a **total order** that respects the dependencies of a **partial order**.

Tags:
[[Relation]]