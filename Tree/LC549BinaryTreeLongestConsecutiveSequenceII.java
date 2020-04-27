public class LC549BinaryTreeLongestConsecutiveSequenceII {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	class RecursionSolution {
	    int max = 0;
	    public int longestConsecutive(TreeNode root) {
	        dfs(root);
	        
	        return max;
	    }
	    
	    private int[] dfs(TreeNode node) {
	        if (node == null) {
	            return new int[]{0, 0};
	        }
	        int incLen = 1;
	        int decLen = 1;
	        if (node.left != null) {
	            int[] leftLens = dfs(node.left);
	            if (node.left.val == node.val + 1) {
	                incLen = leftLens[0] + 1;
	            } else if (node.left.val == node.val - 1) {
	                decLen = leftLens[1] + 1;
	            }
	        }
	        if (node.right != null) {
	            int[] rightLens = dfs(node.right);
	            if (node.right.val == node.val + 1) {
	                incLen = Math.max(incLen, rightLens[0] + 1);
	            } else if (node.right.val == node.val - 1) {
	                decLen = Math.max(decLen, rightLens[1] + 1);
	            }
	        }
	        
	        max = Math.max(max, incLen + decLen - 1);
	        
	        return new int[]{incLen, decLen};
	    }
	}
}