package Generics;

//You can upper bound generic types., For example you can only find mimimum of numbers. and to use compareTo extends comparable

public class GenericUpperBounded {
    public static <T extends Number & Comparable> T getMin(final T... array) {
        if (array == null || array.length == 0) {
            return null;
        }
        T min = array[0];
        for (final T t : array) {
            if (t.compareTo(min) < 0) {
                min = t;
            }
        }
        return min;
    }

    public static void main(final String[] args) {
        final Integer[] array = new Integer[] { 1, 2, 3, -1, 4, 5 };
        final int min = getMin(array);
        System.out.println("minimum : " + min);
        // below wont compile
        // String [] array1 = new String[]{"a", "b"};
        // String min1 = getMin(array1);

    }
}