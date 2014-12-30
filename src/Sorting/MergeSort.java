/**
 *  in Java, when performing a generic sort (using a Comparator), an element comparison can be expensive (because comparisons might not be easily inlined,
 *  and thus the overhead of dynamic dispatch could slow things down), but moving elements is cheap (because they are reference assignments, rather than
 *  copies of large objects).
 *  
 *  Mergesort uses the lowest number of comparisons of all the popular sorting algorithms, and thus is a good candidate for general-purpose sorting in Java
 *  
 *  Complexity - O(n lg n)
 *  Space - O(n) + recursion stack;
 *  
 *  Although mergesort’s running time is O(N log N), it has the significant problem that merging two sorted lists uses linear extra memory.1 The additional 
 *  work involved in copying to the temporary array and back, throughout the algorithm, slows the sort considerably.
 */

package Sorting;

public class MergeSort {
    public void mergeSort(final int[] arr, final int start, final int end) {
        if (end > start) {
            final int middle = start + (end - start) / 2;
            mergeSort(arr, start, middle);
            mergeSort(arr, middle + 1, end);
            merge(arr, start, middle, middle + 1, end);
        }
    }

    public void merge(final int[] arr, final int start1, final int end1, final int start2, final int end2) {
        int length1 = end1 - start1 + 1;
        int length2 = end2 - start2 + 1;
        final int[] leftArray = new int[length1];
        final int[] rightArray = new int[length2];
        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = arr[start1 + i];
        }
        for (int i = 0; i < rightArray.length; i++) {
            rightArray[i] = arr[start2 + i];
        }
        // merge left array and right array to original
        int i = 0;
        int j = 0;
        int index = start1;
        while (length1 > 0 && length2 > 0) {
            if (leftArray[i] < rightArray[j]) {
                arr[index] = leftArray[i];
                length1--;
                i++;
            } else {
                arr[index] = rightArray[j];
                length2--;
                j++;
            }
            index++;
        }
        if (length1 == 0 && length2 > 0) {
            while (length2 > 0) {
                arr[index] = rightArray[j];
                j++;
                index++;
                length2--;
            }
        }
        if (length2 == 0 && length1 > 0) {
            while (length1 > 0) {
                arr[index] = leftArray[i];
                i++;
                index++;
                length1--;
            }
        }
    }

    public static void main(final String... args) {
        final MergeSort mergeSort = new MergeSort();
        final int[] array = new int[] { 12, 11, -12, 33, 12, 89, 0, -67 };
        // final int[] arr2 = new int[] { 12, 14, 18, 19, 13, 14, 15, 16 };
        mergeSort.mergeSort(array, 0, array.length - 1);
        for (final int x : array) {
            System.out.print(x + " ");
        }
    }
}