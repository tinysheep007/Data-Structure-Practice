import java.util.Scanner;
public class qqqquicksort {



    private static int split(int[] list, int lo, int hi){

        int left = lo+1;
        int right = hi;
        int pivot = list[lo];
    while(true){ 
        while(left <= right){
            if(list[left] < pivot){
                left++;
            }else{
                break;
            }
        }
        while(right > left){
            if(list[right] < pivot){
                break;
            }
            else{
                right--;
            }
        }

        if(left >= right){
            break;
        }
        
        int temp = list[left];
        list[left] = list[right];
        list[right] = temp;

        left++;
        right--;
    }

    list[lo] = list[left-1];
    list[left-1] = pivot;

        return left-1;
        
    }

    private static void sort(int[] list, int lo, int hi){
        if((hi - lo) <= 0){
            return;
        }
        int splitPoint = split(list, lo, hi);
        sort(list, lo, splitPoint-1); //left subarray recursion
        sort(list,splitPoint+1, hi); //right subarray recursion
    }

    public static void sort(int[] list){
        if(list.length <=1 ){
            return;
        }
        sort(list, 0, list.length-1);
    }


    public static void main(String[] args) {
        qqqquicksort check = new qqqquicksort();

        Scanner checker = new Scanner(System.in);

        System.out.println("Please enter size of array");
        int num = checker.nextInt();

        int[] arr = new int[num];

        for(int i = 0; i<arr.length; i++){
            arr[i] = (int)(Math.random() *20) + 1;
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        check.sort(arr);


        for(int i = 0; i<arr.length; i++){
           System.out.print(arr[i]+" ");
        }

        



        


        
    }


}