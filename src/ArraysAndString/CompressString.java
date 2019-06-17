package ArraysAndString;

import nanocounter.NanoCounter;

/*String Compression: Implement a method to perform basic string compression using the counts
of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
"compressed" string would not become smaller than the original string, your method should return
the original string. You can assume the string has only uppercase and lowercase letters (a - z).
*/

public class CompressString {

	public static void main(String[] args) {
		
		NanoCounter.run("compressString", (e) -> {
			compressString();
		});

	}
	
	public static void compressString() {
		
		String s = "aabcccccaaa";

		StringBuilder sb = new StringBuilder();
		
		char currentChar = s.charAt(0);
		int currentCharCount = 1;
		
		for(int i = 1; i < s.length(); i++) {
			
			if(currentChar == s.charAt(i)) {
				currentCharCount++;
				
				if(i == s.length() - 1) {
					sb.append(currentChar);
					sb.append(currentCharCount);
				}
				
			}else {

				sb.append(currentChar);
				sb.append(currentCharCount);
				
				currentChar = s.charAt(i);
				currentCharCount = 1;
			}
			
		}

		
		System.out.println(sb);
		
	}

}
