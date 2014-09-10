package lists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Merge_k_Sorted_Lists {
	public static class ListNode{
		public int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	//Build a comparator
	private static Comparator<ListNode> listNodeComparator = 
			new Comparator<ListNode>(){

				@Override
				public int compare(ListNode o1, ListNode o2) {
					if (o1.val < o2.val) {
						return -1;
					} else if (o1.val > o2.val) {
						return 1;
					} else {
						return 0;
					}
					
				}
		
	};
	
	public static ListNode mergeKLists(ArrayList<ListNode> lists) {
		if (lists == null || lists.size() == 0) {
			return null;
		}
		Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), listNodeComparator);
		// add element to heap
		for (int i = 0; i < lists.size(); i++) {
			if (lists.get(i) != null) {
				// put the head of each list into heap
				heap.add(lists.get(i));
			}
		}
		
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while (!heap.isEmpty()) {
			ListNode head = heap.poll();
			tail.next = head;
			tail = head;
			if (head.next != null) {
				heap.add(head.next);
			}
		}
		return dummy.next;
	}
	
}
