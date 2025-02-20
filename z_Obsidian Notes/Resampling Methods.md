Resampling Methods are computational techniques that involve repeatedly drawing samples from a dataset to estimate statistical quantities and assess model performance. These methods are fundamental to modern statistical inference and machine learning.

### Common Methods
1. **[[Cross-Validation]]**
   - K-fold partitioning
   - Leave-one-out
   - Stratified sampling
   - Used for model assessment and selection

2. **[[Bootstrap]]**
   - Sampling with replacement
   - Estimates sampling distributions
   - Confidence intervals
   - Standard errors

3. **Jackknife**
   - Leave-one-out resampling
   - Bias estimation
   - Variance estimation
   - Influence analysis

### Applications
1. **Model Evaluation**
   - Performance estimation
   - Model selection
   - Hyperparameter tuning
   - [[Bias-Variance Trade-Off]] assessment

2. **Statistical Inference**
   - Parameter estimation
   - Confidence intervals
   - Hypothesis testing
   - Standard error estimation

3. **Ensemble Methods**
   - [[Bagging]]
   - Random subspace method
   - Stacking
   - Model averaging

### Implementation
1. **Cross-Validation Steps**
   - Split data into k folds
   - Train on k-1 folds
   - Test on held-out fold
   - Rotate and repeat

2. **Bootstrap Steps**
   - Draw n samples with replacement
   - Compute statistic of interest
   - Repeat many times
   - Analyze distribution

### Advantages and Limitations
1. **Advantages**
   - Distribution-free methods
   - Robust error estimation
   - Works with small samples
   - Multiple performance metrics

2. **Limitations**
   - Computationally intensive
   - Time dependence issues
   - Sample size requirements
   - Independence assumptions
