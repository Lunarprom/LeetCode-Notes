public class LC285InorderSuccessorInBST {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	class IterativeSolution {
	    /**
	     * Binary search solution: traverse from top down to the closest node whose value is larger than p.val;
	     * Runtime: 2 ms, faster than 84.92% of Java online submissions for Inorder Successor in BST.
	     * Memory Usage: 40.1 MB, less than 5.26% of Java online submissions for Inorder Successor in BST.
	     */
	    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
	        if (root == null || p == null) {
	            return null;
	        }
	        TreeNode result = null;
	        while (root != null) {
	            if (p.val >= root.val) {
	                root = root.right;
	            } else {
	                result = root;
	                root = root.left;
	            }
	        }
	        
	        return result;
	    }
	}

    /** 
     * 当根节点值小于等于p节点值，说明p的后继节点一定在右子树中，所以对右子节点递归调用此函数;
     * 如果根节点值大于p节点值，那么有可能根节点就是p的后继节点，或者左子树中的某个节点是p的后继节点，
     * 所以先对左子节点递归调用此函数，如果返回空，说明根节点是后继节点，返回即可，如果不为空，则将那个节点返回
     */
	class RecursiveSolution {
	    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
	        if (root == null || p == null) {
	            return null;
	        }
	        if (root.val <= p.val) {
	            return inorderSuccessor(root.right, p);
	        } else {
	            TreeNode left = inorderSuccessor(root.left, p);
	            return left != null ? left : root;
	        }
	    }
	}
}
