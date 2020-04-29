public class LC1008ConstructBinarySearchTreeFromPreorderTraversal {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	class Solution {
	    /**
	     * The first number of the array is the root.
	     * cut the subarray of all numbers smaller than the root, it's the left subtree;
	     * the other half is the right subtree
	     */
	    public TreeNode bstFromPreorder(int[] preorder) {
	        if (preorder == null || preorder.length == 0) {
	            return null;
	        }
	        
	        return helper(preorder, 0, preorder.length - 1);
	    }
	    
	    private TreeNode helper(int[] preorder, int start, int end) {
	        if (start > end) {
	            return null;
	        }
	        TreeNode root = new TreeNode(preorder[start]);
	        if (start == end) {
	            return root;
	        }
	        int index = start;
	        // 去看index + 1 可以防止index越界
	        while (index + 1 <= end && preorder[index + 1] < root.val) {
	            index++;
	        }
	        root.left = helper(preorder, start + 1, index);
	        root.right = helper(preorder, index + 1, end);
	        
	        return root;
	    }
	}
}