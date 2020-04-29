public class LC133CloneGraph {
	
	class DFSSolution {
	    
	    Map<Node, Node> created;
	    
	    public Node cloneGraph(Node node) {
	        created = new HashMap<>();
	        
	        return dfs(node);
	    }
	    
	    private Node dfs(Node head) {
	        if (head == null) {
	            return null;
	        }
	        // TODO: directly get the copy
	        if (created.containsKey(head)) {
	            return created.get(head);
	        }
	        Node copy = new Node(head.val, new ArrayList<>());
	        created.put(head, copy);
	        for (Node neighbor : head.neighbors) {
	            copy.neighbors.add(dfs(neighbor));
	        }
	        
	        return copy;
	    }
	}

	/*
	// Definition for a Node.
	class Node {
	    public int val;
	    public List<Node> neighbors;
	    
	    public Node() {
	        val = 0;
	        neighbors = new ArrayList<Node>();
	    }
	    
	    public Node(int _val) {
	        val = _val;
	        neighbors = new ArrayList<Node>();
	    }
	    
	    public Node(int _val, ArrayList<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
	}
	*/
}