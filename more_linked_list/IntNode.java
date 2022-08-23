

public class IntNode {
	int data;
	IntNode next;
	
	public IntNode(int data, IntNode next) {
		this.data = data;
		this.next = next;
	}

	/**
	 * return the string representation of an IntNode object
	 */
	public String toString() {
		return data+"";
	}
}