public class LC103BinaryTreeZigZagLevelOrderTraversal {
    class BFSSolution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new LinkedList<>();
            if (root == null) {
                return result;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int level = 0;
            while (!queue.isEmpty()) {
                LinkedList<Integer> nodes = new LinkedList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode curr = queue.poll();
                    if (level % 2 == 0) {
                        nodes.addLast(curr.val);
                    } else {
                        nodes.addFirst(curr.val);
                    }
                    if (curr.left != null) {
                        queue.add(curr.left);
                    }
                    if (curr.right != null) {
                        queue.add(curr.right);
                    }
                }
                result.add(nodes);
                level++;
            }
            
            return result;
        }
    }


    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}