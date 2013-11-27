import java.util.HashMap;

public class TwoSigma {
	public static void main(String args[]) {
		System.out.println(pangramMissingLetters("The quick brow fox jumps over the lazy dog"));
	}
	
	public static String pangramMissingLetters(String s) {
		String missing = "";
		
		HashMap<Character, Integer> hm = str2hmLC(s);
		
		for (int i=0; i<s.length(); ++i) {
			char c = Character.toLowerCase(s.charAt(i));
			if (hm.containsKey(c)) {
				hm.put(c, hm.get(c)+1);
			} else {
				hm.put(c, 1);
			}
		}
		
		for (int i = 97; i <= 122; ++i) {
			if (!hm.containsKey((char)i)) {
				missing = missing + (char)i;
			}
		}
		
		return missing.isEmpty() ? "*Input string is a pangram" : missing;
		
	}
	
	public static HashMap<Character, Integer> str2hmLC(String s) {
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

		for (int i=0; i<s.length(); ++i) {
			char c = Character.toLowerCase(s.charAt(i));
			hm.put(c, hm.get(c) != null ? hm.get(c)+1 : 1);
		}
		
		return hm;
	}
}
