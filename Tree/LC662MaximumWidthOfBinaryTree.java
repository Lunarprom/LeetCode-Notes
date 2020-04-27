public class LC662MaximumWidthOfBinaryTree {
	/**
	 * BFS层序遍历的变形。主要是厘清左右子节点的index。
	 * 左子节点的index为 root.index * 2, 右子节点的index为root.index * 2 + 1
	 * 不断去找最小的左index和最大的右index（它们都是正数）
	 */
	class BFSSolution {
	    class Node {
	        TreeNode node;
	        int index;
	        public Node(TreeNode node, int index) {
	            this.node = node;
	            this.index = index;
	        }
	    }
	    public int widthOfBinaryTree(TreeNode root) {
	        if (root == null) {
	            return 0;
	        }
	        Queue<Node> queue = new LinkedList<>();
	        queue.offer(new Node(root, 0));
	        int maxWidth = 1;
	        while (!queue.isEmpty()) {
	            int left = Integer.MAX_VALUE;
	            int right = Integer.MIN_VALUE;
	            int size = queue.size();
	            for (int i = 0; i < size; i++) {
	                Node curr = queue.poll();
	                int index = curr.index;
	                left = Math.min(left, curr.index);
	                right = Math.max(right, curr.index);
	                
	                if (curr.node.left != null) {
	                    queue.offer(new Node(curr.node.left, index * 2));
	                }
	                if (curr.node.right != null) {
	                    queue.offer(new Node(curr.node.right, index * 2 + 1));
	                }
	            }
	            maxWidth = Math.max(maxWidth, right - left + 1);
	        }
	        
	        return maxWidth;
	    }
	}


	/**
	 * Definition for a binary tree node.
	 */
	 public class TreeNode {
	 	int val;
	 	TreeNode left;
	 	TreeNode right;
	 	TreeNode(int x) { val = x; }
	 }
}