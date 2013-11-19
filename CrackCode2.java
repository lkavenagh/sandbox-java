
public class CrackCode2 {
	
	public static void main(String args[]) {
		Node n = new Node();
		n.data = 3;
		n.appendToTail(4);
		
		traverseList(n);
	}
	
	public static void traverseList(Node root) {
		System.out.println(root.data);
		while (root.next != null) {
			root = root.next;
			System.out.println(root.data);
		}
	}
	
	
	
}