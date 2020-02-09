import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LeetCode114FlattenBinaryTreeToLinkedList {

    /**
     * Preorder the tree and store all nodes to LinkedList.
     * Time complexity: O(N)
     * Space complexity: O(N)
     * @param root
     */
    public void flatten(TreeNode root) {
        List<TreeNode> nodeList = new LinkedList<TreeNode>();
        preOrder(root, nodeList);
        for (int i = 0; i < nodeList.size() - 1; i++) {
            TreeNode node = nodeList.get(i);
            node.left = null;
            node.right = nodeList.get(i + 1);
        }
    }

    private void preOrder(TreeNode root, List<TreeNode> nodeList) {
        if (root == null) {
            return;
        }

        nodeList.add(root);
        preOrder(root.left, nodeList);
        preOrder(root.right, nodeList);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
