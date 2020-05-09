public class LC322CoinChange {
	// Bottom up solution
	class BottomUpIterationSolution {
	    public int coinChange(int[] coins, int amount) {
	        if (amount == 0) {
	            return 0;
	        } else if (amount < 0) {
	            return -1;
	        }
	        int[] dp = new int[amount + 1];
	        Arrays.fill(dp, amount + 1);
	        dp[0] = 0;
	        for (int i = 1; i < dp.length; i++) {
	            for (int coin : coins) {
	                if (i - coin < 0) {
	                    continue;
	                }
	                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
	            }
	        }
	        return dp[amount] == amount + 1 ? -1 : dp[amount];
	    }
	}

	class TopDownRecursionSolution {
    
	    Map<Integer, Integer> memo;
	    
	    public int coinChange(int[] coins, int amount) {
	        memo = new HashMap<>();
	        return dp(coins, amount);
	    }
	    
	    private int dp(int[] coins, int rem) {
	        if (memo.containsKey(rem)) {
	            return memo.get(rem);
	        }
	        if (rem == 0) {
	            return 0;
	        } else if (rem < 0) {
	            return -1;
	        }
	        int res = Integer.MAX_VALUE;
	        for (int coin : coins) {
	            int subProblem = dp(coins, rem - coin);
	            if (subProblem == -1) {
	                continue;
	            }
	            res = Math.min(res, subProblem + 1);
	        }
	        memo.put(rem, res == Integer.MAX_VALUE ? -1 : res);
	        
	        return memo.get(rem);
	    }
	}
}