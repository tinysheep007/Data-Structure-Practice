public class queueLL {
    int val;
    queueLL next;
    queueLL head;
    int size=0;
    public queueLL(){
        this.next=null;
        this.head=null;

    }

    public queueLL(int val){
        this.val=val;
        this.next=null;
        this.head=null;
    }

    public void enqueue(int val){
        queueLL temp= new queueLL(val);
        queueLL cursor=head;
        if(head ==null){
            head=temp;
            size++;
        }
        else{
            while(cursor.next != null){
                cursor=cursor.next;
            }
            cursor.next=temp;
            size++;
        }
        
    }

    public int dequeue(){   
        if(head !=null){
            int num=head.val;
            head=head.next;
            size--;
            return num;
        }
        else{
            throw new NullPointerException("nothing in queue");
        }
    }

    public int peek(){
        if(head !=null){
            int num=head.val;
            return num;
        }
        else{
            throw new NullPointerException("nothing in queue");
        }
    }

    public int getSize(){
        return size;
    }
    
    public boolean isEmpty(){
        return head==null;
    }

    public void print(){
        try{
            queueLL cursor=head;
        
            while(cursor.next!=null){
                System.out.println(cursor.val);
                cursor=cursor.next;
            }
            
            System.out.println(cursor.val);
        }catch (NullPointerException e){
            System.out.println("null pointer");
        }
       
        
        
    }
    public static void main(String[] agrs){
        queueLL head= new queueLL();
        head.enqueue(3);
        head.enqueue(5);
        head.enqueue(10);
        head.print();
        System.out.println("After: ");
        head.dequeue();
        head.dequeue();
        //head.dequeue();
        System.out.println(head.peek());;
    }
}
