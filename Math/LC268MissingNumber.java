public class LC268MissingNumber {
	/**
	 * Brute force is to store the numbers in a hash set and iterate through all entries until we find the missing one.
	 * This takes O(N) time complexity and O(N) space complexity.
	 */
	class HashSetSolution {
	    public int missingNumber(int[] nums) {
	        Set<Integer> set = new HashSet<>();
	        for (int number : nums) {
	            set.add(number);
	        }
	        for (int i = 0; i < nums.length + 1; i++) {
	            if (!set.contains(i)) {
	                return i;
	            }
	        }
	        return -1;
	    }
	}

	class XORSolution {
	    public int missingNumber(int[] nums) {
	        int missing = nums.length;
	        for (int i = 0; i < nums.length; i++) {
	            missing ^= i ^ nums[i];
	        }
	        
	        return missing;
	    }
	}
}