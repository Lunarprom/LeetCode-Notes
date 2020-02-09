import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LeetCode144BinaryTreePreorderTraversal {

    class NonRecursion {
        // Version 3: none recursion. Using stack to store nodes un-visited
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> values = new LinkedList<>();
            if (root == null) {
                return values;
            }
            Stack<TreeNode> stack = new Stack<>();
            values.add(root.val);
            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                values.add(cur.val);
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }

            return values;
        }

    }

    class DivideAndConquer {
        // Version 2: Divide and Conquer
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> values = new LinkedList<Integer>();
            if (root == null) {
                return values;
            } else {
                values.add(root.val);
            }

            List<Integer> left = preorderTraversal(root.left);
            List<Integer> right = preorderTraversal(root.right);

            values.addAll(left);
            values.addAll(right);
            return values;
        }
    }

    class Traversal {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> values = new LinkedList<Integer>();
            helper(root, values);

            return values;
        }

        private void helper(TreeNode root, List<Integer> values) {
            if (root == null) {
                return;
            }
            values.add(root.val);
            helper(root.left, values);
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
