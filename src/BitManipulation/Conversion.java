package BitManipulation;

public class Conversion {

	public static void main(String[] args) {
		
		int n1 = 0b11101;
		int n2 = 0b01111;
		
		nToConvert(n1, n2);
		
	}
	
	public static int nToConvert(int n1, int n2) {
		
		int counter = 0;
		
		for(int i = n1, k = n2; i != 0 || k != 0 ; i >>= 1, k >>= 1) {
			if((i & 1) != (k & 1) ) {
				counter++;
			}
		}
		
		System.out.println(counter);
		
		return counter;
		
	}
	
}
