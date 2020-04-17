public class LC77Combinations {
	/**
	 * comb(k) = num[k] + comb(k - 1) -> recursively getting the combination
	 * DFS + backtracking
	 * Runtime: 17 ms, faster than 70.46% of Java online submissions for Combinations.
	 *Memory Usage: 40.9 MB, less than 34.78% of Java online submissions for Combinations.
	 */
	class BackTrackingSolution {
	    public List<List<Integer>> combine(int n, int k) {
	        List<List<Integer>> result = new ArrayList<>();
	        if (n == 0 || n < k) {
	            return result;
	        }
	        helper(1, n, k, result, new ArrayList<Integer>());
	        return result;
	    }
	    
	    private void helper(int start, int total, int count, List<List<Integer>> result, List<Integer> combo) {
	        if (count == 0) {
	            result.add(new ArrayList<Integer>(combo)); // Make sure to add the deep copy instead of passing in the reference of combo!
	            return;
	        }
	        for (int i = start; i <= total; i++) {
	            combo.add(i);
	            helper(i + 1, total, count - 1, result, combo);
	            combo.remove(combo.size() - 1);
	        }
	    }
	}
}