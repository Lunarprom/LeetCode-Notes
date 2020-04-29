public class LC1245TreeDiameter {
	/**
	 * 遍历邻接表记录所有的点之间的边
	 * DFS/BFS 找出每个点最大和次大的路径，二者相加
	 */
	class DFSSolution {
	    
	    int maxDist = 0;
	    
	    public int treeDiameter(int[][] edges) {
	        if (edges == null || edges.length == 0 || edges[0].length == 0) {
	            return 0;
	        }
	        // The index of the list mapps to each node, Assuming the node values are unique.
	        List<List<Integer>> graph = new ArrayList<>();
	        // The length of graph is edges.length + 1 (the count of nodes is one more than that of edges)
	        for (int i = 0; i < edges.length + 1; i++) {
	            graph.add(new ArrayList<Integer>());
	        }
	        
	        for (int[] edge : edges) {
	            graph.get(edge[0]).add(edge[1]);
	            graph.get(edge[1]).add(edge[0]);
	        }
	        boolean[] visited = new boolean[graph.size()];
	        
	        dfs(graph, 0, visited);
	        
	        return maxDist;
	    }
	    
	    private int dfs(List<List<Integer>> graph, int index, boolean[] visited) {
	        visited[index] = true;
	        List<Integer> nodes = graph.get(index);
	        int max1 = 0;
	        int max2 = 0;
	        for (int next : nodes) {
	            if (visited[next]) {
	                continue;
	            }
	            int dist = dfs(graph, next, visited);
	            if (dist > max1) {
	                max2 = max1;
	                max1 = dist;
	            } else if (dist > max2) {
	                max2 = dist;
	            }
	        }
	        maxDist = Math.max(maxDist, max1 + max2);
	        
	        return Math.max(max1, max2) + 1;
	    }
	}
}