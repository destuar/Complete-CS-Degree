**Classification** is a type of [[Supervised Learning]] where the goal is to predict categorical (discrete) response variables. It involves identifying which category or class an observation belongs to based on a set of features.

### Mathematical Framework
For response Y and predictors X:
$P(Y = k|X = x)$ where k represents different classes

### Types of Classification Methods

1. **Linear Methods**
   - [[Logistic Regression]]: $P(Y=1|X) = \frac{e^{\beta_0 + \beta_1X}}{1 + e^{\beta_0 + \beta_1X}}$
   - [[Linear Discriminant Analysis]]: Assumes normal distribution with shared covariance
   - [[Multinomial Logistic Regression]]: Extends logistic regression to K > 2 classes

2. **Non-Linear Methods**
   - [[Quadratic Discriminant Analysis]]: Class-specific covariances
   - [[Naive Bayes]]: Assumes feature independence
   - [[K-Nearest Neighbors]]: Non-parametric approach

3. **Support Vector Methods**
   - [[Support Vector Machines]]: $f(x) = \text{sign}(\sum_{i=1}^n \alpha_i y_i K(x_i, x) + b)$
   - [[Maximal Margin Classifier]]
   - [[Support Vector Classifier]]

4. **Tree-Based Methods**
   - [[Classification Trees]]
   - [[Random Forests]]
   - [[Boosting]]

### Model Evaluation
1. **Performance Metrics**
   - Accuracy: $\frac{\text{Correct Predictions}}{\text{Total Predictions}}$
   - Precision: $\frac{\text{True Positives}}{\text{True Positives + False Positives}}$
   - Recall: $\frac{\text{True Positives}}{\text{True Positives + False Negatives}}$
   - F1 Score: $2 \cdot \frac{\text{Precision} \cdot \text{Recall}}{\text{Precision} + \text{Recall}}$
   - ROC Curve and AUC

2. **Validation Methods**
   - [[Cross-Validation]]
   - [[Bootstrap]]
   - Confusion Matrix

### Key Considerations
- Class imbalance
- Decision boundaries
- [[Bias-Variance Trade-Off]]
- Feature importance
- Probability calibration
- Multi-class strategies:
  - One-vs-All
  - One-vs-One
  - Error-Correcting Output Codes

