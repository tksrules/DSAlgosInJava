/**
 * Highly used for implementing priority queues.
 * 
 * For any element in array position i, the left child is in position 2i, 
 * the right child is in the cell after the left child (2i + 1), and the parent is in position [i/2];
 * 
 * Heap property: Min heap - In a heap, for every node X, the key in the parent of X is smaller than 
 * (or equal to) the key in X, with the exception of the root (which has no parent).
 * 
 * Heap insertion - O(log N). d+1 comparisons if node is percolated d levels up.
 * Heap deletion - O(log N). percolate down.
 * Heap findMin - O(1)
 * BuildHeap - O(n)
 * 
 * http://www.cse.hut.fi/en/research/SVG/TRAKLA2/tutorials/heap_tutorial/lisaaminen.html
 */

//lets build max heap here

package DataStructures;

public class BinaryHeap {

    int[] array;

    public BinaryHeap(final int[] arr) {
        array = arr;
    }

    public int getParent(final int i) {
        return (i - 1) / 2;
    }

    public int getLeftChild(final int i) {
        return (2 * i) + 1;
    }

    public int getRightChild(final int i) {
        return (2 * i) + 2;
    }

    public void heapify(final int i) {
        final int left = getLeftChild(i);
        final int right = getRightChild(i);
        int greatest = i;
        if (left < array.length && array[left] > array[i]) {
            greatest = left;
        }
        if (right < array.length && array[right] > array[greatest]) {
            greatest = right;
        }
        if (greatest != i) {
            swap(greatest, i);
            heapify(greatest);
        }
    }

    public void swap(final int pos1, final int pos2) {
        final int temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }

    public void buildHeap() {
        for (int i = (array.length - 1 / 2); i >= 0; i--) {
            heapify(i);
        }
    }

    /*
     * Inserting a new item into a binary heap: Store the new item at the last empty cell in the array (the levels are
     * occupied from left to right) Lift the new item into its correct position by performing swaps with its father
     * until the heap order property is satisfied.
     */
    public void insert() {

    }

    /*
     * Replace the root node with the last element in the heap . Remove the last element Swap (i.e. heapify) the new
     * root with its child until the correct position has found
     */
    public void deleteMax() {

    }

    /*
     * HeapSort Heap can be utilized in sorting as well. A maximum heap is built using the linear time algorithm. After
     * this, the largest item is deleted N times. The largest item can be added to the position that became empty as a
     * result of the deletion. Since the items are removed from the largest to the smallest (maxheap) and the deleted
     * item is placed at the empty position at the end of the array, the items will end up in order from smallest to
     * largest.
     */

    public static void main(final String[] args) {
        final int[] pq = new int[] { 8, 7, 9, 3, 16, 14, 10, 2, 4, 1 };
        final BinaryHeap bh = new BinaryHeap(pq);
        bh.buildHeap();
        for (final int x : pq) {
            System.out.print(x + " ");
        }
    }
}
