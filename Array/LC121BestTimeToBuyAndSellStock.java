public class LC121BestTimeToBuyAndSellStock {
	/**
	 * prefix sum的核心思想：i,j两重循环其实有一重循环是多余的，即，起点i其实是已知的
	 * Runtime: 1 ms, faster than 99.17% of Java online submissions for Best Time to Buy and Sell Stock.
	 * Memory Usage: 39.4 MB, less than 22.56% of Java online submissions for Best Time to Buy and Sell Stock.
	 * 
	 */
	class PrefixSumSolution {
	    public int maxProfit(int[] prices) {
	        int maxProfit = 0;
	        if (prices == null || prices.length == 0) {
	            return maxProfit;
	        }
	        
	        int minPrice = prices[0];
	        for (int i = 1; i < prices.length; i++) {
	            minPrice = Math.min(minPrice, prices[i]);
	            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
	        }
	        
	        return maxProfit;
	    }
	}
}