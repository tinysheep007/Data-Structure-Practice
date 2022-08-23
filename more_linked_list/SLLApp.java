

public class SLLApp {

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
	public static StringNode addFront(String item, StringNode front) {
		return new StringNode(item, front); //It works when the original list is empty, meaning front is null
		//the following code has the same semantic
		/**
		 * StringNode newNode = new StringNode(item, null);
		 * node.next = front;
		 * front = node;
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
	public static StringNode deleteFront(StringNode front) {
		if (front == null) {
			return null;
		}
		return front.next;
	}
	
	// while loop version, stylized single-line output
	public static void traverse(StringNode front) {
		if (front == null) {
			System.out.println("Empty list");
			return;
		}
		System.out.print(front.data); // first item
		StringNode ptr = front.next; // prepare to loop starting with second item
		while (ptr != null) {
			System.out.print("->" + ptr.data);
			ptr = ptr.next;
		}
		System.out.println();
	}

	public static boolean search(StringNode front, String target) {
		for (StringNode ptr = front; ptr != null; ptr = ptr.next) {
			if (target.equals(ptr.data)) {
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
	public static StringNode delete(StringNode front, String item) {
		if (front == null) { //for empty list
			return null;
		}
		StringNode ptr = front, prev = null; //prev is to be used for pointing to the node before node-to-be-deleted
		while (ptr != null) {
			if (ptr.data.equals(item)) {
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
		}
		prev.next = ptr.next; // let the node before node-to-be-deleted point to the node after node-to-be-deleted to delete
		return front;
	}
	
	// add newItem after currItem
	public static void addAfter(StringNode front, String currItem, String newItem) {
		StringNode ptr = front;
		while (ptr != null) {
			if (ptr.data.equals(currItem)) {
				break;
			}
			ptr = ptr.next;
		}
		if (ptr == null) { // currItem not in list
			return;
		}
		ptr.next = new StringNode(newItem, ptr.next);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StringNode front = null;
		
		traverse(front);  // test traverse on empty list
        System.out.println("\nadding apple to front");
        front = addFront("apple",front);
        traverse(front);
        System.out.println("\nadding banana to front");
        front = addFront("banana",front);
        traverse(front);
        System.out.println("\nadding mango to front");
        front = addFront("mango",front);
        traverse(front);
        
        
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
