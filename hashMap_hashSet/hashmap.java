import java.util.*;
public class hashmap {
    public static void main(String[] args){
        HashMap<String, Integer> temp=new HashMap<String, Integer>();
      
        temp.put("first",1);
        temp.put("second",2);
        temp.put("third",3);
        System.out.println(temp);
       
        temp.put("first",100);
        temp.remove("second");
        for(String str : temp.keySet()){
            System.out.println("key: "+str+" value: "+temp.get(str));
        }

        
    }
}
