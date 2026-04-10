/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    private int globalMaxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        calculateGain(root);
        return globalMaxSum;
    }

    private int calculateGain(TreeNode node) {
        if (node == null) return 0;

        // Step 1: Recursively get the max gain from subtrees.
        // If a subtree gain is negative, we ignore it (max with 0).
        int leftGain = Math.max(calculateGain(node.left), 0);
        int rightGain = Math.max(calculateGain(node.right), 0);

        // Step 2: Calculate the price of a path that "peaks" at this node.
        int currentPathSum = node.val + leftGain + rightGain;

        // Step 3: Update the global maximum sum if the current peak is better.
        globalMaxSum = Math.max(globalMaxSum, currentPathSum);

        // Step 4: Return the "bridge" value—the max path that can extend to the parent.
        return node.val + Math.max(leftGain, rightGain);
    }
}