public class LC110BalancedBinaryTree {
	/**
	 * My intuitive solution. Finished bug-free in 7 minutes.
	 */
	class DoubleRecursionSolution {
	    public boolean isBalanced(TreeNode root) {
	        if (root == null) {
	            return true;
	        }
	        
	        int leftHeight = getHeight(root.left);
	        int rightHeight = getHeight(root.right);
	        if (Math.abs(leftHeight - rightHeight) > 1) {
	            return false;
	        }
	        
	        boolean leftBalanced = isBalanced(root.left);
	        boolean rightBalanced = isBalanced(root.right);
	        
	        return leftBalanced && rightBalanced;
	    }
	    
	    private int getHeight(TreeNode root) {
	        if (root == null) {
	            return 0;
	        }
	        int leftHeight = getHeight(root.left);
	        int rightHeight = getHeight(root.right);
	        
	        return Math.max(leftHeight, rightHeight) + 1;
	    } 
	}
}