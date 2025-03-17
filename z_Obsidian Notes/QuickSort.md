QuickSort is a highly efficient [[Divide & Conquer Recurrence|divide-and-conquer]] sorting algorithm that has become one of the most widely used sorting methods due to its excellent average-case performance, in-place operation, and elegant theoretical properties.

## Basic Idea

- [[Divide & Conquer Recurrence|Divide-and-conquer]] approach to sorting
- Select a "pivot" element from the array
- Partition the array around the pivot (elements less than pivot to the left, greater to the right)
- Recursively sort the sub-arrays
- No additional merging step required (unlike [[Merge Sort]])

## Algorithm

1. **Partition Step**:
   - Choose a pivot element (various strategies exist)
   - Rearrange the array so that:
     - All elements less than the pivot are before it
     - All elements greater than the pivot are after it
   - The pivot is now in its final sorted position

2. **Recursive Step**:
   - Recursively apply QuickSort to the sub-array before the pivot
   - Recursively apply QuickSort to the sub-array after the pivot

3. **Base Case**:
   - Arrays of size 0 or 1 are already sorted

## Pseudocode

```
function quickSort(arr, low, high):
    if low < high:
        pivotIndex = partition(arr, low, high)
        quickSort(arr, low, pivotIndex - 1)
        quickSort(arr, pivotIndex + 1, high)

function partition(arr, low, high):
    pivot = arr[high]
    i = low - 1
    for j = low to high - 1:
        if arr[j] <= pivot:
            i = i + 1
            swap arr[i] and arr[j]
    swap arr[i + 1] and arr[high]
    return i + 1
```

## Time Complexity

1. **Best Case**: $O(n \log n)$
   - Occurs when the partition divides the array into nearly equal halves
   - Recurrence relation: $T(n) = 2T(n/2) + O(n)$
   - Solved using the Master Method

2. **Average Case**: $O(n \log n)$
   - Expected time with random pivot selection
   - Probabilistic analysis shows balanced partitions are likely

3. **Worst Case**: $O(n^2)$
   - Occurs when the partition produces one subproblem with $n-1$ elements and one with 0 elements
   - Happens with already sorted arrays and poor pivot selection
   - Recurrence relation: $T(n) = T(n-1) + O(n)$

## Space Complexity

- **In-place sorting**: $O(1)$ auxiliary space for the iterative version
- Recursive implementation requires $O(\log n)$ stack space on average
- Worst case stack space: $O(n)$ with poor pivots
