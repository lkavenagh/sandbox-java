import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Arrays;

public class BST {
	
	TreeNode root;
	
	public BST(int d) {
		root = new TreeNode(d);
	}
	
	public BST() {
		
	}
	
	public void insert(int d) {
		TreeNode cur = root;
		if (cur == null) {
			root = new TreeNode(d);
			return;
		}
		while (cur != null) {
			if (d < cur.data) {
				if (cur.leftChild == null) {
					cur.leftChild = new TreeNode(d);
					cur.leftChild.parent = cur;
					return;
				}
				cur = cur.leftChild;
			} else if (d > cur.data) {
				if (cur.rightChild == null) {
					cur.rightChild = new TreeNode(d);
					cur.rightChild.parent = cur;
					return;
				}
				cur = cur.rightChild;
			} else {
				System.out.println("Data already in tree");
				return;
			}
		}
		
	}
	
	public TreeNode findNode(int d) {
		// Find node
		TreeNode cur = root;
		while (cur != null) {
			if (d < cur.data) {
				cur = cur.leftChild;
			} else if (d > cur.data) {
				cur = cur.rightChild;
			} else {
				// Found node
				return cur;
			}
		}
		
		System.out.println("Node not found!");
		return null;
	}
	
	public void delete(int d) {
		TreeNode n = findNode(d);
		// Case 1 - delete a node with no children
		if (n.leftChild == null && n.rightChild == null) {
			if (n.parent.leftChild != null && n.parent.leftChild.data == n.data) {
				n.parent.leftChild = null;
			} else {
				n.parent.rightChild = null;
			}
		}
		
		// Case 2a - delete a node with one child (right)
		if (n.leftChild == null && n.rightChild != null) {
			n.rightChild.parent = n.parent;
			if (n.parent.leftChild != null && n.parent.leftChild.data == n.data) {
				n.parent.leftChild = n.rightChild;
			} else {
				n.parent.rightChild = n.rightChild;
			}
		}
		
		// Case 2b - delete a node with one child (left)
		if (n.leftChild != null && n.rightChild == null) {
			n.leftChild.parent = n.parent;
			if (n.parent.leftChild.data == n.data) {
				n.parent.leftChild = n.leftChild;
			} else {
				n.parent.rightChild = n.leftChild;
			}
		}
		
		//Case 3 - delete a node with two children
		if (n.leftChild != null && n.rightChild != null) {
			// Find predecessor
			TreeNode pre = n.leftChild;
			while (pre.rightChild != null) {
				pre = pre.rightChild;
			}
			int newData = pre.data;
			delete(pre.data);
			n.data = newData;
		}
	}
	
	public void inOrderTraverse(TreeNode n) {
		if (n == null) { System.out.println("Empty tree"); return; }
		
		if (n.leftChild != null) {
			inOrderTraverse(n.leftChild);
		}
		
		System.out.print(n.data + " ");
		
		if (n.rightChild != null) {
			inOrderTraverse(n.rightChild);
		}
	}
	
	public boolean isBalanced() {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		
		getLeafLevels(root, 0, hm);
		
		Iterator<Map.Entry<Integer, Integer>> it = hm.entrySet().iterator();
		int curMin=Integer.MAX_VALUE, curMax=Integer.MIN_VALUE;
		while (it.hasNext()) {
			Map.Entry<Integer, Integer> pairs = it.next();
			if (pairs.getValue() < curMin) { curMin = pairs.getValue(); }
			if (pairs.getValue() > curMax) { curMax = pairs.getValue(); }
		}
		return curMax-curMin > 1 ? false : true;
		
	}
	
	public void getLeafLevels(TreeNode n, int level, HashMap<Integer, Integer> hm) {
		if (n.leftChild == null && n.rightChild == null) {
			hm.put(n.data, level);
		}
		
		if (n.leftChild != null) {
			getLeafLevels(n.leftChild, level+1, hm);
		}
		
		if (n.rightChild != null) {
			getLeafLevels(n.rightChild, level+1, hm);
		}
	}
	
	public static void depthFirstTraverse(TreeNode n) {
		System.out.print(n.data + " ");
		if (n.leftChild != null) { depthFirstTraverse(n.leftChild); }
		if (n.rightChild != null) { depthFirstTraverse(n.rightChild); }
	}
	
	public void breadthFirstTraverse() {
		Queue q = new Queue();
		
		
		if (root.leftChild != null) { q.enqueue(root.leftChild.data); }
		if (root.rightChild != null) { q.enqueue(root.rightChild.data); }
		
		System.out.print(root.data + " ");
		
		while (!q.isEmpty()) {
			int d = q.dequeue();
			TreeNode cur = findNode(d);
			
			System.out.print(cur.data + " ");
			
			if (cur.leftChild != null) { q.enqueue(cur.leftChild.data);}
			if (cur.rightChild != null) { q.enqueue(cur.rightChild.data);}
		}
	}
	
	public void addArray(int[] arr) {
		int start = 0;
		int end = arr.length-1;
		int mid = (end +  start) / 2;
		
		if (end < start) { return; }
		
		System.out.println("Inserting arr[" + mid + "]: " + arr[mid]);
		insert(arr[mid]);
		addArray(Arrays.copyOfRange(arr, start, mid));
		addArray(Arrays.copyOfRange(arr, mid+1, end+1));
	}
	
	public static boolean containsTree(TreeNode t1, TreeNode t2) {
		if (t2 == null) { return true; }
		else {
			return subTree(t1, t2);
		}
	}
	
	public static boolean subTree(TreeNode t1, TreeNode t2) {
		if (t1 == null) { return false; }
		if (t1.data == t2.data) {
			if (matchTree(t1, t2)) { return true; }
		}
		return subTree(t1.leftChild, t2) || subTree(t1.rightChild, t2);
	}
	
	public static boolean matchTree(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) {
			return true;
		}
		if (t1 == null) {
			return false;
		}
		if (t2 == null) {
			return true;
		}
		if (t1.data != t2.data) {
			return false;
		}
		return matchTree(t1.leftChild, t2.leftChild) && matchTree(t1.rightChild, t2.rightChild);
	}
	
	public static void main(String args[]) {
		BST bst = new BST();
		BST bst2 = new BST();
		bst2.insert(8);
		bst2.insert(6);
		bst2.insert(9);
		
		int[] arr = {0,1,2,3,4,5,6,7,8,9,10};
		bst.addArray(arr);
		
		bst.inOrderTraverse(bst.root);
		System.out.println();
		
		System.out.println(bst.isBalanced());
		bst.delete(7);
		
		System.out.println(bst.isBalanced());
		bst.insert(7);
		
		depthFirstTraverse(bst.root);
		System.out.println();
		bst.breadthFirstTraverse();
		System.out.println(); bst2.breadthFirstTraverse();
		
		System.out.println();
		
		System.out.println("\n" + containsTree(bst.root, bst2.root));
	}
}
