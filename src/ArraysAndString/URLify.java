package ArraysAndString;

import nanocounter.NanoCounter;

/*
 * URLify: Write a method to replace all spaces in a string with '%20: You may assume that the string
has sufficient space at the end to hold the additional characters, and that you are given the "true"
length of the string. (Note: If implementing in Java, please use a character array so that you can
perform this operation in place.)
*/

public class URLify {

	public static void main(String[] args) {
		
		String s = "Mr John Smith    ";
		
		NanoCounter.run("urlify", (e) -> {
			urlifyRegex(s);
		});
		
		
		NanoCounter.run("urlify", (e) -> {
			urlify(s);
		});
		
	}
	
	public static void urlify(String s) {
		
		StringBuilder sb = new StringBuilder();
		s = s.trim();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c != ' ') {
				sb.append(c);
			}else {
				sb.append("%20");
			}
			
		}
		
		System.out.println(sb);
		
	}
	
	public static void urlifyRegex(String s) {
		
		s = s.trim();
		
		s = s.replaceAll("\\s+", "%20");
		
		System.out.println(s);
		
	}

}
