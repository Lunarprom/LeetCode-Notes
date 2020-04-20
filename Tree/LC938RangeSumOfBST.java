public class LC938RangeSumOfBST {
	/** 
	 * Runtime: 1 ms, faster than 51.01% of Java online submissions for Range Sum of BST.
	 * Memory Usage: 47 MB, less than 93.60% of Java online submissions for Range Sum of BST.
	 */
	class InorderTraversalRecursiveSolution {
	    int sum;
	    public int rangeSumBST(TreeNode root, int L, int R) {
	        sum = 0;
	        inorderTraversal(root, L, R);
	        
	        return sum;
	    }
	    
	    private void inorderTraversal(TreeNode root, int L, int R) {
	        if (root == null) {
	            return;
	        }
	        inorderTraversal(root.left, L, R);
	        if (root.val >= L && root.val <= R) {
	            sum += root.val;
	        }
	        inorderTraversal(root.right, L, R);
	    }
	}

	/**
	 * Runtime: 7 ms, faster than 5.10% of Java online submissions for Range Sum of BST.
	 * Memory Usage: 47.6 MB, less than 90.70% of Java online submissions for Range Sum of BST.
	 */
	class InorderTraversalIterativeSolution {
	    public int rangeSumBST(TreeNode root, int L, int R) {
	        int sum = 0;
	        if (root == null) {
	            return sum;
	        }
	        Stack<TreeNode> stack = new Stack<>();
	        TreeNode curr = root;
	        while (curr != null || !stack.isEmpty()) {
	            while (curr != null) {
	                stack.push(curr);
	                curr = curr.left;
	            }
	            curr = stack.pop();
	            if (curr.val >= L && curr.val <= R) {
	                sum += curr.val;
	            }
	            curr = curr.right;
	        }
	        
	        return sum;
	    }
	}

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}