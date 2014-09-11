package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Find_Longest_Consecutive_Integer_in_Array {
	// Solution 1:
	public int findLonestConsequence(int[] array) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max = 1;
		for (int num: array) {
			if (map.containsKey(num)) {
				continue;
			}
			map.put(num, 1);
			
			if (map.containsKey(num - 1)) {
				max = Math.max(max, merge(map, num - 1, num));
			}
			if (map.containsKey(num + 1)) {
				max = Math.max(max, merge(map, num, num + 1));
			}
		}
		return max;
	}
	
	public int merge(HashMap<Integer, Integer> map, int left, int right) {
		int upper = right + map.get(right) - 1;
		int lower = left - (map.get(left) - 1);
		int len = upper - lower + 1;
		map.put(upper, len);
		map.put(lower, len);
		return len;
	}
	// Solution 2:
	public int findLonestConsequence2(int[] num) {
		Set<Integer> set = new HashSet<Integer>();
		int max = 1;
		for (int n : num) {
			set.add(n);
		}
		for (int n : num) {
			int left = n - 1;
			int right = n + 1;
			int count = 1;
			while (set.contains(left)) {
				count++;
				/* After the element is checked, it should be 
				 *  removed from the set
				 */
				set.remove(left);
				left--;
			}
			while (set.contains(right)) {
				count++;
				set.remove(right);
				right++;
			}
			max = Math.max(count, max);
		}
		return max;
	}
}
