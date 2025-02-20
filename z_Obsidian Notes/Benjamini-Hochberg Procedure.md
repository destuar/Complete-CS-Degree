**Benjamini-Hochberg Procedure** (BH) is a method for controlling the [[False Discovery Rate]] in [[Multiple Testing]] scenarios. It offers a less conservative approach compared to [[Family-Wise Error Rate]] control methods while maintaining meaningful error control.

### Mathematical Framework
The procedure:

1. Order p-values: $p_{(1)} \leq p_{(2)} \leq ... \leq p_{(m)}$
2. Find largest k where: $p_{(k)} \leq \frac{k}{m}\alpha$
3. Reject all hypotheses i where $p_i \leq p_{(k)}$

where:
- m is number of tests
- α is target FDR level
- k is rejection threshold

### Properties
1. **Control Level**
   - Controls FDR at level α
   - Valid under independence
   - Valid under PRDS
   - More powerful than FWER

2. **Statistical Power**
   - Increases with true effects
   - Adaptive to signal sparsity
   - Better than [[Bonferroni Method]]
   - Maintains reasonable power

### Implementation
1. **Algorithm Steps**
   - Calculate p-values
   - Sort in ascending order
   - Compare to threshold line
   - Determine cutoff point

2. **Practical Considerations**
   - Tied p-values
   - One/two-sided tests
   - Discrete p-values
   - Multiple endpoints

### Extensions
1. **Variants**
   - Adaptive procedures
   - Weighted BH
   - Step-up procedures
   - Local FDR

2. **Related Methods**
   - BY procedure
   - q-value method
   - Empirical Bayes
   - Hybrid procedures

### Advantages and Limitations
**Advantages:**
- Higher power than FWER
- Suitable for large-scale testing
- Clear interpretation
- Widely accepted

**Limitations:**
- Weaker than FWER control
- Assumes independence/PRDS
- May include false positives
- Requires careful interpretation
