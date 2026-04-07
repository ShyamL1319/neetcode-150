/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int goodNodes(TreeNode root) {
        // Start recursion with the smallest possible integer or root.val
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int maxSoFar) {
        if (node == null) {
            return 0;
        }

        int count = 0;
        // Check if current node is "good"
        if (node.val >= maxSoFar) {
            count = 1;
            // Update maxSoFar for the children
            maxSoFar = node.val;
        }

        // Add "good" nodes found in subtrees
        count += dfs(node.left, maxSoFar);
        count += dfs(node.right, maxSoFar);

        return count;
    }
}