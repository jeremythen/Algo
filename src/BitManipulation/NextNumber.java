package BitManipulation;

public class NextNumber {

	public static void main(String[] args) {

		
		nextNumber(654651);
		
	
	}
	public static void nextNumber(int n) {
		
		int n2 = n;
		int n3 = n;
		
		boolean n2Found = false;
		boolean n3Found = false;
		
		
		int nCount = Integer.bitCount(n);

		for(;;) {
			if(!n2Found) {
				if(nCount == Integer.bitCount(++n2)) {
					n2Found = true;
				}
			}
			
			if(!n3Found) {
				if(nCount == Integer.bitCount(--n3)) {
					n3Found = true;
				}
			}
			
			if(n2Found && n3Found) break;
			
		}
		
		System.out.format("Number: %s, Binary: %s, 1s: %s%n", n, Integer.toBinaryString(n), Integer.bitCount(n));
		System.out.format("Number: %s, Binary: %s, 1s: %s%n", n2, Integer.toBinaryString(n2), Integer.bitCount(n2));
		System.out.format("Number: %s, Binary: %s, 1s: %s%n", n3, Integer.toBinaryString(n3), Integer.bitCount(n3));
		
	}

}
