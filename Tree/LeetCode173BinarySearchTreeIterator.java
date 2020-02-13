import java.util.Stack;

public class LeetCode173BinarySearchTreeIterator {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class NonRecursiveBSTIterator {
        Stack<TreeNode> stack;

        public NonRecursiveBSTIterator(TreeNode root) {
            stack = new Stack<TreeNode>();
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            if (!hasNext()) {
                throw new RuntimeException("No more nodes available!");
            }
            TreeNode current = stack.pop();
            if (current.right != null) {
                TreeNode node = current.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }

            return current.val;
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}