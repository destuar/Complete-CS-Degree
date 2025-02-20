**Boosting** is an ensemble learning method that combines many weak learners (typically shallow trees) sequentially, where each learner focuses on the mistakes of previous ones. It's a general approach that includes algorithms like AdaBoost and Gradient Boosting.

### Mathematical Framework

For M weak learners, final prediction:
$F_M(x) = \sum_{m=1}^M \alpha_m f_m(x)$

where:
- $f_m(x)$ are weak learners
- $\alpha_m$ are learner weights
- M is number of iterations

### AdaBoost Algorithm

1. **Initialize** weights $w_i = \frac{1}{n}$

2. **For** m = 1 to M:
   - Fit classifier $f_m(x)$ to weighted data
   - Compute error: $\epsilon_m = \frac{\sum_{i=1}^n w_i I(y_i \neq f_m(x_i))}{\sum_{i=1}^n w_i}$
   - Compute weight: $\alpha_m = \log(\frac{1-\epsilon_m}{\epsilon_m})$
   - Update: $w_i \leftarrow w_i\exp(\alpha_m I(y_i \neq f_m(x_i)))$

### Gradient Boosting

1. **Initialize** $F_0(x) = \arg\min_\gamma \sum_{i=1}^n L(y_i, \gamma)$

2. **For** m = 1 to M:
   - Compute negative gradients: $r_{im} = -[\frac{\partial L(y_i,F(x_i))}{\partial F(x_i)}]_{F=F_{m-1}}$
   - Fit base learner to residuals: $f_m(x)$
   - Line search: $\gamma_m = \arg\min_\gamma \sum_{i=1}^n L(y_i, F_{m-1}(x_i) + \gamma f_m(x_i))$
   - Update: $F_m(x) = F_{m-1}(x) + \nu\gamma_m f_m(x)$

### Properties

1. **Bias-Variance Trade-off**
   - Reduces both bias and variance
   - Can overfit if too many iterations
   - Learning rate controls trade-off

2. **Feature Importance**
   - Based on split frequency
   - Improvement in loss function
   - Scaled by tree weight

### Advantages
- Often best-in-class accuracy
- Handles mixed feature types
- Built-in feature selection
- Less prone to overfitting than single trees
- Natural handling of missing values

### Limitations
- Sequential (hard to parallelize)
- Sensitive to noisy data
- Can overfit if not tuned
- Computationally intensive
- Less interpretable than single trees

### Implementation

1. **Key Parameters**
   - Number of iterations (M)
   - Learning rate (ν)
   - Tree depth
   - Subsampling rate

2. **Regularization Methods**
   - Early stopping
   - Shrinkage (learning rate)
   - Subsampling
   - L1/L2 regularization

### Variants

1. **XGBoost**
   - System optimization
   - Regularization terms
   - Approximate tree learning

2. **LightGBM**
   - Leaf-wise growth
   - Histogram-based splits
   - Feature bundling

### Applications
- Competition winning
- Click prediction
- Ranking systems
- Anomaly detection
- Risk modeling

### Diagnostics
- Learning curves
- Feature importance
- Partial dependence
- Cross-validation
- Residual analysis

Tags:
[[Ensemble Methods]]
[[Gradient Descent]]
