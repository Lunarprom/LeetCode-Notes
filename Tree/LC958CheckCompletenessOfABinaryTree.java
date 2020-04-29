public class LC958CheckCompletenessOfABinaryTree {
	/**
	 * DFS 好像行不通。BFS层序遍历检查中途是否出现过null.
	 */
	class BFSSolution {
	    public boolean isCompleteTree(TreeNode root) {
	        if (root == null) {
	            return true;
	        }
	        boolean hasNull = false;
	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.add(root);
	        while (!queue.isEmpty()) {
	            int size = queue.size();
	            for (int i = 0 ; i < size; i++) {
	                TreeNode curr = queue.poll();
	                if (curr == null) {
	                    hasNull = true;
	                    continue;
	                } else if (hasNull) {
	                    return false;
	                } else {
	                    queue.add(curr.left);
	                    queue.add(curr.right);
	                }
	            }
	        }
	        return true;
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