public class LeetCode104MaximumDepthOfBinaryTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int maxDepth(TreeNode root) {
            int depth = 0;
            if (root == null) {
                return depth;
            }

            return helper(root, depth);
        }

        private int helper(TreeNode root, int depth) {
            if (root == null) {
                return depth;
            }
            int left = helper(root.left, depth + 1);
            int right = helper(root.right, depth + 1);

            return Math.max(left, right);
        }
    }

    class Solution2 {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }
}
