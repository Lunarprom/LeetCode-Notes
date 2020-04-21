public class LC560SubarraySumEqualsK {
	/**
	 * prefix sum + HashTable (why hash table?)
	 * Runtime: 11 ms, faster than 95.51% of Java online submissions for Subarray Sum Equals K.
	 * Memory Usage: 40.9 MB, less than 10.87% of Java online submissions for Subarray Sum Equals K.
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 */
	class Solution {
	    public int subarraySum(int[] nums, int k) {
	        int count = 0;
	        int sum = 0;
	        Map<Integer, Integer> map = new HashMap<>();
	        map.put(0, 1);
	        for (int i = 0; i < nums.length; i++) {
	            sum += nums[i];
	            
	            if (map.containsKey(sum - k)) {
	                count += map.get(sum - k);
	            }
	            map.put(sum, map.getOrDefault(sum, 0) + 1);
	        }
	        
	        return count;
	    }
	}
}