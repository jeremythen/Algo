package BitManipulation;

import nanocounter.NanoCounter;

public class Insertion {

	public static void main(String[] args) {
		
		
		int n = 0b10001111100;
		int m = 0b10011;
		
		
		//insertBit(n, m, 2, 6);
		
		NanoCounter.run("insertBit", (e) -> {
			insertBit(n, m, 2, 6);
		});
		
	}
	
	
	public static void insertBit(int n, int m, int i, int j) {
		
		
		int t = ~(m << i);
		
		n = (n & t) | (m << i);
		
		// n = (n & (~(m << i))) | (m << i);
		
		System.out.println(Integer.toBinaryString(n));
		
	}

}
