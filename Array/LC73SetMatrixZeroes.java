public class LC73SetMatrixZeroes {
	/**
	 * 1. Use a HashMap/HashSet to store the location of all 0s. -> Worst case needs O(M*N) space
	 * 2. If the value of the matrix entry is within a specific scope, then change 0 to a value that won't clash with the other entries.
	 * 3. Use the first row and first column as the hashset. Make sure to come back and check them.
	 */
	class OptimizedSolution {
	    public void setZeroes(int[][] matrix) {
	        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
	            return;
	        }
	        boolean col0 = false;
	        for (int i = 0; i < matrix.length; i++) {
	            if (matrix[i][0] == 0) {
	                col0 = true;
	            }
	            for (int j = 1; j < matrix[0].length; j++) {
	                if (matrix[i][j] == 0) {
	                    matrix[i][0] = 0;
	                    matrix[0][j] = 0;
	                }
	            }
	        }
	        
	        for (int i = 1; i < matrix.length; i++) {
	            for (int j = 1; j < matrix[0].length; j++) {
	                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
	                    matrix[i][j] = 0;
	                }
	            }
	        }
	        
	        // Use matrix[0][0] as the marker for the first row;
	        if (matrix[0][0] == 0) {
	            for (int j = 1; j < matrix[0].length; j++) {
	                matrix[0][j] = 0;
	            }
	        }
	        
	        // Use col0 as the marker for the first column;
	        if (col0) {
	            for (int i = 0; i < matrix.length; i++) {
	                matrix[i][0] = 0;
	            }
	        }
	        
	        return;
	    }
	}
}