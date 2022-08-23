import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;


public class binary_search_tree {

    //table of content

    public static void main(String[] args){
        binary_search_tree tree=new binary_search_tree();
        // tree.insert(40);
        // tree.insert(20);
        // tree.insert(60);
        // tree.insert(10);
        // tree.insert(30);
        // tree.insert(50);
        // tree.insert(70);
        // tree.print();
        // System.out.println(tree.countInRange(tree.root, -15, 25));


        tree.insert(1);
        tree.insert(-1);
        tree.insert(3);
        tree.insert(2);
        tree.insert(5);
        tree.print();
        
        // tree.delete(70);
        // tree.delete(40);
        // tree.delete(30);
        //System.out.println(tree.floor(tree.root,60));
        //System.out.println(tree.ceiling(15));
        System.out.println("inorder: "+tree.inOrder());
        System.out.println("preorder: "+tree.preOrder());
        System.out.println("postorder: "+tree.postOrder());
        System.out.println("level: "+tree.height(tree.root));
        //System.out.println(tree.rank(1));
    }





    //I implement the BST Node class first
    private static class Node {
        private int key;
        private Node left, right;
        private int size;

        //By default a Node will have a key and size 1
        public Node(int k) {
            key = k;
            left = null;
            right = null;
            size = 1;
        }
    }

    //The BST Object stores a reference to the root of the tree
    private Node root;

    public binary_search_tree(){
        root=null;
    }

    //Wrapper method for size, makes sure null nodes are handled
    public static int size(Node n) {
        return (n == null) ? 0 : n.size;
    }

    //This is a method to print out the BST in your terminal to help you test
    //Not part of your curriculum, but you can try to understand it after completing this problemset!
    private static void print(Node n, String indent, boolean isRight, boolean isRoot) {
        System.out.print(indent);
        
        if (!isRoot) System.out.print(isRight ? "|-R- " : "|-L- ");
         
        else System.out.print("|--- ");
        if (n == null) {
            System.out.println("null");
            return;
        }
        
        System.out.println(n.key);

        if (n.left == null && n.right == null) return;

        indent += isRight ? "|    " : "    ";

        print(n.right, indent, true, false);
        print(n.left,  indent, false, false);
    }

    //Wrapper non-recursive method which doesn't require parameters
    //This makes it so that you can run the method simply as ".print()" in your main method
    public void print() {
        print(root, "", false, true);
    }

    //Takes in a node and key, and returns the node after the new element is inserted
    private static Node insert(Node n, int k) {
        //If current node is null, return a new node with new key
        if (n == null) return new Node(k);

        //If new key is smaller, set n.left to a recursive call
        if (k < n.key) n.left = insert(n.left, k);

        //If new key is bigger, set n.right to a recursive call
        else if (k > n.key) n.right = insert(n.right, k);

        //Update the size of the current node, and then return it
        n.size = size(n.left) + size(n.right) + 1;
        return n;

        //Note that if k == n.key, nothing happens and n is returned unchanged
    }

    //Public wrapper method, only takes in k and applies insert to the root
    public void insert(int k) {
        root = insert(root, k);
    }






    //level order traversal
    public void printLevel() {
        Queue<Node> q = new LinkedList<>();
        q.add(root); //Enqueue the root
    
        //Keep going until we run out of nodes to print
        while (!q.isEmpty()) {
            //Store the dequeued node
            Node temp = q.remove();
    
            //Enqueue the left and right if they're not null
            if (temp.left != null) q.add(temp.left);
            if (temp.right != null) q.add(temp.right);
    
            //Print out the current node and continue
            System.out.print(temp.key + " ");
        }
    }


    //in order traversal
    public Queue<Integer> inOrder(){
        Queue<Integer> q=new LinkedList<>();
        in_order_trav(root, q);
        return q;
    }
    private void in_order_trav(Node x, Queue<Integer> q){

        if(x==null){
            return;
        }
        in_order_trav(x.left,q);
        q.add(x.key);
        in_order_trav(x.right, q);
    }


    //pre order traversal
    public Queue<Integer> preOrder(){
        Queue<Integer> q=new LinkedList<>();
        pre_order_trav(root, q);
        return q;
    }
    private void pre_order_trav(Node x, Queue<Integer> q){

        if(x==null){
            return ;
        }
        q.add(x.key);
        pre_order_trav(x.left, q);
        pre_order_trav(x.right, q);
    }

    //post order
    public Queue<Integer> postOrder(){
        Queue<Integer> q=new LinkedList<>();
        post_order_tra(root, q);
        return q;
    }

    private void post_order_tra(Node root,Queue<Integer> q){
        if(root==null){
            return;
        }
        post_order_tra(root.left, q);
        post_order_tra(root.right, q);
        q.add(root.key);
    }


        //Takes in current node, returns max of that subtree
    private static int max(Node n) {
        //If there is no right subtree, just return key
        if (n.right == null) return n.key;

        //Otherwise, recurse on the right
        return max(n.right);
    }

    //Wrapper method with no arguments, calls max on root
    public int max() {
        return max(root);
    }







    //Takes in a node and key, returns whether the key is present in the subtree
    private static boolean search(Node n, int k) {
        //If n is null, the key isn't present
        if (n == null) return false;

        //If k == n.key, we've found the element
        if (k == n.key) return true;

        //If k is too small, search on the left, and otherwise search on the right
        if (k < n.key) return search(n.left, k);
        return search(n.right, k);
    }

    //Wrapper method which only requires k, and runs search on root
    public boolean search(int k) {
        return search(root, k);
    }


    //kth largest element
    //Takes in current node and k, returns the key of the kth largest element in the subtree
    private static int kthLargest(Node n, int k) {
        //If the size of the right subtree is k-1, just return key
        if (size(n.right) == k-1) return n.key;

        //If it's bigger, recursively search on the right
        if (size(n.right) >= k) return kthLargest(n.right, k);
        
        //If it's smaller, search on the left, but adjust k to remove current node and right subtree
        return kthLargest(n.left, k-size(n.right)-1);
    }

    //Wrapper method which only needs k, and runs kthLargest on root
    public Integer kthLargest(int k) {
        return kthLargest(root, k);
    }





    //rank
    //Takes in the current node and a target, returns the rank of the target in the tree
    private static int rank(Node n, int target) {
        //If we find the target, we can simply return the size of the left subtree
        if (target == n.key) return size(n.left);
        
        //If target is less, we can recursively search on the left
        if (target < n.key) return rank(n.left, target);
        
        //If it's greater, we need to add size(n.left) + 1 to the rank in the right subtree
        return size(n.left) + 1 + rank(n.right, target);
    }

    //Wrapper method which only needs target and calls rank on root
    public int rank(int target) {
        return rank(root, target);
    }



    //select 
    //given the rank of the item, return the key of target
    public int select(int k){ 
        return select(root, k); 
    } 

    private int select(Node x, int k) { 

        if (x == null) return -1; 

        int t = size(x.left); 

        if (t > k){
            return select(x.left, k); 
        } 

        else if (t < k){
            return select(x.right, k-t-1); 
        } 
        else if (t == k){
            return x.key; 
        } 

        return x.key;
    

    } 


    //ceiling
    private static Integer ceiling(Node n, int target) {
        //If n is null, no ceiling was found so we return null 
        if (n == null) return null;
    
        //If we found the exact key, we can simply return it
        if (target == n.key) return n.key;
        
        //If we are still less than target, we know our solution is on the right
        if (target > n.key) return ceiling(n.right, target);
    
        //If we're greater, we first store the result to the left    
        Integer leftCeil = ceiling(n.left, target);
        
        //If no ceiling found, return current key
        //Otherwise, return that value
        return (leftCeil == null) ? n.key : leftCeil;
    }
    
    //Wrapper method which only needs target, and runs ceiling on root
    public Integer ceiling(int target) {
        return ceiling(root, target);
    }

    
    //floor need fixing
    /*This function is used to find floor of a key*/
    static int floor(Node root, int key)
    {
        if (root == null)
            return Integer.MAX_VALUE;
  
        /* If root->data is equal to key */
        if (root.key == key)
            return root.key;
  
        /* If root->data is greater than the key */
        if (root.key > key)
            return floor(root.left, key);
  
        /* Else, the floor may lie in right subtree 
    or may be equal to the root*/
        int floorValue = floor(root.right, key);
        return (floorValue <= key) ? floorValue : root.key;
    }

    //floor 2
    public int floor2(int key){
        return floor2(root, key); 
    } 

    private int floor2(Node x, int key) { 

    if (x == null) return -1; 
    
    if(key==x.key) return x.key;
    if (key<x.key) return floor2(x.left, key);
 
    int t=floor(x.right,key);
    if(t!=-1){
        return t;
    }
    else
        return x.key;
    } 

    //deletetion
    public void delete(int key) { root = delete(root, key); } 

    private Node delete(Node x, int key) { 

    if (x == null) return null; 

    if (key < x.key) x.left = delete(x.left, key);
    else if (key > x.key) x.right = delete(x.right, key);
    else { 

    if (x.right == null) return x.left;
    if (x.left == null) return x.right; 

    Node t = x; 

    x = min(t.right); 

    x.right = deleteMin(t.right); x.left = t.left; 

    } 

    x.size = size(x.left) + size(x.right) + 1; return x; 

    } 

    //delete minimum
    public void deleteMin() 

    { root = deleteMin(root); } 

    private Node deleteMin(Node x) { 

    if (x.left == null) return x.right; 

    x.left = deleteMin(x.left); 

    x.size = 1 + size(x.left) + size(x.right); return x; 

    } 

    //find minimum
    private Node min(Node x){
        if(x.left==null){
            return x;
        }
        else
            return min(x.left);

    }

    public int min(){
        if(root==null){
            return -1;
        }
        return min(root).key;
    }



    public static int countInRange(Node root, int low, int high) {
        if (root == null)
            return 0;
        if (root.key <= high && root.key >= low)
            return countInRange(root.left, low, high) + countInRange(root.right, low, high) + 1;
        else if (root.key < low)
            return countInRange(root.right, low, high);
        else
            return countInRange(root.left, low, high);
    }

    public static int height(Node root){
        if(root==null){
            return 0;
        }
        return 1+Math.max(height(root.left),height(root.right));
    }
    
}
