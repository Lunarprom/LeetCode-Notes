public class LC40CombinationSumII {
	/**
	 * 跟Combination Sum I 不同的地方就在于同一个数只能用一次，所以在递归的时候start index 需要 + 1
	 * 但两题都需要去重（不能有相同的组合），所以在循环的时候，如果发现当前的数跟前一个数相同，
	 * 那么该数可以组成的组合一定都已经被扫描过了，因此直接跳过当前的这个数。
	 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Combination Sum II.
	 * Memory Usage: 40.2 MB, less than 32.63% of Java online submissions for Combination Sum II.
	 */
	class Solution {
	    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
	        List<List<Integer>> result = new ArrayList<>();
	        if (candidates == null || candidates.length == 0) {
	            return result;
	        }
	        Arrays.sort(candidates);
	        helper(candidates, result, new ArrayList<Integer>(), target, 0);
	        return result;
	    }
	    
	    private void helper(int[] candidates,
	                  List<List<Integer>> result,
	                  List<Integer> combination,
	                  int remainingTarget,
	                  int start) {
	        if (remainingTarget == 0) {
	            result.add(new ArrayList<Integer>(combination));
	            return;
	        }
	        for (int i = start; i < candidates.length; i++) {
	            if (candidates[i] > remainingTarget) {
	                break;
	            }
	            if (i != start && candidates[i] == candidates[i - 1]) {
	                continue;
	            }
	            combination.add(candidates[i]);
	            helper(candidates, result, combination, remainingTarget - candidates[i], i + 1);
	            combination.remove(combination.size() - 1);
	        }
	    }
	}
}