public class LC109ConvertSortedListToBST {
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
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode() {}
	 *     TreeNode(int val) { this.val = val; }
	 *     TreeNode(int val, TreeNode left, TreeNode right) {
	 *         this.val = val;
	 *         this.left = left;
	 *         this.right = right;
	 *     }
	 * }
	 */
	class Solution {
	    
	    LinkedList<Integer> values;
	    
	    public TreeNode sortedListToBST(ListNode head) {
	        values = new LinkedList<Integer>();
	        mapListToValues(head);
	        
	        return convert(0, values.size() - 1);
	    }
	    
	    private void mapListToValues(ListNode head) {
	        while (head != null) {
	          this.values.add(head.val);
	          head = head.next;
	        }
	    }
	    
	    private TreeNode convert(int start, int end) {
	        if (start > end) {
	            return null;
	        }
	        int mid = start + (end - start) / 2;
	        TreeNode curr = new TreeNode(values.get(mid));
	        if (start == end) {
	            return curr;
	        }
	        curr.left = convert(start, mid - 1);
	        curr.right = convert(mid + 1, end);
	        
	        return curr;
	    }
	}
}