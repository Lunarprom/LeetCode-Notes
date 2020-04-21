public class LC124BinaryTreeMaximumPathSum {
	/**
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Maximum Path Sum.
	 * Memory Usage: 41.7 MB, less than 5.95% of Java online submissions for Binary Tree Maximum Path Sum.
	 */
	class Solution {
	    int maxSum = Integer.MIN_VALUE;
	    public int maxPathSum(TreeNode root) {
	        pathSumHelper(root);
	        return maxSum;
	    }
	    
	    private int pathSumHelper(TreeNode root) {
	        if (root == null) {
	            return 0;
	        }
	        
	        // If the sum from the child is <0, might as well skip it.
	        int leftSum = Math.max(0, pathSumHelper(root.left));
	        int rightSum = Math.max(0, pathSumHelper(root.right));
	        
	        // The potential maximum sum is different than the sum being returned.
	        maxSum = Math.max(maxSum, root.val + leftSum + rightSum);
	        
	        // You can only pick left or right path to return.
	        return Math.max(root.val + leftSum, root.val + rightSum);
	    }
	}
	
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}