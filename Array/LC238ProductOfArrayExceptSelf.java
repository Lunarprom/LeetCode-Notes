public class LC238ProductOfArrayExceptSelf {
	/**
	 * Solution: 用两个数组来维护前缀积和后缀积,于是对于每个nums[i]的结果都是prefix[i - 1] * suffix [i + 1]
	 * 
	 * Space-saving solution
	 * 初始化output, 定义prefix, suffix
	 * 从前往后for loop，每个output[i] *= prefix (前i - 1个元素的乘积)
	 * 从后往前for loop, output[i] *= suffix (后i + 1 个元素的乘积)
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