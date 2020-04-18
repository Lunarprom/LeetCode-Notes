public class LC52NQueensII {
	/**
	 * Regular DFS + backtracking solution.
	 * TODO: Try bitmap.
	 * Runtime: 1 ms, faster than 81.85% of Java online submissions for N-Queens II.
	 * Memory Usage: 36 MB, less than 8.70% of Java online submissions for N-Queens II.
	 */
	class Solution {
	    int sum;
	    
	    public int totalNQueens(int n) {
	        sum = 0;
	        if (n <= 0) {
	            return sum;
	        }
	        int[] columns = new int[n];
	        placeQueen(columns, 0);
	        
	        return sum;
	    }
	    
	    private void placeQueen(int[] columns, int row) {
	        int n = columns.length;
	        if (row == n) {
	            sum++;
	            return;
	        }
	        // For the Queen on the row, find a valid column for the queen.
	        for (int i = 0; i < n; i++) {
	            if (isValid(columns, row, i)) {
	                columns[row] = i;
	                placeQueen(columns, row + 1);
	            }
	        }
	    }
	    
	    private boolean isValid(int[] columns, int row, int curCol) {
	        // Only check toward the current row
	        for (int i = 0; i < row; i++) {
	            if (columns[i] == curCol) {
	                // The column has already been occupied
	                return false;
	            }
	            if (Math.abs(columns[i] - curCol) == Math.abs(row - i)) {
	                return false;
	            }
	        }
	        
	        return true;
	    }
	}
}