The **Generalized Sum Rule** (or **Principle of Addition**) states that if a [[set]] $S$ can be **partitioned into disjoint subsets** $A1,A2,...,An$​, then the total number of elements in $S$ is the **sum of the [[cardinality]] of the subsets**:

$$∣S∣=∣A1∣+∣A2∣+⋯+∣An∣$$

where $Ai∩Aj=∅$ for all $i≠j$ (i.e., the subsets do not overlap).

---

**Generalized Sum Rule for More Than Two Sets**

If a task can be done in $n$ mutually exclusive ways, where:

- **Way 1** can be done in **$m_1$** ways,
- **Way 2** can be done in **$m_2$** ways,
- ...
- **Way** $n$ can be done in $m_n$ ways,

then the total number of ways to perform the task is:

$$m_1 + m_2 + \dots + m_n$$

---

**3. Inclusion-Exclusion and Overlapping Sets**

If sets **overlap**, we must adjust the sum by **subtracting double-counted elements** using the **Principle of Inclusion-Exclusion (PIE)**:

For two overlapping sets $A$ and $B$:

$$∣A∪B∣=∣A∣+∣B∣−∣A∩B∣$$

For three overlapping sets $A,B,C$:

$$∣A∪B∪C∣=∣A∣+∣B∣+∣C∣−∣A∩B∣−∣A∩C∣−∣B∩C∣+∣A∩B∩C∣$$