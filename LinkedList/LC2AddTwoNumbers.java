public class LC2AddTwoNumbers {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	class ConciseSolution {
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        int carry = 0;
	        ListNode dummy = new ListNode(0);
	        ListNode curr = dummy;
	        while (l1 != null || l2 != null || carry != 0) {
	            if (l1 != null) {
	                carry += l1.val;
	                l1 = l1.next;
	            }
	            if (l2 != null) {
	                carry += l2.val;
	                l2 = l2.next;
	            }
	            curr.next = new ListNode(carry % 10);
	            carry /= 10;
	            curr = curr.next;
	        }
	        
	        return dummy.next;
	    }
	}



	class MyDummySolution {
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        if (l1 == null && l2 == null) {
	            return null;
	        } else if (l1 == null) {
	            return l2;
	        } else if (l2 == null) {
	            return l1;
	        }
	        
	        ListNode dummy = new ListNode(-1);
	        ListNode curr = dummy;
	        int carry = 0;
	        while (l1 != null && l2 != null) {
	            int value = l1.val + l2.val;
	            int curVal = (value + carry) % 10;
	            curr.next = new ListNode(curVal);
	            carry = (value + carry) / 10;
	            curr = curr.next;
	            l1 = l1.next;
	            l2 = l2.next;
	        }
	        while (l1 != null) {
	            int curVal = (l1.val + carry) % 10;
	            curr.next = new ListNode(curVal);
	            carry = (l1.val + carry) / 10;
	            l1 = l1.next;
	            curr = curr.next;
	        }
	        while (l2 != null) {
	            int curVal = (l2.val + carry) % 10;
	            curr.next = new ListNode(curVal);
	            carry = (l2.val + carry) / 10;
	            l2 = l2.next;
	            curr = curr.next;
	        }
	        if (carry != 0) {
	            curr.next = new ListNode(carry);
	            curr = curr.next;
	        }
	        
	        return dummy.next;
	    }
	}
}