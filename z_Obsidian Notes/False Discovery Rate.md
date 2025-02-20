**False Discovery Rate** (FDR) is the expected proportion of false discoveries among all rejected null hypotheses. It provides a less stringent control of Type I errors compared to [[Family-Wise Error Rate]], making it more suitable for high-dimensional testing problems.

### Mathematical Definition
For m hypothesis tests:

$\text{FDR} = E[\frac{V}{R}]$

where:
- V is number of false positives
- R is total number of rejections
- E is the expectation operator
- FDR ≤ FWER always

### Control Methods
1. **Benjamini-Hochberg (BH)**
   - Order p-values: $p_{(1)} \leq ... \leq p_{(m)}$
   - Find largest k: $p_{(k)} \leq \frac{k}{m}\alpha$
   - Reject all H₀ with $p \leq p_{(k)}$
   - Controls FDR at level α

2. **Advanced Procedures**
   - Benjamini-Yekutieli (BY)
   - Storey's q-value
   - Adaptive methods
   - Local FDR

### Properties
1. **Control Level**
   - Less conservative than FWER
   - Proportional error control
   - Greater statistical power
   - Suitable for screening

2. **Dependencies**
   - PRDS assumption
   - Independence
   - Arbitrary dependence
   - BY modification

### Implementation
1. **Practical Considerations**
   - Choice of α level
   - Multiple test statistics
   - Tied p-values
   - One/two-sided tests

2. **Software Tools**
   - R packages
   - Bioconductor
   - Python libraries
   - Custom implementations

### Advantages and Limitations
**Advantages:**
- Higher power
- Suitable for large-scale testing
- Interpretable error rate
- Less conservative

**Limitations:**
- Weaker error control
- Requires more assumptions
- Complex dependencies
- Choice of threshold

