package CrackingChapter2;

import java.util.HashSet;
import java.util.Set;

class LinkedList<Type> {
    Node<Type> head = null;

    LinkedList() {
        head = null;
    }

    public void addDataAtHead(final Type data) {
        final Node<Type> newNode = new Node<Type>(data, null);
        if (head == null) {
            head = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
    }

    public void addDataAtEnd(final Type data) {
        final Node<Type> newNode = new Node<Type>(data, null);
        if (head == null) {
            head = newNode;
        } else {
            Node<Type> current = head;
            while (current.next() != null) {
                current = current.next();
            }
            current.setNext(newNode);
        }
    }

    public void display() {
        Node<Type> current = head;
        System.out.println();
        while (current != null) {
            System.out.print(current.value() + "-->");
            current = current.next();
        }
    }

    // Delete duplicates .using extra space
    public void removeDuplicates1() {
        final Set<Type> store = new HashSet<Type>();
        // just zero or one node in linkedlist. no duplciates possible;
        if (head == null || head.next() == null) {
            return;
        }
        Node<Type> current = head;
        Node<Type> previous = head;

        while (current != null) {
            if (store.contains(current.value())) {
                current = current.next();
                previous.setNext(current);
            } else {
                store.add(current.value());
                previous = current;
                current = current.next();
            }
        }
    }

    // Delete duplicates .without using extra space
    public void removeDuplicates2() {
        // just zero or one node in linkedlist. no duplciates possible;
        if (head == null || head.next() == null) {
            return;
        }
        Node<Type> current = head;

        while (current != null) {
            Node<Type> previous = current;
            Node<Type> looper = current.next();
            while (looper != null) {
                if (looper.value() == current.value()) {
                    previous.setNext(looper.next());
                    looper = looper.next();
                } else {
                    previous = looper;
                    looper = looper.next();
                }
            }
            current = current.next();
        }
    }
}