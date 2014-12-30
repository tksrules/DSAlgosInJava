package Generics;

public class Stack<T> {
    T[] store;
    int top = -1;
    final int size = 5;

    Stack() {
        store = (T[]) new Object[size];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == size - 1);
    }

    public T peek() {
        return store[top];
    }

    public void push(final T element) throws ArrayIndexOutOfBoundsException {
        if (!isFull()) {
            top++;
            store[top] = element;
        } else {
            throw new ArrayIndexOutOfBoundsException("Stack is full");
        }
    }

    public T pull() throws ArrayIndexOutOfBoundsException {
        if (!isEmpty()) {
            return store[top--];
        } else {
            throw new ArrayIndexOutOfBoundsException("Empty stack. nothing to pop");
        }
    }

    public static void main(final String[] args) {
        final Stack<Integer> intstack = new Stack<Integer>();
        intstack.push(5);
        intstack.push(3);
        intstack.push(4);
        System.out.println(intstack.peek());
    }
}