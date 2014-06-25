package array;

public class RemoveDuplicates2 {
	public int removeDuplicates(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}

		int size = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] == A[size] && size > 0 && A[size - 1] == A[size]) {
				continue;
			}
			A[++size] = A[i];
		}
		return size + 1;
	}

}
