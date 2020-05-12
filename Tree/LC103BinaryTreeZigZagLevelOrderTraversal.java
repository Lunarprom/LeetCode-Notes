public class LC103BinaryTreeZigZagLevelOrderTraversal {
    /**
     * 利用了LinkedList的双端队列性质。用level的奇偶性来track增加的地方。
     * 要是不让用双端队列的话就reverse。多一个O(NLogN)的操作。
     */
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