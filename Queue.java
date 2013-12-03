
public class Queue {
	Node first;
	Node last;
	
	public Queue() {
		first = null;
		last = null;
	}
	
	void enqueue(int d) {
		if (first == null) {
			first = new Node(d);
		} else if (first.next == null) {
			first.next = new Node(d);
			last = first.next;
		} else {
			last.next = new Node(d);
			last = last.next;
		}
	}
	
	int dequeue() {
		if (first == null) { return Integer.MIN_VALUE; }
		
		int item = first.data;
		if (first.next == null) {
			first = null;
			last = null;
			return item;
		} else {
			first = first.next;
			return item;
		}
	}
	
	void print() {
		Node n = first;
		System.out.print("Queue: ");
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}
	
	boolean isEmpty() {
		return first == null ? true : false;
	}
}
