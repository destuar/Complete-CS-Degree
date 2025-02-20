**K-Nearest Neighbors (KNN)** is a [[Non-Parametric Models|non-parametric]] method used for both [[Classification]] and [[Regression Model|regression]], where predictions are made based on the k closest training observations.

### Mathematical Framework

For a point $x_0$, the KNN estimate is:

**Regression**:
$\hat{f}(x_0) = \frac{1}{K}\sum_{i \in \mathcal{N}_K(x_0)} y_i$

**Classification**:
$\hat{C}(x_0) = \text{mode}\{c_i: i \in \mathcal{N}_K(x_0)\}$

where:
- $\mathcal{N}_K(x_0)$ is the set of K nearest neighbors to $x_0$
- $y_i$ are response values
- $c_i$ are class labels

### Distance Metrics

1. **Euclidean Distance**
   $d(x_i, x_j) = \sqrt{\sum_{l=1}^p (x_{il} - x_{jl})^2}$

2. **Manhattan Distance**
   $d(x_i, x_j) = \sum_{l=1}^p |x_{il} - x_{jl}|$

3. **Minkowski Distance**
   $d(x_i, x_j) = (\sum_{l=1}^p |x_{il} - x_{jl}|^q)^{1/q}$

### Model Complexity

1. **Choice of K**
   - Small K: Low bias, high variance
   - Large K: High bias, low variance
   - Optimal K often found via [[Cross-Validation]]

2. **Feature Scaling**
   - Essential for distance-based methods
   - Common approaches:
     - Standardization: $z = \frac{x - \mu}{\sigma}$
     - Min-Max scaling: $x_{new} = \frac{x - x_{min}}{x_{max} - x_{min}}$

### Advantages
- No training phase
- Simple to understand and implement
- Naturally handles multi-class problems
- Makes no assumptions about data distribution
- Adapts to local structure

### Limitations
- Computationally intensive for large datasets
- Requires feature scaling
- Sensitive to irrelevant features
- Suffers from [[Curse of Dimensionality]]
- Memory-intensive (stores all training data)

### Implementation Considerations

1. **Data Structures**
   - KD Trees
   - Ball Trees
   - LSH (Locality-Sensitive Hashing)

2. **Weighted Variants**
   $\hat{f}(x_0) = \frac{\sum_{i \in \mathcal{N}_K(x_0)} w_i y_i}{\sum_{i \in \mathcal{N}_K(x_0)} w_i}$
   where $w_i = \frac{1}{d(x_0, x_i)^2}$

### Applications
- Recommendation systems
- Pattern recognition
- Missing value imputation
- Anomaly detection
- Image classification