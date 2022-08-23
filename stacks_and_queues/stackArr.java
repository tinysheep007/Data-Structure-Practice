public class stackArr {
    int[] a;
    int top=0;
    public stackArr(int capacity){
        a=new int[capacity];
    }

    //push
    public void push(int val){
        a[top++]=val;
    }

    public boolean empty(){
        return top==0;
    }

    public int pop(){
        return a[--top];
    }

    public static void main(String[] agrs){

        stackArr a=new stackArr(10);
        a.push(5);
        a.push(3);
        System.out.println(a.pop());
        System.out.println(a.pop());
        a.push(10);

        //printout everything
        

    }
}
