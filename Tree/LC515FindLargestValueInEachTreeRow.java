public class LC515FindLargestValueInEachTreeRow {
	/**
	 * 一看到row/level之类的词就知道这个可以用BFS。
	 * Runtime: 1 ms, faster than 85.44% of Java online submissions for Find Largest Value in Each Tree Row.
	 * Memory Usage: 39.4 MB, less than 74.19% of Java online submissions for Find Largest Value in Each Tree Row.
	 */
	class Solution {
	    public List<Integer> largestValues(TreeNode root) {
	        List<Integer> result = new ArrayList<>();
	        if (root == null) {
	            return result;
	        }
	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.offer(root);
	        while(!queue.isEmpty()) {
	            int size = queue.size();
	            int maxValue = Integer.MIN_VALUE;
	            for (int i = 0; i < size; i++) {
	                TreeNode curr = queue.poll();
	                maxValue = Math.max(maxValue, curr.val);
	                if (curr.left != null) {
	                    queue.offer(curr.left);
	                }
	                if (curr.right != null) {
	                    queue.offer(curr.right);
	                }
	            }
	            result.add(maxValue);
	        }
	        
	        return result;
	    }
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}