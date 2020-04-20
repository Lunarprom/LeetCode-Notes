public class LC113PathSumII {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	class DFSSolution {
	    /**
	     * Runtime: 1 ms, faster than 99.96% of Java online submissions for Path Sum II.
	     * Memory Usage: 41.9 MB, less than 6.06% of Java online submissions for Path Sum II.
	     */
	    public List<List<Integer>> pathSum(TreeNode root, int sum) {
	        List<List<Integer>> result = new ArrayList<>();
	        dfs(root, result, new ArrayList<Integer>(), sum);
	        
	        return result;
	    }
	    
	    // Traverse DFS
	    private void dfs(TreeNode root, List<List<Integer>> result, List<Integer> path, int sum) {
	        if (root == null) {
	            return;
	        }
	        path.add(root.val);
	        if (root.left == null && root.right == null && root.val == sum) {
	            result.add(new ArrayList<Integer>(path));
	        } else {
	            dfs(root.left, result, path, sum - root.val);
	            dfs(root.right, result, path, sum - root.val);   
	        }
	        path.remove(path.size() - 1);
	    }
	}
}