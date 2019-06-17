package ArraysAndString;

import nanocounter.NanoCounter;

/*One Away: There are three types of edits that can be performed on strings: insert a character,
remove a character, or replace a character. Given two strings, write a function to check if they are
one edit (or zero edits) away.*/

public class OneWay {

	public static void main(String[] args) {
		
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		
		sb1.append("pale");
		sb2.append("ple");
		
		NanoCounter.run("oneWayStr", (e) -> {
			oneWayStr(sb1.toString(), sb2.toString());
		});

		
		sb1.delete(0, sb1.length());
		sb2.delete(0, sb2.length());
		
		sb1.append("pales");
		sb2.append("pale");
		
		NanoCounter.run("oneWayStr", (e) -> {
			oneWayStr(sb1.toString(), sb2.toString());
		});
		
		sb1.delete(0, sb1.length());
		sb2.delete(0, sb2.length());
		
		sb1.append("pale");
		sb2.append("bale");
		
		NanoCounter.run("oneWayStr", (e) -> {
			oneWayStr(sb1.toString(), sb2.toString());
		});
		
		sb1.delete(0, sb1.length());
		sb2.delete(0, sb2.length());
		
		sb1.append("pale");
		sb2.append("bake");
		

		NanoCounter.run("oneWayStr", (e) -> {
			oneWayStr(sb1.toString(), sb2.toString());
		});
	}
	
	public static void oneWayStr(String s1, String s2) {
		
		int l1 = s1.length();
		int l2 = s2.length();
		
		int count = 0;
		boolean isOneWay = true;
		
		if(l1 - l2 > 1 || l2 - l1 > 1) {
			isOneWay = false;
		} else if(l1 == l2) {
			for(int i = 0; i < l1; i++) {
				if(s1.charAt(i) != s2.charAt(i)) {
					count++;
				} 
			}
		}else {
			if(l1 > l2) {
				for(int i = 0, j = 0; i < l2;) {
					if(s1.charAt(i) != s2.charAt(j)) {
						i++;
						count++;
					}else {
						j++;
						i++;
						if(i == l2 && count == 0) {
							count++;
							break;
						}
					}
				}
			}
		}
		
		if(count > 1) isOneWay = false;
		
		System.out.format("Is %s way: %s%n", count, isOneWay);
	}

}
