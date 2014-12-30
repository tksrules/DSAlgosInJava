package Iterators;

//Implement array iterator in java

import java.util.Iterator;

class ArrayIterator<T> implements Iterator<T> {
    T[] array;
    private int count;

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        while (hasNext()) {
            return null;
        }
        return null;
    }

    @Override
    public void remove() {

    }

}