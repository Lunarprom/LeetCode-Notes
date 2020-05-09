public class LC325MaximumSizeSubarraySumEqualsK {
	/**
	 * 先求前缀和, 找到sum - k的位置
	 * 初始化的时候要把(0, -1)放进去，in case sum == k.
	 */
	class Solution {
	    public int maxSubArrayLen(int[] nums, int k) {
	        if (nums == null || nums.length == 0) {
	            return 0;
	        }
	        Map<Integer, Integer> map = new HashMap<>();
	        int maxLen = 0;
	        int sum = 0;
	        map.put(0, -1);
	        for (int i = 0; i < nums.length; i++) {
	            sum += nums[i];
	            if (map.containsKey(sum - k)) {
	                maxLen = Math.max(maxLen, i - map.get(sum - k));
	            }
	            if (!map.containsKey(sum)) {
	                map.put(sum, i);
	            }
	        }
	        
	        return maxLen;
	    }
	}
}