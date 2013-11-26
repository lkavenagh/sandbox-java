
public class Stack {
	Node top;
	
	int pop() {
		if (top != null) {
			int item = top.data;
			top = top.next;
			return item;
		} 
		return -1;
	}
	
	void push(int d) {
		Node t = new Node(d);
		t.next = top;
		t.next.prev = t;
		top = t;
	}
	
	int peek() {
		return top.data;
	}
}
