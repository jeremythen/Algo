package BitManipulation;

public class BinaryToString {

	public static void main(String[] args) {
		
		double d = 0.1;

		int n = 2;
		
		String s = doubleBinaryToString(d);
		
		System.out.print(s);
		
	}
	
	public static String doubleBinaryToString(double d) {
		
		StringBuilder sb = new StringBuilder();
		
		if(d <= 0 || d >= 1) {
			return "ERROR";
		}
		
		
		while(d > 0) {
			
			double t = d * 2;
			
			if(t >= 1) {
				sb.append(1);
				d = t - 1;
			}else {
				sb.append(0);
				d = t;
			}
			
			if(sb.length() > 32) {
				return "ERROR";
			}
			
		}
		
		System.out.println(sb.length());
		
		return sb.toString();
	}

}
