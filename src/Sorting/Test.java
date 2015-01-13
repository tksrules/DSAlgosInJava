package Sorting;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static List<Integer> mergeSortedLists(final List<Integer> A, final List<Integer> B) {
        final List<Integer> result = new ArrayList<Integer>();

        int i = 0;
        int j = 0;

        while (i < A.size() && j < B.size()) {
            if (A.get(i) < B.get(j)) {
                result.add(A.get(i));
                i++;
            } else {
                result.add(B.get(j));
                j++;
            }
        }

        // 1,4,5
        while (i < A.size()) {
            result.add(A.get(i));
            i++;
        }
        // 1,4,5,6,10

        while (j < B.size()) {
            result.add(B.get(j));
            j++;
        }

        return result;
    }

    public static void main(final String... args) {
        final List<Integer> A = new ArrayList<Integer>();
        final List<Integer> B = new ArrayList<Integer>();

        A.add(1);
        A.add(4);
        A.add(10);
        B.add(2);
        B.add(3);

        final List<Integer> result = mergeSortedLists(A, B);
        for (final int x : result) {
            System.out.print(x);
        }

    }
}
