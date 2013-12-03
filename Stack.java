
public class Stack {
	Node top;
	int stackSize = 0;
	
	int pop() {
		if (top != null) {
			int item = top.data;
			top = top.next;
			stackSize--;
			return item;
		} 
		return Integer.MIN_VALUE;
	}
	
	void push(int d) {
		Node t = new Node(d);
		stackSize++;
		if (top == null) {
			top = t;
			return;
		}
		t.next = top;
		t.next.prev = t;
		top = t;
		
	}
	
	int peek() {
		return top.data;
	}
	
	boolean isEmpty() {
		return top == null ? true : false;
	}

	int size() {
		return stackSize;
	}
	
	int get(int i) {
		int idx = 0;
		Node cur = top;
		while (cur != null && idx <= this.size()) {
			if (idx == i) {
				return cur.data;
			}
			idx++;
			cur = cur.next;
		}
		return Integer.MIN_VALUE;
	}
}
