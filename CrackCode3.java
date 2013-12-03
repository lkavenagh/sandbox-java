public class CrackCode3 {
	public static void main(String args[]) {
		SetOfStacks s = new SetOfStacks();
		
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);
		s.push(7);
		s.push(8);
		s.push(9);
		s.push(10);
		s.push(11);
		s.push(12);
		
		System.out.println(s.curStack());
		System.out.println(s.pop());
		System.out.println(s.curStack());
		System.out.println(s.pop());
		System.out.println(s.curStack());
		System.out.println(s.pop());
		System.out.println(s.curStack());
		System.out.println(s.pop());
	}
}
