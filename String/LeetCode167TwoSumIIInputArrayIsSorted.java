/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class LeetCode167TwoSumIIInputArrayIsSorted {
    /**
     * Start summing up from the two sides. O(lgN) time complexity
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length <= 1) {
            return new int[]{0};
        }

        int start = 0;
        int end = numbers.length - 1;
        while (start + 1 < end) {
            if (numbers[start] + numbers[end] == target) {
                return new int[]{start + 1, end + 1};
            } else if (numbers[start] + numbers[end] < target) {
                start++;
            } else {
                end--;
            }
        }
        if (numbers[start] + numbers[end] == target) {
            return new int[]{start + 1, end + 1};
        }

        return null;
    }
}
