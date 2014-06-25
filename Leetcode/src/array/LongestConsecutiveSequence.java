package array;

import java.util.HashSet;
import java.util.Set;

/**
 * We can use a HashSet to add and remove elements. HashSet is implemented by
 * using a hash table. Elements are not ordered. The add, remove and contains
 * methods have constant time complexity O(1).
 */
public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] num) {
		Set<Integer> set = new HashSet<Integer>();
		int max = 1;

		for (int n : num)
			set.add(n);

		for (int n : num) { // O(n)
			int left = n - 1;
			int right = n + 1;
			int count = 1;

			while (set.contains(left)) { // O(m1)
				count++;
				// after element is checked, it should be removed from the set
				set.remove(left);
				left--;
			}

			while (set.contains(right)) { // O(m2)
				count++;
				set.remove(right);
				right++;
			}

			max = Math.max(count, max);
		}

		return max;
	}

}
