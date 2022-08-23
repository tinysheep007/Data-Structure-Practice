public class separateChaining {

    private class node{
        int val;
        node next;
        public node(int val){
            this.val=val;
            this.next=null;
        }

       
    }

    //instance variables
    node[] array;
    int size;
    public separateChaining(int sizes){
        array=new node[sizes];
        this.size=sizes;
    }

    public int hash(int num){
        int ans=num;
        ans=ans % 9;
        return ans;
    }

    public void put(int num){
        int hashCode=hash(num);

        if(array[hashCode] == null){
            node temp= new node(num);
            array[hashCode]=temp;
        }
        else {
            node temp=new node(num);
            temp.next=array[hashCode];
            array[hashCode]=temp;
        }
    }

    public void print(){
        for(int i=0;i<array.length;i++){
            System.out.println("index at "+i+" key:");
            
            for(node a=array[i];a!=null;a=a.next){
                
                 System.out.println(a.val+" -> ");
                
            }
            
        }
    }

    public static void main(String[] agrs){
        separateChaining a=new separateChaining(10);
        a.put(5);
        a.put(28);
        a.put(19);
        a.put(15);
        a.put(20);
        a.put(33);
        a.put(12);
        a.put(17);
        a.put(10);
        a.print();

        //5, 28, 19, 15, 20, 33, 12, 17, 10
    }
}
