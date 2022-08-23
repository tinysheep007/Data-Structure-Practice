public class insertionSort {
    
    public static void main(String[] args){
        int[] arr={-2,3,234,237,-2342,0,123,123,23};
        System.out.println("original: ");
        print(arr);
        System.out.println();


        insertion_sort_descend(arr);
        
        System.out.println("descending: ");
        print(arr);
        System.out.println();

        System.out.println("ascending: ");
        insertion_sort_ascend(arr);
        print(arr);

    }

    //descending order
    public static void insertion_sort_descend(int[] arr){
        //only for outter loop
        for(int i=1;i<arr.length;i++){
            //inner comparasion
            for(int j=i;j>0;j--){
                //if the last element is smaller than current one swap them
                //this means bigger element will be move to the front
                if(arr[j-1]<arr[j]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
                else{
                    break;
                }
            }
        }
    }

    //ascending
    public static void insertion_sort_ascend(int[] arr){
        //only for outter loop
        for(int i=1;i<arr.length;i++){
            //inner comparasion
            for(int j=i;j>0;j--){
                //if the last element is smaller than current one swap them
                if(arr[j-1]>arr[j]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
                else{
                    break;
                }
            }
        }
    }

    public static void print(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
