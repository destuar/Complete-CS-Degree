Factor Analysis is a statistical method used to describe variability among observed, correlated variables in terms of a potentially lower number of unobserved variables called factors. It's a key technique in [[Dimensionality Reduction]].

### Mathematical Model

The basic factor analysis model:

$$X = \Lambda F + \epsilon$$

where:
- $X$ is the vector of observed variables
- $\Lambda$ is the factor loading matrix
- $F$ is the vector of latent factors
- $\epsilon$ is the error term

### Types

1. **Exploratory Factor Analysis (EFA)**
   - No prior assumptions about structure
   - Discovers underlying factors
   - Used for theory development
   - Methods:
     - Principal Factor Analysis
     - Maximum Likelihood Factor Analysis

2. **Confirmatory Factor Analysis (CFA)**
   - Tests specific theoretical models
   - Requires prior hypotheses
   - Used for theory testing
   - Part of structural equation modeling

### Key Concepts

1. **Factor Loadings**
   - Correlations between variables and factors
   - Usually consider loadings > 0.3 significant
   - Higher loadings indicate stronger relationships

2. **Communality**
   - Proportion of variance explained by common factors
   - $h^2 = \sum_{j=1}^k \lambda_{ij}^2$
   - Higher values indicate better explanation

3. **Rotation Methods**
   - Varimax (orthogonal)
   - Promax (oblique)
   - Improve interpretability
   - Preserve explained variance

### Model Selection

1. **Number of Factors**
   - Scree plot analysis
   - Kaiser criterion (eigenvalues > 1)
   - Parallel analysis
   - Theoretical considerations

2. **Model Fit Indices**
   - Chi-square test
   - RMSEA
   - CFI/TLI
   - SRMR
