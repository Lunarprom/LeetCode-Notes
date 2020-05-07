/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class LeetCode153FindMinimumInRotatedSortedArray {
    /**
     * When cut in half, there will be two cases:
     * 1. the front half is the normal sorted array but nums[mid] > nums[end] -> min should be in the second half
     * 2. Otherwise the min should be in first half
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start)/2;
            if (nums[mid] >= nums[start] && nums[end] <= nums[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] <= nums[end]) {
            return nums[start];
        } else {
            return nums[end];
        }
    }
}