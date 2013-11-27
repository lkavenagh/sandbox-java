import java.util.ArrayList;

public class SetOfStacks {
	int itemIdx = 0;
	int capacity = 10;
	int currSize = 0;
	ArrayList<Stack> sa = new ArrayList<Stack>();
	
	int pop() {
		int item = sa.get(itemIdx).pop();
		currSize--;
		if (currSize == 0) {
			itemIdx--;
			currSize = capacity;
		}
		
		return item;
	}
	
	void push(int d) {
		if (currSize == capacity) {
			itemIdx++;
			currSize = 0;
		}
		
		if (sa.size() <= itemIdx) {
			sa.add(new Stack());
		}
		sa.get(itemIdx).push(d);
		currSize++;
		
	}
	
	int peek() {
		return sa.get(itemIdx).peek();
	}
	
	int curStack() {
		return itemIdx;
	}
	
}
