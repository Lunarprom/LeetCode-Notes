public class LC129SumRootToLeafNumbers {
	/**
	 * DFS/Preorder.
	 * Essentially a Path Sum
	 */
	class PreOrderRecursionSolution {
	    
	    int rootToLeaf = 0;
	    public int sumNumbers(TreeNode root) {
	        dfs(root, 0);
	        
	        return rootToLeaf;
	    }
	    
	    private void dfs(TreeNode root, int currSum) {
	        if (root == null) {
	            return;
	        }
	        currSum = currSum * 10 + root.val;
	        if (root.left == null && root.right == null) {
	            rootToLeaf += currSum;
	            return;
	        }
	        if (root.left != null) {
	            dfs(root.left, currSum);
	        }
	        if (root.right != null) {
	            dfs(root.right, currSum);
	        }
	    }
	}

	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
}