**Multiple Testing** addresses the problem of increased Type I error rates when performing multiple hypothesis tests simultaneously. It provides methods to control various error rates while maintaining statistical power.

### Key Concepts
1. **Error Types**
   - Family-wise error rate ([[Family-Wise Error Rate]])
   - False discovery rate ([[False Discovery Rate]])
   - Per-comparison error rate
   - Per-family error rate

2. **Error Control**
   - Strong control: Valid under any configuration
   - Weak control: Valid under global null
   - Conservative vs. exact methods

### Methods
1. **FWER Control**
   - [[Bonferroni Method]]: $\alpha_{adj} = \alpha/m$
   - Šidák correction: $\alpha_{adj} = 1-(1-\alpha)^{1/m}$
   - Holm's step-down procedure
   - Hochberg's step-up procedure

2. **FDR Control**
   - [[Benjamini-Hochberg Procedure]]
   - Benjamini-Yekutieli procedure
   - q-value approach
   - Local FDR

### Implementation
1. **Test Statistics**
   - t-tests
   - F-tests
   - Chi-square tests
   - Correlation tests

2. **P-value Adjustment**
   - Single-step procedures
   - Step-down methods
   - Step-up methods
   - Resampling approaches

### Advanced Topics
1. **Dependency Structures**
   - Independent tests
   - Positive dependence
   - Arbitrary dependence
   - Block correlation

2. **Power Considerations**
   - Sample size planning
   - Effect size estimation
   - Power analysis
   - Optimal procedures

### Practical Considerations
1. **Method Selection**
   - Number of tests
   - Dependency structure
   - Type of control needed
   - Power requirements

2. **Reporting**
   - Adjusted p-values
   - Effect sizes
   - Confidence intervals
   - Discovery proportions
