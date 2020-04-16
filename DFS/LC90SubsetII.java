public class LC90SubsetII {
	/**
	 * Classic backtracking solution. 
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Subsets II.
	 * Memory Usage: 39.5 MB, less than 5.88% of Java online submissions for Subsets II.
	 */
	class BackTrackingSolution {
	    public List<List<Integer>> subsetsWithDup(int[] nums) {
	        List<List<Integer>> result = new ArrayList<>();
	        if (nums == null || nums.length == 0) {
	            return result;
	        }
	        Arrays.sort(nums);
	        dfs(nums, result, new ArrayList<Integer>(), 0);
	        return result;
	    }
	    
	    private void dfs(int[] nums, List<List<Integer>> result, List<Integer> subset, int start) {
	        result.add(new ArrayList<Integer>(subset));
	        for (int i = start; i < nums.length; i++) {
	            if (i != start && nums[i] == nums[i - 1]) {
	                continue;
	            }
	            subset.add(nums[i]);
	            dfs(nums, result, subset, i + 1);
	            subset.remove(subset.size() - 1);
	        }
	    }
	}
}