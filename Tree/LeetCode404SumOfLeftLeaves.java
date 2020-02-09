/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LeetCode404SumOfLeftLeaves {
    /**
     * Leverage preorder traversal since it is looking for all left nodes.
     */
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return sum;
        }

        return preOrder(root, sum, false);
    }

    private int preOrder(TreeNode node, int sum, boolean isLeft) {
        if (node.left != null) {
            sum = preOrder(node.left, sum, true);
        }

        if (node.left == null && node.right == null && isLeft) {
            sum += node.val;
        }

        if (node.right != null) {
            sum = preOrder(node.right, sum, false);
        }

        return sum;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
