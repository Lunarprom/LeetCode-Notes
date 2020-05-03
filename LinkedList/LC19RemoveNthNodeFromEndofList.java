public class LC19RemoveNthNodeFromEndofList{
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode() {}
	 *     ListNode(int val) { this.val = val; }
	 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 */
	class TwoPointersSolution {
	    public ListNode removeNthFromEnd(ListNode head, int n) {
	        if (head == null || n == 0) {
	            return head;
	        }
	        ListNode dummy = new ListNode(-1, head);
	        ListNode slow = dummy;
	        ListNode fast = dummy;
	        int delta = 0;
	        
	        // Make the fast pointer n + 1 further than slow node.
	        // e.g. -1->1->2->3->4->5, n = 2;
	        // delta = 0: fast:1
	        // delta = 1: fast:2, slow:-1
	        // delta = 2: fast:3, slow:-1
	        while (delta <= n && fast != null) {
	            fast = fast.next;
	            delta++;
	        }
	        while (fast != null) {
	            fast = fast.next;
	            slow = slow.next;
	        }
	        slow.next = slow.next.next;
	        
	        return dummy.next;
	    }
	}
}