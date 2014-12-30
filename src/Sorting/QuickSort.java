/**
 * On the other hand, in C++, in a generic sort, copying objects can be expensive if the objects are large, while comparing objects 
 * often is relatively cheap because of the ability of the compiler to aggressively perform inline optimization. In this scenario,
 * it might be reasonable to have an algorithm use a few more comparisons, if we can also use significantly fewer data movements. 
 * Quicksort, achieves this tradeoff, and is the sorting routine commonly used in C++ libraries.
 * 
 * In Java, quicksort is also used as the standard library sort for primitive types.
 * 
 * Complexity : O(n lg n) 
 * worst case: o(n2) .Pivot element chosen is smallest/largest all time.
 * 
 * Algo:
 * choose pivot i.e median.
 * exchange pivot and last.
 * using two pointers recursively perform such that all elements to left of pivot are less than pivot and ..
 * swap the pivot element i.e last with the element pointed to by i.
 */
package Sorting;

class QuickSort {
    public void sort(final int[] arr, final int start, final int end) {
        if (start < end) {
            final int pivot = start + (end - start) / 2;
            swap(arr, pivot, end);
            int i = start;
            int j = end - 1;
            while (i <= j) {
                if (arr[i] > arr[end] && arr[j] < arr[end]) {
                    swap(arr, i, j);
                    i++;
                    j--;
                } else if (arr[i] < arr[end]) {
                    i++;
                } else if (arr[j] > arr[end]) {
                    j--;
                }
            }
            swap(arr, i, end);
            sort(arr, start, pivot);
            sort(arr, pivot + 1, end);
        }
    }

    public void swap(final int[] arr, final int a, final int b) {
        final int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(final String... args) {
        final QuickSort quickSort = new QuickSort();
        final int[] array = new int[] { 12, 11, -12, 33, 112, 89, 0, -67 };
        quickSort.sort(array, 0, array.length - 1);
        for (final int x : array) {
            System.out.print(x + " ");
        }
    }

}
