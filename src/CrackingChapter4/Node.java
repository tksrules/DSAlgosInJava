package CrackingChapter4;

class Node {
    private int data;
    private Node left;
    private Node right;

    Node() {
        data = 0;
        left = right = null;
    }

    public int getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setData(final int data) {
        this.data = data;
    }

    public void setLeft(final Node left) {
        this.left = left;
    }

    public void setRight(final Node right) {
        this.right = right;
    }
}