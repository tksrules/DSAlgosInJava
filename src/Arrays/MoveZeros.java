//Given an array of intergers, move all the zero’s of a given array to the end of the array. For example, 
//if the given arrays is {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0}, it should be changed to 
//{1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0}. The order of all other elements should be same
package Arrays;

public class MoveZeros {

    public static void MoveZerosToRight(final int[] arr) {
        int p1 = 0, p2 = 0;

        while (arr[p1] != 0) {
            p1++;
            p2++;
            if (p1 == arr.length - 1) {
                return;
            }
        }
        p2++;

        while (p2 < arr.length) {
            if (arr[p2] == 0) {
                p2++;
            } else {
                arr[p1] = arr[p2];
                p1++;
                p2++;
            }
        }

        while (p1 < arr.length) {
            arr[p1] = 0;
            p1++;
        }

    }

    public static void main(final String[] args) {
        final int[] array = new int[] { 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0 };
        MoveZerosToRight(array);
        for (final int x : array) {
            System.out.print(x + " ");
        }
    }

}
