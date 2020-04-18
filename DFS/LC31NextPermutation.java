public class LC31NextPermutation {
	/**
	 * Find the last pair of numbers in ascending order
	 * 1->2->4->3 然后从右往左找到比2大的最小的那个数，交换，然后reverse
	 * 理解字典序
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Next Permutation.
	 * Memory Usage: 39.4 MB, less than 50.00% of Java online submissions for Next Permutation.
	 */
	class Solution {
	    public void nextPermutation(int[] nums) {
	        int len = nums.length;
	        if (len <= 1) {
	            return;
	        }
	        int i = len - 1;
	        while (i > 0 && nums[i] <= nums[i - 1]) {
	            i--;
	        }
	        swapList(nums, i, len - 1);
	        // from i to len - 1, find the smallest number that's larger than 
	        if (i != 0) {
	            int j = i;
	            while (nums[j] <= nums[i - 1]) {
	                j++;
	            }
	            swap(nums, i - 1, j);
	        }
	        return;
	    }
	    
	    private void swap(int[] nums, int left, int right) {
	        int temp = nums[left];
	        nums[left] = nums[right];
	        nums[right] = temp;
	    }
	    
	    private void swapList(int[] nums, int i, int j) {
	        while (i < j) {
	            swap(nums, i, j);
	            i++;
	            j--;
	        }
	    }
	}
}