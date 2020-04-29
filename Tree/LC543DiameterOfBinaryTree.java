public class LC543DiameterOfBinaryTree {
	class CountingEdgeSolution {
	    int max = 0;
	    public int diameterOfBinaryTree(TreeNode root) {
	        if (root == null) {
	            return max;
	        }
	        helper(root, 0);
	        return max;
	    }
	    
	    private int helper(TreeNode root, int length) {
	        if (root == null) {
	            return length;
	        }
	        int left = helper(root.left, length);
	        int right = helper(root.right, length);
	        max = Math.max(max, left + right); // 不+1是因为这里数的是node之间的边。
	        
	        // 返还上一层的时候必须是root +left or root + right
	        return Math.max(left, right) + 1;
	    }
	}
	
	class CountingNodeSolution {
	    int max = 0;
	    public int diameterOfBinaryTree(TreeNode root) {
	        if (root == null) {
	            return max;
	        }
	        helper(root, 0);
	        return max - 1; // left.depth + right.depth - root.depth (since both left and right depth has included the root)
	    }
	    
	    private int helper(TreeNode root, int length) {
	        if (root == null) {
	            return length;
	        }
	        int left = helper(root.left, length);
	        int right = helper(root.right, length);
	        max = Math.max(max, left + right + 1);
	        
	        // 返还上一层的时候必须是root +left or root + right
	        return Math.max(left, right) + 1;
	    }
	}
}