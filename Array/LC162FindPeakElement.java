public class LC162FindPeakElement {
	/**
	 * 四种情况：
	 * mid == summit -> directly return;
	 * mid在上坡 -> start = mid
	 * mid在下坡 -> end = mid
	 * mid在谷底 -> 任意一边都可以
	 * 二分法
	 * 因为两边都是负无穷所以一定有summit
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Peak Element.
	 * Memory Usage: 39.4 MB, less than 76.12% of Java online submissions for Find Peak Element.
	 */
	class BinarySearchSolution {
	    public int findPeakElement(int[] nums) {
	        if (nums == null) {
	            return -1;
	        } 
	        int len = nums.length;
	        int start = 0;
	        int end = len - 1;
	        while (start + 1 < end) {
	            int mid = start + (end - start) / 2;
	            if (nums[mid - 1] < nums[mid]) {
	                if (nums[mid] > nums[mid + 1]) {
	                    return mid;
	                }
	                start = mid;
	            } else {
	                end = mid;
	            }
	        }
	        if (nums[start] > nums[end]) {
	            return start;
	        } else {
	            return end;
	        }
	        
	    }
	}
}