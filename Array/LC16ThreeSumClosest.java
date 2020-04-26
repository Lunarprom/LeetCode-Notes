public class LC16ThreeSumClosest {
	/**
	 * Global variable tracking the minimum delta and corresponding sum. Don't need to skip duplicate numbers since it can
	 * also be a valid combination.
	 * Also left and right pointers shouldn't be moved at the same time.
	 */
	class TwoPointersSolution {
	    public int threeSumClosest(int[] nums, int target) {
	        if (nums == null || nums.length == 0) {
	            return Integer.MAX_VALUE;
	        }
	        int sum = 0;
	        int minDelta = Integer.MAX_VALUE;
	        int len = nums.length;
	        Arrays.sort(nums);
	        for (int i = 0; i < len - 2; i++) {
	            int start = i + 1;
	            int end = len - 1;
	            while (start < end) {
	                int curSum = nums[start] + nums[end] + nums[i];
	                int delta = Math.abs(curSum - target);
	                if (delta <= minDelta) {
	                    sum = curSum;
	                    minDelta = delta;
	                }
	                if (curSum < target) {
	                    start++;
	                } else {
	                    end--;
	                }
	            }
	        }
	        
	        return sum;
	    }
	}
}