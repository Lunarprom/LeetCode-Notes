public class LC54SpiralMatrix {
	// 按层旋转输入。大问题拆解成小问题：外面一圈的遍历+边界条件的约束
	class Solution {
	    public List<Integer> spiralOrder(int[][] matrix) {
	        List<Integer> result = new ArrayList<>();
	        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
	            return result;
	        }
	        int r1 = 0;
	        int r2 = matrix.length - 1;
	        int c1 = 0;
	        int c2 = matrix[0].length - 1;
	        while (r1 <= r2 && c1 <= c2) {
	            for (int c = c1; c <= c2; c++) {
	                result.add(matrix[r1][c]);
	            }
	            for (int r = r1 + 1; r <= r2; r++) {
	                result.add(matrix[r][c2]);
	            }
	            // 如果是单行单列的话就没必要再scan了
	            if (r1 < r2 && c1 < c2) {
	                for (int c = c2 - 1; c > c1; c--) {
	                    result.add(matrix[r2][c]);
	                }
	                for (int r = r2; r > r1; r--) {
	                    result.add(matrix[r][c1]);
	                }
	            }
	            r1++;
	            r2--;
	            c1++;
	            c2--;
	        }
	        
	        return result;
	    }
	}
}