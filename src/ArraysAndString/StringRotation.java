package ArraysAndString;

import nanocounter.NanoCounter;

/*String Rotation: Assume you have a method isSubstring which checks ifone word is asubstring
of another. Given two strings, 51 and 52, write code to check if 52 is a rotation of 51 using only one
call to isSubstring (e.g.,"waterbottle" is a rotation of"erbottlewat").*/


public class StringRotation {

	public static void main(String[] args) {
		
		String s1 = "waterwbottwle";
		String s2 = "erbottlewat";
		
		NanoCounter.run("isSubstring", (e) -> {
			isSubstring(s1, s2);
		});

	}
	
	public static boolean isSubstring(String s1, String s2) {
		
		int len = s1.length();
		
		int counter = 0;
		
		for(int i = 0, j = 0; i < len && counter <= len * 2;) {
			
			char c1 = s1.charAt(i) ;
			char c2 = s2.charAt(j) ;
			
			 if(c1 != c2) {
				 i = 0;
			 }else {
				 i++;
			 }
			 if(j++ == len - 1) {
				 j = 0;
			 }
			 counter++;
		}
		
		boolean isSubstring = counter < len * 2;
	
		System.out.println(isSubstring);
		
		return isSubstring;
		
	}
	
	

}
