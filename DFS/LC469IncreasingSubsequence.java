public class LC469IncreasingSubsequence {
	class BackTrackingSolution {
	    public List<List<Integer>> findSubsequences(int[] nums) {
	        List<List<Integer>> result = new ArrayList<>();
	        if (nums == null || nums.length == 0) {
	            return result;
	        }
	        dfs(nums, result, new ArrayList<Integer>(), 0);
	        
	        return result;
	    }
	    
	    private void dfs(int[] nums, List<List<Integer>> result, List<Integer> seq, int start) {
	        if (start >= nums.length) {
	            if (seq.size() >= 2) {
	               result.add(new ArrayList<Integer>(seq));
	            }
	            return;
	        }
	        
	        if (seq.size() == 0 || nums[start] >= seq.get(seq.size() - 1)) {
	            seq.add(nums[start]);
	            dfs(nums, result, seq, start + 1);
	            seq.remove(seq.size() - 1);
	        }
	        if (start > 0 && !seq.isEmpty() && nums[start] == seq.get(seq.size() - 1)) {
	            return;
	        }
	        // 不把第 index 个元素加进 list 中
	        dfs(nums, result, seq, start + 1);
	    }
	}
}