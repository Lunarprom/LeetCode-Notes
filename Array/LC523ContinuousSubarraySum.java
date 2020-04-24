public class LC523ContinuousSubarraySum {
	/**
	 * 竟然又是DP???
	 * Runtime: 2 ms, faster than 99.51% of Java online submissions for Continuous Subarray Sum.
	 * Memory Usage: 39.9 MB, less than 88.24% of Java online submissions for Continuous Subarray Sum.
	 */
	class DPSolution {
	    public boolean checkSubarraySum(int[] nums, int k) {
	        int sum = 0;
	        Map<Integer, Integer> map = new HashMap<>();
	        map.put(0, -1);
	        for (int i = 0; i < nums.length; i++) {
	            sum += nums[i];
	            if (k != 0) {
	                sum = sum % k;
	            }
	            // 必须判断当前的i是不是比已经在Map里的index要大，否则不满足subarray of size at least 2
	            if (map.containsKey(sum)) {
	                if (i - map.get(sum) > 1) {
	                    return true;
	                }
	            } else {
	                // Only put the sum-i pair into Map when the Map has not already contained the key (otherwise it will keep being updated with the largest index which impacts the result)
	                map.put(sum, i);
	            }
	        }
	        
	        return false;
	    }
	}
}