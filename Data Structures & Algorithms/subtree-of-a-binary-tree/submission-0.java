/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Base case: If root is null, subRoot cannot be a subtree
        if (root == null) return false;

        // 1. Check if the trees starting at the current nodes are the same
        if (isSameTree(root, subRoot)) return true;

        // 2. Otherwise, check the left and right children of the main tree
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        // If both are null, they are identical
        if (s == null && t == null) return true;
        
        // If only one is null or values differ, they are not the same
        if (s == null || t == null || s.val != t.val) return false;

        // Recursively check children
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}

