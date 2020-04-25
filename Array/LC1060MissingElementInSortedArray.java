public class LC1060MissingElementInSortedArray {
	/**
	 * Linear scan solution. 
	 * Time complexity: O(N) since we need to traverse through the whole array.
	 * Space complexity: O(1)
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Missing Element in Sorted Array.
	 * Memory Usage: 45.8 MB, less than 100.00% of Java online submissions for Missing Element in Sorted Array.
	 */
	class LinearScanSolution {
	    public int missingElement(int[] nums, int k) {
	        int len = nums.length;
	        // 先处理边界：
	        // k is larger than the missing count of the whole array, meaning it's outside of the array
	        if (k > missingCount(nums, len - 1)) {
	            return nums[len - 1] + (k - missingCount(nums, len - 1));
	        }
	        int index = 1;
	        while (missingCount(nums, index) < k) {
	            index++;
	        }
	        // kth missing number is larger than nums[idx - 1]
	        // and smaller than nums[idx]
	        return nums[index - 1] + k - missingCount(nums, index - 1);
	    }
	    
	    // Find the count of missing numbers between the start and the index
	    private int missingCount(int[] nums, int index) {
	        return nums[index] - nums[0] - index;
	    }
	}

	/**
	 * 套九章模板
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Missing Element in Sorted Array.
	 * Memory Usage: 45.5 MB, less than 100.00% of Java online submissions for Missing Element in Sorted Array.
	 */
	class BinarySearchSolution {
	    public int missingElement(int[] nums, int k) {
	        if (nums == null || nums.length == 0) {
	            return 0;
	        }
	        int len = nums.length;
	        int missingTotal = missingCount(nums, len - 1);
	        if (k > missingTotal) {
	            return nums[len - 1] + k - missingTotal;
	        }
	        int start = 0;
	        int end = len - 1;
	        while (start + 1 < end) {
	            int mid = start + (end - start)/2;
	            int missing = missingCount(nums, mid);
	            if (missing < k) {
	                start = mid;
	            } else if (missing == k) {
	                end = mid;
	            } else {
	                end = mid;
	            }
	        }

	        if (missingCount(nums, start) < k) {
	            return nums[start] + k - missingCount(nums, start);
	        } else {
	            return nums[end] + k - missingCount(nums, end);
	        }
	    }
	    
	    private int missingCount(int[] nums, int index) {
	        return nums[index] - nums[0] - index;
	    }
	}
}