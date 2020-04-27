public class LC314BinaryTreeVerticalOrderTraversal {

	/**
	 * Maintain the value of minimum column and maximum column so that we can export the result from smallest
	 * to largest.
	 */
	class HashMapSolution {
	    public List<List<Integer>> verticalOrder(TreeNode root) {
	        List<List<Integer>> result = new ArrayList<>();
	        if (root == null) {
	            return result;
	        }
	        Map<Integer, List<Integer>> map = new HashMap<>();
	        Queue<Integer> qCol = new LinkedList<>();
	        Queue<TreeNode> qNode = new LinkedList<>();
	        
	        int minCol = 0;
	        int maxCol = 0;
	        
	        qNode.offer(root);
	        qCol.offer(0);
	        while (!qCol.isEmpty()) {
	            int col = qCol.poll();
	            TreeNode node = qNode.poll();
	            
	            if (col < minCol) {
	                minCol = col;
	            }
	            if (col > maxCol) {
	                maxCol = col;
	            }
	            
	            map.putIfAbsent(col, new ArrayList<>());
	            map.get(col).add(node.val);
	            
	            if (node.left != null) {
	                qCol.offer(col - 1);
	                qNode.offer(node.left);
	            }
	            if (node.right != null) {
	                qCol.offer(col + 1);
	                qNode.offer(node.right);
	            }
	        }
	        
	        for (int i = minCol; i <= maxCol; i++) {
	            result.add(map.get(i));
	        }
	        
	        return result;
	    }
	}


	/**
	 * BFS level-order traversal
	 */
	class TreeMapSolution {
	    public List<List<Integer>> verticalOrder(TreeNode root) {
	        List<List<Integer>> result = new ArrayList<>();
	        if (root == null) {
	            return result;
	        }
	        Map<Integer, List<Integer>> map = new TreeMap<>();
	        Queue<Integer> queueCol = new LinkedList<>();
	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.offer(root);
	        queueCol.offer(0);
	        while (!queue.isEmpty()) {
	            TreeNode curr = queue.poll();
	            int col = queueCol.poll();
	            if (!map.containsKey(col)) {
	                map.put(col, new ArrayList<Integer>(Arrays.asList(curr.val)));
	            } else {
	                map.get(col).add(curr.val);
	            }
	            if (curr.left != null) {
	                queue.offer(curr.left);
	                queueCol.offer(col - 1);
	            }
	            if (curr.right != null) {
	                queue.offer(curr.right);
	                queueCol.offer(col + 1);
	            }
	        }
	        
	        for (int num : map.keySet()) {
	            result.add(map.get(num));
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