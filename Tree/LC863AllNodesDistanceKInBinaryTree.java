public class LC863AllNodesDistanceKInBinaryTree {
	/**
	 * BFS Solution: 
	 * 1. 存每个Node-Parent之间的关系
	 * 2. BFS从Target开始遍历（children + parent)，每一层mark一下步数
	 */
	class Solution {
	    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
	        List<Integer> result = new ArrayList<>();
	        if (root == null) {
	            return result;
	        }
	        Map<TreeNode, TreeNode> parents = new HashMap<>();
	        Set<TreeNode> visited = new HashSet<>();
	        parents.put(null, new TreeNode(-1));
	        buildGraph(root, null, parents);
	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.offer(target);
	        visited.add(target);
	        int count = 0; // or -1?
	        while (!queue.isEmpty()) {
	            int size = queue.size();
	            for (int i = 0; i < size; i++) {
	                TreeNode curr = queue.poll();
	                if (count == K) {
	                    result.add(curr.val);
	                }
	                TreeNode left = curr.left;
	                if (left != null && !visited.contains(left)) {
	                    queue.offer(left);
	                    visited.add(left);
	                }
	                TreeNode right = curr.right;
	                if (right != null && !visited.contains(right)) {
	                    queue.offer(right);
	                    visited.add(right);
	                }
	                TreeNode parent = parents.get(curr);
	                if (parent != null && !visited.contains(parent)) {
	                    queue.offer(parent);
	                    visited.add(parent);
	                }
	            }
	            count++;
	        }
	        
	        return result;
	    }
	    
	    private void buildGraph(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> map) {
	        if (root == null) {
	            return;
	        }
	        map.put(root, parent);
	        buildGraph(root.left, root, map);
	        buildGraph(root.right, root, map);
	    }
	}
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
}