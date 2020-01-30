public class LeetCode34FindFirstandLastPositionofElementinSortedArray {
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
