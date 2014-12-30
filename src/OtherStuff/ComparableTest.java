package OtherStuff;

//Comparable interface example. Must override compareTo to return an int
//Can be used for sorting.

// By convention, the Comparable interface is used for natural ordering, and Comparator is used to give exact control over the ordering.

import java.util.Arrays;

public class ComparableTest {
    public static void main(final String[] args) {
        final Rectangle rect1 = new Rectangle(5, 4);
        final Rectangle rect2 = new Rectangle(3, 4);
        final Rectangle rect3 = new Rectangle(3, 11);

        final Rectangle[] rectArray = new Rectangle[3];
        rectArray[0] = rect1;
        rectArray[1] = rect2;
        rectArray[2] = rect3;

        Arrays.sort(rectArray);

        for (final Rectangle r : rectArray) {
            System.out.println(r);
        }
    }
}

class Rectangle implements Comparable<Rectangle> {
    int length;
    int width;

    Rectangle(final int l, final int w) {
        this.length = l;
        this.width = w;
    }

    public int getArea() {
        return length * width;
    }

    @Override
    public int compareTo(final Rectangle other) {
        return (this.getArea() - other.getArea());
    }

    @Override
    public String toString() {
        return "Length " + length + " width: " + width;
    }
}
