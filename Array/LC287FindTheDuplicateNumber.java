public class LC287FindTheDuplicateNumber {
	/**
	 * 1. Sort
	 * 2. Traverse + Hash O(2N)
	 * 3. Tricky Binary Search Reference: https://leetcode-cn.com/problems/find-the-duplicate-number/solution/er-fen-fa-si-lu-ji-dai-ma-python-by-liweiwei1419/
	 * Runtime: 2 ms, faster than 48.05% of Java online submissions for Find the Duplicate Number.
	 * Memory Usage: 39.3 MB, less than 5.09% of Java online submissions for Find the Duplicate Number.
	 */
	class BinarySearchSolution {
	    public int findDuplicate(int[] nums) {
	        int len = nums.length;
	        int start = 0;
	        int end = len;
	        while (start < end) {
	            int mid = start + (end - start) / 2;
	            int count = 0;
	            for (int num : nums) {
	                if (num <= mid) {
	                    count++;
	                }
	            }
	            
	            if (count > mid) {
	                end = mid;
	            } else {
	                start = mid + 1;
	            }
	        }
	        
	        return start;
	    }
	}

	/**
	 * Floyd Algorithm. Reference: https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode/
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find the Duplicate Number.
	 * Memory Usage: 39.8 MB, less than 5.09% of Java online submissions for Find the Duplicate Number.
	 */
	class FloydSolution {
	    public int findDuplicate(int[] nums) {
	        if (nums.length <= 1) {
	            return -1;
	        }
	        // Find the intersection point of the two runners.
	        int slow = nums[0];
	        int fast = nums[nums[0]];
	        while (slow != fast) {
	            slow = nums[slow];
	            fast = nums[nums[fast]];
	        }

	        // Find the "entrance" to the cycle.
	        int ptr1 = 0;
	        int ptr2 = slow;
	        while (ptr1 != ptr2) {
	            ptr1 = nums[ptr1];
	            ptr2 = nums[ptr2];
	        }

	        return ptr2;
	    }
	}
}