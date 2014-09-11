package array;

public class Find_kth_Element_in_Two_Sorted_Array {
	//Solution 1:
	public int mergeGetKthNumber(int[] A, int[] B, int k) {
		int[] C = mergeTwoArrays(A, B);
		return C[k - 1];
	}
	
	public int[] mergeTwoArrays(int[] A, int[] B) {
		int[] C = new int[A.length + B.length];
		int i = 0, j = 0, k = 0;
		while (i < A.length && j < B.length) {
			if (A[i] <= B[j]) {
				C[k] = A[i];
				i++;
			} else {
				C[k] = B[j];
				j++;
			}
			k++;
		}
		while (i < A.length) {
			C[k] = A[i];
			i++;
			k++;
		}
		while (j < B.length) {
			C[k] = B[j];
			j++;
			k++;
		}
		return C;
	}
	
	//Solution 2:
	// Get the index of largest element in array which is smaller than k
	public int binarySearch(int[] array, int num, int k) {
		int low = 1;
		int high = num;
		while (low < high) {
			int mid = (low + high) / 2;
			if (array[mid] > k) {
				high = mid - 1;
			} else if (array[mid] < k) {
				if (array[mid + 1] > k) {
					return mid;
				} else {
					low = mid + 1;
				}
			}
		}
		return 0;
	}
	
}
