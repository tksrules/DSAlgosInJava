/**
 * O(n2)
 * Use for arrays with small size or nearly sorted array
 */

package Sorting;

public class InsertionSort {
    public void sort(final int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            if (arr[i] < arr[j]) {
                while (arr[i] < arr[j] && j > 0) {
                    j--;
                }
                final int data = arr[i];
                for (int k = i; k > j; k--) {
                    arr[k] = arr[k - 1];
                }
                arr[j] = data;
            }
            for (final int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    public static void main(final String... args) {
        final InsertionSort test = new InsertionSort();
        final int[] array = new int[] { 12, 11, -12, 33, 12, 89, 0, -67 };
        test.sort(array);
        for (final int x : array) {
            System.out.print(x + " ");
        }
    }
}
