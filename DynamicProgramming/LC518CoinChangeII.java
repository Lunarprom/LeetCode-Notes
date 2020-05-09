public class LC518CoinChangeII {
	class BottomUpSolution {
	    public int change(int amount, int[] coins) {
	        // 定义dp[i][j] 为使用第i个硬币的话凑到j amount可行的做法
	        int[][] dp = new int[coins.length + 1][amount + 1];
	        // boundary case
	        for (int i = 0; i <= coins.length; i++) {
	            dp[i][0] = 1; // 金额为0的话任意硬币都有有一种取法，就是不取
	        }
	        
	        for (int i = 1; i <= coins.length; i++) {
	            for (int j = 1; j <= amount; j++) {
	                if (j - coins[i - 1] < 0) {
	                    dp[i][j] = dp[i - 1][j];
	                } else {
	                    dp[i][j] = dp[i][j] = dp[i - 1][j] // 不使用当前这枚硬币的情况下，就要继承“使用了上一枚硬币”的拿法数目
	                    + dp[i][j - coins[i - 1]]; // 使用当前这枚硬币且总金额应该得要减去硬币面值
	                }
	            }
	        }
	        
	        return dp[coins.length][amount];
	    }
	}

	// 状态压缩: dp 数组的转移只和 dp[i][..] 和 dp[i-1][..] 有关 
	// 状态f[i] 代表i amount所对应的硬币组合数, 则 f[i] = f[i] (上一轮的结果，不使用当前硬币) + f[i - coin[j]]
	class CompressedStatusSolution {
	    public int change(int amount, int[] coins) {
	        int n = coins.length;
	        int[] dp = new int[amount + 1];
	        dp[0] = 1; // 状态f[i] 代表i amount所对应的硬币组合数
	        for (int i = 0; i < n; i++) {
	            for (int j = 1; j <= amount; j++) {
	                if (j - coins[i] < 0) {
	                    continue;
	                }
	                dp[j] = dp[j] + dp[j - coins[i]];
	            }
	        }
	        
	        return dp[amount];
	    }
	}
}