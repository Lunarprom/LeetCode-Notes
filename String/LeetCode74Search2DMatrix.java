public class LeetCode74Search2DMatrix {
    /**
     * Since the last entry of each row will always be smaller than the first entry of the next row,
     * the matrix can be expanded to a sorted array.
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        final int m = matrix.length;
        final int n = matrix[0].length;
        final int total = m * n;
        int start = 0;
        int end = total - 1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            int row = mid / n;
            int column = mid % n;
            if (target == matrix[row][column]) {
                return true;
            } else if (target > matrix[row][column]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }
}