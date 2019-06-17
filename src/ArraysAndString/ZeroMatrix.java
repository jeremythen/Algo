package ArraysAndString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import nanocounter.NanoCounter;

/*Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
column are set to O*/

public class ZeroMatrix {

	public static void main(String[] args) {
		
		NanoCounter.run("zeroMatrix", (e) -> {
			zeroMatrix();
		});
		

	}
	
	public static void zeroMatrix() {
		
		int[][] matrix = getMatrix();

		RotateMatrix.printMatrix(matrix);
		
		List<Point> pointList = new ArrayList<>();
		
		int len = matrix.length;
		
		for(int i = 0; i < len; i++) {
			for(int j = 0; j < len; j++) {
				if(matrix[i][j] == 0) {
					pointList.add(new Point(i, j));
				}
			}
		}
		
		System.out.println(pointList);
		
		Set<Integer> xVisited = new HashSet<>();
		Set<Integer> yVisited = new HashSet<>();
		
		int counter = 0;
		
		for(Point point: pointList) {
			
			int x = point.x;
			int y = point.y;
			
			if(xVisited.contains(x)) {
				continue;
			}else {
				xVisited.add(x);
			}
			
			if(yVisited.contains(y)) {
				continue;
			}else {
				yVisited.add(y);
			}
			
			for(int i = 0; i < len; i++) {
				counter++;
				matrix[x][i] = 0;
				matrix[i][y] = 0;
			}
			counter++;
		}
		
		System.out.println("counter: " + counter);;
		
		RotateMatrix.printMatrix(matrix);
		
	}
	
	private static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public String toString() {
			return "(" + x + ", " + y + ")";
		}
	}

	
	public static int[][] getMatrix() {

		int len = 66;
		
		int[][] matrix = new int[len][len];

		Random rand = ThreadLocalRandom.current();

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				matrix[i][j] = rand.nextInt(10);
			}
		}

		return matrix;
	}

	
}
