public class LC39CombinationSum {
	/**
	 * Runtime: 2 ms, faster than 99.59% of Java online submissions for Combination Sum.
	 * Memory Usage: 40.1 MB, less than 11.11% of Java online submissions for Combination Sum.
	 */
	class Solution {
	    public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        List<List<Integer>> result = new ArrayList<>();
	        if (candidates == null || candidates.length == 0) {
	            return result;
	        }
	        Arrays.sort(candidates);
	        dfs(candidates, target, result, new ArrayList<Integer>(), 0);
	        
	        return result;
	    }
	    
	    private void dfs(
	        int[] candidates, 
	        int remainingTarget, 
	        List<List<Integer>> result, 
	        List<Integer> combination,
	        int start) {
	        // Base case
	        if (remainingTarget == 0) {
	            result.add(new ArrayList<Integer>(combination));
	            return;
	        }
	        if (remainingTarget < 0) {
	            return;
	        }
	        for (int i = start; i < candidates.length; i++) {
	            if (candidates[i] > remainingTarget) {
	                break;
	            }
	            if (i != 0 && candidates[i] == candidates[i - 1]) {
	                continue;
	            }
	            combination.add(candidates[i]);
	            dfs(candidates, remainingTarget - candidates[i], result, combination, i); // The same number may be chosen for unlimited times
	            combination.remove(combination.size() - 1);
	        }
	        
	    }
	}
}