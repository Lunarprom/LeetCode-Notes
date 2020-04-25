public class LC540SingleElementInASortedArray {
	/**
	 * [1,1,2,3,3,4,4,8,8]
	 * Before the single number appear, each number occurs in [even, odd]; after that, it's [odd, even]
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Single Element in a Sorted Array.
	 * Memory Usage: 40 MB, less than 8.00% of Java online submissions for Single Element in a Sorted Array.
	 */
	class BinarySearchSolution {
	    public int singleNonDuplicate(int[] nums) {
	        int len = nums.length;
	        int start = 0;
	        int end = len - 1;
	        while (start + 1 < end) {
	            int mid = start + (end - start) / 2;
	            if (mid % 2 == 0) {
	                if (mid + 1 < len && nums[mid] == nums[mid + 1]) {
	                    start = mid;
	                } else {
	                    end = mid;
	                }
	            } else {
	                if (mid - 1 >= 0 && nums[mid] == nums[mid - 1]) {
	                    start = mid;
	                } else {
	                    end = mid;
	                }
	            }
	        }
	        if (start % 2 == 0) {
	            return nums[start];
	        } else {
	            return nums[end];
	        }
	    }
	}
}