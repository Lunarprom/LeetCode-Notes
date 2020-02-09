import javax.swing.tree.TreeNode;
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
public class LeetCode257BinaryTreePaths {
    /**
     * Devide and Conquer
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new LinkedList<String>();
        if (root == null) {
            return paths;
        }

        // If the node is a leaf
        if (root.left == null && root.right == null) {
            paths.add("" + root.val);
            return paths;
        }

        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);

        for (String leftPath : leftPaths) {
            paths.add(root.val + "->" + leftPath);
        }

        for (String rightPath : rightPaths) {
            paths.add(root.val + "->" + rightPath);
        }

        return paths;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}