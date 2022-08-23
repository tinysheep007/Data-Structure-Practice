public class test {
    public static void main(){

    }

    //enqueue function
    public void enqueue(Item item){
        //edge case if empty
        if(isEmpty()){
            //create
            Node new_end=new Node();
            new_end.item=item;
            //connect to itself
            last=new_end;
            last.next=last;
            //increase size
            size++;
        }
        //create new node
        Node new_end=new Node();
        new_end.item=item;
        //connect new node's next to the head
        new_end.next=last.next;
        //connect the last to the new node
        last.next=new_end;
        //make the new node the new last
        last=new_end;
        size++;
    }

    //dequeue function
    public Item dequeue(){
        // if size==0
        if(isEmpty()){
            return null;
        }
        //store the item so we can return in the end
        Item result=last.next.item;
        last.next=last.next.next;
        size=size-1;
        //return result
        return result;

    }


    public static int countInRange(BSTNode root, int low, int high) {

        //if the entire thing is empty
        if (root == null)
            return 0;

        //we add one to the answer if 
        if ( (root.value>=low) && (root.value<=high)){
            return countInRange(root.left, low, high) + countInRange(root.right, low, high) + 1;
        }
        else if (root.value < low){
            //if the current value is too low, we check the right tree
            return countInRange(root.right, low, high);
        }
        else if(root.value > high){
            //if the current value is too high, we check left, so that value is smaller
            return countInRange(root.left, low, high);
        }
            
    }


    //Q 5.2
    Node h = x.right;
    Node left_saved = h.left;
    h.left = x;
    x.right = left_saved;
    
    //N O I  T U    Q    Y   S   A E
    14 15 9 20 21   17   25  19  1  5
  


}
