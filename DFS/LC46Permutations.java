public class LC46Permutations {
	/**
	 * 举例[1,2,3]:
	 * 把1放在第一位的时候，子序列可以是[2,3] or [3,2]
	 * 2 和 3也可以放在第一位，然后再去看子序列的排布
	 * -> 每个array都可以拆解成更小的序列
	 * Since the full-sized permutation is required, we should use a boolean array to record whether the current number has been used or not.
	 * Runtime: 1 ms, faster than 90.16% of Java online submissions for Permutations.
	 * Memory Usage: 39.8 MB, less than 5.68% of Java online submissions for Permutations.
	 * Time complexity: O(N!) 排列个数公式
	 */
	class BacktrackingSolution {
	    public List<List<Integer>> permute(int[] nums) {
	        List<List<Integer>> result = new ArrayList<>();
	        if (nums == null || nums.length == 0) {
	            return result;
	        }
	        boolean[] visited = new boolean[nums.length];
	        // TODO: probably won't need the start
	        helper(nums, result, new ArrayList<Integer>(), visited);
	        return result;
	    }
	    
	    private void helper(int[] nums, 
	                        List<List<Integer>> result, 
	                        List<Integer> perm, 
	                        boolean[] visited) {
	        if (perm.size() == nums.length) {
	            result.add(new ArrayList<Integer>(perm));
	            return;
	        }
	        
	        for (int i = 0; i < nums.length; i++) {
	            if (visited[i]) {
	                continue;
	            }
	            perm.add(nums[i]);
                visited[i] = true;
                helper(nums, result, perm, visited);
                visited[i] = false;
                perm.remove(perm.size() - 1);
	        }
	    }
	}
}