public class LC283MoveZeroes {
	/**
	 * Optimal Solution: 使用快慢指针，快指针每遇到一个非0元素，就赋值给慢指针所在的位置。最后慢指针把所有剩余的位置都用0填满。
	 */
	class Solution {
	    public void moveZeroes(int[] nums) {
	        if (nums == null || nums.length == 0) {
	            return;
	        }
	        
	        int slow = 0;
	        int fast = 0;
	        while (fast < nums.length) {
	            if (nums[fast] != 0) {
	                nums[slow] = nums[fast];
	                slow++;
	            }
	            fast++;
	        }
	        
	        while (slow < nums.length) {
	            nums[slow] = 0;
	            slow++;
	        }
	    }
	}
}