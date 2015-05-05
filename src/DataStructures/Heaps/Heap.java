/*build a Min Heap*/


package DataStructures.Heaps;

import java.util.Random;

public class Heap {
    int [] array;
    int n;

    Heap(){
        array = new int[10];
        n = 0;
    }

    public int getLeftChild(int i){
        return 2*i +1;
    }

    public int getRightChild(int i){
        return 2*i +2;
    }

    public  int getParent(int i){
        return (i-1)/2;
    }

    public int getMin(){
        if(n==0){
            throw new RuntimeException("Heap is empty");
        }
        else{
            return array[0];
        }
    }

    //insert an item to heap.
    public void insertItem(int item){
        if(n ==  array.length){
            System.out.print("Priority Heap full. No more space to insert");
            return;
        }
        else if(n==0){
            array[0] = item;
            n++;
        }
        else{
            array[n] = item;
            bubbleUp(n);
            n++;
        }
    }

    public void bubbleUp(int n){
        if(n == 0)
            return;
        int parentIndex = getParent(n);
        if(array[n] < array[parentIndex]){
            int temp = array[n];
            array[n] = array[parentIndex];
            array[parentIndex] = temp;
            bubbleUp(parentIndex);
        }
    }


    //delete min from heap
    public void deleteMin(){
        if(n==0){
            throw new RuntimeException("Heap is empty.Nothing to delete");
        }
        else{

        }
    }

    public  static void main(String ... args){
        Heap heap = new Heap();
        Random random = new Random();
        for(int i = 0;i<5;i++){
            int x  = random.nextInt(100);
            System.out.println("Inserting " + x);
            heap.insertItem(x);
            System.out.println("Min " + heap.getMin());
        }
    }
}
