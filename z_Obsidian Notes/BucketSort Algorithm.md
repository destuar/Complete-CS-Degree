Bucket Sort is a non-comparison-based sorting algorithm that works by distributing elements into a number of buckets. Each bucket is then sorted individually, either using a different sorting algorithm or by recursively applying Bucket Sort. It is efficient when the input is drawn from a uniform distribution.

## Basic Idea

- Distribute $n$ input elements into $k$ ordered buckets (often $k=n$).
- Sort the elements within each non-empty bucket.
- Concatenate the sorted buckets to produce the final sorted array.
- Key assumption: Input data is uniformly distributed over a range (e.g., $[0, 1)$).
- Not a comparison-based sort; uses element values to determine bucket assignments.

## Algorithm Steps

1.  **Initialize Buckets**: Create an array of $k$ empty buckets (lists or dynamic arrays).
2.  **Scatter**: Iterate through the input array. For each element, determine its target bucket (e.g., for range $[0, 1)$ and $n$ buckets, place element $x$ into bucket $\lfloor n \cdot x \rfloor$). Add the element to the corresponding bucket.
3.  **Sort Buckets**: Iterate through the buckets. Sort the elements within each non-empty bucket using a suitable sorting algorithm (e.g., Insertion Sort is common, or recursively call Bucket Sort).
4.  **Gather**: Concatenate the sorted elements from the buckets back into the original array in order.

## Pseudocode

```
function bucketSort(arr, n): // n is the number of elements
    // 1. Create n empty buckets
    buckets = array of n empty lists
    
    // 2. Scatter: Put array elements in different buckets
    for i = 0 to n - 1:
        bucketIndex = floor(n * arr[i]) // Assumes input in [0, 1)
        add arr[i] to buckets[bucketIndex]
        
    // 3. Sort individual buckets
    for i = 0 to n - 1:
        sort(buckets[i]) // e.g., using Insertion Sort
        
    // 4. Gather: Concatenate all buckets into arr
    index = 0
    for i = 0 to n - 1:
        for j = 0 to length(buckets[i]) - 1:
            arr[index] = buckets[i][j]
            index = index + 1
    return arr
```
*Note: The choice of sorting algorithm for individual buckets affects overall performance.* 

## Time Complexity

1.  **Best Case**: $O(n+k)$ or $O(n)$ if $k=n$.
    - Occurs when elements are perfectly uniformly distributed, resulting in constant or few elements per bucket.
    - If Insertion Sort ($O(m)$ best case for $m$ elements) is used for buckets, sorting each bucket takes constant time on average.
    - Steps 1 & 4 take $O(k)$ and $O(n)$ respectively.
    - Step 2 takes $O(n)$.
    - Step 3 takes $O(n)$ on average under uniformity assumption.

2.  **Average Case**: $O(n)$
    - Assuming input is uniformly distributed.
    - The expected number of elements per bucket is constant ($n/k$).
    - If Insertion Sort is used, the expected time to sort each bucket is $O(1)$.
    - Total average time: $O(n + k + n \cdot O(1)) = O(n+k)$. If $k=n$, this is $O(n)$.

3.  **Worst Case**: $O(n^2)$ (if using Insertion Sort/QuickSort for buckets) or $O(n \log n)$ (if using Merge Sort/Heap Sort for buckets).
    - Occurs when all elements fall into a single bucket.
    - The performance degrades to that of the sorting algorithm used within the buckets.
    - Example: If all elements are identical or clustered.

## Space Complexity

- $O(n+k)$ auxiliary space.
- $O(k)$ for the bucket array itself.
- $O(n)$ for storing the elements within the buckets in the worst case (if all elements go into one bucket).

## Key Features & Assumptions

- **Non-Comparison Based**: Does not rely solely on comparing elements like [[QuickSort]] or Merge Sort. Uses element values directly for placement.
- **Linear Average Time**: Achieves $O(n)$ average time complexity, beating the $\Omega(n \log n)$ lower bound for comparison sorts.
- **Assumption of Uniformity**: Performance relies heavily on the input data being uniformly distributed. If not, performance degrades significantly.
- **Good for specific distributions**: As noted in the context image, suitable for data drawn from known distributions.

## Relationship to Other Sorts

- **Counting Sort**: Can be seen as a special case of Bucket Sort where each bucket holds elements with the same key value and the range of keys is small.
- **Radix Sort**: Often uses Bucket Sort (or Counting Sort) as a subroutine for sorting digits/characters at each position.

## Applications

- Sorting large sets of floating-point numbers known to be uniformly distributed.
- Problems where input data follows a known distribution that can be mapped to uniform.
- As a subroutine in Radix Sort.
