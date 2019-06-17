package IntroductionToAlgo3rd;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MaximunSubarray {

	public static void main(String[] args) {
		
		int[] arr = {-13, -3, -1, -20, -3, -16, -23, -18, -20, -7, -12, -5, -22, -15, -4, -7};

		
		
		//findMaxSubarray(arr);
		
		int[] answer = findMaxSubarray(arr, 0, arr.length - 1);
		
		System.out.println(Arrays.toString(answer));
		maxSubArraySum(arr, arr.length);
		
	}
	
	static void maxSubArraySum(int a[], int size) { 
        
		int currentMax = Integer.MIN_VALUE;
		int maxStart = 0;
		int currentStart = 0;
		int sum = 0;
		int endIndex = 0;
		
		for(int i = 0; i < size; i++) {
			
			sum += a[i];
			
			if(currentMax < sum) {
				currentMax = sum;
				maxStart = currentStart;
				endIndex = i;
			}
			
			if(sum < 0) {
				sum = 0;
				currentStart = i + 1;
			}
			
			
		}
		
		System.out.format("maxStart: %s, endIndex: %s, sum: %s", maxStart, endIndex, currentMax);
		
		
    } 
	
	public static int[] findMaxSubarray(int[] arr, int lo, int hi) {
		
		if(lo == hi) {
			return new int[] {lo, hi, arr[lo]};
		}else {
			int mid = (hi + lo) / 2;
			int[] leftArr = findMaxSubarray(arr, lo, mid);
			
			int[] rightArr = findMaxSubarray(arr, mid + 1, hi);
			
			int[] crossing = findMaxCrossingSubarray(arr, lo, mid , hi);
			
			if(leftArr[2] >= rightArr[2] && leftArr[2] >= crossing[2]) {
				//return leftArr;
				return Arrays.copyOf(leftArr, leftArr.length);
			}else if(rightArr[2] >= leftArr[2] && rightArr[2] >= crossing[2]) {
				//return rightArr;
				return Arrays.copyOf(rightArr, rightArr.length);
			}else {
				//return crossing;
				return Arrays.copyOf(crossing, crossing.length);
			}	
		}
	}
	
	
	public static int[] findMaxCrossingSubarray(int[] arr, int lo, int mid, int hi) {
		
		int sum = 0;
		
		int leftSum = Integer.MIN_VALUE;
		int maxLeftIndex = 0;
		
		for(int i = mid; i >= 0; i--) {
			
			sum += arr[i];
			
			if(sum > leftSum) {
				leftSum = sum;
				maxLeftIndex = i;
			}
		}
		
		sum = 0;
		int rightSum = Integer.MIN_VALUE;
		int maxRightIndex = 0;
		
		for(int i = mid + 1; i < hi; i++) {
			
			sum += arr[i];
			
			if(sum > rightSum) {
				rightSum = sum;
				maxRightIndex = i;
			}
			
		}
		
		//System.out.format("MaxLeft: %s, MaxRight: %s, total: %s", maxLeftIndex, maxRightIndex, leftSum + rightSum);
		
		return new int[] {maxLeftIndex, maxRightIndex, leftSum + rightSum};
		
	}

}
