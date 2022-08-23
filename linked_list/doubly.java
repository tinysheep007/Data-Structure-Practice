public class doubly {
    //doubly linked list

    //two pointers: one to the front, one to the back
    doubly next;
    doubly prev;
    int key;

    //constrcutor 
    public doubly(int key){
        this.key=key;
        this.next=null;
        this.prev=null;
    }


    //inserting after an given node 
    public void publicstaticvoidinsertAfter(doubly prevNode,int data){
        //1.check edge case 
        //if prevNode is null
        if(prevNode==null){
            System.out.println("prev node is none");
            return;
        }

        //2.create a new node with the given data
        doubly temp=new doubly(data);

        //connect temp to previous one's next node
        temp.next=prevNode.next;
        //make the new node's previous one to the acutal previous given one
        temp.prev=prevNode;
        //change previous's next to the new node
        prevNode.next=temp;
        //change .next's previous to the new node
        if(temp.next!=null){
            temp.next.prev=temp;
        }
        
    }   


    public void deleteNode(doubly node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
}
