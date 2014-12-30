package Generics;


//Generic methods can be in normal classes. Need not be generic classes.
//Also note that we can't pass primitive types to function expecting generic arguments, SO pass Integer instead of int.
public class GenericMethod {

    public static <T> T getMiddle(final T... data) {
        return data[data.length / 2];
    }

    public static void main(final String[] args) {
        final Integer[] array = new Integer[] { 1, 2, 3, 4, 5 };
        final int x = GenericMethod.getMiddle(array);
        System.out.println("middle :" + x);
    }
}