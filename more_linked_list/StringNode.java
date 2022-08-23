
public class StringNode {
	String data;
	StringNode next;
	
	public StringNode(String data, StringNode next) {
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
