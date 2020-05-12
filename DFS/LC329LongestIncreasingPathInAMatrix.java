public class LC329LongestIncreasingPathInAMatrix {
	// Optimize with memoization.
	class Solution {
	    
	    int[] dx = {0, 1, 0, -1};
	    int[] dy = {1, 0, -1, 0};
	    int[][] memo;
	    
	    public int longestIncreasingPath(int[][] matrix) {
	        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
	            return 0;
	        }
	        int m = matrix.length;
	        int n = matrix[0].length;
	        memo = new int[m][n];
	        int max = 0;
	        for (int i = 0; i < m; i++) {
	            for (int j = 0; j < n; j++) {
	                max = Math.max(max, dfs(matrix, i, j, memo));
	            }
	        }
	        
	        return max;
	    }
	    
	    private int dfs(int[][] matrix, int x, int y, int[][] memo) {
	        if (memo[x][y] != 0) {
	            return memo[x][y];
	        }
	        for (int i = 0; i < dx.length; i++) {
	            int nx = x + dx[i];
	            int ny = y + dy[i];
	            if (isValid(nx, ny, matrix.length, matrix[0].length) && matrix[nx][ny] > matrix[x][y]) {
	                memo[x][y] = Math.max(memo[x][y], dfs(matrix, nx, ny, memo));
	            }
	        }
	        
	        return ++memo[x][y];
	    }
	    
	    private boolean isValid(int x, int y, int m, int n) {
	        return x >= 0 && x < m && y >= 0 && y <n;
	    }
	}
}