package InheritancePolymorphism;

import java.util.ArrayList;
import java.util.List;

interface Peeable {
    public void goPee();
}

class A implements Peeable {
    public void print() {
        System.out.println("In A");
    }

    @Override
    public void goPee() {
        System.out.println("A is peeing");
    }
}

class B extends A implements Peeable {
    @Override
    public void print() {
        System.out.println("In B");
    }

    @Override
    public void goPee() {
        System.out.println("B is peeing");
    }
}

public class TestInheritance {
    public static void main(final String[] args) {
        final A objectA = new A();
        objectA.print();

        // compile error ----------- B objectB = new A();
        final A objectB = new B();
        objectB.print();

        // LOLLLLL
        final List<Peeable> peeGosthi = new ArrayList<Peeable>();
        for (int i = 0; i < 10; i++) {
            peeGosthi.add(new A());
            peeGosthi.add(new B());
        }

        // best example of polymorphism
        for (final Peeable x : peeGosthi) {
            x.goPee();
        }

        // this should give class cast exception
        final B objectC = (B) (new A());
        objectC.print();

    }
}