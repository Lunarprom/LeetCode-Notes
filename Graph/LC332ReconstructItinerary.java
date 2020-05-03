// 建图然后遍历。注意的是结果需要逆序插入。
public class LC332ReconstructItinerary {
	class DFSSolution {
	    public List<String> findItinerary(List<List<String>> tickets) {
	        LinkedList<String> result = new LinkedList<>();
	        Map<String, PriorityQueue<String>> graph = buildGraph(tickets);
	        String start = "JFK";
	        dfs(graph, result, start);
	        
	        return result;
	    }
	    
	    // Make sure whoever ends earliest be pushed to the end of the list, i.e. everytime when we insert a destination we should insert in the front.
	    private void dfs(Map<String, PriorityQueue<String>> graph, LinkedList<String> result, String start) {
	        PriorityQueue<String> dests = graph.get(start);
	        while (dests != null && !dests.isEmpty()) {
	            String destination = dests.poll();
	            dfs(graph, result, destination);
	        }
	        
	        result.add(0, start);
	    }
	    
	    private Map<String, PriorityQueue<String>> buildGraph(List<List<String>> tickets) {
	        Map<String, PriorityQueue<String>> graph = new HashMap<>();
	        for (List<String> ticket : tickets) {
	            
	            String start = ticket.get(0);
	            String dest = ticket.get(1);
	            if (!graph.containsKey(start)) {
	                graph.put(start, new PriorityQueue<String>());
	            }
	            graph.get(start).offer(dest);
	        }
	        
	        return graph;
	    }
	}
}