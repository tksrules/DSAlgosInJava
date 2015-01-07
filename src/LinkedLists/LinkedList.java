package LinkedLists;

public class LinkedList {
    ListNode head;

    public LinkedList() {
        head = null;
    }

    public void prepend(final int in) {
        final ListNode data = new ListNode(in);
        data.next = head;
        head = data;
    }

    public void appendToList(final int in) {
        final ListNode data = new ListNode(in);
        ListNode current = head;
        if (head == null) {
            head = data;
            return;
        }
        while (current.next != null) {
            current = current.next;
        }
        current.next = data;
    }

    public void printList(final ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println();
    }

    public ListNode reverseList(final ListNode node) {
        if (node == null) {
            return null;
        }
        if (node.next == null) {
            return node;
        }
        final ListNode secondElem = node.next;
        node.next = null;
        final ListNode reverseRest = reverseList(secondElem);
        secondElem.next = node;
        return reverseRest;
    }

    public ListNode findMiddle(final ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        if (head == null) {
            return head;
        }
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode MergeSort(final ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        final ListNode middle = findMiddle(head);
        final ListNode secondHalf = middle.next;
        middle.next = null;
        MergeSort(head);
        MergeSort(secondHalf);
        return null;
    }

    // merge two sorted linklists to one list
    public ListNode merge(final ListNode head1, final ListNode head2) {

    }
}
