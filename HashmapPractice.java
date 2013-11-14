import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

public class HashmapPractice {
	public static void main(String args[]){
		
		String[] students = {"A","B","C","D","E"};
		int[] results = {90, 80, 60, 58, 74};
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		for (int i = 0; i < students.length; ++i) {
			hm.put(students[i], results[i]);
		}
		
		for (Map.Entry<String, Integer> entry : hm.entrySet()) {
			System.out.print(entry.getKey() + ":");
			System.out.println(entry.getValue());
		}
		
	}
}
