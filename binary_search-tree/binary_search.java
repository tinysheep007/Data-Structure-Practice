public class binary_search{

    public static int while_search(int[] arr, int key ){
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=(high+low)/2;
            if(arr[mid]==key){
                return key;
            }

            if(key>arr[mid]){
                low=mid+1;
            }

            if(key<arr[mid]){
                high=mid-1;
            }
        }
        //not found match
        return -1;
    }


    public static int recursive_search(int[] arr, int low, int high, int key){

        int mid=(low+high)/2;
        
        if(arr[mid]==key){
            return key;
        }

        if(key>arr[mid]){
            recursive_search(arr, mid+1, high, key);
        }
        else if(key<arr[mid]){
            recursive_search(arr, low, mid-1, key);
        }
        
        //if nothing found

        return -1;
    }


}