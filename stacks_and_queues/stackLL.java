public class stackLL {

    //instance variable
    int val;
    stackLL next;
    stackLL head;

    //initiate empty stack head
    public stackLL(){
        this.next=null;
        this.head=null;
    }

    //initiate an stack element with val
    public stackLL(int val){
        this.val=val;
    }

    //push item to the stack
    public void push(int val){
        stackLL temp=new stackLL(val);
        if(head ==null){
            this.head=temp;
        }
        else{
            temp.next=head;
            head=temp;
        }
    }

    

    //pop the first element (cloest to the head)
    public int pop(){
        stackLL cursor=head;
        int num;
        if(cursor == null){
            System.out.println("poping a empty stack");
            return 0;
        }else{
            num=head.val;
            this.head=head.next;
            
        }
        return num;
        
    }

    //peek
    public int peek(){
        if(head==null){
            System.out.println("peeking at empty stack");
            return -1;
        }
        else{
            return head.val;
        }
    }

    //fastder peek
    public void peekf(){
        head.push(pop());
    }

    //check is it empty
    public boolean isEmpty(){
        return head==null;
    }
    
    //print out everything
    public void print(){
        try{
            stackLL cursor=head;
            while(cursor.next != null){
                System.out.println(cursor.val);
                cursor=cursor.next;
            }
            System.out.println(cursor.val);

            
        }catch(NullPointerException e){
            System.out.println("no more item");
        }

       
    }

    public static void main(String[] args){
        stackLL head=new stackLL();
        head.push(1);
        head.push(2);
        head.push(3);
        head.print();
        System.out.println("first pop: ");
        
        head.peek();
        
        //head.pop();
       // head.pop();
        //head.pop();
        
       
        
    }
}
