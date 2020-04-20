public class LC426ConvertBSTToSortedDoublyLinkedList {
	
	/**
	 * 感觉这道题是flatten binary tree to linked list 的升级版本
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Binary Search Tree to Sorted Doubly Linked List.
	 * Memory Usage: 39.4 MB, less than 6.90% of Java online submissions for Convert Binary Search Tree to Sorted Doubly Linked List.
	 */
	class InorderTraversalRecursionSolution {
	    Node curr = null;
	    public Node treeToDoublyList(Node root) {
	        Node dummy = new Node(-1, null, null);
	        if (root != null) {
	            curr = dummy;
	        
	            inorder(root);
	            // After the traversal, the curr is at the tail of the list. So point it to the head of the list.
	            curr.right = dummy.right;
	            dummy.right.left = curr;
	        }

	        return dummy.right;
	    }
	    
	    private void inorder(Node node) {
	        if (node == null) {
	            return;
	        }
	        
	        inorder(node.left);
	        curr.right = node;
	        node.left = curr;
	        curr = node;
	        
	        inorder(node.right);
	    }
	}

	/**
     * Runtime: 1 ms, faster than 20.13% of Java online submissions for Convert Binary Search Tree to Sorted Doubly Linked List.
     * Memory Usage: 39 MB, less than 6.90% of Java online submissions for Convert Binary Search Tree to Sorted Doubly Linked List.
     */
	class InorderTraversalIterationSolution {
	    public Node treeToDoublyList(Node root) {
	        if (root == null) {
	            return root;
	        }
	        Node dummy = new Node(-1, null, null);
	        Node pre = dummy;
	        Node curr = root;
	        Stack<Node> stack = new Stack<>();
	        while (curr != null || !stack.isEmpty()) {
	            while (curr != null) {
	                stack.push(curr);
	                curr = curr.left;
	            }
	            curr = stack.pop();
	            link(pre, curr);
	            pre = curr;
	            curr = curr.right;
	        }
	        link(pre, dummy.right);
	        return dummy.right;
	    }
	    
	    private void link(Node former, Node latter) {
	        former.right = latter;
	        latter.left = former;
	    }
	}

	// Definition for a Node.
	class Node {
	    public int val;
	    public Node left;
	    public Node right;

	    public Node() {}

	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val,Node _left,Node _right) {
	        val = _val;
	        left = _left;
	        right = _right;
	    }
	}
}