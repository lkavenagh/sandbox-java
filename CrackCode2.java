
public class CrackCode2 {
	
	public static void main(String args[]) {
		Node n = new Node();
		n.data = 3;
		n.appendToTail(4);
		n.appendToTail(5);
		n.appendToTail(4);
		traverseList(n);
		Node newNode = new Node(9);
		n.insertAfter(newNode, 5);

		traverseList(n);
		traverseListBackwards(n);
		removeDuplicates(n);
		traverseList(n);
		
		System.out.println("2nd to last element is: " + getKthElement(n, 2));
		System.out.println("4th to last element is: " + getKthElement(n, 4));
		System.out.println("6th to last element is: " + getKthElement(n, 6));
		
		Node n1 = new Node(7);
		n1.appendToTail(1);
		n1.appendToTail(6);
		
		Node n2 = new Node(5);
		n2.appendToTail(9);
		n2.appendToTail(2);
		
		traverseList(n1);
		System.out.println("+");
		traverseList(n2);
		System.out.println("=");
		traverseList(addLists(n1, n2));
	}
	
	public static void traverseList(Node root) {
		System.out.print(root.data);
		
		while (root.next != null) {
			root = root.next;
			System.out.print("->" + root.data);
		}
		System.out.println("");
		
	}
	
	public static int length(Node root) {
		int length = 1;
		
		if (root == null) { return 0; }
		if (root.next == null) { return 1; }
		
		while (root.next != null) {
			length++;
			root = root.next;
		}
		return length;
	}
	
	public static void removeDuplicates(Node root) {
		Node n1 = root;
		Node n2 = root.next;
				
		if (length(n1) <= 1) { return; }

		while (n1.next != null) {
			while (n2 != null) {
				if (n1.data == n2.data) {
					if (n2.next != null) {
						n2.next.prev = n2.prev;
						n2.prev.next = n2.next;
					} else {
						n2.prev.next = null;
					}
				}
				n2 = n2.next;
			}
			n1 = n1.next;
			n2 = n1.next;
		}
	}
	
	public static void traverseListBackwards(Node root) {
		System.out.println("Linked list (backwards): ");
		while (root.next != null) {
			root = root.next;
		}
		
		while (root.prev != null) {
			System.out.print(root.data + "->");
			root = root.prev;
		}
		System.out.println(root.data);
	}
	
	public static int getKthElement(Node root, int k) {
		Node n1 = root;
		Node n2 = n1;
		
		if (length(root) < k) { return -1; }
		
		for (int i = 0; i < k-1; i++) { n2 = n2.next; }
		
		while (n2.next != null) {
			n1 = n1.next;
			n2 = n2.next;
		}
		
		return n1.data;
	}
	
	public static Node addLists(Node n1, Node n2) {
		//Assume n1 and n2 are same length
		Node n = new Node();
		Node head = n;
		int thisAdd = 0;
		int carry = 0;
		
		while (n1 != null) {
			
			thisAdd = carry + n1.data + n2.data;
			carry = thisAdd / 10;
			thisAdd = thisAdd % 10;

			n.data = thisAdd;
			
			n1 = n1.next;
			n2 = n2.next;
			
			if (n1 != null) { 
				n.next = new Node();
				n.next.prev = n;
				n = n.next;
			}
			
		}
		
		return head;
	}
	
	
	
}