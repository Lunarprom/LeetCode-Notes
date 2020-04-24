public class LC304RangeSumQuery2DImmutable {
	/**
	 * 2D Prefix sum. (这尼玛其实是一道动态规划。。。)
	 * Runtime: 10 ms, faster than 99.96% of Java online submissions for Range Sum Query 2D - Immutable.
	 * Memory Usage: 45.2 MB, less than 33.33% of Java online submissions for Range Sum Query 2D - Immutable.
	 */
	class NumMatrix {
	    
	    int[][] prefix;

	    public NumMatrix(int[][] matrix) {
	        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
	            return;
	        }
	        int row = matrix.length;
	        int col = matrix[0].length;
	        prefix = new int[row + 1][col + 1];
	        for (int i = 0; i < row; i++) {
	            for (int j = 0; j < col; j++) {
	                prefix[i + 1][j + 1] = prefix[i][j + 1] + prefix[i + 1][j] - prefix[i][j] + matrix[i][j];
	            }
	        }
	    }
	    
	    public int sumRegion(int row1, int col1, int row2, int col2) {
	        return prefix[row2 + 1][col2 + 1] - prefix[row2 + 1][col1] - prefix[row1][col2 + 1] + prefix[row1][col1];
	    }
	}

	/**
	 * Your NumMatrix object will be instantiated and called as such:
	 * NumMatrix obj = new NumMatrix(matrix);
	 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
	 */
}