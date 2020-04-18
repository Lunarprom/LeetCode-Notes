public class LC47PermutationsII {
	/**
	 * Instinct: sort the array and skip repeated numbers
	 * Runtime: 2 ms, faster than 46.30% of Java online submissions for Permutations II.
	 * Memory Usage: 40.1 MB, less than 43.28% of Java online submissions for Permutations II.
	 */
	class Solution {
	    public List<List<Integer>> permuteUnique(int[] nums) {
	        List<List<Integer>> result = new ArrayList<>();
	        if (nums == null || nums.length == 0) {
	            return result;
	        }
	        Arrays.sort(nums);
	        boolean[] visited = new boolean[nums.length];
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
	            // skip the duplicated entries
	            // !visited[i - 1] 说明上一个entry刚被track过且从permutation里移除了
	            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
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