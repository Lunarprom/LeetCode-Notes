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
public class LC114FlattenBinaryTreeToLinkedList {

    /**
     * Most straightforward solution. 
     * If the current rooot has left child, then:
     * 1. first find the right most child of the left;
     * 2. Make root.left become root.right
     * 3. Make root.right become the right of the right most child of the left.
     * 4. Make root.left null.
     */
    class PreorderTraversalIterativeSolution {

        public void flatten(TreeNode root) {
            while (root != null) {
                if (root.left == null) {
                    root = root.right;
                } else {
                    TreeNode pre = root.left;
                    while (pre.right != null) {
                        pre = pre.right;
                    }
                    pre.right = root.right;
                    root.right = root.left;
                    root.left = null;
                    root = root.right;
                }
            }
        }
    }

    /**
     * 把先序遍历反过来变成右左根，每次都把上一个访问过的节点接到root的右边。
     */
    class ReversedPreorderTraversalRecursiveSolution {
        TreeNode pre = null;
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            flatten(root.right);
            flatten(root.left);
            root.right = pre;
            root.left = null;
            pre = root;
        }
    }

    /**
     * This method does not qualify as an in-memory solution.
     */
    class PreorderTraversalSolution {
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
    }

    /**
     * Runtime: 1 ms, faster than 26.61% of Java online submissions for Flatten Binary Tree to Linked List.
     * Memory Usage: 40.1 MB, less than 5.45% of Java online submissions for Flatten Binary Tree to Linked List.
     */
    class PreorderTraversalInMemorySolution {
        TreeNode lastNode = null;
        
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }

            if (lastNode != null) {
                lastNode.left = null;
                lastNode.right = root;
            }

            lastNode = root;
            // Store right node before it's altered by flatten(root.left).
            TreeNode right = root.right;
            flatten(root.left);
            flatten(right);
        }
    }

    /**
     * Divide & Conquer
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Flatten Binary Tree to Linked List.
     * Memory Usage: 40.5 MB, less than 5.45% of Java online submissions for Flatten Binary Tree to Linked List.
     */
    class DivideAndConquerSolution {
        
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            helper(root);
        }
        
        private TreeNode helper(TreeNode root) {
            if (root == null) {
                return root;
            }
            TreeNode leftLast = helper(root.left);
            TreeNode rightLast = helper(root.right);
            if (leftLast != null) {
                leftLast.right = root.right; // hook the tail of left link with the head of right link
                root.right = root.left; // switch the left link to be the right child
                root.left = null;
            }
            if (rightLast != null) {
                return rightLast;
            }
            if (leftLast != null) {
                return leftLast;
            }
            return root;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
