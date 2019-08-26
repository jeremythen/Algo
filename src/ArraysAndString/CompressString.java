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
		
		String str = "aabcccccaaa";

		StringBuilder sb = new StringBuilder();
		
		char previousChar = str.charAt(0);
		int currentCharCount = 1;
		int lastIndex = str.length() - 1;
		
		for(int i = 1; i <= lastIndex; i++) {
			char currentChar = str.charAt(i);
			
			if(previousChar == currentChar) {
				currentCharCount++;
				
				if(i == lastIndex) {
					appendCompressedString(sb, previousChar, currentCharCount);
				}
				
			}else {

				appendCompressedString(sb, previousChar, currentCharCount);
				
				previousChar = str.charAt(i);
				currentCharCount = 1;
			}
			
		}

		
		System.out.println(sb);
		
	}
	
	private static void appendCompressedString(StringBuilder sb, char previousChar, int count) {
		sb.append(previousChar).append(count);
	}

}
