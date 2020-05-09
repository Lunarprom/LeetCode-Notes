public class LC289GameOfLife {
	/*
	 * Brute force是copy一个new matrix用于盛放下一个state，然后对每个格子的周围8个邻居进行扫描, O(N) time and O(N) space
	 * 原地修改cell life status, 用不同的值来表示细胞之前和之后的状态
	 * Similar problem: 73 Set Matrix Zeroes
	 */
	class Solution {
	    
	    int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
	    int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
	    
	    public void gameOfLife(int[][] board) {
	        if (board == null || board.length == 0 || board[0].length == 0) {
	            return;
	        }
	        for (int i = 0; i < board.length; i++) {
	            for (int j = 0; j < board[0].length; j++) {
	                int count = count(board, i, j);
	                // The cell used to be alive but now will be dead
	                if (board[i][j] == 1 && (count < 2 || count > 3)) {
	                    board[i][j] = -1;
	                    continue;
	                } 
	                // The cell used to be dead but will be alive next round.
	                if (board[i][j] == 0 && count == 3) {
	                    board[i][j] = 2; 
	                }
	            }
	        }          
	        
	        for (int i = 0; i < board.length; i++) {
	            for (int j = 0; j < board[0].length; j++) {
	                if (board[i][j] <= 0) {
	                    board[i][j] = 0;
	                } else if (board[i][j] > 0) {
	                    board[i][j] = 1;
	                }
	            }
	        }
	                    
	    }
	    
	    private int count(int[][] board, int row, int col) {
	        int count = 0;
	        for (int i = 0; i < dx.length; i++) {
	            int nx = row + dx[i];
	            int ny = col + dy[i];
	            // Make sure to get the Math.abs() because the status of cell might get changed.
	            if (isValid(nx, ny, board.length, board[0].length) && Math.abs(board[nx][ny]) == 1) {
	                count++;
	            }
	        }
	        return count;
	    }
	    
	    private boolean isValid(int row, int col, int m, int n) {
	        return row >= 0 && row < m && col >= 0 && col < n;
	    }
	}
}