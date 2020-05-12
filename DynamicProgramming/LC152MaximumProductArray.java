public class LC152MaximumProductArray {
	/**
	 * 考虑到有可能会出现负数，且如果是奇数个负数的话，累乘之后乘积是负数，但如果是偶数个的话累乘之后又是正数。
	 * 用动态规划的思想，maintain一个dpMax[] + 一个dpMin[]，然后当前的状态，取决于nums[i] 是正数还是负数，最大值就会可能是* dpMax[i - 1] or *dpMin[i - 1]
	 * 当 nums[i] >= 0 并且dpMax[i-1] < 0，此时如果和前边的数累乘的话，会变成负数，所以dpMax[i] = nums[i]
	 * 当 nums[i] < 0, dpMin[i-1] >= 0，dpMin[i] = nums[i]
	 */
	class DPSolution {
	    public int maxProduct(int[] nums) {
	        if (nums == null || nums.length == 0) {
	            return 0;
	        }
	        int n = nums.length;
	        int[] dpMax = new int[n];
	        int[] dpMin = new int[n];
	        int max = nums[0]; // 不能等于0因为可能有负数
	        dpMax[0] = nums[0];
	        dpMin[0] = nums[0];
	        for (int i = 1; i < n; i++) {
	            dpMax[i] = Math.max(nums[i], Math.max(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]));
	            dpMin[i] = Math.min(nums[i], Math.min(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]));
	            max = Math.max(max, dpMax[i]);
	        }
	        
	        return max;
	    }
	}
}