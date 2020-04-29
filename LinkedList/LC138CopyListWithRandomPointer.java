public class LC138CopyListWithRandomPointer {

	/**
	 * DFS. Need O(N) extra space complexity for the "visited" HashMap.
	 */
	class BackTrackingSolution {
	    
	    Map<Node, Node> visited = new HashMap<>();
	    
	    public Node copyRandomList(Node head) {
	        if (head == null) {
	            return null;
	        }
	        
	        return backTracking(head);
	    }
	    
	    private Node backTracking(Node head) {
	        if (head == null) {
	            return null;
	        }
	        if (visited.containsKey(head)) {
	            return visited.get(head);
	        }
	        
	        Node copy = new Node(head.val, null, null);
	        visited.put(head, copy); // must put into the map before enter the back tracking steps.
	        copy.next = backTracking(head.next);
	        copy.random = backTracking(head.random);
	        return copy;
	    }
	}

	/*
	// Definition for a Node.
	class Node {
	    int val;
	    Node next;
	    Node random;

	    public Node(int val) {
	        this.val = val;
	        this.next = null;
	        this.random = null;
	    }
	}
	*/
}