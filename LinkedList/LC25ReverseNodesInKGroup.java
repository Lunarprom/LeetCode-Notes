public class LC25ReverseNodesInKGroup {

	class IterationSolution {
	    public ListNode reverseKGroup(ListNode head, int k) {
	        // Save the previous reversed pointer in prev and in each iteration use prev.next to set the previous ptr to the current reversed.
	        ListNode dummy = new ListNode(0);
	        dummy.next = head;
	        
	        ListNode tempHead = head;
	        ListNode prev = dummy;
	        while (tempHead != null) {
	            ListNode kLast = tempHead;
	            int counter = 0;
	            while (counter < k && tempHead != null) {
	                tempHead = tempHead.next;
	                counter++;
	            }
	            // reversal is not needed.
	            if (counter < k) {
	                prev.next = kLast;
	                break;
	            }
	            ListNode kStart = reverseLinkedList(kLast, k);
	            prev.next = kStart;
	            prev = kLast;
	        }
	        
	        return dummy.next;
	    }
	    
	    // 1->2->3
	    private ListNode reverseLinkedList(ListNode head, int k) {
	        ListNode newHead = null;
	        ListNode ptr = head;
	        while (k > 0) {
	            ListNode next = ptr.next;
	            ptr.next = newHead;
	            newHead = ptr;
	            ptr = next;
	            k--;
	        }
	        
	        return newHead;
	    }
	}

	/**
	 * 把node按K个为一组来翻转。递归的方式天然适合做这种循环，但是题目要求常数级别的额外空间所以递归这个解法不符合要求。
	 */
	class RecursionSolution {
	    public ListNode reverseKGroup(ListNode head, int k) {
	        int count = 0;
	        ListNode ptr = head;
	        while (count < k && ptr != null) {
	            ptr = ptr.next;
	            count++;
	        }
	        if (count == k) {
	            ListNode reverseHead = reverseLinkedList(head, k);
	            head.next = reverseKGroup(ptr, k);
	            return reverseHead;
	        }
	        
	        return head;
	    }
	    
	    // 1->2->3
	    private ListNode reverseLinkedList(ListNode head, int k) {
	        ListNode newHead = null;
	        ListNode ptr = head;
	        while (k > 0) {
	            ListNode next = ptr.next;
	            ptr.next = newHead;
	            newHead = ptr;
	            ptr = next;
	            k--;
	        }
	        
	        return newHead;
	    }
	}
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
}