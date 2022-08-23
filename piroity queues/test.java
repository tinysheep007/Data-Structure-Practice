public class test {

    // if(key == a[mid]){
    //     while( a[mid + 1] != key ){
    //         //if the next index is within the range
    //         if(mid + 1 == a.length){
    //         break;
    //         }
    //         else{
    //         mid++;
    //         }
    //     }
    //     //returning ans
    //     return mid;

    // }


    public void put(Key key, Value val){

        int index = key % 9;
        for(Node x = hashmap[index]; x != null; x = x.next){
          if(key.equals(x.key)){
            x.val = val;
            return;
          }
        }
        ds[index] = new Node(key, val, hashmap[i]);
      }

}
