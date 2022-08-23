public class selectionSort {
    
    public static void main(String[] args){
        int[] arr={4,5,5,1,3,6,1213,0,-2};
        System.out.println("original: ");
        print(arr);
        System.out.println();

        selection_sort_ascend(arr);
        
        System.out.println("asecend: ");
        print(arr);
        System.out.println();

        selection_sort_descend(arr);
        System.out.println("descend: ");
        print(arr);

        
    }

    //ascending order
    public static void selection_sort_ascend(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            //min holds the index value
            int min=i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            //swap the min and i
            int temp=arr[i];
            arr[i]=arr[min];
            arr[min]=temp;
        }
    }

    //descending order
    public static void selection_sort_descend(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            //min holds the index value
            int max=i;
            for(int j=i+1;j<n;j++){
                if(arr[j]>arr[max]){
                    max=j;
                }
            }
            //swap the min and i
            int temp=arr[i];
            arr[i]=arr[max];
            arr[max]=temp;
        }
    }

    public static void print(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
