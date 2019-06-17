package BitManipulation;

import java.util.ArrayList;
import java.util.List;

public class FlipBitToWin {

	public static void main(String[] args) {
		
		int n = 0b11011101111;
		
		flipBit(n);

	}
	
	public static void flipBit(int b) {
		
		List<BitCount> list = new ArrayList<>();
		
		int b2 = b;
		
		int currentN = b2 & 1;
		b2 = b2 >>> 1;
		int i = 1;
		
		StringBuilder sb = new StringBuilder();
		sb.append(currentN);
		
		while(b2 != 0) {
			if((b2 & 1) != currentN) {
				list.add(new BitCount(sb.toString(), i, currentN));
				sb.setLength(0);
				sb.append(b2 & 1);
				i = 0;
			}else {
				sb.append(currentN);
			}
			i++;
			currentN = b2 & 1;
			b2 = b2 >>> 1;
			
		}
		
		list.add(new BitCount(sb.toString(), i, currentN));
		
		System.out.println(list);
		
	}
	
	private static class BitCount {
		String bin;
		int n;
		int type;
		
		public BitCount(String bin, int n, int type) {
			this.bin = bin;
			this.n = n;
			this.type = type;
		}

		@Override
		public String toString() {
			return "BitCount [bin=" + bin + ", n=" + n + ", type=" + type + "]";
		}
		
	}

}
