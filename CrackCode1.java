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
		
		System.out.println(str + " reversed is: " + reverseString(str));
		System.out.println(str2 + " without duplicates is: " + removeDuplicates(str2));
		
		str = "abcdef";
		str2 = "fedacb";
		if (isAnagram(str, str2)) {
			System.out.println(str + " and " + str2 + " are anagrams");
		} else {
			System.out.println(str + " and " + str2 + " are NOT anagrams");
		}
		str = "abccdef";
		str2 = "fedacb";
		if (isAnagram(str, str2)) {
			System.out.println(str + " and " + str2 + " are anagrams");
		} else {
			System.out.println(str + " and " + str2 + " are NOT anagrams");
		}
		
	}
	
	public static boolean uniqueCharsString(String str) {
		
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		
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
	
	public static String reverseString(String str) {
		
		String revstr = "";
		
		for (int i=str.length()-1; i>=0; --i) {
			revstr = revstr + str.charAt(i);
		}
		
		return revstr+"\n";
		
	}
	
	public static String removeDuplicates(String str) {
		String newStr = "";
		
		for (int i=0; i<str.length(); ++i) {
			if (!newStr.contains(Character.toString(str.charAt(i)))) {
				newStr = newStr + str.charAt(i);
			}
		}
		
		return newStr;
	}
	
	public static Boolean isAnagram(String str1, String str2) {
		
		HashMap<Character, Integer> hm1 = new HashMap<Character, Integer>();
		
		for (int i=0; i<str1.length(); ++i) {
			if (hm1.containsKey(str1.charAt(i))) {
				hm1.put(str1.charAt(i), hm1.get(str1.charAt(i))+1);
			} else {
				hm1.put(str1.charAt(i), 1);
			}
		}
		
		
		for (int i = 0; i < str2.length(); ++i) {
			if (!hm1.containsKey(str2.charAt(i))) {
				return false;
			}
			int count = hm1.get(str2.charAt(i));
			int thisCount = str2.length() - str2.replace(Character.toString(str2.charAt(i)), "").length();
			if (count != thisCount) {
				return false;
			}
		}
		
		return true;
	}
	
	
}
