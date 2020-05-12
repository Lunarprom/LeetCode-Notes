public class LC228SummaryRanges {
	/**
	 * Related Problem: Missing Ranges
	 * Scane the nums with one pass:
	 * nums[i + 1] != nums[i] + 1: 单独build nums[i]
	 * nums[i + 1] == nums[i] + 1: keep adding up index until finding the discrepancy
	 * 重要的是需要知道数字的range。所以必须要有两个指针。
	 */
	class Solution {
	    public List<String> summaryRanges(int[] nums) {
	        List<String> result = new ArrayList<>();
	        if (nums == null || nums.length == 0) {
	            return result;
	        }

	        for (int i = 0, j = 0; j < nums.length; j++) {
	            i = j;
	            while (j + 1 < nums.length && nums[j + 1] == nums[j] + 1) {
	                j++;
	            }
	            if (i == j) {
	                result.add(String.valueOf(nums[i]));
	            } else {
	                result.add(nums[i] + "->" + nums[j]);
	            }
	        }
	        return result;
	    }
	}
}