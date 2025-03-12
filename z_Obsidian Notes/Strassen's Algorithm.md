Strassen's Algorithm is a divide-and-conquer algorithm for [[matrix multiplication]] that reduces the computational complexity from $O(n^3)$ to approximately $O(n^{2.81})$ by decreasing the number of recursive multiplications from 8 to 7 for 2×2 matrices.

## Basic Idea

- Standard matrix multiplication of two $n \times n$ matrices requires $n^3$ scalar multiplications
- For $2 \times 2$ matrices, the standard approach uses 8 multiplications and 4 additions
- Strassen (1969) discovered a method using only 7 multiplications and 18 additions
- The algorithm recursively applies this approach to larger matrices

## 2×2 Matrix Multiplication Example

1. **Standard Approach**:
   - For matrices $A = \begin{pmatrix} a_{11} & a_{12} \\ a_{21} & a_{22} \end{pmatrix}$ and $B = \begin{pmatrix} b_{11} & b_{12} \\ b_{21} & b_{22} \end{pmatrix}$
   - The product $C = A \times B$ is computed as:
     - $c_{11} = a_{11} \times b_{11} + a_{12} \times b_{21}$
     - $c_{12} = a_{11} \times b_{12} + a_{12} \times b_{22}$
     - $c_{21} = a_{21} \times b_{11} + a_{22} \times b_{21}$
     - $c_{22} = a_{21} \times b_{12} + a_{22} \times b_{22}$
   - This requires 8 multiplications and 4 additions

2. **Strassen's Approach**:
   - Define 7 products:
     - $P_1 = (a_{11} + a_{22}) \times (b_{11} + b_{22})$
     - $P_2 = (a_{21} + a_{22}) \times b_{11}$
     - $P_3 = a_{11} \times (b_{12} - b_{22})$
     - $P_4 = a_{22} \times (b_{21} - b_{11})$
     - $P_5 = (a_{11} + a_{12}) \times b_{22}$
     - $P_6 = (a_{21} - a_{11}) \times (b_{11} + b_{12})$
     - $P_7 = (a_{12} - a_{22}) \times (b_{21} + b_{22})$
   
   - Compute the result:
     - $c_{11} = P_1 + P_4 - P_5 + P_7$
     - $c_{12} = P_3 + P_5$
     - $c_{21} = P_2 + P_4$
     - $c_{22} = P_1 + P_3 - P_2 + P_6$
   
   - This requires 7 multiplications and 18 additions/subtractions

## Recursive Application to Larger Matrices

1. **Divide Step**:
   - Split an $n \times n$ matrix into four $\frac{n}{2} \times \frac{n}{2}$ submatrices:
     $A = \begin{pmatrix} A_{11} & A_{12} \\ A_{21} & A_{22} \end{pmatrix}$ and $B = \begin{pmatrix} B_{11} & B_{12} \\ B_{21} & B_{22} \end{pmatrix}$

2. **Conquer Step**:
   - Apply the 7-multiplication formula recursively to the submatrices
   - Base case: direct multiplication for small matrices (typically 32×32 or 64×64)

3. **Combine Step**:
   - Assemble the results into the final product matrix

## Complexity Analysis

1. **Recurrence Relation**:
   - $T(n) = 7T(n/2) + O(n^2)$ for matrices of size $n \times n$
   - By the Master Theorem, this gives $T(n) = O(n^{\log_2 7}) \approx O(n^{2.81})$
   - Compared to standard matrix multiplication: $O(n^3)$

2. **Practical Considerations**:
   - The overhead of additions makes Strassen's algorithm less efficient for small matrices
   - Typically used with a hybrid approach: Strassen's for large matrices, standard for small ones

## Optimality and Improvements

1. **Lower Bounds**:
   - Theoretical lower bound for matrix multiplication is not known
   - Conjectured to be $O(n^2)$ (not proven)

2. **Subsequent Algorithms**:
   - Coppersmith-Winograd algorithm: $O(n^{2.376})$
   - Williams' algorithm (2020): $O(n^{2.3729})$
   - All based on reducing the number of multiplications in recursive steps

3. **Practical Limitations**:
   - Advanced algorithms have large constant factors
   - Only become practical for extremely large matrices
   - Strassen's remains the most widely implemented fast matrix algorithm
