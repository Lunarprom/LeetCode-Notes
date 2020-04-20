public class LC437PathSumIII {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	class DoubleRecursionSolution {
	    /**
	     * double recursion + preorder traversal, in which treats every node as the root.
	     * Runtime: 20 ms, faster than 58.20% of Java online submissions for Path Sum III.
	     * Memory Usage: 40.9 MB, less than 63.64% of Java online submissions for Path Sum III.
	     */
	    public int pathSum(TreeNode root, int sum) {
	        if (root == null) {
	            return 0;
	        }
	        
	        return containPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
	    }
	    
	    private int containPath(TreeNode root, int sum) {
	        if (root == null) {
	            return 0;
	        }
	        int count = 0;
	        if (root.val == sum) {
	            count++;
	        }
	        return count + containPath(root.left, sum - root.val) + containPath(root.right, sum - root.val);
	    }
	}
}