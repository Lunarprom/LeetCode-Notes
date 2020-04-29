public class LC106ConstructBinaryTreeFromInorderAndPostOrderTraversal {
	/*
	 * 04/27 思路
	 * Postorder中最后一个点一定是当前子树的根结点。在中序遍历中，这个结点会把数组分割成左右子树。
	 * 递归处理的时候是根->右->左。
	 */
	class RecursionSolution {
	    int postIndex;
	    Map<Integer, Integer> inorderMap;
	    public TreeNode buildTree(int[] inorder, int[] postorder) {
	        if (inorder == null || postorder == null || inorder.length != postorder.length) {
	            return null;
	        }
	        postIndex = postorder.length - 1;
	        inorderMap = new HashMap<Integer, Integer>();
	        for (int i = 0; i < inorder.length; i++) {
	            inorderMap.put(inorder[i], i);
	        }
	        
	        return treeBuilder(inorder, postorder, 0, inorder.length); //是左闭右开的区间
	    }
	    
	    private TreeNode treeBuilder(int[] inorder, int[] postorder, int inStart, int inEnd) {
	        if (inStart >= inEnd) {
	            return null;
	        }
	        TreeNode root = new TreeNode(postorder[postIndex]);
	        postIndex--;
	        int index = inorderMap.get(root.val);
	        root.right = treeBuilder(inorder, postorder, index + 1, inEnd);
	        root.left = treeBuilder(inorder, postorder, inStart, index);
	        
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