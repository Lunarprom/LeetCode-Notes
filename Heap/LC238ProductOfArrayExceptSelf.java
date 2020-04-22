public class LC238ProductOfArrayExceptSelf {

	/**
	 * Prefix products + suffix products
	 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Product of Array Except Self.
	 * Memory Usage: 48.4 MB, less than 5.51% of Java online submissions for Product of Array Except Self.
	 */
	class NaiveSolution {
	    public int[] productExceptSelf(int[] nums) {
	        if (nums == null || nums.length == 0) {
	            return new int[]{0};
	        }
	        int len = nums.length;
	        int[] result = new int[len];
	        int[] prefix = new int[len];
	        prefix[0] = 1;
	        for (int i = 1; i < len; i++) {
	            prefix[i] = prefix[i - 1] * nums[i - 1];
	        }
	        
	        int[] suffix = new int[len];
	        suffix[len - 1] = 1;
	        for (int i = len - 2; i >= 0; i--) {
	            suffix[i] = suffix[i + 1] * nums[i + 1];
	        }
	        
	        for (int i = 0; i < len; i++) {
	            result[i] = prefix[i] * suffix[i];
	        }
	        
	        return result;
	    }
	}

	/**
	 * solutionion: 用两个数组来维护前缀积和后缀积,于是对于每个nums[i]的结果都是prefix[i - 1] * suffix [i + 1]
	 * 
	 * Space-saving solution
	 * 初始化output, 定义prefix, suffix
	 * 从前往后for loop，每个output[i] *= prefix (前i - 1个元素的乘积)
	 * 从后往前for loop, output[i] *= suffix (后i + 1 个元素的乘积)
	 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Product of Array Except Self.
	 * Memory Usage: 48.1 MB, less than 5.51% of Java online submissions for Product of Array Except Self.
	 */
	class SpaceSavingSolution {
	    public int[] productExceptSelf(int[] nums) {
	        if (nums == null || nums.length == 0) {
	            return new int[]{0};
	        }
	        int[] output = new int[nums.length];
	        output[0] = 1;
	        int prefix = 1;
	        // 从前往后处理前缀和
	        for (int i = 1; i < nums.length; i++) {
	            output[i] = output[i - 1] * nums[i - 1];
	        }
	        
	        // 从后往前处理后缀和
	        int suffix = 1;
	        for (int i = nums.length - 1; i >= 0; i--) {
	            output[i] *= suffix;
	            suffix *= nums[i];
	        }
	        
	        return output;
	    }
	}
}