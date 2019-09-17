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
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, false);
    }
    public int helper(TreeNode root, boolean isLeft) {
        if(root==null) return 0;
        if(root.left == null && root.right ==null){
            if(isLeft) return root.val;
            else return 0;
        }
        return helper(root.left, true)+ helper(root.right, false);
    }
}