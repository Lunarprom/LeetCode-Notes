public class LC417PacificAtlanticWaterFlow {
	/*
	 * 感觉这道题比较适合用双向BFS做
	 */
	class BiDirectionalBFSSolution {
	    int[] dx = new int[]{0, -1, 0, 1};
	    int[] dy = new int[]{1, 0, -1, 0};
	    
	    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
	        List<List<Integer>> result = new ArrayList<>();
	        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
	            return result;
	        }
	        int m = matrix.length;
	        int n = matrix[0].length;
	        
	        Queue<int[]> pQueue = new LinkedList<>();
	        Queue<int[]> aQueue = new LinkedList<>();
	        
	        int[][] pVisited = new int[m][n];
	        int[][] aVisited = new int[m][n];
	        
	        for (int i = 0; i < m; i++) {
	            for (int j = 0; j < n; j++) {
	                if (i == 0 || j == 0) {
	                    pQueue.add(new int[]{i, j});
	                }
	                if (i == m - 1 || j == n - 1) {
	                    aQueue.add(new int[]{i, j});
	                }
	            }
	        }
	        
	        bfs(matrix, pQueue, pVisited);
	        bfs(matrix, aQueue, aVisited);
	        
	        for (int i = 0; i < m; i++) {
	            for (int j = 0; j < n; j++) {
	                if (pVisited[i][j] == 1 && aVisited[i][j] == 1) {
	                    result.add(Arrays.asList(i, j));
	                }
	            }
	        }
	        
	        return result;
	    }
	    
	    private void bfs(int[][] matrix, Queue<int[]> queue, int[][] visited) {
	        while (!queue.isEmpty()) {
	            int[] cur = queue.poll();
	            int row = cur[0];
	            int col = cur[1];
	            visited[row][col] = 1;
	            for (int i = 0; i < dx.length; i++) {
	                int nextRow = row + dx[i];
	                int nextCol = col + dy[i];
	                if (inBound(nextRow, nextCol, matrix.length, matrix[0].length) 
	                   && matrix[row][col] <= matrix[nextRow][nextCol]
	                    && visited[nextRow][nextCol] != 1) {
	                    queue.add(new int[]{nextRow, nextCol});
	                }
	            }
	        }
	    }
	    
	    private boolean inBound(int i, int j, int m, int n) {
	        return i >= 0 && i < m && j >= 0 && j < n;
	    }
	}
}