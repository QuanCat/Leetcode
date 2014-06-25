package array;

/* //You may assume that A has enough space 
 * (size that is greater or equal to m + n) to hold 
 * additional elements from B. 
 * */

public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
		int index = m + n; // index in A,add from the end of A
		while (m > 0 && n > 0) {
			if (A[m - 1] > B[n - 1]) {
				A[--index] = A[--m];
			} else {
				A[--index] = B[--n];
			}
		}
		while (n > 0) {
			A[--index] = B[--n];
		}
	}

}
