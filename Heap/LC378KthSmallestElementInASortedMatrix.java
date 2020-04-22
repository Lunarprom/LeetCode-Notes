public class LC378KthSmallestElementInASortedMatrix {
	/**
	 * Java PriorityQueue with customized comparator that tops up the "largest number within k smallest numbers"
	 * Runtime: 16 ms, faster than 42.66% of Java online submissions for Kth Smallest Element in a Sorted Matrix.
	 * Memory Usage: 44.5 MB, less than 54.05% of Java online submissions for Kth Smallest Element in a Sorted Matrix.
	 */
	class PriorityQueueSolution {
	    public int kthSmallest(int[][] matrix, int k) {
	        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
	            return 0;
	        }

	        PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>() {
	            @Override
	            public int compare(Integer num1, Integer num2) {
	                return num2 - num1;
	            }
	        });
	        for (int i = 0; i < matrix.length; i++) {
	            for (int j = 0; j < matrix[0].length; j++) {
	                pq.offer(matrix[i][j]);
	                if (pq.size() > k) {
	                    pq.remove();
	                }
	            }
	        }
	        
	        return pq.poll();
	    }
	}
}