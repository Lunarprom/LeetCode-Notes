public class LC105ConstructBinaryTreeFromPreorderAndInorderTraversal {
	/**
	 * 前序数组中，每遍历到一个点，它一定是它所在树的根结点。
	 * 中序数组是用来约束前序中对应的节点的位置的。
	 */
	class RecursionSolution {
	    Map<Integer, Integer> inorderMap;
	    int preIndex = 0;
	    public TreeNode buildTree(int[] preorder, int[] inorder) {
	        if (preorder == null || inorder == null || preorder.length != inorder.length) {
	            return null;
	        }
	        inorderMap = new HashMap<>();
	        for (int i = 0; i < inorder.length; i++) {
	            inorderMap.put(inorder[i], i);
	        }
	        
	        return treeBuilder(preorder, inorder, 0, inorder.length);
	    }
	    
	    private TreeNode treeBuilder(int[] preorder, int[] inorder, int inStart, int inEnd) {
	        if (inEnd <= inStart) {
	            return null;
	        }
	        TreeNode root = new TreeNode(preorder[preIndex]);
	        preIndex++;
	        int index = inorderMap.get(root.val);
	        root.left = treeBuilder(preorder, inorder, inStart, index);
	        root.right = treeBuilder(preorder, inorder, index + 1, inEnd);
	        
	        return root;
	    }
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}