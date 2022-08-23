public class mergeSort {


    public static void main(String[] args){
        int[] arr={2,4,1,0,123123,12};
        mergeSort(arr, arr.length);
        print(arr);
    }

    public static void mergeSort(int[] a, int n) {
        //if size lower than 2 return nothing
        if (n < 2) {
            return;
        }
        //get the current mid index
        int mid = n / 2;
        //make arrays of appriopriate size
        int[] l = new int[mid];
        int[] r = new int[n - mid];
        //copy each half of the array
        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);
    
        merge(a, l, r, mid, n - mid);
    }

    //parameter (original array, left sub-array,right sub-array)
    public static void merge(int[] a, int[] l, int[] r, int left, int right) {
 
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
        a[k++] = r[j++];
        }
    }

    public static void print(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

}
