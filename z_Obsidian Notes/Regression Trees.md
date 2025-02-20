**Regression Trees** are a [[Non-Parametric Models|non-parametric]] method for [[Regression Model|regression]] that recursively partitions the feature space into rectangular regions and fits a simple model (usually a constant) in each region.

### Mathematical Framework

For a partition of feature space into M regions $R_1, ..., R_M$:

$\hat{f}(x) = \sum_{m=1}^M c_m I(x \in R_m)$

where:
- $c_m$ is the prediction for region m
- $I(x \in R_m)$ is the indicator function

### Growing Algorithm

1. **Split Selection**
   Minimize RSS at each step:
   $\sum_{i: x_i \in R_1(j,s)} (y_i - \hat{c}_1)^2 + \sum_{i: x_i \in R_2(j,s)} (y_i - \hat{c}_2)^2$
   
   where:
   - j is feature index
   - s is split point
   - $\hat{c}_1 = \text{mean}\{y_i | x_i \in R_1(j,s)\}$
   - $\hat{c}_2 = \text{mean}\{y_i | x_i \in R_2(j,s)\}$

2. **Recursive Partitioning**
   - Start with all data
   - Find best split
   - Repeat on each resulting region
   - Continue until stopping criterion met

### Tree Pruning

1. **Cost-Complexity Pruning**
   Minimize:
   $\sum_{m=1}^{|T|} \sum_{i: x_i \in R_m} (y_i - \hat{c}_m)^2 + \alpha|T|$

   where:
   - |T| is number of terminal nodes
   - α is complexity parameter

2. **Weakest Link Pruning**
   - Compute error reduction per node
   - Collapse least important splits
   - Create sequence of nested trees

### Properties

1. **Interpretability**
   - Natural decision rules
   - Visual representation
   - Variable importance measures

2. **Flexibility**
   - Captures non-linear relationships
   - Handles interactions automatically
   - No assumptions about functional form

### Advantages
- Easy to understand and interpret
- Handles missing values
- No feature scaling needed
- Captures interactions naturally
- Computationally efficient

### Limitations
- High variance
- Can overfit easily
- Discontinuous predictions
- Sensitive to small data changes
- Poor additive structure handling

### Implementation

1. **Stopping Criteria**
   - Minimum node size
   - Maximum depth
   - Minimum improvement
   - Maximum number of nodes

2. **Hyperparameters**
   - Tree depth
   - Minimum samples per leaf
   - Complexity parameter α
   - Maximum features per split

### Extensions

1. **[[Random Forests]]**
   - Ensemble of trees
   - Reduces variance
   - Better prediction accuracy

2. **[[Boosting]]**
   - Sequential tree fitting
   - Focuses on hard cases
   - Gradient boosting machines

### Applications
- Real estate price prediction
- Environmental modeling
- Financial forecasting
- Risk assessment

### Diagnostics
- Cross-validation error
- Variable importance plots
- Residual analysis
- Tree visualization

Tags:
[[Statistical Learning]]
[[Non-Parametric Models]]
[[Regression Model]]
[[Tree-Based Methods]]
[[Model Selection]]
