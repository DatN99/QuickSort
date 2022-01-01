# QuickSort
My own implementation of quick sort algorithm

This class holds my implementation of a quicksort. 
 
To partition the array, each element is iterated through on the first iteration. On the second recursion, half of the array is iterated through. On the third, half and so on...
Therefore, the average/worst-case time complexity for partitioning is O(n) since each element is iterated over at least once

The recursive portion where quicksort is called on the left side and followed by the right side has O(log n) time since the left portion of the array is quicksorted
follower by the right portion and so on until the left/right portion only has one node left
Therefore, the time complexity is dependent on the height of the recursive calls. For example, if there were 8 elements, there would be 3 recursive calls at most...O (log2 8) = 3.

Furthermore, every time quicksort is called recursively, a partition is also called where all elements of that array portion are iterated over.

Putting it all together, the time complexity is then be O(n logn).

Note: I used median of three as a partitioning technique to avoid O(n^2) worst case time complexity that would have occurred by choosing a partitioning technique that possible
divides the array unevenly.

To use:
call "quicksort(<array>, 0, array.length-1);"
