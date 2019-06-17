package SortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class BucketSort {

	public static void main(String[] args) {
		
		int[] ints = {3,1,0,7,5,9,8,2,3,4,1,7};
		int max = 9;
		
		System.out.println(Arrays.toString(ints));

		radixSort(ints, max);
		
		System.out.println(Arrays.toString(ints));
		
	}
	
	public static void radixSort(int [] arr, int max) {
		
		List<Integer>[] bucket = new ArrayList[arr.length + max + 1];
		
		for(int i = 0; i < arr.length; i++) {
			
			int value = arr[i];
			
			if(bucket[value] == null) {
				bucket[value] = new ArrayList<>();
			}
			
			bucket[value].add(value);
			
		}
		
		int k = 0;
		
		for(int i = 0; i < arr.length; i++) {
			List<Integer> list = bucket[i];
			if(Objects.nonNull(list)) {
				for(int e : list) {
					arr[k++] = e;
				}
			}
			
		}
		
	}

}
