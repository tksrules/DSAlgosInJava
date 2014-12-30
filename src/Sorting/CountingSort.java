/**
 * The biggest advantage of counting sort is its complexity – O(n+k), where n is the size of the sorted array and
 * k is the size of the helper array (range of distinct values).

It has also several disadvantages – if non-primitive (object) elements are sorted, another helper array is needed to
store the sorted elements. Second and the major disadvantage is that counting sort can be used only to sort discrete values 
(for example integers), because otherwise the array of frequencies cannot be constructed.
 */

//Input array:          9 6 6 3 2 0 4 2 9 3 
//Array of frequencies: 1 0 2 2 1 0 2 0 0 2 
//Array of occurrences: 0 0 2 4 5 5 7 7 7 9 
//Sorted array:         0 2 2 3 3 4 6 6 9 9  
//
//Input array:          2 8 9 8 0 8 8 9 4 6 
//Array of frequencies: 1 0 1 0 1 0 1 0 4 2 
//Array of occurrences: 0 0 1 1 2 2 3 3 7 9 
//Sorted array:         0 2 4 6 8 8 8 8 9 9  

package Sorting;

public class CountingSort {
    public static int[] countingSort(final int[] array) {
        // array to be sorted in, this array is necessary
        // when we sort object datatypes, if we don't,
        // we can sort directly into the input array
        final int[] aux = new int[array.length];

        // find the smallest and the largest value
        int min = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            } else if (array[i] > max) {
                max = array[i];
            }
        }

        // init array of frequencies
        final int[] counts = new int[max - min + 1];

        // init the frequencies
        for (int i = 0; i < array.length; i++) {
            counts[array[i] - min]++;
        }

        // recalculate the array - create the array of occurences
        counts[0]--;
        for (int i = 1; i < counts.length; i++) {
            counts[i] = counts[i] + counts[i - 1];
        }

        // Sort the array right to the left
        // 1) look up in the array of occurences the last occurence of the given value
        // 2) place it into the sorted array
        // 3) decrement the index of the last occurence of the given value
        // 4) continue with the previous value of the input array (goto: 1), terminate if all values were already sorted
        for (int i = array.length - 1; i >= 0; i--) {
            aux[counts[array[i] - min]--] = array[i];
        }

        return aux;
    }
}
