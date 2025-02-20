K-Fold Cross-Validation is a resampling method used to assess model performance and tune hyperparameters. It provides a more robust evaluation of model performance than a single train-test split.

### Basic Procedure

1. **Data Partitioning**
   - Split data into k equal-sized folds
   - Typically k = 5 or 10
   - Each fold serves as test set once
   - Remaining k-1 folds form training set

2. **Iteration Process**
   - For i = 1 to k:
     1. Use fold i as validation set
     2. Train on remaining k-1 folds
     3. Evaluate on validation fold
     4. Store performance metric

3. **Performance Estimation**
   - Average metrics across k iterations
   - Calculate standard deviation
   - Assess model stability
   - Compare models

### Variants

1. **Stratified K-Fold**
   - Maintains class distribution
   - Better for imbalanced data
   - Reduces bias in evaluation
   - Default for classification

2. **Leave-One-Out (LOO)**
   - Special case where k = n
   - Each sample is test set once
   - Computationally expensive
   - Low bias, high variance

3. **Repeated K-Fold**
   - Multiple rounds of k-fold
   - Different random splits
   - More robust estimates
   - Higher computational cost

### Best Practices

1. **Choosing k**
   - k = 5 or 10 typical
   - Trade-off: bias vs variance
   - Consider sample size
   - Consider computational cost

2. **Implementation**
   - Shuffle data first
   - Stratify if needed
   - Handle dependencies
   - Preserve time order if relevant
