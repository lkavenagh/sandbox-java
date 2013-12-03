public class Tower {

	Stack discs;
	int index;
	
	public Tower(int i) {
		discs = new Stack();
		index = i;
	}
	
	public void add(int d) {
		discs.push(d);
	}
	
	public int index() {
		return index;
	}
	
	public void moveDiscs(int n, Tower dest, Tower buf, Hanoi h) {
		if (n > 0) {
			//First, move the discs above the current one to the buffer,
			//using the destination as a 'buffer'
			moveDiscs(n-1, buf, dest, h);
			//Then, move this one to the destination
			this.moveTop(n, dest, h);
			//Then, move the buffer to the destination,
			//using this as the buffer
			buf.moveDiscs(n-1, dest, this, h);
		}
	}
	
	public void moveTop(int n, Tower dest, Hanoi h) {
		int d = discs.pop();
		dest.add(d);
		System.out.println("Moved disc " + d + " from " + this.index() + " to " + dest.index());
		h.print(3);
	}
	
	public void print(int n) {
		for (int i = discs.size()-1; i >= 0; --i) {
			if (discs.get(i) >= 0 && i <= discs.size()) {
				System.out.print(discs.get(i));
			} else {
				System.out.print('-');
			}
		}
		int empties = n - discs.size();
		for (int i = 0; i < empties; ++i) {
			System.out.print('-');
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		int n = 6;
		
		Hanoi towers = new Hanoi(3);
		
		//Initialize tower 0 with n discs
		for (int i = 0; i < n; ++i) {
			towers.get(0).add(n-i-1);
		}
		
		towers.print(3);
		towers.get(0).moveDiscs(n, towers.get(2), towers.get(1), towers);
	}
}

