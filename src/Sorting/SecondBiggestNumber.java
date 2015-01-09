//given digits, find second largest number possible.

package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SecondBiggestNumber {
    public static int secondLargest(final ArrayList<Integer> in) {
        Collections.sort(in, Collections.reverseOrder());
        if (in.size() == 1) {
            return in.get(0);
        }
        final int last = in.get(0);
        final int secondLast = in.get(1);
        in.set(1, last);
        in.set(0, secondLast);

        int result = 0;
        for (final int x : in) {
            result = result * 10 + x;
        }
        return result;

    }

    public static void main(final String[] args) {
        final Integer[] nos = new Integer[] { 3, 7, 4, 2 };
        final ArrayList<Integer> x = new ArrayList<Integer>(Arrays.asList(nos));
        System.out.println(secondLargest(x));
    }

}
