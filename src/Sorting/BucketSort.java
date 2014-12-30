package Sorting;

//file:    bucketsort.java
//author:  Robert Keller
//purpose: illustrating a very fast sorting program for natural numbers in
//       a reasonably small range only
//
//       bucketsort works as follows: The minimum and maximum of the 
//       range of numbers is found.  Then an array of "buckets" is 
//       allocated for each integral value between the minimum and
//       maximum inclusive.  The number of each value in the original
//       array is counted by one pass over the latter, using the datum
//       as an index into the bucket array.
//
//       This method is O(N) where N is the number of elements to be sorted;
//       a prime example of the use of the linear-addressing principle.
//
//       If the range of numbers is to large, the bucket array can't be
//       allocated and the method will fail.

import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.Date;

class BucketSort {
    /**
     * Calling bucketsort constructor on array of floats sorts the array. Parameter N is the number of elements to be
     * sorted.
     **/

    BucketSort(final int array[], final int N) {
        if (N <= 0) {
            return; // Case of empty array
        }

        int min = array[0];
        int max = min;
        for (int i = 1; i < N; i++) {
            if (array[i] > max) {
                max = array[i];
            } else if (array[i] < min) {
                min = array[i];
            }
        }

        final int bucket[] = new int[max - min + 1]; // Create buckets

        for (int i = 0; i < N; i++) {
            bucket[array[i] - min]++; // by counting each datum
        }

        int i = 0;
        for (int b = 0; b < bucket.length; b++) {
            for (int j = 0; j < bucket[b]; j++) {
                array[i++] = b + min; // by creating one per count
            }
        }
    }

    /**
     * test program for bucketsort; reads arbitrarily-many numbers from standard input, sorts them, then writes them to
     * standard output.
     **/

    @SuppressWarnings("deprecation")
    public static void main(final String[] args) {
        final StreamTokenizer in = new StreamTokenizer(System.in);

        int Size = 1; // initial allocation
        int N = 0; // number of elements in array
        int array[] = new int[Size]; // initial array allocation

        try {
            // while more numbers in file
            while (in.nextToken() != java.io.StreamTokenizer.TT_EOF) {
                if (N == Size) // if the array is full
                {
                    array = reallocate(array); // int the array size
                    Size *= 2;
                }
                array[N++] = (int) in.nval; // put item in array
            }
        } catch (final IOException e) {
            System.err.println("*** IOException caught");
        }

        final Date startTime = new Date();

        System.err.println("Sorting started");

        new BucketSort(array, N); // calling constructor sorts

        final Date endTime = new Date();

        final long time = endTime.getTime() - startTime.getTime();

        System.err.println("Sorting finished in " + time + " ms");

        for (int i = 0; i < N; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();

        System.err.println("Sorting " + N + " elements using bucketsort took " + time + " ms");
    }

    /**
     * reallocate allocates a new array int the size of the original and copies the original into it. The new array is
     * returned.
     **/

    static int[] reallocate(final int array[]) {
        final int[] newArray = new int[2 * array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
}