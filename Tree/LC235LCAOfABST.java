public class LC235LCAOfABST {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	class RecursiveSolution {
	    /**
	     * Recursive approach.
	     * Runtime: 9 ms, faster than 5.56% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
	     * Memory Usage: 47.7 MB, less than 5.10% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
	     */
	    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        if (root == null || p == null || q == null) {
	            return null;
	        }
	        if (p.val < q.val) {
	            TreeNode temp = p;
	            p = q;
	            q = temp;
	        }
	        
	        return lcaHelper(root, p, q);
	    }
	    
	    private TreeNode lcaHelper(TreeNode root, TreeNode p, TreeNode q) {
	        if (root == null) {
	            return null;
	        }
	        if (p.val > root.val && q.val > root.val) {
	            return lcaHelper(root.right, p, q);
	        }
	        if (p.val < root.val && q.val < root.val) {
	            return lcaHelper(root.left, p, q);
	        }
	        return root;
	    }
	}

	/**
	 * Runtime: 6 ms, faster than 7.34% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
	 * Memory Usage: 47.6 MB, less than 5.10% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
	 */
	class IterationSolution {
	    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        if (root == null) {
	            return root;
	        }
	        if (p.val > q.val) {
	            TreeNode temp = p;
	            p = q;
	            q = temp;
	        }
	        TreeNode node = root;
	        while (node != null) {
	            if (p.val > node.val && q.val > node.val) {
	                node = node.right;
	            } else if (p.val < node.val && q.val < node.val) {
	                node = node.left;
	            } else {
	                return node;
	            }
	        }
	        
	        return node;
	    }
	}
}