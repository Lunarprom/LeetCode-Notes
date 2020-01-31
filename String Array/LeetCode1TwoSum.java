import java.util.HashMap;
import java.util.Map;

public class LeetCode1TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return new int[]{-1, -1};
        }

        final Map<Integer, Integer> pair = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int delta = target - nums[i];
            if (pair.get(nums[i]) != null) {
                return new int[]{i, pair.get(nums[i])};
            } else {
                pair.put(delta, i);
            }
        }

        return new int[]{-1, -1};
    }
}