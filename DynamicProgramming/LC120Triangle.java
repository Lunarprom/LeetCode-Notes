public class LC120Triangle {
	/**
	 * 看着像backtrack...
	 * Given the sample, arrays are unsoted, and each row contains exactly 1 more entry. Are numbers sum up to lower than Integer.MAX_VALUE? Are they all non-negative?
	 * 从顶层开始做backtrack，用当前的index去约束下一层使用的位置就好了并track
	 * 如何约束下一层的位置: 如果当前>=0, 就是同一个index或者下一个; 如果当前是最后一个，就是同一个index或者前一个。
	 
	    【4，1，8，3】
	   【1，2，3，4，5】
	   
	   不能用贪心法来剪枝因为有可能当前虽然不是最小但是下一层会遇到更小的。所以必须把所有的都暴力遍历一遍。
	   暴力DFS会超时。需要加上memoization.
	 * 看了discussion里的题解，自顶向下的记忆化DP会消耗O(N^2)的额外空间，没有必要。直接自底向上只需要O(N)级别的额外空间。
	 */
	class BottomUpDPSolution {
	    public int minimumTotal(List<List<Integer>> triangle) {
	        if (triangle == null || triangle.size() == 0) {
	            return 0;
	        }
	        int[] min = new int[triangle.size() + 1];
	        for (int i = triangle.size() - 1; i >= 0; i--) {
	            for (int j = 0; j < triangle.get(i).size(); j++) {
	                // Find the lesser of its two children, and sum the current value in the triangle with it.
	                // 滚动数组优化。min[k][j] = Math.min(min[k+1][j], min[k+1][j + 1]) + triangle.get(i).get(j); -> 层数其实没有用可以扔掉。
	                min[j] = Math.min(min[j], min[j + 1]) + triangle.get(i).get(j);
	            }
	        }
	        
	        return min[0];
	    }
	}
}