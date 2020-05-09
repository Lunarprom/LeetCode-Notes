public class LC79WordSearch {
	/**
	 * Classic backtracking problem.
	 */
	class Solution {
	    
	    int[] dx = {-1, 0, 1, 0};
	    int[] dy = {0, 1, 0, -1};
	    
	    public boolean exist(char[][] board, String word) {
	        if (board == null || board.length == 0 || board[0].length == 0) {
	            return false;
	        } else if (word == null || word.length() == 0) {
	            return true;
	        }
	        int m = board.length;
	        int n = board[0].length;
	        boolean[][] visited = new boolean[m][n];
	        for (int i = 0; i < m; i++) {
	            for (int j = 0; j < n; j++) {
	                if (board[i][j] == word.charAt(0) && backtrack(board, word, 0, i, j, visited)) {
	                    return true;
	                }
	            }
	        }
	        
	        return false;
	    }
	    
	    // 如何避免DFS时折返回去看已经查过的字母？
	    private boolean backtrack(char[][] board, String word, int start, int x, int y, boolean[][] visited) {
	        if (start == word.length()) {
	            return true;
	        }
	        if (!isValid(x, y, board.length, board[0].length) || board[x][y] != word.charAt(start) || visited[x][y]) {
	            return false;
	        }

	        // board[x][y] = '#';
	        visited[x][y] = true;
	        for (int i = 0; i < dx.length; i++) {
	            int nx = x + dx[i];
	            int ny = y + dy[i];
	            if (backtrack(board, word, start + 1, nx, ny, visited)) {
	                return true;
	            }
	        }
	        visited[x][y] = false;
	        // board[x][y] = word.charAt(start);
	        return false;
	    }
	    
	    private boolean isValid(int x, int y, int m, int n) {
	        return x >= 0 && x < m && y >= 0 && y < n;
	    }
	}
}