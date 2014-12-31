package OtherStuff;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {
    @SuppressWarnings("unchecked")
	public static void main(final String[] args) {
        final Rect rect1 = new Rect(5, 4);
        final Rect rect2 = new Rect(3, 4);
        final Rect rect3 = new Rect(3, 11);

        final Rect[] rectArray = new Rect[3];
        rectArray[0] = rect1;
        rectArray[1] = rect2;
        rectArray[2] = rect3;

        Arrays.sort(rectArray, new RectangleComparator());

        for (final Rect r : rectArray) {
            System.out.println(r);
        }
    }
}

class Rect {
    int length;
    int width;

    Rect(final int l, final int w) {
        this.length = l;
        this.width = w;
    }

    public int getArea() {
        return length * width;
    }

    @Override
    public String toString() {
        return "Length " + length + " width: " + width;
    }

}

class RectangleComparator implements Comparator {
    @Override
    public int compare(final Object r1, final Object r2) {
        if (r1 instanceof Rect && r2 instanceof Rect) {
            final Rect x = (Rect) r1;
            final Rect y = (Rect) r2;
            return x.getArea() - y.getArea();
        } else {
            throw new RuntimeException("Illegal arguments to comparator");
        }
    }
}
