public class LC142LinkedListCycleII {
	/**
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle II.
	 * Memory Usage: 39.8 MB, less than 6.32% of Java online submissions for Linked List Cycle II.
	 */
	public class Solution {
	    public ListNode detectCycle(ListNode head) {
	        if (head == null || head.next == null) {
	            return null;
	        }
	        ListNode fast = head.next.next;
	        ListNode slow = head.next;

	        while(fast != slow){
	            if(fast == null || fast.next == null) {
	                return null;
	            }
	            
	            slow = slow.next;
	            fast = fast.next.next;
	        }

	        fast = head;
	        while (slow != fast) {
	            slow = slow.next;
	            fast = fast.next;
	        }
	        return fast;
	    }
	}

	class ListNode {
		int val;
	 	ListNode next;
	 	ListNode(int x) {
	 		val = x;
	 		next = null;
	 	}
	}
}