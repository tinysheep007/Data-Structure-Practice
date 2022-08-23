public class queueWithLast{
    queueWithLast front, last,next;
    int val;

    public queueWithLast(){
        this.front=null;
    }

    public queueWithLast(int val){
        this.front=null;
        this.val=val;

    }

    public void enqueue(int val){

        //save the address of old less
        queueWithLast oldLast=last;

        //make a new element with val
        queueWithLast temp= new queueWithLast(val);
        last=temp;
        last.next=null;
        if(isEmpty()){
            front=last;
        }
        else{
            oldLast.next=temp;
        }

    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("no item in queue");
            last=null;
            return -1;
        }
        else{
            int num=front.val;
            front=front.next;
            return num;
        }
    }

    public boolean isEmpty(){
        if(front==null){
            return true;
        }
        else
            return false;
    }

    public static void main(String[] args){
        queueWithLast queue=new queueWithLast();
        queue.enqueue(3);
        queue.enqueue(5);
        queue.enqueue(10);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}