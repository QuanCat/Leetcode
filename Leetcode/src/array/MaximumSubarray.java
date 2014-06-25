package array;

public class MaximumSubarray {
	// Version 1: Sliding Window
	public int maxSubArray1(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}

		int max = Integer.MIN_VALUE, sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			max = Math.max(max, sum);
			sum = Math.max(sum, 0);
		}

		return max;
	}

	// Version 2: Prefix Sum
	public int maxSubArray2(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}

		int max = Integer.MIN_VALUE, sum = 0, minSum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			max = Math.max(max, sum - minSum);
			minSum = Math.min(minSum, sum);
		}
		return max;
	}

}
