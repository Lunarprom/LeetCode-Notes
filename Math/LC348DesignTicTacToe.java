/**
 * O(1) Solution with O(N) extra space. 不需要keep track of the whole board, just use the arrays to track the column and rows.
 * Use 1 vs -1 to track the total count: for either player to win, the absolute value of sum of row/col/diag/antiDiag must be n
 */
public class LC348DesignTicTacToe {
	class TicTacToe {
	    
	    int[] rows;
	    int[] cols;
	    int diag;
	    int antiDiag;

	    /** Initialize your data structure here. */
	    public TicTacToe(int n) {
	        rows = new int[n];
	        cols = new int[n];
	    }
	    
	    /** Player {player} makes a move at ({row}, {col}).
	        @param row The row of the board.
	        @param col The column of the board.
	        @param player The player, can be either 1 or 2.
	        @return The current winning condition, can be either:
	                0: No one wins.
	                1: Player 1 wins.
	                2: Player 2 wins. */
	    public int move(int row, int col, int player) {
	        int curr = player == 1 ? 1 : -1;
	        rows[row] += curr;
	        cols[col] += curr;
	        
	        if (row == col) {
	            diag += curr;
	        }
	        if (col + row == cols.length - 1) {
	            antiDiag += curr;
	        }
	        
	        int n = rows.length;
	        if (Math.abs(rows[row]) == n
	            || Math.abs(cols[col]) == n
	            || Math.abs(diag) == n
	            || Math.abs(antiDiag) == n) {
	            return player;
	        }
	        return 0;
	    }
	}

	/**
	 * Your TicTacToe object will be instantiated and called as such:
	 * TicTacToe obj = new TicTacToe(n);
	 * int param_1 = obj.move(row,col,player);
	 */
}