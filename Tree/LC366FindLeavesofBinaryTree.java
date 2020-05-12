public class LC366FindLeavesofBinaryTree {
	/**
	 * 从上往下行不通，就想想自底向上，这样的话叶子结点就都能被存到同一层去。
	 */
	class Solution {
	    public List<List<Integer>> findLeaves(TreeNode root) {
	        List<List<Integer>> result = new ArrayList<>();
	        helper(root, result);
	        
	        return result;
	    }
	    
	    private int helper(TreeNode root, List<List<Integer>> result) {
	        if (root == null) {
	            return -1;
	        }
	        int left = helper(root.left, result);
	        int right = helper(root.right, result);
	        int level = Math.max(left, right) + 1;
	        if (result.size() == level) {
	            result.add(new ArrayList<>());
	        }
	        result.get(level).add(root.val);
	        root.left = null;
	        root.right = null;
	        
	        return level;
	    }
	}

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
}