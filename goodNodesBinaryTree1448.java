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
    public int goodNodes(TreeNode root) {
        return goodNodesHelp(root, 0 - Integer.MAX_VALUE);

    }

    public int goodNodesHelp(TreeNode root, int maxVal) {
        int ct = 0;
        if (root == null) {
            return 0;
        }
        if (root.val >= maxVal) {
            maxVal = root.val;
            ct = 1;
        }
        return ct + goodNodesHelp(root.left, maxVal) + goodNodesHelp(root.right, maxVal);
    }
}