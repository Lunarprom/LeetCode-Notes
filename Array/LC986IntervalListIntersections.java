public class LC986IntervalListIntersections {
	/**
	 * Two pointers
	 * Runtime: 2 ms, faster than 99.54% of Java online submissions for Interval List Intersections.
	 * Memory Usage: 40.3 MB, less than 97.30% of Java online submissions for Interval List Intersections.
	 */
	class Solution {
	    public int[][] intervalIntersection(int[][] A, int[][] B) {
	        List<int[]> result = new ArrayList<>();
	        int pA = 0;
	        int pB = 0;
	        
	        while (pA < A.length && pB < B.length) {
	            int low = Math.max(A[pA][0], B[pB][0]);
	            int high = Math.min(A[pA][1], B[pB][1]);
	            
	            if (low <= high) {
	                result.add(new int[]{low, high});
	            }
	            
	            if (A[pA][1] == high) {
	                pA++;
	            } else {
	                pB++;
	            }
	        }
	        
	        return result.toArray(new int[result.size()][]);
	    }
	}
}