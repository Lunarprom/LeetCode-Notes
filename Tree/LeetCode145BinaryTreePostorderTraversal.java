import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LeetCode145BinaryTreePostorderTraversal {

    /**
     * Version 3: none recursion. When deciding whether to input the current node value, need to confirm whether
     *  all the child tree has already been visited. Therefore a flag is needed.
     *  Reference: https://www.jianshu.com/p/456af5480cee
     */
    class NonRecursion {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> values = new LinkedList<Integer>();
            if (root == null) {
                return values;
            }
            TreeNode node = root;
            TreeNode lastVisited = root;
            Stack<TreeNode> stack =  new Stack<TreeNode>();
            while (!stack.isEmpty() || node != null) {
                // push all left node into the stack until reaching the end.
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
                node = stack.peek(); // Not popping yet because we need to make sure there is no right child.
                if (node.right == lastVisited || node.right == null) {
                    // No need to worry about right child. Can pop out.
                    values.add(node.val);
                    stack.pop();
                    lastVisited = node;
                    node = null;
                } else {
                    // Need to visit node right child first
                    node = node.right;
                }
            }

            return values;
        }
    }

    class DivideAndConquer {
        // Version 2: Divide and Conquer
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> values = new LinkedList<Integer>();
            if (root == null) {
                return values;
            }
            List<Integer> left = postorderTraversal(root.left);
            List<Integer> right = postorderTraversal(root.right);

            values.addAll(left);
            values.addAll(right);
            values.add(root.val);

            return values;
        }
    }

    class Traversal {
        // Version 1: Traversal
        public List<Integer> postorderTraversal(TreeNode root) {
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
            helper(root.right, values);
            values.add(root.val);
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
