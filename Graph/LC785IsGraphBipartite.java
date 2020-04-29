public class LC785IsGraphBipartite {
	class BFSSolution {
	    public boolean isBipartite(int[][] graph) {
	        if (graph == null || graph.length == 0) {
	            return true;
	        }
	        int n = graph.length;
	        int[] colors = new int[n];
	        for (int i = 0; i < n; i++) {
	            colors[i] = -1;
	        }
	        for (int i = 0; i < n; i++) {
	            if (colors[i] == -1 && !bfs(i, graph, colors)) {
	                return false;
	            }
	        }
	        
	        return true;
	    }
	    
	    // Color is either 1 or 0.
	    private boolean bfs(int node, int[][] graph, int[] colors) {
	        Queue<Integer> queue = new LinkedList<>();
	        queue.add(node);
	        colors[node] = 0;
	        while (!queue.isEmpty()) {
	            int curr = queue.poll();
	            for (int neighbor : graph[curr]) {
	                if (colors[neighbor] == -1) {
	                    queue.add(neighbor);
	                    colors[neighbor] = 1 - colors[curr];
	                } else if (colors[neighbor] == colors[curr]) {
	                    return false;
	                }
	            }
	        }
	        
	        return true;
	    }
	}
}