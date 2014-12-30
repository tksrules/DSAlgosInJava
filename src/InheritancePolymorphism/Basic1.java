package InheritancePolymorphism;

//SuperClass variable can take subclass reference
//for example numbers or objects can store integer

public class Basic1 {
    public static void main(final String[] args) {
        Object x = new Object();
        final Integer y = new Integer(5);
        x = y;
        // But below wont compile
        // y = x;
        Object[] objectArray;
        final Integer[] integerArray = new Integer[] { 3, 4, 5, 1, 2 };
        objectArray = integerArray; // OK
        // However bewaware of ArrayStoreException. For example below
        // objectArray[0] = new Object();
    }
}
