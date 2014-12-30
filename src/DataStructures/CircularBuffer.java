package DataStructures;

/**
 * A circular buffer, cyclic buffer or ring buffer is a data structure that uses a single, fixed-size buffer as if it
 * were connected end-to-end. This structure lends itself easily to buffering data streams. In short a simple queue that
 * wraps around
 */

public class CircularBuffer {
    int[] store;
    int size;
    int front, back, count;

    CircularBuffer() {
        this.size = 10;
        store = new int[this.size];
        front = back = count = 0;
    }

    CircularBuffer(final int size) {
        if (size <= 1) {
            throw new IllegalArgumentException("Enter a valid positive size");
        }
        this.size = size;
        store = new int[this.size];
        front = back = count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == size;
    }

    public void insert(final int element) {
        if (back == -1) {
            back++;
            front++;
        } else if (back == size - 1) {
            back = 0;
            if (back == 0) {
                front = 1;
            }
        } else {
            back = (back % (size - 1)) + 1;
            if (back == front) {
                front = (front % (size - 1)) + 1;
            }
        }
        store[back] = element;
    }

    public int remove() {
        if (front == -1) {
            throw new IllegalArgumentException("Buffer is empty");
        }
        final int result = store[front];
        if (front == size - 1) {
            front = 0;
        } else {
            front = (front % (size - 1)) + 1;
            if (back == front) {
                back = front = -1;
            }
        }
        return result;
    }

    public void printArray() {
        for (int i = 0; i < size; i++) {
            System.out.print(store[i] + ", ");
        }
    }

    public static void main(final String[] args) {
        final CircularBuffer buffer = new CircularBuffer(5);
        for (int i = 0; i < 7; i++) {
            buffer.insert(i);
        }
        for (int i = 0; i < 7; i++) {
            System.out.print(buffer.remove() + "  ");
        }
    }

}