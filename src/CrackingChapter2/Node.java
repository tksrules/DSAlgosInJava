package CrackingChapter2;

class Node<Type> {

    private Type value;
    private Node<Type> next;

    public Node(final Type value, final Node<Type> next) {
        this.value = value;
        this.next = next;
    }

    /* accessor methods */

    /**
     * Returns the data containedå in this Node.
     * 
     * @return the object within this Node
     */
    public Type value() {
        return value;
    }

    /**
     * Returns the next node in the linked list.
     * 
     * @return reference to the next Node
     */
    public Node<Type> next() {
        return next;
    }

    /**
     * Sets the data that this Node should hold.
     * 
     * @param the
     *            object this Node should store
     */
    public void setValue(final Type value) {
        this.value = value;
    }

    /**
     * Sets the next node in the linked list.
     * 
     * @param reference
     *            to the next Node
     */
    public void setNext(final Node<Type> next) {
        this.next = next;
    }
}