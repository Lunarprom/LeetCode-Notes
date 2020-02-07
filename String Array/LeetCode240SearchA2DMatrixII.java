public class LeetCode240SearchA2DMatrixII {
    /**
     * Start search from either upper right or bottom left. Because it will gives a specific signal of
     * which direction we should move toward after each comparsion.
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int m = 0;
        int n = matrix[0].length - 1;
        while (m <= matrix.length - 1 && n >= 0) {
            int current = matrix[m][n];
            if (current == target) {
                return true;
            } else  if (current < target) {
                m++;
            } else {
                n--;
            }
        }

        return false;
    }
}