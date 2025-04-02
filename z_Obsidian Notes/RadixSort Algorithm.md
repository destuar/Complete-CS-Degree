Radix Sort is a non-comparison-based sorting algorithm that sorts data with integer keys (or keys that can be mapped to integers) by grouping keys by individual digits (or characters, bits) which share the same significant position and value. It processes digits position by position, from least significant to most significant (LSD) or vice versa (MSD), relying on a stable sorting algorithm for each pass.

## Basic Idea

- Does not compare elements directly.
- Sorts numbers digit by digit (or character by character, etc.).
- Starts from the least significant digit (LSD) and moves to the most significant digit (MSD), or vice versa.
- Requires a stable sorting algorithm (like [[CountingSort Algorithm]]) to sort the elements based on the digit at the current position.
- Stability ensures that the relative order of elements with the same digit value at the current position is maintained from previous passes.

## Algorithm Steps (LSD Radix Sort)

Let the input array be `A` of size $n$, and let the maximum number of digits in any element be $d$. Assume base $b$ (e.g., $b=10$ for decimal, $b=256$ for bytes).

1.  **Iterate through Digits**: Loop from the least significant digit position $i=1$ up to the most significant digit position $i=d$.
2.  **Stable Sort**: In each iteration $i$, use a stable sorting algorithm (e.g., [[CountingSort Algorithm]]) to sort the input array `A` based *only* on the value of the $i$-th digit.
3.  **Result**: After $d$ iterations, the array `A` will be fully sorted.

## Pseudocode (LSD Radix Sort)

```
function radixSort(A, n, d): // A=input array, n=size, d=max digits
    // Loop from least significant digit to most significant digit
    for i = 1 to d:
        // Use a stable sort (e.g., Counting Sort) to sort array A 
        // based on the i-th digit (from the right)
        stableSortByDigit(A, n, i) 
```

```
// Example using Counting Sort as the stable sort subroutine
function stableSortByDigit(A, n, digitPosition):
    // Assuming keys are integers in base 10
    k = 9 // Digits range from 0 to 9
    B = array of size n // Output array
    C = array of size (k + 1) initialized to 0
    
    // Calculate digit for each element A[j]
    // e.g., digit = floor(A[j] / power(10, digitPosition - 1)) % 10
    
    // Perform Counting Sort based on the calculated digit
    // (Similar steps as standard Counting Sort, but uses the digit as the key)
    
    // 1. Store counts of each digit
    for j = 0 to n - 1:
        digit = getDigit(A[j], digitPosition) 
        C[digit] = C[digit] + 1
        
    // 2. Store cumulative counts
    for i = 1 to k:
        C[i] = C[i] + C[i-1]
        
    // 3. Place elements into output array B based on digit counts
    for j = n - 1 down to 0:
        digit = getDigit(A[j], digitPosition)
        B[C[digit] - 1] = A[j]
        C[digit] = C[digit] - 1
        
    // Copy sorted elements back to A
    for j = 0 to n - 1:
        A[j] = B[j]
```

## Time Complexity

- Let $d$ be the maximum number of digits/characters in the keys.
- Let $b$ be the base (radix) of the numbers (e.g., 10 for decimal, 2 for binary, 256 for bytes).
- Let the stable sort used take $O(n+k)$ time, where $n$ is the number of elements and $k$ is the range of values for a single digit (i.e., $k=b$).
- Radix sort performs $d$ passes of the stable sort.
- Total time complexity: $O(d \cdot (n+b))$.
- If $d$ is constant and $b = O(n)$, the complexity becomes linear: $O(n)$.
- For numbers up to value $U$, $d = \log_b U$. Complexity can be $O(\log_b U \cdot (n+b))$. Choosing $b \approx n$ can make this $O(n \log_n U)$.

## Space Complexity

- Depends on the stable sorting algorithm used.
- If using [[CountingSort Algorithm]], the space complexity is $O(n+b)$ (for the output array and the count array of size $b$).

## Key Features & Variants

- **Non-Comparison Based**: Sorts without comparing elements, beating the $\Omega(n \log n)$ lower bound for comparison sorts like [[QuickSort]].
- **Requires Stable Sort**: The correctness depends crucially on the stability of the underlying sorting algorithm used for each digit.
- **LSD vs. MSD**: 
    - **LSD (Least Significant Digit)**: Starts with the rightmost digit. Generally simpler to implement and often preferred.
    - **MSD (Most Significant Digit)**: Starts with the leftmost digit. Can be faster if sorting terminates early for some buckets, but often more complex due to handling variable-length keys and recursion.
- Works well for fixed-size keys (like integers or fixed-length strings).

## Relationship to Other Sorts

- **[[CountingSort Algorithm]]**: Typically used as the stable sorting subroutine within Radix Sort.
- **[[BucketSort Algorithm|Bucket Sort]]**: MSD Radix Sort has similarities to Bucket Sort, where buckets are determined by the most significant digit.

## Applications

- Sorting integers.
- Sorting strings lexicographically.
- Historically used in card sorting machines.
