package ArraysAndString;


import nanocounter.NanoCounter;

/*
Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4
bytes, write a method to rotate the image by 90 degrees. (an you do this in place?
*/

public class RotateMatrix {

	public static void main(String[] args) {

		int[][] matrix = getMatrix();
		
		NanoCounter.run("rotateMatrix", (e) -> {
			rotateMatrix(matrix);
		});
		
		System.out.println();
		System.out.println("AFte first");
		System.out.println();
		
		NanoCounter.run("rotateMatrix", (e) -> {
			rotate(matrix);
		});

	}
	
	public static boolean rotate(int[][] matrix) {
		
		printMatrix(matrix);
		
		int n = matrix.length;
		
		for(int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for(int i = first; i < last; i++) {
				int offset = i - first;
				int top = matrix[first][i];
				matrix[first][i] = matrix[last-offset][first];
				matrix[last-offset][first] = matrix[last][last - offset];
				matrix[last][last - offset] = matrix[i][last];
				matrix[i][last] = top;
			}
		}
		
		printMatrix(matrix);
		
		return true;
		
	}

	public static void rotateMatrix(int[][] matrix) {


		printMatrix(matrix);

		int len = matrix.length;

		int to = (len * len) / 2;
		int count = 0;

		for (int i = 0, k = len - 1; count < to; i++, k--) {
			for (int j = 0, m = len - 1; count < to && j < len; j++, m--) {
				int v = matrix[i][j];
				matrix[i][j] = matrix[k][m];
				matrix[k][m] = v;
				count++;
			}
		}

		printMatrix(matrix);

	}

	public static void printMatrix(int[][] matrix) {

		int len = matrix.length;

		System.out.println();
		
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				System.out.format("%-5s", matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println();

	}

	public static int[][] getMatrix() {

		int[][] matrix = new int[4][4];

		int counter = 0;

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				matrix[i][j] = counter++;
			}
		}

		return matrix;
	}

}
