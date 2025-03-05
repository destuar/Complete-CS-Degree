A confusion matrix is a fundamental tool in [[Classification]] for evaluating the performance of a classifier by organizing predicted versus actual class labels. It provides a detailed breakdown of correct and incorrect classifications for each class.

## Basic Structure

1. **Binary Classification Matrix**:
   $$ \begin{array}{c|cc}
   & \hat{y}=+1 & \hat{y}=-1 \\
   \hline
   y=+1 & N_{tp} & N_{fn} \\
   y=-1 & N_{fp} & N_{tn}
   \end{array} $$
   where:
   - $N_{tp}$: True Positives
   - $N_{tn}$: True Negatives
   - $N_{fp}$: False Positives
   - $N_{fn}$: False Negatives

## Performance Metrics

1. **Basic Rates**:
   - Error Rate: $\frac{N_{fp} + N_{fn}}{N}$
   - Accuracy: $\frac{N_{tp} + N_{tn}}{N}$
   - Misclassification Rate: $1 - \text{Accuracy}$

2. **Class-Specific Metrics**:
   - True Positive Rate (Sensitivity): $\frac{N_{tp}}{N_{tp} + N_{fn}}$
   - True Negative Rate (Specificity): $\frac{N_{tn}}{N_{tn} + N_{fp}}$
   - False Positive Rate: $\frac{N_{fp}}{N_{tn} + N_{fp}}$
   - False Negative Rate: $\frac{N_{fn}}{N_{tp} + N_{fn}}$

3. **Precision and Recall**:
   - Precision: $\frac{N_{tp}}{N_{tp} + N_{fp}}$
   - Recall: $\frac{N_{tp}}{N_{tp} + N_{fn}}$ (same as Sensitivity)
   - F1 Score: $2 \cdot \frac{\text{Precision} \cdot \text{Recall}}{\text{Precision} + \text{Recall}}$

## Important Considerations

1. **Class Imbalance**:
   - Accuracy can be misleading
   - Consider class-specific metrics
   - Use balanced accuracy when needed

2. **Threshold Selection**:
   - Affects trade-off between metrics
   - ROC curve analysis
   - Precision-Recall curve analysis

## Important Notes

- Off-diagonal elements represent errors
- Diagonal elements represent correct predictions
- Sum of all elements equals total number of predictions
- Used in [[Cross-Validation]] for model assessment
- Essential for model selection and tuning
- Consider domain-specific requirements when choosing metrics
