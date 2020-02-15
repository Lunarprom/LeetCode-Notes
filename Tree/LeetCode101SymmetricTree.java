public class LeetCode101SymmetricTree {
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
        /**
         * 暴力解法：层序遍历然后检查字符串是否对称。（非递归
         * 递归怎么做：一棵对称的树它的子树也是对称的
         */
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return isMirror(root.left, root.right);
        }

        private boolean isMirror(TreeNode node1, TreeNode node2) {
            if (node1 == null && node2 == null) {
                return true;
            }

            if (node1 == null || node2 == null) {
                return false;
            }

            return (node1.val == node2.val)
                    && isMirror(node1.left, node2.right)
                    && isMirror(node1.right, node2.left);
        }
    }
}