The Randomized Selection (RSelect) algorithm efficiently finds the $i$-th smallest element (the $i$-th order statistic) in an unsorted array, leveraging randomization and a partitioning strategy similar to [[QuickSort]].

## Basic Idea

- Goal: Find the $i$-th smallest element in an array $A$ of length $n$.
- Uses a [[Divide & Conquer Recurrence|divide-and-conquer]] approach.
- Randomly selects a pivot element.
- Partitions the array around the pivot.
- Recursively searches only in the partition that contains the $i$-th element.

## Algorithm Steps (from image)

1.  **(Base Case)** If $n=1$, return the single element $A[1]$.
2.  **(Choose Pivot)** Select a pivot element $p$ from $A$ uniformly at random.
3.  **(Partition)** Partition the array $A$ around the pivot $p$. Let $j$ be the final index (position) of the pivot $p$ after partitioning. All elements before index $j$ are $\le p$, and all elements after index $j$ are $\ge p$.
4.  **(Check Pivot)** If the pivot's index $j$ is equal to the desired rank $i$, then the pivot $p$ is the $i$-th smallest element. Return $p$.
5.  **(Recurse Left)** If the pivot's index $j$ is greater than $i$, the $i$-th smallest element must be in the first part of the array (elements smaller than $p$). Recursively call RSelect on the subarray $A[1...j-1]$ to find the $i$-th smallest element.
6.  **(Recurse Right)** If the pivot's index $j$ is less than $i$, the $i$-th smallest element must be in the second part of the array (elements larger than $p$). Recursively call RSelect on the subarray $A[j+1...n]$ to find the $(i-j)$-th smallest element in that subarray.

## Pseudocode
```
// Finds the i-th smallest element in arr[low...high] (1-based index i)
function RSelect(arr, low, high, i):
    if low == high: // Base case: array of size 1
        return arr[low]
    
    // Choose a random pivot index between low and high
    pivotIndex = random(low, high)
    
    // Partition the array around the pivot and get pivot's final position
    pivotFinalIndex = partition(arr, low, high, pivotIndex) // Assume partition returns final 0-based index
    
    // Calculate the rank (1-based) of the pivot in the subarray arr[low...high]
    pivotRank = pivotFinalIndex - low + 1
    
    if i == pivotRank:
        return arr[pivotFinalIndex]
    else if i < pivotRank:
        // Recurse on the left part
        return RSelect(arr, low, pivotFinalIndex - 1, i)
    else:
        // Recurse on the right part, adjust the target rank
        return RSelect(arr, pivotFinalIndex + 1, high, i - pivotRank)

// Partition function similar to QuickSort's partition
// Takes pivotIndex as input, partitions arr[low...high] around arr[pivotIndex]
// Returns the final 0-based index of the pivot element
function partition(arr, low, high, pivotIndex): 
    // (Implementation similar to QuickSort partition, e.g., Lomuto or Hoare)
    // ... swaps pivot to end, partitions, swaps pivot to final place ...
    // return final_pivot_index 
```
*Note: Assumes a suitable `partition` function exists, like the one used in [[QuickSort]]. The pseudocode uses 0-based indexing for array access but calculates ranks based on the 1-based input `i`.* 

## Time Complexity

1.  **Average Case**: $O(n)$
    - Random pivot selection makes balanced partitions highly likely.
    - The expected work decreases geometrically in each recursive step.
    - Recurrence (average): $T(n) \le T(7n/10) + O(n)$ (intuition: good pivot splits roughly 30/70)
    - Solves to $T(n) = O(n)$.

2.  **Worst Case**: $O(n^2)$
    - Occurs if pivot selection consistently results in highly unbalanced partitions (e.g., always picking the smallest or largest element).
    - Recurrence: $T(n) = T(n-1) + O(n)$
    - Same worst-case behavior as [[QuickSort]].

## Space Complexity

- **Average Case**: $O(\log n)$ due to the recursion stack depth with balanced partitions.
- **Worst Case**: $O(n)$ stack space if partitions are consistently unbalanced.
- Can be made $O(1)$ auxiliary space with an iterative implementation or tail call optimization. 

## Relationship to QuickSort

- Uses the same core partitioning subroutine as [[QuickSort]].
- Key difference: RSelect only recurses into *one* subproblem, whereas QuickSort recurses into *two*.
- This difference leads to RSelect's linear average time complexity compared to QuickSort's $O(n \log n)$.
