public class circular{
    //circular linked list

    circular rear;
    circular next;
    int key;

    public circular(int key){
        this.key=key;
        this.rear=null;
        this.next=null;
    }

    public boolean search(int data){
        if(rear==null){
            return false;
        }


        circular cur = rear.next;
        while(cur!=rear){
            if(cur.key==data){
                return true;
            }else{
                cur=cur.next;
            }
        }

        return rear.key==data;
    }

    public void addFront(int data){

        circular temp=new circular(data);
        if(rear==null){
            rear=temp;
            rear.next=rear;
        }else{
            temp.next=rear.next;
            rear.next=temp;
        }

    }

    public int deleteFront(){

        //empty list
        if(rear==null){
            return -1;
        }

        //save the data
        int temp=rear.next.key;

        //1 item in list
        if(rear.next==rear){
            rear=null;
        }

        //2 or more item
        rear.next=rear.next.next;


        return temp;

    }

}