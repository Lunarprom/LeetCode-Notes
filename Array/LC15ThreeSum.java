public class LC15ThreeSum{
	/**
	 * a + b + c = 0 ==> a + b = - c.
	 * Two Sum 外面多套一层
	 */
	class TwoPointersSolution {
	    public List<List<Integer>> threeSum(int[] nums) {
	        List<List<Integer>> results = new ArrayList<>();
	        if (nums == null || nums.length == 0) {
	            return results;
	        }
	        // Sort takes O(NLogN) time.
	        Arrays.sort(nums);
	        int len = nums.length;
	        for (int i = 0; i < len - 2; i++) {
	            if (i > 0 && nums[i] == nums[i - 1]) {
	                continue;
	            }
	            int left = i + 1;
	            int right = len - 1;
	            while (left < right) {
	                if (nums[left] + nums[right] == 0 - nums[i]) {
	                    results.add(Arrays.asList(nums[i], nums[left], nums[right]));
	                    // Since it asks for all the combinations, we need to keep searching after finding a combo.
	                    while (left < right && nums[left] == nums[left + 1]) {
	                        left++;
	                    }
	                    while (left < right && nums[right] == nums[right - 1]) {
	                        right--;
	                    }
	                    left++;
	                    right--;
	                } else if (nums[left] + nums[right] < 0 - nums[i]) {
	                    left++;
	                } else {
	                    right--;
	                }
	            }
	        }
	        
	        return results;
	    }
	}
}