
public class Node {
	
	Node next = null;
	Node prev = null;
	int data;	
	
	public Node(int d) {
		data = d;
	}
	
	public Node() {
		
	}
	
	public void appendToTail(int d) {
		Node end = new Node();
		end.data = d;
		
		Node n = this;
		while (n.next != null) { n = n.next; }
		
		n.next = end;
		end.prev = n;
	}
	
	public void insertAfter(Node newNode, int d) {
		Node n = this;
		
		while (n != null) {
			if (n.data == d) {
				if (n.next == null) {
					n.appendToTail(newNode.data);
					break;
				} else {
					newNode.next = n.next;
					newNode.prev = n;
					n.next = newNode;
					newNode.next.prev = newNode;
				}
			}
			n = n.next;
		}
	}
	
	public Node deleteNode(int d) {
		Node n = this;
		
		if (n.data == d) {
			n.next.prev = null;
			return n.next;
		}
		while (n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
				n.next.prev = n;
			}
			n = n.next;
		}
		
		return this;
	}
}