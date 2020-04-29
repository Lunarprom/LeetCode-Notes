public class LC1026MaximumDifferenceBetweenNodeAndAncestor {
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
	    int result = 0;
	    public int maxAncestorDiff(TreeNode root) {
	        if (root == null) {
	            return result;
	        }
	        dfs(root, root.val, root.val);
	        
	        return result;
	    }
	    
	    private void dfs(TreeNode root, int min, int max) {
	        if (root == null) {
	            return;
	        }
	        min = Math.min(min, root.val);
	        max = Math.max(max, root.val);
	        if (root.left == null && root.right == null) {
	            result = Math.max(result, Math.abs(max - min));
	        }
	        dfs(root.left, min, max);
	        dfs(root.right, min,max);
	    }
	}
}