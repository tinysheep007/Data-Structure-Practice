public class test {
    public static int findMin(Node front){
        //make a new small varaibale as first data 
        int minNum=front.data;

        //loop through entire thing
        for(Node cursor=front.next;cursor != null; cursor.next=cursor.next.next){
            if( cursor.data < minNum){
                minNum=cursor.data;
            }
        }
        return minNum;
    }


    public String max(){
        String max="";
        if(!a.isEmpty()){
             max=a[0];

        }
        for(int i=0;i<a.length-1;i++){
            max= max.compareTo(a[i]);//what does it return
        }
        return max;

    }

    public void push(String item){
        for(int i = 0; i < a.length; i++){
            item = (item.compareTo(a[i]));
        }
        a[n++] = item;
    }

    public String max(){
        if(!a.isEmpty())
            String maxNum = a[0];
        push(maxNum);
        return pop();
    }
}
