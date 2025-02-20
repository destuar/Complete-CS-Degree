**Family-Wise Error Rate** (FWER) is the probability of making at least one Type I error when performing multiple hypothesis tests. It is a key concept in [[Multiple Testing]] that provides strong control over false positive results.

### Mathematical Definition
For m hypothesis tests:

$\text{FWER} = P(\text{at least one Type I error}) = 1 - P(\text{no Type I errors})$

where:
- Type I error: rejecting true null hypothesis
- m is the number of tests
- α is the significance level

### Control Methods
1. **Single-step Procedures**
   - [[Bonferroni Method]]: $\alpha_{adj} = \alpha/m$
   - Šidák correction: $\alpha_{adj} = 1-(1-\alpha)^{1/m}$
   - Maximum test statistic
   - Permutation methods

2. **Sequential Procedures**
   - Holm's step-down
   - Hochberg's step-up
   - Hommel's procedure
   - Closed testing

### Properties
1. **Strong Control**
   - Valid under any configuration
   - Conservative approach
   - Guaranteed error rate
   - Independent of true nulls

2. **Weak Control**
   - Valid under global null
   - Less conservative
   - Limited applicability
   - Specific scenarios

### Applications
1. **Clinical Trials**
   - Multiple endpoints
   - Interim analyses
   - Subgroup analyses
   - Safety monitoring

2. **Genomics**
   - Gene expression
   - SNP analysis
   - Pathway testing
   - Biomarker discovery

### Relationship to Other Methods
- Alternative to [[False Discovery Rate]]
- Component of [[Multiple Testing]]
- Used with [[Bonferroni Method]]
- Stricter than per-comparison error

### Advantages and Limitations
**Advantages:**
- Strong error control
- Simple interpretation
- Well-established methods
- Conservative guarantee

**Limitations:**
- Often conservative
- Reduced power
- May miss discoveries
- Assumes independence

Tags:
[[Multiple Testing]]
