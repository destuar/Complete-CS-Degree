**Naive Bayes** is a [[Parametric Models|parametric]] [[Classification]] method based on [[Bayes Theorem]] that assumes features are conditionally independent given the class label. Despite this strong assumption, it often performs well in practice.

### Mathematical Framework

Using Bayes' Theorem:
$P(Y=k|X=x) = \frac{P(X=x|Y=k)P(Y=k)}{P(X=x)}$

Naive independence assumption:
$P(X=x|Y=k) = \prod_{j=1}^p P(X_j=x_j|Y=k)$

Classification rule:
$\hat{y} = \arg\max_k P(Y=k)\prod_{j=1}^p P(X_j=x_j|Y=k)$

### Types of Naive Bayes

1. **Gaussian Naive Bayes**
   - For continuous features
   - $P(X_j|Y=k) \sim N(\mu_{jk}, \sigma_{jk}^2)$
   - Parameters: $\hat{\mu}_{jk}, \hat{\sigma}_{jk}^2$

2. **Multinomial Naive Bayes**
   - For discrete count features
   - $P(X_j|Y=k) \sim \text{Multinomial}(\theta_{jk})$
   - Common in text classification

3. **Bernoulli Naive Bayes**
   - For binary features
   - $P(X_j|Y=k) \sim \text{Bernoulli}(p_{jk})$
   - Used for document classification

### Parameter Estimation

1. **Prior Probabilities**
   $\hat{P}(Y=k) = \frac{n_k}{n}$

2. **Conditional Probabilities**
   - Gaussian: MLE for mean and variance
   - Multinomial: Relative frequencies with Laplace smoothing
   - Bernoulli: Relative frequencies with smoothing

### Log-Space Implementation
To prevent numerical underflow:
$\log P(Y=k|X=x) = \log P(Y=k) + \sum_{j=1}^p \log P(X_j=x_j|Y=k)$

### Advantages
- Simple and fast to train
- Works well with high-dimensional data
- Handles missing values naturally
- Good for small training sets
- Easily interpretable

### Limitations
- Independence assumption rarely holds
- Can't learn feature interactions
- Zero frequency problem
- Sensitive to feature redundancy

### Applications
1. **Text Classification**
   - Spam detection
   - Document categorization
   - Sentiment analysis

2. **Medical Diagnosis**
   - Disease prediction
   - Risk assessment

3. **Real-time Prediction**
   - Recommendation systems
   - Real-time classification

### Feature Engineering
1. **Discretization**
   - Binning continuous variables
   - Equal-width bins
   - Equal-frequency bins

2. **Feature Selection**
   - Remove correlated features
   - Information gain
   - Chi-squared test

### Diagnostics
- Independence tests
- Feature importance analysis
- Cross-validation
- Confusion matrices
- ROC curves

Tags:
[[Statistical Learning]]
[[Classification]]
[[Parametric Models]]
[[Bayes Theorem]]
[[Probability Theory]]
[[Text Classification]]
