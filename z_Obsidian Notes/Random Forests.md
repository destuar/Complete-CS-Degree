**Random Forests** is an ensemble learning method that combines multiple decision trees through [[Bootstrap]] aggregation (bagging) and random feature selection to improve prediction accuracy and reduce overfitting.

### Mathematical Framework

For B trees and training set D:
1. For b = 1 to B:
   - Draw bootstrap sample $D_b$
   - Grow tree $T_b$ using random feature selection
   - Get predictions $\hat{f}_b(x)$

2. Aggregate predictions:
   - Regression: $\hat{f}_{rf}(x) = \frac{1}{B}\sum_{b=1}^B \hat{f}_b(x)$
   - Classification: $\hat{C}_{rf}(x) = \text{majority vote}\{\hat{C}_b(x)\}_{1}^B$

### Algorithm Components

1. **Bootstrap Aggregation (Bagging)**
   - Sample with replacement
   - Each tree sees ~63.2% of data
   - Remaining data forms OOB (out-of-bag) set

2. **Random Feature Selection**
   - At each split, consider mtry features
   - Regression: mtry ≈ p/3
   - Classification: mtry ≈ $\sqrt{p}$

### Properties

1. **Variance Reduction**
   - Trees are decorrelated
   - Averaging reduces variance
   - Maintains low bias

2. **Feature Importance**
   - Mean decrease in impurity
   - Permutation importance
   - OOB feature importance

### Advantages
- Excellent accuracy
- No overfitting (with enough trees)
- Built-in validation (OOB error)
- Handles high-dimensional data
- Estimates feature importance
- Parallel computation

### Limitations
- Less interpretable than single trees
- Computationally intensive
- Memory intensive
- No smooth decision boundaries
- May struggle with linear relationships

### Implementation

1. **Key Parameters**
   - Number of trees (B)
   - mtry (features per split)
   - Minimum node size
   - Maximum depth

2. **Tuning Considerations**
   - B until OOB error stabilizes
   - mtry via cross-validation
   - Balance computation vs accuracy

### Error Estimation

1. **Out-of-Bag Error**
   $\text{OOB Error} = \frac{1}{n}\sum_{i=1}^n L(y_i, \hat{f}_{oob}(x_i))$
   where $\hat{f}_{oob}$ uses only trees where i was OOB

2. **Variable Importance**
   - Measure decrease in accuracy
   - When variable permuted
   - Averaged across trees

### Extensions

1. **Proximity Measures**
   - Count co-occurrence in leaves
   - Used for clustering
   - Outlier detection

2. **Missing Value Imputation**
   - Proximity-based
   - Iterative process
   - Handles mixed types

### Applications
- Genomics
- Computer vision
- Remote sensing
- Financial prediction
- Ecology

### Diagnostics
- OOB error curves
- Variable importance plots
- Partial dependence plots
- Proximity matrices
- Prediction intervals

Tags:
[[Statistical Learning]]
[[Ensemble Methods]]
[[Tree-Based Methods]]
[[Classification]]
[[Regression Model]]
[[Bootstrap]]
