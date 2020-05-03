public class LC695MaxAreaOfIsland {
	/**
	 * 粗暴版本的DFS，标准的岛屿题目做法
	 */
	class NaiveDFSSolution {
	    
	    int[] dx = {0, 1, 0, -1};
	    int[] dy = {1, 0, -1, 0};
	    
	    public int maxAreaOfIsland(int[][] grid) {
	        if (grid == null || grid.length == 0 || grid[0].length == 0) {
	            return 0;
	        }
	        int m = grid.length;
	        int n = grid[0].length;
	        boolean[][] visited = new boolean[m][n];
	        int max = 0;
	        for (int i = 0; i < m; i++) {
	            for (int j = 0; j < n; j++) {
	                if (visited[i][j] == false && grid[i][j] == 1) {
	                    int area = dfs(grid, visited, i, j);
	                    max = Math.max(area, max);
	                }
	            }
	        }
	        
	        return max;
	    }
	    
	    private int dfs(int[][] grid, boolean[][] visited, int x, int y) {
	        if (!isValid(x, y, grid.length, grid[0].length)
	           || grid[x][y] != 1) {
	            return 0;
	        }
	        visited[x][y] = true; // Make sure to mark the current node as visited!!!
	        int area = 0;
	        for (int i = 0; i < dx.length; i++) {
	            int nextX = x + dx[i];
	            int nextY = y + dy[i];
	            if (isValid(nextX, nextY, grid.length, grid[0].length) 
	                && !visited[nextX][nextY]
	               && grid[nextX][nextY] == 1) {
	                visited[nextX][nextY] = true;
	                area += dfs(grid, visited, nextX, nextY);
	            }
	        }
	        
	        return area + 1;
	    }
	    
	    private boolean isValid(int x, int y, int m, int n) {
	        return x >= 0 && x < m && y >= 0 && y < n;
	    }
	}

	/**
	 * BFS: 遍历网格，每遇到一个非0且未访问的结点就启动BFS。
	 */
	class BFSSolution {
	    
	    int[] dx = {0, 1, 0, -1};
	    int[] dy = {1, 0, -1, 0};

	    public int maxAreaOfIsland(int[][] grid) {
	        if (grid == null || grid.length == 0 || grid[0].length == 0) {
	            return 0;
	        }
	        int m = grid.length;
	        int n = grid[0].length;
	        boolean[][] visited = new boolean[m][n];
	        int max = 0;
	        for (int i = 0; i < m; i++) {
	            for (int j = 0; j < n; j++) {
	                if (visited[i][j] == false && grid[i][j] == 1) {
	                    int area = bfs(grid, visited, i, j);
	                    max = Math.max(area, max);
	                }
	            }
	        }

	        return max;
	    }
	    
	    private int bfs(int[][] grid, boolean[][] visited, int x, int y) {
	        int m = grid.length;
	        int n = grid[0].length;
	        if (!isValid(x, y, m, n) || visited[x][y]) {
	            return 0;
	        }
	        Queue<int[]> queue = new LinkedList<>();
	        queue.offer(new int[]{x, y});
	        visited[x][y] = true;
	        int area = 0;
	        while (!queue.isEmpty()) {
	            int[] curr = queue.poll();
	            area++;
	            for (int i = 0; i < dx.length; i++) {
	                int newX = curr[0] + dx[i];
	                int newY = curr[1] + dy[i];
	                if (isValid(newX, newY, m, n) 
	                    && !visited[newX][newY]
	                    && grid[newX][newY] == 1) {
	                    visited[newX][newY] = true;
	                    queue.offer(new int[]{newX, newY});
	                }
	            }
	        }
	        return area;
	    }
	    
	    private boolean isValid(int x, int y, int m, int n) {
	        return x >= 0 && x < m && y >= 0 && y < n;
	    }
	}
}