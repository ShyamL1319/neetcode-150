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
    private int preorderIndex;
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderIndexMap = new HashMap<>();
        
        // Principal Engineer Tip: Pre-indexing allows O(1) lookup
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return arrayToTree(preorder, 0, inorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        // Base case: if there are no elements to construct the tree
        if (left > right) return null;

        // Select the preorderIndex element as the root and increment it
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // Split the inorder array into left and right subtrees
        int index = inorderIndexMap.get(rootValue);

        // Recursively build the subtrees
        root.left = arrayToTree(preorder, left, index - 1);
        root.right = arrayToTree(preorder, index + 1, right);

        return root;
    }
}