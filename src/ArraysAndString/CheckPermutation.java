package ArraysAndString;

import java.util.HashMap;
import java.util.Map;

import nanocounter.NanoCounter;

/**
 * 
 * Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
 * 
 * */

public class CheckPermutation {

	public static void main(String[] args) {

		NanoCounter.run("checkIfStrIsPerOfAnother", (e) -> {
			checkIfStrIsPermutationOfAnother();
		});

	}

	public static void checkIfStrIsPermutationOfAnother() {
		String s1 = "jeremy";

		String s2 = "rymeje";

		boolean isPer = true;

		if (s1.length() == s2.length()) {

			Map<Character, Integer> map1 = new HashMap<>();
			Map<Character, Integer> map2 = new HashMap<>();

			for (int i = 0; i < s1.length(); i++) {
				map1.merge(s1.charAt(i), 1, (oldValue, newValue) -> oldValue + newValue);
				map2.merge(s2.charAt(i), 1, (oldValue, newValue) -> oldValue + newValue);
			}

			for (Map.Entry<Character, Integer> m : map1.entrySet()) {
				if (!m.getValue().equals(map2.get(m.getKey()))) {
					isPer = false;
				}
			}

		} else {
			isPer = false;
		}

		System.out.println(isPer);
	}

}
