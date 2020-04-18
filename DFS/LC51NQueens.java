public class LC51NQueens {
	/**
	 * Standard solution from Jiuzhang. 
	 * Runtime: 6 ms, faster than 34.42% of Java online submissions for N-Queens.
	 * Memory Usage: 39.3 MB, less than 32.43% of Java online submissions for N-Queens.
	 */
	class StandardBacktrackingSolution {
	    public List<List<String>> solveNQueens(int n) {
	        List<List<String>> result = new ArrayList<>();
	        if (n <= 0) {
	            return result;
	        }
	        helper(n, result, new ArrayList<Integer>());
	        
	        return result;
	    }
	    
	    private void helper(int n, List<List<String>> result, List<Integer> column) {
	        if (column.size() == n) {
	            result.add(draw(column));
	            return;
	        }
	        for (int colIndex = 0; colIndex < n; colIndex++) {
	            if (!isValid(column, colIndex)) {
	                continue;
	            }
	            column.add(colIndex);
	            helper(n, result, column);
	            column.remove(column.size() - 1);
	        }
	    }
	    
	    // Assuming the ith queen will be at the ith row, validate whether the current column is a valid spot for the ith queen.
	    private boolean isValid(List<Integer> column, int curr) {
	        int row = column.size();
	        for (int i = 0; i < column.size(); i++) {
	            if (column.get(i) == curr) {
	                return false;
	            }
	            // If it's on the same diagonal line, then the absolute values of (row - column) of the two queens' are the same. e.g. (0, 1) & (1, 0)
	            if (Math.abs(i - row) == Math.abs(column.get(i) - curr)) {
	                return false;
	            }
	        }
	        return true;
	    }
	    
	    List<String> draw(List<Integer> column) {
	        List<String> result = new ArrayList<>();
	        for (int i = 0; i < column.size(); i++) {
	            StringBuilder sb = new StringBuilder();
	            for (int j = 0; j < column.size(); j++) {
	                sb.append(j == column.get(i) ? 'Q' : '.');
	            }
	            result.add(sb.toString());
	        }
	        
	        return result;
	    }
	}
}