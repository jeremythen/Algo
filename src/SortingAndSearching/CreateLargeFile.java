package SortingAndSearching;

import java.io.*;

public class CreateLargeFile {
	public static final String PATH = "C:\\Users\\Jeremy\\Desktop\\PDFs\\Java\\externalSortTest\\";
	public static void main(String[] args) throws Exception {
		DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(PATH + "largedata.txt")));

		for (int i = 0; i < 800_004; i++)
			output.writeInt((int) (Math.random() * 1_000_000));

		output.close();

// Display first 100 numbers
		DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(PATH + "largedata.txt")));
		for (int i = 0; i < 100; i++)
			System.out.print(input.readInt() + " ");

		input.close();
	}
}