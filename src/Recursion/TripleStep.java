package Recursion;

import java.util.Arrays;

public class TripleStep {

	public static void main(String[] args) {
		
		System.out.println(checkStep(4));

	}
	
	
	public static int checkStep(int n) {
		
		int[] memo = new int[n + 1];
		
		Arrays.fill(memo, -1);
		
		return checkStep(n, memo);
		
	}
	
	public static int checkStep(int n, int[] memo) {
		System.out.println(Arrays.toString(memo));
		if(n < 0) {
			return 0;
		}else if(n == 0) {
			return 1;
		}else if(memo[n] > -1) {
			return memo[n];
		}else {
			memo[n] = checkStep(n - 1, memo) + checkStep(n - 2, memo) + checkStep(n - 3, memo);
			return memo[n];
		}
	}

}
