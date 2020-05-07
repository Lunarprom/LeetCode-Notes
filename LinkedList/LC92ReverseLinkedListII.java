public class LC92ReverseLinkedListII {
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
	class IterationSolution {
	    public ListNode reverseBetween(ListNode head, int m, int n) {
	        ListNode dummy = new ListNode(-1);
	        dummy.next = head;
	        ListNode curr = dummy;
	        int index = 1;
	        while (index < m && curr.next != null) {
	            curr = curr.next;
	            index++;
	        }
	        // dummy->1->2->3->4->5 curr=(1->2->3->4->5) pre = 1
	        ListNode start = curr;
	        ListNode pre = null;
	        ListNode tmp = null;
	        curr = curr.next;
	        while (index <= n && curr != null) {
	            tmp = curr.next;
	            curr.next = pre;
	            pre = curr;
	            curr = tmp;
	            index++;
	        }
	        // index:2:dummy->1 pre:1->... curr:2->... tmp:3->...
	            // dummy->1<-2 curr:3->
	        // index:3 dummy->1<-2 pre: 2->... curr:3-> tmp:4->...
	            // dummy->1<-2<-3 curr:4->
	        // index:4 dummy->1<-2<-3 curr:4->.. tmp:5->null
	            // dummy->1<-2<-3<-4 tmp:5->null start:1->2->... pre:4->3->2...
	        start.next.next = tmp; // dummy->1 null<-5<-2<-3<-4
	        start.next = pre;
	        
	        return dummy.next;
	    }
	}
}