public class LC206ReverseLinkedList {
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
	class RecursionSolution {
	    public ListNode reverseList(ListNode head) {
	        if (head == null || head.next == null) {
	            return head;
	        }
	        ListNode next = reverseList(head.next);
	        head.next.next = head;
	        head.next = null;
	        return next;
	    }
	}

	class IterationSolution {
	    public ListNode reverseList(ListNode head) {
	        ListNode prev = null;
	        ListNode curr = head;
	        // null 1->2->3 pre = null, curr = 1
	        // null<-1 2->3 pre = 1, curr = 2
	        // null<-1<-2 3 pre = 2, curr = 3
	        // null<-1<-2<-3 pre = 3, curr = null
	        while (curr != null) {
	            ListNode nextTmp = curr.next;
	            curr.next = prev;
	            prev = curr;
	            curr = nextTmp;
	        }
	        
	        return prev;
	    }
	}
}