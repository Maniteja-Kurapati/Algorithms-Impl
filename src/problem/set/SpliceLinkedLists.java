package problem.set;

public class SpliceLinkedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode head = new ListNode(0);
		ListNode current = head;
		ListNode curLs1 = l1;
		ListNode curLs2 = l2;

		while (curLs1 != null && curLs2 != null) {
			if (curLs1.val <= curLs2.val) {
				current.next = curLs1;
				curLs1 = curLs1.next;
			} else {
				current.next = curLs2;
				curLs2 = curLs2.next;
			}
		}
		if (curLs1 == null) {
			current.next = curLs2;
		}
		if (curLs2 == null) {
			current.next = curLs1;
		}
		return head.next;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
