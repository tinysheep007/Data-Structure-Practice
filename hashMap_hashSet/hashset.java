import java.util.*;

public class hashset {
    public static void main(String[] args){
        HashSet<Integer> set = new HashSet<Integer>();
        //doesnt ganrantee the input order is saved
        set.add(10);
        set.add(5);
        set.add(15);
        set.add(15);
        System.out.println(set); 
        set.remove(5);
        System.out.println(set);
    }
}
