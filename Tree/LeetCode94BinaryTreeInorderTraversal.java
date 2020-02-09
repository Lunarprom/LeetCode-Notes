import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * BST can be recovered back to a sorted array by conducting inorder traversal. This will be frequenltly used.
 */
public class LeetCode94BinaryTreeInorderTraversal {
    class NonRecursion {
        // Version 3: none recursion. Using stack to store nodes un-visited
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> values = new LinkedList<Integer>();
            if (root == null) {
                return values;
            }
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode curr = root;
            while (!stack.isEmpty() || curr != null) {
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
                if (!stack.isEmpty()) {
                    curr = stack.pop();
                    values.add(curr.val);
                    curr = curr.right;
                }
            }

            return values;
        }
    }

    class DivideAndConquer {
        // Version 2: Divide and conquer
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> values = new LinkedList<Integer> ();
            if (root == null) {
                return values;
            }
            List<Integer> left = inorderTraversal(root.left);
            List<Integer> right = inorderTraversal(root.right);

            values.addAll(left);
            values.add(root.val);
            values.addAll(right);

            return values;
        }
    }


    class Traversal {
        // Version 1: Traversal
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> values = new LinkedList<Integer>();
            if (root == null) {
                return values;
            }
            helper(root, values);

            return values;
        }

        private void helper(TreeNode root, List<Integer> values) {
            if (root == null) {
                return;
            }

            helper(root.left, values);
            values.add(root.val);
            helper(root.right, values);
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
