public class reverseString {

    public static void main(String[] args){
        String a="asd";
        String b="";
        System.out.println(a.charAt(1));
        for(int i=a.length()-1;i>=0;i--){
            b=b+a.charAt(i);
        }
        System.out.println(b);
    }
    
}
