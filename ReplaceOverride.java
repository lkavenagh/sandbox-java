import java.net.*;
import java.io.*;

public class ReplaceOverride {
	
	public static void main(String args[]) throws IOException{
		String str = "";
		String tmp;
		
		URL oracle = new URL("http://www.oracle.com/");
        BufferedReader in = new BufferedReader(
        		new InputStreamReader(oracle.openStream())
        	);

        String inputLine;
        while ((inputLine = in.readLine()) != null){
            str = str + inputLine + '\n';
        }
        in.close();
        str = str.substring(0,8500);
		
		char ch = 'e';
		char repch = 'u';
		
		long curTime = System.currentTimeMillis();
		
		System.out.println(str);
		System.out.println("Took : " + (System.currentTimeMillis()-curTime) + "ms");
		tmp = ReplaceOverride.replace(str, ch, repch);
		System.out.println("Took : " + (System.currentTimeMillis()-curTime) + "ms");
		tmp = ReplaceOverride.replaceRec(str, ch, repch);
		System.out.println("Took : " + (System.currentTimeMillis()-curTime) + "ms");
	}
	
	public static String replace(String str, char ch, char repch){
		
		String newstr = "";
		
		for (int i=0; i<str.length(); ++i) {
			if (str.charAt(i) == ch) {
				newstr = newstr + repch;
			} else {
				newstr = newstr + str.charAt(i);
			}
		}
		
		return newstr;
	}
	
public static String replaceRec(String str, char ch, char repch){

		if (str.length() == 0) {
			return str;
		} else if (str.length() == 1) {
			return (str.charAt(0) == ch) ? Character.toString(repch) : str;
		} else {
			return replaceRec(str.substring(0,1), ch, repch) + replaceRec(str.substring(1), ch, repch);
		}
	}
}
