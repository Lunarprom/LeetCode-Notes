public class LC199BinaryTreeRightSideView {
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
	     * DFS solution: Always make sure the right most child node gets visited and added to the result first
	     */
	    public List<Integer> rightSideView(TreeNode root) {
	        List<Integer> result = new ArrayList<>();
	        dfs(root, result, 0);
	        
	        return result;
	    }
	    
	    private void dfs(TreeNode root, List<Integer> result, int depth) {
	        if (root == null) {
	            return;
	        }
	        if (depth == 0 || depth >= result.size()) {
	            result.add(root.val);
	        }
	        dfs(root.right, result, depth + 1);
	        dfs(root.left, result, depth + 1);
	    }
	}

	class BFSSolution {
	    /**
	     * Level-order traversal but only output the value of the last node in each level.
	     */
	    public List<Integer> rightSideView(TreeNode root) {
	        List<Integer> result = new ArrayList<>();
	        if (root == null) {
	            return result;
	        }
	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.offer(root);
	        while (!queue.isEmpty()) {
	            // Make sure only traversing the same level every time
	            int size = queue.size();
	            List<TreeNode> level = new ArrayList<>();
	            for (int i = 0; i < size; i++) {
	                TreeNode curr = queue.poll();
	                if (curr.left != null) {
	                    queue.offer(curr.left);
	                }
	                if (curr.right != null) {
	                    queue.offer(curr.right);
	                }
	                level.add(curr);
	            }
	            TreeNode node = level.get(level.size() - 1);
	            result.add(node.val);
	        }
	        
	        return result;
	    }
	}
}