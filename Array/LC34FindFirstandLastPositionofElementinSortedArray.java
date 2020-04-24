/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class LC34FindFirstandLastPositionofElementinSortedArray {
    /**
     * 0423 Version.
     * 左闭右开的写法，两次Binary search分别寻找左右边界，跳出循环的时候检查指针是否越界。
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
     * Memory Usage: 42.8 MB, less than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
     */
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return new int[]{-1, -1};
            }
            
            int start = 0;
            int end = nums.length;
            // Find the left border
            while (start < end) {
                int mid = start + (end - start)/2;
                if (nums[mid] == target) { // shrink the right border
                    end = mid;
                } else if (nums[mid] > target) {
                    end = mid;
                } else { // nums[mid] < target
                    start = mid + 1;
                }
            }
            // currently start == end
            int left = (start >= nums.length || nums[start] != target) ? -1 : start;
            start = 0;
            end = nums.length;
            while (start < end) {
                int mid = start + (end - start)/2;
                if (nums[mid] == target) {
                    start = mid + 1;
                } else if (nums[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            // currently start == end = nums.length;
            int right = (end - 1 < 0 || nums[end - 1] != target) ? -1 : end - 1;
            
            return new int[]{left, right};
        }
    }

    /**
     * Run two binary search.
     * The first time, find the first position of the targeted number.
     * The second time, find the last position of the targeted number.
     * Time complexity: O(logN)
     */
    public int[] searchRange(int[] nums, int target) {
        int head = -1;
        int tail = -1;
        if (nums == null || nums.length == 0) {
            return new int[]{head, tail};
        }

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target <= nums[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] == target) {
            head = start;
        } else if (nums[end] == target) {
            head = end;
        }

        start= 0;
        end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target >= nums[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[end] == target) {
            tail = end;
        } else if (nums[start] == target) {
            tail = start;
        }

        return new int[]{head, tail};
    }
}
