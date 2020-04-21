public class LC226InvertBinaryTree {
	/**
	 * Divide & conquer.
	 * Time complexity: O(N) since we need to visit all the nodes.
	 * Space complexity: O(h), h is the height of the tree -> O(N)
	 */
	class DACRecursionSolution {
	    public TreeNode invertTree(TreeNode root) {
	        if (root == null) {
	            return root;
	        }
	        TreeNode left = invertTree(root.left);
	        TreeNode right = invertTree(root.right);
	        
	        root.left = right;
	        root.right = left;
	        
	        return root;
	    }
	}

	/**
	 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Invert Binary Tree.
	 * Memory Usage: 38.6 MB, less than 5.10% of Java online submissions for Invert Binary Tree.
	 * Time complexity: O(N) since we need to visit all the nodes.
	 * Space complexity: O(N) in worst case when the queue contains all the nodes in one level, 
	 * and O(N/2) = O(N)
	 */
	class BFSIterationSolution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.right;
            current.right = current.left;
            current.left = temp;
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        
        return root;
    }
}

	//Definition for a binary tree node.
	public class TreeNode {
		int val;
	 	TreeNode left;
	 	TreeNode right;
	 	TreeNode(int x) { val = x; }
	}
}