
public class MinStack extends Stack {
	private Stack ms = new Stack();
	
	MinStack() {
		ms.push(Integer.MAX_VALUE);
	}
	
	void push(int d) {
		if (d < ms.peek()) {
			ms.push(d);
		}
		super.push(d);
	}
	
	int pop() {
		if (super.peek() == ms.peek()) {
			ms.pop();
		}
		return super.pop();
	}
	
	int min() {
		return ms.peek();
	}
}
