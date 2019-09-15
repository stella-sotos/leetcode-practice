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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p ==null || q ==null) return null;
        else if (p.val < root.val && q.val < root.val){
            TreeNode tryNode = lowestCommonAncestor(root.left, p, q);
            if(tryNode != null) return tryNode;
            else return root;
        }
        else if (p.val > root.val && q.val > root.val){
            TreeNode tryNode = lowestCommonAncestor(root.right, p, q);
            if(tryNode != null) return tryNode;
            else return root;
        }
        else return root;
    }
}