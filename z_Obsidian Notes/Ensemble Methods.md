Ensemble Methods combine multiple machine learning models to create a more robust and accurate predictor. These methods leverage the wisdom of crowds principle to improve prediction performance and reduce overfitting.

### Main Types
1. **[[Bagging]] (Bootstrap Aggregating)**
   - Random sampling with replacement
   - Parallel model training
   - Averaging/voting for predictions
   - Example: [[Random Forests]]

2. **[[Boosting]]**
   - Sequential model training
   - Focus on hard examples
   - Weighted combination
   - Examples: AdaBoost, XGBoost, LightGBM

3. **Stacking**
   - Meta-learning approach
   - Multiple base learners
   - Meta-model combines predictions
   - Cross-validated predictions

### Key Concepts
1. **Model Diversity**
   - Different algorithms
   - Different hyperparameters
   - Different data subsets
   - Different feature subsets

2. **Combination Methods**
   - Averaging (regression)
   - Voting (classification)
   - Weighted combinations
   - Meta-models

3. **Error Reduction**
   - Bias reduction
   - Variance reduction
   - [[Bias-Variance Trade-Off]]
   - Overfitting mitigation

### Popular Algorithms
1. **[[Random Forests]]**
   - Bagging of decision trees
   - Random feature selection
   - Out-of-bag error estimation
   - Feature importance

2. **Gradient Boosting**
   - Sequential optimization
   - Gradient descent in function space
   - Learning rate control
   - Tree-based models

3. **Voting Classifiers**
   - Hard voting (majority)
   - Soft voting (probabilities)
   - Weighted voting
   - Model selection