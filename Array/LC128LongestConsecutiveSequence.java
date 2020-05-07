public class LC128LongestConsecutiveSequence {
	/**
	 * TODO: 优化一下find()里的路径压缩写法，不用递归
	 */
	class UnionFindSolution {
	    public int longestConsecutive(int[] nums) {
	        if(nums == null || nums.length == 0) {
	            return 0;
	        }
	        
	        UnionFind uf = new UnionFind(nums);
	        
	        for(int i = 0; i<nums.length; i++){
	            //查找当前节点的上一个节点
	            if(uf.parent.containsKey(nums[i] - 1)){
	                uf.union(nums[i] - 1, nums[i]);
	            }
	        }
	        return uf.max;
	    }
	    
	    class UnionFind {
	        Map<Integer, Integer> parent;
	        Map<Integer, Integer> rank;
	        int max;
	        public UnionFind(int[] nums) {
	            max = 1;
	            parent = new HashMap<Integer, Integer>();
	            rank = new HashMap<Integer, Integer>();
	            for (int num : nums) {
	                parent.put(num, num);
	                rank.put(num, 1);
	            }
	        }
	        
	        int find(int val) {
	            int father = parent.get(val);
	            if (father != val) {
	                father = find(father);
	            }
	            parent.put(val, father);
	            
	            return father;
	        }
	        
	        void union(int p, int q) {
	            int rootP = find(p);
	            int rootQ = find(q);
	            if (rootP == rootQ) {
	                return;
	            }
	            int rankSum = rank.get(rootP) + rank.get(rootQ);
	            if (rank.get(rootP) > rank.get(rootQ)) {
	                parent.put(rootQ, rootP);
	                rank.put(rootP, rankSum);
	            } else {
	                parent.put(rootP, rootQ);
	                rank.put(rootQ, rankSum);
	            }
	            max = Math.max(rankSum, max);
	        }
	    }
	}
}