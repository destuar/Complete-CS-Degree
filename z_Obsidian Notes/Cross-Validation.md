**Cross-Validation** is a resampling method used to assess model performance and select optimal parameters by partitioning data into training and validation sets multiple times.

### Basic Types

1. **Validation Set Method**
   - Split data once into training and validation sets
   - Simple but high variance
   - Wastes data
   - Depends heavily on specific split

2. **K-Fold Cross-Validation**
   - Split data into K equal-sized folds
   - Train on K-1 folds, test on remaining fold
   - Repeat K times, each time using different test fold
   - CV Error: $CV_{(K)} = \frac{1}{K}\sum_{i=1}^K \text{Err}_i$

3. **Leave-One-Out Cross-Validation (LOOCV)**
   - Special case where K = n
   - Each observation serves as test set once
   - Less bias, but high variance
   - Computationally intensive

### Mathematical Framework

For squared error loss:
$CV_{(K)} = \frac{1}{n}\sum_{i=1}^n(y_i - \hat{f}^{-\kappa(i)}(x_i))^2$

where:
- $\kappa(i)$ is the fold containing observation i
- $\hat{f}^{-\kappa(i)}$ is the fitted function with fold $\kappa(i)$ removed

### Applications

1. **Model Selection**
   - Choose between different model types
   - Select optimal hyperparameters

2. **Feature Selection**
   - Evaluate different feature subsets
   - Assess importance of individual features

3. **Regularization**
   - Select optimal regularization parameters
   - Examples: λ in [[Ridge Regression]] or [[Lasso Regression]]

### Variations

1. **Stratified K-Fold**
   - Maintains class proportions in each fold
   - Important for imbalanced [[Classification]] problems

2. **Repeated K-Fold**
   - Performs K-fold CV multiple times
   - Reduces variance of estimate
   - More computationally intensive

3. **Nested Cross-Validation**
   - Inner loop for model selection
   - Outer loop for performance estimation
   - Reduces optimistic bias

### Implementation Considerations

1. **Choice of K**
   - K = 5 or 10 most common
   - Larger K: Less bias, more variance
   - Smaller K: More bias, less variance

2. **Data Splitting**
   - Random vs. systematic splitting
   - Time series considerations
   - Dealing with grouped data

3. **Computational Cost**
   - Increases linearly with K
   - LOOCV can be expensive
   - Parallel implementation possible

### Advantages
- More efficient use of data than validation set
- More reliable performance estimates
- Works for any predictive modeling method
- Helps prevent overfitting

### Limitations
- Computationally intensive
- May not preserve data dependencies
- Results can still be noisy
- May not work well for very small datasets