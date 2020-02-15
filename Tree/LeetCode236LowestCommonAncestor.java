public class LeetCode236LowestCommonAncestor {
    /**
     * Since the node is also its own ancestor, then return the node
     * when it is p or q.
     * Else, divide and conquer and query the left node and right node.
     */
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) {
                return root;
            }

            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left != null && right != null) {
                return root;
            }
            return left == null ? right : left;
        }
    }

}