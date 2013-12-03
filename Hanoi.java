public class Hanoi {

	Tower[] towers;
	
	public Hanoi(int n) {
		towers = new Tower[n];
		
		//Initialize each tower with an index
		for (int i = 0; i < length(); ++i) {
			towers[i] = new Tower(i);
		}
	}	
	
	int length() {
		return towers.length;
	}
	
	Tower get(int i) {
		return towers[i];
	}
	
	void print(int n) {
		for (int i=0; i < length(); ++i) {
			towers[i].print(n);
		}
	}
}