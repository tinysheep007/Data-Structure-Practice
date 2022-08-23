public class stackWithTwoQueue {
    static queueLL q1=new queueLL();
    static queueLL q2=new queueLL();
    static int size;


    public stackWithTwoQueue(){
        size=0;
    }

    public static void push(int val){
        size++;

        q2.enqueue(val);

        // Push all the remaining 
        // elements in q1 to q2. 
        while (!q1.isEmpty()) { 
            q2.enqueue(q1.peek()); 
            q1.dequeue(); 
        } 

        queueLL temp=q1;
        q1=q2;
        q2=temp;
  
    }

    public static int pop(){
        //check if the entire stack is empty
        if(q1.isEmpty()){
            System.out.println("empty stack");
            return -1;
        }

        //save the data 
        int num=q1.dequeue();
        size--;
        return num;

    }

    public static int getSize(){
        return size;
    }

    public static void main(String[] args){
        stackWithTwoQueue stack= new stackWithTwoQueue();
        stack.push(3);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
