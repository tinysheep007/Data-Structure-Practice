

public class LLApp {

	/**
	 * three steps to add an element at the front:
	 * 	1. Create a new node
	 *  2. Make the new node point to the first node of the original list
	 *  3. Make front (the variable which points to the first node of the list) point to the new node, otherwise the newly added node cannot be accessed

	 *
	 *  Note1: the third is essential! 
	 *  Since the first node of the linked list is no longer the original one, we need to let front point to the newly added node;
	 *  Otherwise, the new node is added into the list, but we still cannot access it without knowing its address.
	 *  Remember we can only access nodes starting from front. 
	 *  
	 *  Note2: the implementation works when the original list is empty, 
	 *         which means we build a new linked list by adding the first element
	 *  	
	 * @param item
	 * @param front
	 * @return
	 */
	public static IntNode addFront(int item, IntNode front) {
		return new IntNode(item, front); //It works when the original list is empty, meaning front is null
		//the following code has the same semantic
		/**
		 * IntNode newNode = new IntNode(item, null);
		 * newNode.next = front;
		 * front = newNode;
		 * return front;
		 */
	}

	/**
	 * delete and return the first node of a linked list
	 * 
	 * watch out for empty list!
	 * 
	 * @param front
	 * @return
	 */
	public static IntNode deleteFront(IntNode front) {
		if (front == null) {
			return null;
		}
		return front.next;
	}
	
	// while loop version, stylized single-line output
	public static void traverse(IntNode front) {//also can be changed to head/list/sll
		if (front == null) {
			System.out.println("Empty list"); //you can also throw an emptyListException
			return;
		}
		//
		System.out.print(front.data); // first item
		IntNode ptr = front.next; // prepare to loop starting with second item
		while (ptr != null) {
			System.out.print("->" + ptr.data);
			ptr = ptr.next;
		}
		System.out.println();
		
		/**
		 * ptr = front;
		 * while(ptr != null){
		 *  System.out.print("->" + ptr.data);
			ptr = ptr.next;
			}
		 */
	}

	public static boolean search(IntNode front, int target) {
		for (IntNode ptr = front; ptr != null; ptr = ptr.next) {
			if (target == ptr.data) {
				return true;
			}
		}
		return false;

	}

	/**
	 * the method works when 1. there is only one node in the original list.
	 *                       2. the node to be deleted is the the first node.
	 *                       3. the node to be deleted is the last one.
	 *                       4. the original list is empty
	 * @param front
	 * @param item
	 * @return
	 */
	public static IntNode delete(IntNode front, int item) {
		if (front == null) { //for empty list
			return null;
		}
		IntNode ptr = front, prev = null; //prev is to be used for pointing to the node before node-to-be-deleted
		while (ptr != null) {
			if (ptr.data == item) {
				break;
			}
			prev = ptr; //prev moves to the next element in each iteration to point to the node before ptr
			ptr = ptr.next;
		}
		if (ptr == null) { // item is not in list
			return front;
		}
		if (prev == null) { // first node is to be deleted
			return front.next;
			//what we want is to delete the first node. so we need to let front point to the second node of the orignial list
			//front = front.next; return front; //these two statements is equivalent to return front.next
		}
		prev.next = ptr.next; // let the node before node-to-be-deleted point to the node after node-to-be-deleted to delete
		return front;
	}
	
	// add newItem after currItem
	public static void addAfter(IntNode front, int currItem, int newItem) {
		IntNode ptr = front;
		while (ptr != null) {
			if (ptr.data == currItem) {
				break;
			}
			ptr = ptr.next;
		}
		if (ptr == null) { // currItem not in list
			return;
		}
		ptr.next = new IntNode(newItem, ptr.next);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IntNode front = null;
		
		traverse(front);  // test traverse on empty list
        System.out.println("\nadding 4 to front");
        front = addFront(4,front);
        //addFront(4,front);
        traverse(front);
        System.out.println("\nadding 6 to front");
        front = addFront(6,front);
        traverse(front);
        System.out.println("\nadding 8 to front");
        front = addFront(8,front);
        traverse(front);
        
        boolean flag = search(front, 5);
        if(flag)
        	System.out.println("5 is in the list");
        else
        	System.out.println("5 is not in the list");
        
        boolean flag2 = search(front, 6);
        if(flag2)
        	System.out.println("6 is in the list");
        else
        	System.out.println("6 is not in the list");
        
        System.out.println("\ndeleting front");
        front = deleteFront(front);
        traverse(front);
        System.out.println("\ndeleting front");
        front = deleteFront(front);
        traverse(front);
        System.out.println("\ndeleting front");
        front = deleteFront(front);
        traverse(front);
        System.out.println("\ndeleting front");
        front = deleteFront(front);
	}

}
