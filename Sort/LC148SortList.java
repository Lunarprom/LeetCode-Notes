public class LC148SortList {
	// Merge sort. 题目要求Constant extra space。但每次递归会使用O(LogN)的额外空间所以不符合题意。
	class Solution {
	    public ListNode sortList(ListNode head) {
	        if (head == null || head.next == null) {
	            return head;
	        }

	        // step 1. cut the list to two halves
	        ListNode prev = null, slow = head, fast = head;

	        while (fast != null && fast.next != null) {
	          prev = slow;
	          slow = slow.next;
	          fast = fast.next.next;
	        }

	        // cut the two half
	        prev.next = null;

	        // step 2. sort each half
	        ListNode l1 = sortList(head);
	        ListNode l2 = sortList(slow);

	        // step 3. merge l1 and l2
	        return nonRecursiveMerge(l1, l2);
	    }

	    private ListNode nonRecursiveMerge(ListNode node1, ListNode node2) {
	        if (node1 == null && node2 == null) {
	            return null;
	        } else if (node1 == null) {
	            return node2;
	        } else if (node2 == null) {
	            return node1;
	        }
	        ListNode dummy = new ListNode(-1);
	        ListNode tail = dummy;
	        while (node1 != null && node2 != null) {
	            if (head2 == null || (head1 != null && head1.val <= head2.val)) {
	                tail.next = node1;
	                node1 = node1.next;
	            } else {
	                tail.next = node2;
	                node2 = node2.next;
	            }
	            tail = tail.next;
	        }
	        
	        return dummy.next;
	    }
	    
	    private ListNode merge(ListNode node1, ListNode node2) {
	        if (node1 == null && node2 == null) {
	            return null;
	        } else if (node1 == null) {
	            return node2;
	        } else if (node2 == null) {
	            return node1;
	        }
	        
	        if (node1.val <= node2.val) {
	            node1.next = merge(node1.next, node2);
	            return node1;
	        } else {
	            node2.next = merge(node1, node2.next);
	            return node2;
	        }
	    }
	}

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
}