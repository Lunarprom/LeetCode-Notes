public class LC78Subsets {
    /**
     * Backtracking solution.
     */
    class BackTrackingSolution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return result;
            }
            dfs(nums, result, new ArrayList<Integer>(), 0);
            return result;
        }
        
        // 递归的定义:在nums中找到所有以subset开头的子集，并加入result
        private void dfs(int[] nums, List<List<Integer>> result, List<Integer> subset, int start) {
            // 递归的拆解
            // Add a deep copy of subset to result before mutating it
            result.add(new ArrayList<Integer>(subset));
            for (int i = start; i < nums.length; i++) {
                subset.add(nums[i]);
                dfs(nums, result, subset, i + 1);
                subset.remove(subset.size() - 1);
            }
            
            // 递归的出口
        } 
    }   
}
