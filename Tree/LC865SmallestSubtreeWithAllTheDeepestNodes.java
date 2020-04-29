public class LC865SmallestSubtreeWithAllTheDeepestNodes {\
	class DFSSolution {
	    public TreeNode subtreeWithAllDeepest(TreeNode root) {
	        return dfs(root).node;
	    }
	    
	    private Result dfs(TreeNode root) {
	        if (root == null) {
	            return new Result(null, 0);
	        }
	        Result left = dfs(root.left);
	        Result right = dfs(root.right);
	        if (left.depth > right.depth) {
	            return new Result(left.node, left.depth + 1);
	        } else if (left.depth < right.depth) {
	            return new Result(right.node, right.depth + 1);
	        } else {
	            return new Result(root, left.depth + 1);
	        }
	    }
	    
	    class Result {
	        TreeNode node;
	        int depth;
	        public Result(TreeNode node, int depth) {
	            this.node = node;
	            this.depth = depth;
	        }
	    }
	}
}