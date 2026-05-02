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
        if (p.val == q.val)
            return p;

        TreeNode l = root.left != null ? lowestCommonAncestor(root.left, p, q) : null;
        TreeNode r = root.right != null ? lowestCommonAncestor(root.right, p, q) : null;
        if (l != null)
            return l;
        if (r != null)
            return r;

        if ((hasDec(root, p) && hasDec(root, q)))
            return root;
        return null;
    }

    public boolean hasDec(TreeNode root, TreeNode p) {
        if (root == null)
            return false;
        if (root == p)
            return true;
        else
            return hasDec(root.left, p) || hasDec(root.right, p);
    }
}