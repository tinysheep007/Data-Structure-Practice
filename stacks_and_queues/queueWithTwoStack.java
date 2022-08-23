public class queueWithTwoStack {
    static stackLL s1=new stackLL();
    static stackLL s2=new stackLL();

    public static void enqueue(int val){
        //pop everyting from s1 to s2
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }

        //push the new key
        s1.push(val);

        //move everything back from s2 to s1
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }

    public static int dequeue(){
        
        int num=s1.peek();
        s1.pop();
        return num;
    }

    public static void main(String[] agrs){
        enqueue(5);
        enqueue(10);
        System.out.println(dequeue());
        System.out.println(dequeue());
    }
    
}
