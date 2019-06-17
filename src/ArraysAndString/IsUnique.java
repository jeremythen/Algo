package ArraysAndString;

import java.util.HashSet;

import nanocounter.NanoCounter;

/**
 * 
 * Is Unique: Implement an algorithm to determine if a string has all unique
 * characters. What if you cannot use additional data structures?
 * 
 */
public class IsUnique {

	public static void main(String[] args) {

		/*
		 * NanoCounter.run("printIfStrIsUniqueLinear", (e) -> {
		 * printIfStrIsUniqueLinear(); });
		 * 
		 * NanoCounter.run("printIfStrIsUnitqueMap", (e) -> { printIfStrIsUnitqueMap();
		 * });
		 */
		
		String s = "abcdefghijklmnopqrastuvxyz";
		
		
		System.out.println(isUniqueChars(s));
		System.out.println(isUniqueChars2(s));

	}

	public static boolean isUniqueChars(String str) {
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) {
				return false;
			}
			checker |= (1 << val);
		}
		return true;
	}
	
	public static boolean isUniqueChars2(String str) {
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			int v = (1 << val);
			if ((checker & v) == 1) {
				return false;
			}
			checker |= v;
		}
		return true;
	}

	public static void printIfStrIsUniqueLinear() {

		String s = "abcdefghijklmnopqrstuvxyz1234567890,.;'[]*-+abcdefghijklmnopqrstuvxyz1234567890,.;'[]*-+";

		final int sLen = s.length();

		boolean isUnique = true;

		for (int i = 0; i < sLen; i++) {

			char c = s.charAt(i);
			if (i != s.lastIndexOf(c)) {
				isUnique = false;
				break;
			}
		}

		System.out.format("Is Unique: %s%n", isUnique);
	}

	public static void printIfStrIsUnitqueMap() {

		String s = "abcdefghijklmnopqrstuvxyz1234567890,.;'[]*-+abcdefghijklmnopqrstuvxyz1234567890,.;'[]*-+";

		final int sLen = s.length();

		HashSet<Character> set = new HashSet<>();

		boolean isUnique = true;

		for (int i = 0; i < sLen; i++) {
			char c = s.charAt(i);
			if (set.contains(c)) {
				isUnique = false;
				break;
			} else {
				set.add(c);
			}
		}

		System.out.format("Is Unique: %s%n", isUnique);
	}

}
