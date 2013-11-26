import java.util.HashMap;
import java.util.Map.Entry;

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
		
		char[] str3 = "Hello world!  ".toCharArray();
		System.out.println(new String(str3) + " -> " + new String(replaceSpaces(str3, 12)));
		
		str = "aabccaaaaaa";
		System.out.println(str + " -> " + compressString(str));
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
		
		for (Entry<Character, Integer> e : hm.entrySet()) {
			if (e.getValue() > 1) {
				return false;
			}
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
	
	public static char[] replaceSpaces(char[] str, int length) {
		
		int numSpaces = 0;
		for (int i=0; i < length; ++i) {
			if (str[i] == ' ') {
				numSpaces++;
			}
		}
		
		int newIdx = length + numSpaces*2 - 1;
		for (int i=length-1; i>=0; --i) {
			if (str[i] == ' ') {
				str[newIdx] = '0';
				str[newIdx-1] = '2';
				str[newIdx-2] = '%';
				newIdx -= 3;
			} else {
				str[newIdx] = str[i];
				newIdx--;
			}
		}
		
		return str;
		
	}
	
	public static String compressString(String str) {
		String newStr = "";
		int repLength, i, j;
		
		for (i = 0; i < str.length(); ++i) {
			repLength = 0;
			j = i;
			while (j < str.length() && str.charAt(j) == str.charAt(i)) {
				repLength++;
				j++;
			}
			newStr = newStr + str.charAt(i) + Integer.toString(repLength);
			i = j-1;
		}
		
		if (newStr.length() < str.length()) { return newStr; }
		else { return str; }
		
	}
	
	
}
