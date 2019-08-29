//Given a binary tree, count the number of uni-value subtrees. A Uni-value subtree means all nodes of the subtree have the same value.

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
    public int countUnivalSubtrees(TreeNode root) {
        int count = 0;
        if(root!=null){
            if(checkSub(root, root.val)) count++;
            return count + countUnivalSubtrees(root.left)+ countUnivalSubtrees(root.right);
        }
        return count;
    }
    public boolean checkSub(TreeNode root, int val){
        if(root==null) return false;
        if(root.val!=val) return false;
        else if(root.left==null&&root.right==null&&root.val == val) return true;
        else if(root.left==null&&root.val==val) return checkSub(root.right,val);
        else if(root.right==null&&root.val==val) return checkSub(root.left,val);
        else return (checkSub(root.left,val)&&checkSub(root.right, val));

    }
}