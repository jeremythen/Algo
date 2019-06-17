import java.util.Arrays;
import java.util.*;

public class Tests {


	public static void main(String... args) {

		
		System.out.println(Arrays.toString("Jeremy".getBytes()));
		
		
	}
	
	public static int roateBinaryBy(int bin, int d) {
		
		int a = (bin << d);
		int b = bin >> (7 - d);
		
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(b));
		
		return a | b;
		
	}

	public static boolean isSparse(int n ) {
		
		return (n & (n >> 1)) > 0 ? false: true;
	}
	
	public static int getNextSparse(int n) {
		while((n & (n >> 1)) > 0) {
			n++;
		}
		return n;
	}


	public static int gcm(int m, int n) {

		if (m % n == 0)
			return n;
		int g = 1;

		for (int k = n / 2; k >= 1; k--) {

			if (m % k == 0 && n % k == 0) {
				g = k;
				break;
			}

		}

		return g;

	}

	public static int gcm2(int m, int n) {

		if (m % n == 0)
			return n;
		else
			return gcm2(n, m & n);

	}

	public static long efficientFib(int n) {

		long f0 = 0;
		long f1 = 1;
		long f2 = 1;

		if (n == f0)
			return f0;
		if (n == f1)
			return f1;
		if (n == 2)
			return f1;

		for (int i = 3; i <= n; i++) {

			f0 = f1;
			f1 = f2;
			f2 = f0 + f1;
		}

		return f2;

	}


	public static int fib(int n) {

		if (n == 0)
			return 0;
		if (n == 1)
			return 1;

		return fib(n - 1) + fib(n - 2);

	}

	public static void isMultiple(int n) {

		boolean is3Multiple = n % 3 == 0;
		boolean is5Multiple = n % 5 == 0;

		if (is3Multiple && is5Multiple) {
			System.out.println("FizzBuzz");
		} else if (is3Multiple) {
			System.out.println("Buzz");
		} else if (is5Multiple) {
			System.out.println("Fizz");
		}

	}

}
