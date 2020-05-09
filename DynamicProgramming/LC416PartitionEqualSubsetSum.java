public class LC416PartitionEqualSubsetSum {

	class StatusCompressedSolution {
	    public boolean canPartition(int[] nums) {
	        if (nums == null || nums.length == 0) {
	            return true;
	        }
	        int sum = 0;
	        for (int i = 0; i < nums.length; i++) {
	            sum += nums[i];
	        }
	        if (sum % 2 != 0) {
	            return false;
	        }
	        sum /= 2;
	        // dp[i] 是能不能用given number填满i
	        boolean[] dp = new boolean[sum + 1];
	        dp[0] = true;
	        for (int i = 0; i < nums.length; i++) {
	            // 唯一需要注意的是 j 应该从后往前反向遍历，因为每个物品（或者说数字）只能用一次，以免之前的结果影响其他的结果。
	            // “从后向前” 写的过程中，一旦 nums[i] <= j 不满足，可以马上退出当前循环，因为后面的 j 的值肯定越来越小，没有必要继续做判断，直接进入外层循环的下一层。相当于也是一个剪枝
	            for (int j = sum; j >= 0; j--) {
	                if (j - nums[i] >= 0) {
	                    dp[j] = dp[j] || dp[j - nums[i]];
	                }
	            }
	        }
	        
	        return dp[sum];
	     }
	}

	class NaiveSolution {
	    public boolean canPartition(int[] nums) {
	        if (nums == null || nums.length == 0) {
	            return true;
	        }
	        int sum = 0;
	        for (int i = 0; i < nums.length; i++) {
	            sum += nums[i];
	        }
	        if (sum % 2 != 0) {
	            return false;
	        }
	        sum /= 2;
	        // dp[i][j] 对于第i个数，有没有可能达到j amount
	        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
	        for (int i = 0; i <= nums.length; i++) {
	            dp[i][0] = true;
	        }
	        
	        for (int i = 1; i <= nums.length; i++) {
	            for (int j = 1; j <= sum; j++) {
	                if (j - nums[i - 1] < 0) {
	                    dp[i][j] = dp[i - 1][j];
	                } else {
	                    // 装或者不装进背包
	                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i - 1]];
	                }
	            }
	        }
	        
	        return dp[nums.length][sum];
	    }
	}
}