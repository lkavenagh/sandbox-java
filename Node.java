
public class Node {
	
	Node next = null;
	int data;	
	
	public void appendToTail(int d) {
		Node end = new Node();
		end.data = d;
		
		Node n = this;
		while (n.next != null) { n = n.next; }
		
		n.next = end;
	}
	
}