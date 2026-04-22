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
    ArrayList<Integer> a1;
    ArrayList<Integer> a2;

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        a1 = new ArrayList<Integer>();
        a2 = new ArrayList<Integer>();
        getLeafSequence(root1, a1);
        getLeafSequence(root2, a2);
        return a1.equals(a2);

    }

    public void getLeafSequence(TreeNode r, ArrayList<Integer> a) {
        if (r != null && r.left == null && r.right == null) {
            a.add(r.val);
        } else {
            if (r.left != null) {
                getLeafSequence(r.left, a);
            }
            if (r.right != null) {
                getLeafSequence(r.right, a);
            }
        }
    }
}