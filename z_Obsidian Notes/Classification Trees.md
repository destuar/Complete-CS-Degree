**Classification Trees** are a [[Non-Parametric Models|non-parametric]] method for [[Classification]] that recursively partitions the feature space into regions and assigns a class label to each region based on majority vote.

### Mathematical Framework
For K classes and M regions, predict class k in region $R_m$ if:

$\hat{p}_{mk} = \frac{1}{N_m}\sum_{i: x_i \in R_m} I(y_i = k)$ is maximum

where:
- $N_m$ is number of observations in region m
- $\hat{p}_{mk}$ is proportion of class k in region m

### Growing Algorithm
1. **Split Selection**
   Minimize node impurity using one of:

   **Gini Index:**
   $G = \sum_{k=1}^K \hat{p}_{mk}(1-\hat{p}_{mk})$

   **Cross-Entropy:**
   $D = -\sum_{k=1}^K \hat{p}_{mk}\log(\hat{p}_{mk})$

   **Misclassification Error:**
   $E = 1 - \max_k(\hat{p}_{mk})$

2. **Recursive Partitioning**
   - Start with all data
   - Find best split
   - Repeat on each region
   - Stop when criterion met

### Tree Pruning
1. **Cost-Complexity Pruning**
   Minimize:
   $\sum_{m=1}^{|T|} \sum_{i: x_i \in R_m} I(y_i \neq \hat{y}_{R_m}) + \alpha|T|$

   where:
   - |T| is number of terminal nodes
   - α is complexity parameter
   - $\hat{y}_{R_m}$ is majority class in region m

2. **Validation Approach**
   - Grow large tree
   - Cross-validate to find optimal size
   - Prune back to that size

### Properties
1. **Decision Boundaries**
   - Rectangular regions
   - Parallel to axes
   - Hierarchical structure

2. **Probability Estimates**
   - Class proportions in leaves
   - Can be poorly calibrated
   - Discrete jumps at boundaries

### Advantages
- Natural for multi-class problems
- Handles mixed feature types
- Invariant to monotone transformations
- Built-in feature selection
- Handles missing values

### Limitations
- Unstable (high variance)
- Can overfit
- Axis-parallel splits only
- Biased toward features with many levels
- Discontinuous decision boundaries

### Implementation
1. **Stopping Rules**
   - Minimum node size
   - Maximum depth
   - Minimum impurity decrease
   - Pure node (single class)

2. **Hyperparameters**
   - Splitting criterion
   - Minimum samples per leaf
   - Maximum features per split
   - Class weights for imbalance

### Extensions
1. **[[Random Forests]]**
   - Bagging of trees
   - Random feature selection
   - Reduces variance

2. **[[Boosting]]**
   - AdaBoost
   - Gradient Boosting
   - Focus on misclassified cases

### Diagnostics
- Confusion matrix
- ROC curves
- Variable importance
- Tree visualization
- Cross-validation error
