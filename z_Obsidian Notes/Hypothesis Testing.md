Hypothesis Testing is a statistical method used to make inferences about population parameters based on sample data. It involves comparing a null hypothesis ($H_0$) against an alternative hypothesis ($H_1$ or $H_a$).

### Key Components

1. **Hypotheses**
   - Null Hypothesis ($H_0$): Initial assumption to be tested
   - Alternative Hypothesis ($H_1$): Competing claim
   - Types:
     - Two-tailed: $H_1: \mu \neq \mu_0$
     - One-tailed: $H_1: \mu > \mu_0$ or $H_1: \mu < \mu_0$

2. **Types of Errors**
   - Type I Error (α): Rejecting $H_0$ when it's true
   - Type II Error (β): Failing to reject $H_0$ when it's false
   - Power (1-β): Probability of correctly rejecting false $H_0$

3. **Test Statistics**
   - Z-test (known σ): $Z = \frac{\bar{X} - \mu_0}{\sigma/\sqrt{n}}$
   - T-test (unknown σ): $t = \frac{\bar{X} - \mu_0}{s/\sqrt{n}}$
   - Chi-square test: $\chi^2 = \sum \frac{(O-E)^2}{E}$

4. **P-value**
   - Probability of obtaining test results at least as extreme as observed
   - Decision rule: Reject $H_0$ if p-value < α
   - Common significance levels: α = 0.05, 0.01

### Multiple Testing
When conducting multiple hypothesis tests:
- [[Family-Wise Error Rate]]
- [[False Discovery Rate]]
- [[Bonferroni Method]]
- [[Benjamini-Hochberg Procedure]]

### Common Tests
1. **Parametric Tests**
   - One-sample t-test
   - Two-sample t-test
   - Paired t-test
   - ANOVA

2. **Non-parametric Tests**
   - Mann-Whitney U test
   - Wilcoxon signed-rank test
   - Kruskal-Wallis test
