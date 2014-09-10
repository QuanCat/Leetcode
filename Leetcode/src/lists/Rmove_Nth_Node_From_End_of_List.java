package lists;

public class Rmove_Nth_Node_From_End_of_List {
	//Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode removeNthFromEnd(ListNode head, int n) {
        /*
         * 1. two start points: head and prev
         * 2. Node n2 move N steps first
         * 3. then n1, n2, head move (L-N) steps together
         * 4. return head.next
         */
		ListNode prev, n1, n2;
		prev = new ListNode(0);
		prev.next = head;
		head = prev;
		n1 = head.next;
		n2 = head.next;
		while (n2 != null && n > 0) {
			n2 = n2.next;
			n--;
		}
		/*
		 *	Runtime Error Message:	Line 28: java.lang.NullPointerException
		 *	Last executed input:	{1}, 1
		 */
		if (n > 0) {return n1;}
		while (n2 != null) {
			n2 = n2.next;
			n1 = n1.next;
			prev = prev.next;
		}
		prev.next = n1.next;
		return head.next;
	
    }
}
