import java.util.Stack;

public class LeetCode700SearchInABST {

    class RecursionBST {
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null || root.val == val) {
                return root;
            }
            if (root.val > val) {
                return searchBST(root.left, val);
            } else {
                return searchBST(root.right, val);
            }
        }
    }

    class BruteForceInorderTraversal {
        // Solution 1: Brute Force inorder traversal
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null) {
                return null;
            }
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode current = root;
            while (true) {
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
                if (stack.isEmpty()) {
                    break;
                }
                current = stack.pop();
                if (current.val == val) {
                    return current;
                }
                current = current.right;
            }

            return null;
        }
    }

    class IterationBST {
        public TreeNode searchBST(TreeNode root, int val) {
            while (root != null && val != root.val) {
                if (root.val > val) {
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
            return root;
        }
    }
}
