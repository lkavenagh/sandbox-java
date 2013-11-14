import java.util.HashMap;
import java.util.Map;

public class CrackCode1 {
	
	public static void main(String args[]){
		String str = "abcdef";
		String str2 = "abcdee";
		if (uniqueCharsString(str)) { 
			System.out.println(str + " is all unique chars");
		} else {
			System.out.println(str + " is NOT all unique chars");
		}
		
		if (uniqueCharsString(str2)) { 
			System.out.println(str2 + " is all unique chars");
		} else {
			System.out.println(str2 + " is NOT all unique chars");
		}
	}
	
	public static boolean uniqueCharsString(String str) {
		
		HashMap<Character, Integer> hm = new HashMap();
		
		for (int i=0; i<str.length(); ++i) {
			if (hm.containsKey(str.charAt(i))) {
				hm.put(str.charAt(i), hm.get(str.charAt(i))+1);
			} else {
				hm.put(str.charAt(i), 1);
			}
		}
		
		
		for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
			if (entry.getValue() > 1) { return false; }
		}
		
		return true;
		
	}
	
}
