package CrackingChapter2;

class Main {
    public static void main(final String[] args) {
        final LinkedList<Integer> list = new LinkedList<Integer>();
        list.addDataAtHead(10);
        list.addDataAtHead(12);

        list.addDataAtHead(10);
        list.addDataAtHead(9);
        list.addDataAtHead(8);
        list.addDataAtHead(8);
        list.addDataAtEnd(11);
        list.addDataAtEnd(12);
        list.display();
        list.removeDuplicates2();
        list.display();
    }
}