public class LeetCode250CountUniversalSubtrees {

    class Solution2 {
        int count = 0;

        public int countUnivalSubtrees(TreeNode root) {
            if (root == null) {
                return count;
            }
            helper(root, root.val);

            return count;
        }

        private boolean helper(TreeNode root, int val) {
            if (root == null) {
                return true;
            }
            if (!helper(root.left, root.val) | !helper(root.right, root.val)) {
                return false;
            }
            count++;
            return root.val == val;
        }
    }

    class Solution1 {
        int count = 0;
        public int countUnivalSubtrees(TreeNode root) {
            if (root == null) {
                return 0;
            }
            isUniVal(root);

            return count;
        }

        boolean isUniVal(TreeNode root) {
            if (root.left == null && root.right == null) {
                count++;
                return true;
            }
            boolean isUniVal = true;
            if (root.left != null) {
                isUniVal = isUniVal(root.left) && isUniVal;
                isUniVal = root.val == root.left.val && isUniVal;
            }
            if (root.right != null) {
                isUniVal = isUniVal(root.right) && isUniVal;
                isUniVal &= root.val == root.right.val;
            }
            if (isUniVal) {
                count++;
            }
            return isUniVal;
        }
    }
}
