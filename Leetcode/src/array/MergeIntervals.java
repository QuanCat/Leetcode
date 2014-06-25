package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//  Definition for an interval.
class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
}

public class MergeIntervals {
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		if (intervals == null || intervals.size() <= 1) {
			return intervals;
		}
		// Nlog(N)
		Collections.sort(intervals, new IntervalComparator());
		// [1,3], [2,5]
		ArrayList<Interval> result = new ArrayList<Interval>();
		Interval last = intervals.get(0); // [1,3]
		for (int i = 1; i < intervals.size(); i++) {
			Interval curt = intervals.get(i); // [2,5]
			if (curt.start <= last.end) { // 2<=3
				last.end = Math.max(last.end, curt.end);
				// then keep on compare last with next curr
			} else {
				result.add(last);
				last = curt;
			}
		}

		result.add(last);
		return result;
	}

	// to sort intervals from small to big according to the first number
	private class IntervalComparator implements Comparator<Interval> {
		public int compare(Interval a, Interval b) {
			return a.start - b.start;
		}
	}

}
