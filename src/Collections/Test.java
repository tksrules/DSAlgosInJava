package Collections;

import java.util.HashSet;
import java.util.Set;

class Test {
    public static void main(final String[] args) {
        final Set<Integer> set = new HashSet<>();
        set.add(12);
        set.add(13);
        set.add(12);
        set.add(14);
        set.add(12);
        for (final Integer x : set) {
            System.out.println(x);
        }
    }
}
