import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class MaxPQ {
    //We'll be using an arraylist to handle resizing automatically
    private ArrayList<Integer> heap;

    //Constructor for empty heap
    public MaxPQ() {
        heap = new ArrayList<Integer>();
        heap.add(0); //We ignore index 0, just add a dummy value
    }

    //Constructor for preexisting arraylist (might not be heap yet)
    public MaxPQ(ArrayList<Integer> h) {
        heap = h;
        heap.add(0, 0); //We ignore index 0, just add a dummy value at the beginning
    }

    //methods section:


    //Sifts up index i until it is less than its parent
    public void siftUp(int i) {
        //Keep going until i possibly reaches 1
        while (i > 1) {
            //If i > parent, swap them and update i to its parent
            if (heap.get(i) > heap.get(i/2)) {
                Collections.swap(heap, i, i/2);
                i /= 2;
            }
                
            //Otherwise we're done, and i is in the right place
            else break;
        }
    }

    //Inserts an element into the heap
    public void insert(int n) {
        //Add the element to the end and sift it up
        heap.add(n);
        siftUp(heap.size()-1);
    }

    //Sifts down index i until it is greater than both children
    public void siftDown(int i) {
        //Keep going until there are no children to check
        while (i*2 < heap.size()) {
            int newI; //Will store the greater child

            //If no right child or left child is bigger, newI is left child, otherwise right child
            if (1+i*2 == heap.size() || heap.get(i*2) > heap.get(1+i*2)) newI = i*2;
            else newI = 1+i*2;
                
            //If i is less than its child, swap them and update i
            if (heap.get(i) < heap.get(newI)) {
                Collections.swap(heap, i, newI);
                i = newI;
            }

            //Otherwise i is in the right spot, we're done
            else break;
        }
    }

    //Deletes and returns the max element in the heap
    public int deleteMax() {
        int mx = heap.get(1); //We know the max is stored at index 1

        //Swap the last value in, remove the current max from the heap
        Collections.swap(heap, 1, heap.size()-1);
        heap.remove(heap.size()-1);

        //Sift down the previous last value, and return the max
        siftDown(1);
        return mx;
    }

    //Converts the current arraylist to a valid heap
    public void heapify() {
        //Start at the parent of the last element
        int i = (heap.size() - 1) / 2; 

        //Sift down and decrement i until i = 0
        while (i >= 1) {
            siftDown(i);
            i--;
        }
    }


    public int[] mergeHeaps(int[] maxHeap1, int[] maxHeap2){

        int[] ans=new int[maxHeap1.length+maxHeap2.length-1];

        for(int i=0;i<maxHeap1.length;i++){
            ans[i]=maxHeap1[i];
        }

        for(int j=1;j<maxHeap2.length;j++){
           
            ans[maxHeap1.length -1 + j] = maxHeap2[j];
        }
        int size=ans.length;
        for(int a=size/2; a>=1 ; a--){
            sink(ans,size,a);
        }

        return ans;
    }


    //Returns the top k elements of the given arraylist
    public static ArrayList<Integer> topK(ArrayList<Integer> a, int k) {
        //Initialize a new heap with the arraylist, and heapify it
        MaxPQ pq = new MaxPQ(a);
        pq.heapify();

        //Sol will be used to store the top k elements
        ArrayList<Integer> sol = new ArrayList<Integer>();

        //Simply deleteMax() k times 
        for (int i = 0; i < k; i++) sol.add(pq.deleteMax());
        
        //Return our final arraylist
        return sol;
    }

    //Print method to help with testing
    public void print(int index, String indent, boolean isRight, boolean isRoot) {
        System.out.print(indent);

        if (!isRoot) System.out.print(isRight ? "|-R- " : "|-L- ");
        else System.out.print("|--- ");

        if (index >= heap.size()) {
            System.out.println("empty");
            return;
        }
        
        System.out.println(heap.get(index));

        if (2*index >= heap.size()) return;

        indent += isRight ? "|    " : "    ";

        print(2*index+1, indent, true, false);
        print(2*index,  indent, false, false);
    }

    //Print wrapper method with no parameters
    public void print() {
        print(1, "", false, true);
        System.out.println();

        System.out.println("Array Storage: " + heap);
        System.out.println("Index 0 is ignored for the heap structure");
    }





    public static void main(String[] args){
        MaxPQ temp= new MaxPQ();
        temp.insert(2);
        temp.insert(3);
        temp.insert(4);
        temp.insert(5);
        temp.print();

        //;
        //temp.print();

    }
}