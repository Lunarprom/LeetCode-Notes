public class LC116PopulatingNextRightPointersInEachNode {
	/*
	// Definition for a Node.
	class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node next;

	    public Node() {}
	    
	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, Node _left, Node _right, Node _next) {
	        val = _val;
	        left = _left;
	        right = _right;
	        next = _next;
	    }
	};
	*/

	// BFS 层序遍历就完事儿了。
	class Solution {
	    public Node connect(Node root) {
	        if (root == null) {
	            return root;
	        }
	        Queue<Node> queue = new LinkedList<>();
	        queue.offer(root);
	        while (!queue.isEmpty()) {
	            int size = queue.size();
	            for (int i = 0; i < size; i++) {
	                Node curr = queue.poll();
	                if (i == size - 1) {
	                    curr.next = null;
	                } else {
	                    curr.next = queue.peek();
	                }
	                if (curr.left != null) {
	                    queue.offer(curr.left);
	                }
	                if (curr.right != null) {
	                    queue.offer(curr.right);
	                }
	            }
	        }
	        
	        return root;
	    }
	}
}