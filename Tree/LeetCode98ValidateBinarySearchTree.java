/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * Not only each child tree needs to be BST independently
     * All the descedents value must abide with the root node value.
     * Essentially this is pre-order traversal.
     */
    public boolean isValidBST(TreeNode root) {
        return validateBST(root, null, null);
    }
    
    private boolean validateBST(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        if (lower != null && root.val >= lower) {
            return false;
        }
        if (upper != null && root.val <= upper) {
            return false;
        }
        
        return validateBST(root.left, val, upper) && validateBST(root.right, lower, val);
    }
}
