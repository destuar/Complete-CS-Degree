Counting Sort is a non-comparison-based sorting algorithm that operates by counting the number of objects that have each distinct key value. It is efficient when the range of input values (keys) is not significantly larger than the number of items to be sorted.

## Basic Idea

- Determine the range of input values (e.g., 0 to $k$).
- Count the occurrences of each distinct value in the input array.
- Calculate the starting position for each value in the sorted output array based on the counts.
- Place each element from the input array into its correct sorted position in an output array.
- Not a comparison-based sort; uses actual values as indices into an auxiliary array.

## Algorithm Steps

Let the input array be `A` of size $n$, with elements in the range $[0, k]$.

1.  **Initialize Count Array**: Create a count array `C` of size $k+1$, initialized to all zeros.
2.  **Store Counts**: Iterate through the input array `A`. For each element `A[j]`, increment the corresponding count: `C[A[j]] = C[A[j]] + 1`. After this step, `C[i]` contains the number of elements equal to $i$.
3.  **Store Cumulative Counts**: Modify the count array `C` such that `C[i]` now contains the number of elements less than or equal to $i$. This is done by iterating from $i=1$ to $k$ and setting `C[i] = C[i] + C[i-1]$. `C[i]` now represents the final position (plus one) of element $i$ in the sorted output.
4.  **Place Elements in Output Array**: Create an output array `B` of size $n$. Iterate through the input array `A` *backwards* (from $j=n-1$ down to 0). For each element `A[j]`, place it into the output array `B` at the position given by the cumulative count: `B[C[A[j]] - 1] = A[j]`. Then, decrement the count for that element: `C[A[j]] = C[A[j]] - 1`. Iterating backwards ensures stability.
5.  **Copy Back (Optional)**: Copy the sorted elements from `B` back to `A` if in-place modification is desired.

## Pseudocode

```
function countingSort(A, B, n, k): // A=input, B=output, n=size, k=max value
    // 1. Initialize Count Array C of size k+1
    C = array of size (k + 1) initialized to 0
    
    // 2. Store counts of each element
    for j = 0 to n - 1:
        C[A[j]] = C[A[j]] + 1
    // C[i] now contains the number of elements equal to i
    
    // 3. Store cumulative counts
    for i = 1 to k:
        C[i] = C[i] + C[i-1]
    // C[i] now contains the number of elements <= i
    
    // 4. Place elements into output array B
    for j = n - 1 down to 0:
        B[C[A[j]] - 1] = A[j]
        C[A[j]] = C[A[j]] - 1
```

## Time Complexity

- $O(n+k)$
- Step 1 takes $O(k)$.
- Step 2 takes $O(n)$.
- Step 3 takes $O(k)$.
- Step 4 takes $O(n)$.
- Total time complexity is $O(n+k)$.
- If $k = O(n)$, the complexity becomes linear: $O(n)$.

## Space Complexity

- $O(n+k)$ auxiliary space.
- $O(k)$ for the count array `C`.
- $O(n)$ for the output array `B`.

## Key Features & Assumptions

- **Non-Comparison Based**: Does not compare elements directly. Uses values as indices.
- **Linear Time**: Achieves $O(n+k)$ time complexity, which is linear if $k=O(n)$. Beats the $\Omega(n \log n)$ lower bound for comparison sorts like [[QuickSort]].
- **Stable**: Preserves the relative order of equal elements. This is crucial when used as a subroutine in Radix Sort.
- **Assumption**: Input consists of integers (or objects with integer keys) in a known, relatively small range $[0, k]$.
- **Good for Small Integers**: As noted in the context image, highly efficient when the range $k$ is not significantly larger than $n$.

## Relationship to Other Sorts

- **[[BucketSort Algorithm|Bucket Sort]]**: Counting Sort can be viewed as a special case of Bucket Sort where the range of keys is small, and each bucket corresponds to a single key value.
- **Radix Sort**: Counting Sort is often used as the stable sorting subroutine within Radix Sort to sort elements based on individual digits or characters.

## Applications

- Sorting items with small integer keys.
- As a subroutine in Radix Sort.
- Situations where the range of input data is known and limited.
