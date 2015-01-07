package LinkedLists;

public class ReverseList {

    public static void main(final String[] args) {
        // TODO Auto-generated method stub
        final LinkedList linkedList = new LinkedList();
        linkedList.appendToList(12);
        linkedList.appendToList(13);
        linkedList.appendToList(14);
        linkedList.appendToList(15);
        linkedList.printList(linkedList.head);
        final ListNode head = linkedList.reverseList(linkedList.head);
        linkedList.printList(head);
    }

}
