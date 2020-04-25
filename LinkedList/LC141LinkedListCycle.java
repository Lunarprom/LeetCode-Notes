public class LC141LinkedListCycle {
	public class Solution {
	    public boolean hasCycle(ListNode head) {
	        if (head == null) {
	            return false;
	        }
	        ListNode slow = head;
	        ListNode fast = head.next;
	        while (slow != fast) {
	            if (fast == null || fast.next == null) {
	                return false;
	            }
	            fast = fast.next.next;
	            slow = slow.next;
	        }
	        
	        return true;
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