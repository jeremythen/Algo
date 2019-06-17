import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CountPairsInArray {

	public static void main(String[] args) {
		
		//findPermutationInStr();
		
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
	
	public static void checkIfStrIsPerOfAnother() {
		String s1 = "jeremy";
		
		String s2 = "rymeje";
		
		
		boolean isPer = true;
		
		if(s1.length() == s2.length()) {
			
			Map<Character, Integer> map1 = new HashMap<>();
			Map<Character, Integer> map2 = new HashMap<>();
			
			for(int i = 0; i < s1.length(); i++) {
				map1.merge(s1.charAt(i), 1, (oldValue, newValue) -> oldValue + newValue);
				map2.merge(s2.charAt(i), 1, (oldValue, newValue) -> oldValue + newValue);
			}
			
			for(Map.Entry<Character, Integer> m: map1.entrySet()) {
				if(!m.getValue().equals(map2.get(m.getKey()))) {
					isPer = false;
				}
			}
			
		}else {
			isPer = false;
		}
		
		System.out.println(isPer);
	}
	
	public static void findPermutationInStr() {
		
		String s = "abbc";
		String b = "cbabadcbbabbcbabaabccbabc";
		
		long l1 = System.currentTimeMillis();

		Map<Character, Integer> map = new HashMap<>();

		Map<Character, Integer> map2 = new HashMap<>();
		
		for(int i = 0; i < s.length(); i++) {
			map.merge(s.charAt(i), 1, (a, a2) -> a + a2);
		}
		
		boolean contains = true;
		
		//int counter = 0;
		
		con: for(int i = 0; i < b.length() - s.length() + 1; i++) {
			//counter++;
			for(int j = i, k = 0; k < s.length(); j++, k++) {
				//counter++;
				char c = b.charAt(j);
				if(map.get(c) == null) {
					continue con;
				}
				//counter++;
				map2.merge(c, 1, (a, a2) -> a + a2);
			}
			
			for(Map.Entry<Character, Integer> en : map.entrySet()) {
				//counter++;
				if(!en.getValue().equals(map2.get(en.getKey()))) {
					contains = false;
					//counter++;
					break;
				}
			}
			
			map2.clear();

			/*if(contains) {
				System.out.println("Contains at index: " + i);
			}*/
			
			contains = true;
			
		}
		
		long l2 = System.currentTimeMillis() - l1;
		
		System.out.println(l2);
	}

	public static void printAllPowerOf3() {
		// Print all positive integer solutions to the equation a3 + b3 = c3 + d3 where
		// a,b,c,d
		// are integers between 1 and 1000

		int n = 1000;

		Map<Integer, List<String>> map = new HashMap<>();
		List<String> list = new LinkedList<>();

		for (int a = 1; a <= n; a++) {
			for (int b = 1; b <= n; b++) {
				int result = (int) (Math.pow(a, 3) + Math.pow(b, 3));

				if (map.get(result) == null) {
					map.put(result, new LinkedList<>());
				}

				map.get(result).add("(" + a + "," + b + ")");

			}
		}

		map.forEach((result, ls) -> {

			for (String i : ls) {

				for (String i2 : ls) {
					System.out.format("(%s, %s)%n ", i, i2);
				}
			}

		});

	}

	public static void printPairs() {

		int[] ints = { 1, 7, 5, 9, 2, 12, 3 };

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < ints.length; i++) {

			int v = ints[i];
			int v2 = v + 2;
			int v3 = v - 2;

			map.put(v, null);

			if (v3 > 0) {
				if (map.containsKey(v3)) {
					map.put(v3, v);
					// System.out.format("(%s, %s) ", v3, v);

				}
			}

			if (map.containsKey(v2)) {
				map.put(v, v2);
				// System.out.format("(%s, %s) ", v, v2);
			}

		}

		// System.out.println(map);

		map.entrySet().stream().filter(entry -> entry.getValue() != null).forEach(entry -> {

			System.out.format("(%s, %s) ", entry.getKey(), entry.getValue());
		});

	}

}
