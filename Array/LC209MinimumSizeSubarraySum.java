public class LC209MinimumSizeSubarraySum {
	/**
	 * Sliding window
	 * Runtime: 1 ms, faster than 99.87% of Java online submissions for Minimum Size Subarray Sum.
	 * Memory Usage: 39.4 MB, less than 5.71% of Java online submissions for Minimum Size Subarray Sum.
	 */
	class SlidingWindowSolution {
	    public int minSubArrayLen(int s, int[] nums) {
	        if (nums == null || nums.length == 0) {
	            return 0;
	        }
	        int len = nums.length;
	        int minLen = Integer.MAX_VALUE;
	        int sum = 0;
	        int left = 0;
	        int right = 0;
	        for (; right < len; right++) {
	            sum += nums[right];
	            while (sum >= s) {
	                minLen = Math.min(minLen, right - left + 1);
	                sum -= nums[left++];
	            }
	        } 
	        
	        return minLen == Integer.MAX_VALUE ? 0 : minLen;
	    }
	}
}