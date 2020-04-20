import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * Binary Tree worst time complexity is always O(h) (When h = N)
 * Follow up: optimization-
 */
public class LC230KthSmallestElementInABST {

    class solutionUsingAList {
        /**
         * Time complexity: O(N)
         * Space complexity: O(N) potentially need to store the whole tree
         */
        public int kthSmallest(TreeNode root, int k) {
            int result = Integer.MAX_VALUE;
            if (root == null) {
                return -1;
            }
            List<Integer> smallests = new ArrayList<Integer>();
            helper(root, smallests);

            int length = smallests.size();
            if (length <= k - 1) {
                return smallests.get(length - 1);
            } else {
                return smallests.get(k - 1);
            }
        }

        private void helper(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            helper(root.left, list);
            list.add(root.val);
            helper(root.right, list);
        }
    }

    /**
     * Resursion solution using inorder traversal
     * Runtime: 1 ms, faster than 34.77% of Java online submissions for Kth Smallest Element in a BST.
     * Memory Usage: 42.3 MB, less than 5.51% of Java online submissions for Kth Smallest Element in a BST.
     */
    class InorderTraversalRecursionSolution {
        int count;
        int result;
        public int kthSmallest(TreeNode root, int k) {
            count = k;
            result = -1;
            inorderTraversal(root);
            
            return result;
        }
        
        private void inorderTraversal(TreeNode root) {
            if (root == null) {
                return;
            }
            inorderTraversal(root.left);
            --count;
            if (count == 0) {
                result = root.val;
                return;
            }
            inorderTraversal(root.right);
        }
    }

    class NonRecursion {

        public int kthSmallest(TreeNode root, int k) {
            int result = Integer.MAX_VALUE;
            int count = k;
            if (root == null) {
                return result;
            }
            Stack<TreeNode> stack = new Stack<TreeNode>();
            while (true) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }

                if (stack.isEmpty()) {
                    break;
                }
                root = stack.pop();
                count--;
                if (count == 0) {
                    return root.val;
                }
                root = root.right;
            }

            return result;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}