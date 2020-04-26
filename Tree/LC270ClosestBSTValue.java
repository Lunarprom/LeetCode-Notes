public class LC270ClosestBSTValue {

	/**
	 * Runtime: 1 ms, faster than 10.41% of Java online submissions for Closest Binary Search Tree Value.
	 * Memory Usage: 38.9 MB, less than 25.64% of Java online submissions for Closest Binary Search Tree Value.
	 */
	class InorderWithComparatorSolution {
	    public int closestValue(TreeNode root, double target) {
	        List<Integer> nums = new ArrayList<>();
	        inorder(root, nums);
	        
	        int index = 0;
	        return Collections.min(nums, new Comparator<Integer>() {
	            @Override
	            public int compare(Integer num1, Integer num2) {
	                return Math.abs(num1 - target) < Math.abs(num2 - target) ? -1 : 1;
	            }
	        });
	    }
	    
	    private void inorder(TreeNode root, List<Integer> nums) {
	        if (root == null) {
	            return;
	        }
	        inorder(root.left, nums);
	        nums.add(root.val);
	        inorder(root.right, nums);
	    }
	}

	/**
	 * Inorder traversal + binary search 
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Closest Binary Search Tree Value.
	 * Memory Usage: 41.3 MB, less than 5.13% of Java online submissions for Closest Binary Search Tree Value.
	 */
	class BinarySearchRecursiveSolution {
	    double minDelta = Double.MAX_VALUE;
	    int result = Integer.MIN_VALUE;
	    public int closestValue(TreeNode root, double target) {
	        if (root == null) {
	            return result;
	        }
	        double curDelta = Math.abs(root.val - target);
	        if (curDelta <= minDelta) {
	            result = root.val;
	            minDelta = curDelta;
	        }
	        result = root.val > target ? closestValue(root.left, target) : closestValue(root.right, target);
	        
	        return result;
	    }
	}

	class BinarySearchIterationSolution {
	    public int closestValue(TreeNode root, double target) {
	        if (root == null) {
	            return Integer.MIN_VALUE;
	        }
	        int closest = root.val;
	        while (root != null) {
	            closest = Math.abs(root.val - target) < Math.abs(closest - target) ? root.val : closest;
	            root = root.val > target ? root.left : root.right;
	        }
	        
	        return closest;
	    }
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
 	}
}