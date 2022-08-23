public class linkedList{
    
    //instance varables
    int val;
    linkedList next;
    linkedList head;

    //create empty class
    public linkedList(){
        this.next=null;
        this.head=null;
    }

    //make a val
    public linkedList(int val){
        this.val=val;
    }

    //add a item at the end of linkedlist
    public void add(int val){
        linkedList temp= new linkedList(val);
        if(head == null){
            System.out.println("head is added: "+val);
            this.head=temp;
        }
        else{
            linkedList cursor=head;
            while(cursor.next != null){
                cursor=cursor.next;
            }
            cursor.next=temp;
        }
    }

    //delete a node form linked list
    public boolean delete(int val){
        //check if entire linked list is empty
        try{
            //if nothing is in the linkedList
            if(head == null){
                System.out.println("no item in linked list");
                return false;
            }
            //if head is getting deleted and there's element after it
            else if(head.val==val && head.next != null){
                head=head.next;
                return true;
            }
            //if head is getting deleted but there's no element after it 
            else if(head.val==val && head.next==null){
                linkedList temp=new linkedList();
                head=temp;
                return true;
            }
            else{
                    //make a new cursor which loop thourgh the linkedlist to find the deleting one
                    linkedList cursor=head;
                    linkedList prev=null;
                    while(cursor.next != null){
                        if(cursor.val==val){
                            prev.next=cursor.next;
                            return true;
                        }
                        prev=cursor;
                        cursor=cursor.next;
                    }
                    //check if last element is to be deleted
                    if(cursor.val==val){
                        prev.next=cursor.next;
                        return true;
                    }
                    else{
                        System.out.println("No such element found");
                        return false;
                    }
                    
            }
        }catch(NullPointerException e){
            System.out.println("deleting null pointer");
        }
        return false;
        }

    public void addFront(int val){
        linkedList temp= new linkedList(val);
        if(head==null){
            head=temp;
        }
        else{
            temp.next=head;
            head=temp;
        }
    }
    //print
    public void print(){
        try{
            linkedList cursor=head;
            
            while(cursor.next != null ){
                System.out.println(cursor.val);
                cursor=cursor.next;
            }
            System.out.println(cursor.val+ " end of the linkedlist");

 
        }catch(NullPointerException e){
            System.out.print("No element in linkedList");
        }
        
    }

    public static void main(String[] args){
        linkedList head=new linkedList();
        System.out.println("add 3, 5, 10: ");
        head.add(3);
        head.add(5);
        head.add(10);
        head.print();

        System.out.println("deleted 3: ");
        head.delete(3);
        head.print();

        System.out.println("deleted 10: ");
        head.delete(10);
        head.print();
        
        System.out.println("deleted 5: ");
        head.delete(5);
        head.print();
    }
}