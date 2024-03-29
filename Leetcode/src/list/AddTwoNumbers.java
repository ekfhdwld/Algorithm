package list;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode h = new ListNode(0);
		ListNode curr = h;
		int carry = 0;

		while (l1 != null || l2 != null) {
			int x = l1 != null ? l1.val : 0;
			int y = l2 != null ? l2.val : 0;
			
			int sum = carry + x + y;
			carry = sum / 10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			
			if (l1 != null) l1 = l1.next;
			if (l2 != null) l2 = l2.next;
		}

		if (carry > 0) curr.next = new ListNode(carry);

		return h.next;
	}
}

// Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode() {}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}