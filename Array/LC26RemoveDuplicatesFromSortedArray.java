public class LC26RemoveDuplicatesFromSortedArray {
	/**
	 * 双指针，一快一慢。每次快指针指向的值不等于慢指针指向的值，就把慢指针挪到下一位然后赋值。最后返回慢指针+1 （题目求的是数组长度，但指针index是从0开始的）
	 */
	class TwoPointersSolution {
	    public int removeDuplicates(int[] nums) {
	        if (nums == null || nums.length == 0) {
	            return 0;
	        }
	        int fast =
	        int slow = 0;
	        for (; fast < nums.length; fast++) {
	            if (nums[fast] != nums[slow]) {
	                nums[++slow] = nums[fast];
	            }
	        }
	        
	        return slow + 1;
	    }
	}
}