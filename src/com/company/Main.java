package com.company;

/**
 * This class holds my implementation of a quicksort. This one was a real pain...
 *
 * To partition the array, each element is iterated through on the first iteration. On the second recursion, half of the array is iterated through. On the third, half and so on...
 * Therefore, the average/worst-case time complexity for partitioning is O(n) since each element is iterated over at least once
 *
 * The recursive portion where quicksort is called on the left side and followed by the right side has O(log n) time since the left portion of the array is quicksorted
 * follower by the right portion and so on until the left/right portion only has one node left
 * Therefore, the time complexity is dependent on the height of the recursive calls. For example, if there were 8 elements, there would be 3 recursive calls at most...O (log2 8) = 3.
 *
 * Furthermore, every time quicksort is called recursively, a partition is also called where all elements of that array portion are iterated over.
 *
 * Putting it all together, the time complexity is then be O(n logn).
 *
 * Note: I used median of three as a partitioning technique to avoid O(n^2) worst case time complexity that would have occurred by choosing a partitioning technique that possible
 * divides the array unevenly.
 */

public class Main {

    public static void main(String[] args) {


    //make array here
        int[] array = {3, 4, 5, 1, 2,6, 8,7, 10, 20, 25, 30};
	quicksort(array, 0, array.length-1);
	print(array);
    }

    public static void print(int[] array){
        String s = "[";

        for (int i = 0; i < array.length; i++){
            s += Integer.toString(array[i]) + ", ";
        }

        System.out.println(s + "]");
    }

    public static void quicksort(int[] array, int i , int j){
        if (i >= j){
            return;
        }

        else{

            int pivot = findMedian(array, i, i+(j-i)/2, j);

            swap(array, pivot, j);
            pivot = partition(array, i, j-1, j);
            quicksort(array, i, pivot-1);
            quicksort(array, pivot + 1, j);
        }
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int partition(int[] array, int start, int end, int pivot){
        int i = start;
        int j = end;

        while (i < j){

            while (array[i] < array[pivot] && i <= end){
                i++;
            }

            while (array[j] > array[pivot] && j >= start){
                j--;
            }

            if (i < j){
                swap(array, i, j);
            }
        }

        swap(array, pivot, i);

        return i;
    }

    private static int findMedian(int[] array, int a, int b, int c){

        if (array[a] > array[b]){

            if (array[b] > array[c]){
                return b;
            }

            if (array[c] > array[a]){
                return a;
            }

            return c;
        }

        if (array[a] < array[b]){

            if (array[c] > array[b]){
                return b;
            }

            if (array[a] > array[c]){
                return a;
            }

            return c;
        }

        else {
            return lowest(array, a,b,c);
        }
    }

    private static int lowest(int[] array, int a, int b, int c){
        if (array[a] == array[b]){
            if (array[a] < array[c]){
                return a;
            }

            if (array[a] > array[c]){
                return c;
            }
        }

        if (array[b] == array[c]){
            if (array[a] < array[b]){
                return a;
            }

            if (array[a] > array[b]){
                return b;
            }
        }

        if (array[a] == array[c]){
            if (array[a] < array[b]){
                return a;
            }

            if (array[a] > array[b]){
                return b;
            }
        }

        return -1;
    }
}
