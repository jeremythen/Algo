package ArraysAndString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import nanocounter.NanoCounter;

/*Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation
is a rearrangement of letters.The palindrome does not need to be limited to just dictionary words.
*/
public class PalindromePermutation {

	public static void main(String[] args) {
		
		String s = "Stop! nine myriad murmur. Put up rum, rum, dairymen, in pots.";
		
		NanoCounter.run("palindromePermutation", (e) -> {
			palindromePermutation(s);
		});
		
		
		String s1 = "Jeremy";
		String s2 = "rJymee";
		
		System.out.println(isPalindromePer(s1, s2));
		
		s2 = "rJymeee";
		
		System.out.println(isPalindromePer(s1, s2));
		
		
	}
	
	public static boolean isPalindromePer(String s1, String s2) {
		
		if(s1.length() != s2.length()) return false;
		
		int len = s1.length();
		
		int[] sub = new int[128];
		
		for(int i = 0; i < len; i++) {
			sub[s2.charAt(i)]++;
		}
		
		System.out.print(Arrays.toString(sub));
		
		for(int i = 0; i < len; i++) {
			char c = s1.charAt(i);
			if(sub[c] <= 0) return false;
			
			sub[c]--;
		}
		
		return true;
	}
	
	public static void palindromePermutation(String s) {

		Map<Character, Integer> map = new HashMap<>();
		
		s = s.replaceAll("\\W*", "").toLowerCase();
		
		char uniqueC = 0;
		boolean isAPalindrom = true;
			
		for(int i = 0; i < s.length(); i++) {
			map.merge(s.charAt(i), 1, (o, n) -> o + n);
		}
		
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		
		for(Map.Entry<Character, Integer> m : map.entrySet()) {
			
			int v = m.getValue();
			
			if(v % 2 == 0) {
				char k = m.getKey();
				for(int i = 0; i < v; i += 2) {
					sb1.append(k);
					sb2.append(k);
				}
			}else if(v % 2 == 1 && v != 1) {
				
				if(uniqueC != 0) {
					isAPalindrom = false;
					break;
				}
				
				uniqueC = m.getKey();
				
				v = m.getValue() - 1;
				
				m.setValue(v);
				
				char k = m.getKey();
				
				for(int i = 0; i < v; i += 2) {
					sb1.append(k);
					sb2.append(k);
				}

			}else if(v == 1) {
				
				if(uniqueC != 0) {
					isAPalindrom = false;
					break;
				}
				
				uniqueC = m.getKey();
			}
			
		}
		
		if(uniqueC != 0) {
			sb1.append(uniqueC);
			
		}
		
		sb1.append(sb2.reverse());
		
		System.out.format("Is palindrome: %s, sb1: %s%n", isAPalindrom, sb1);
		
	}

}
