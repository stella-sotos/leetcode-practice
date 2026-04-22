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
    List<Integer> lSum;

    public int maxLevelSum(TreeNode root) {
        lSum = new ArrayList<Integer>();
        mlsHelp(root, 0);
        System.out.println(lSum);
        int max = lSum.get(0);
        int maxLvl = lSum.size() - 1;
        for (int i = lSum.size() - 1; i >= 0; i--) {
            int sum = lSum.get(i);
            if (sum >= max) {
                max = sum;
                maxLvl = i;
            }
        }
        return maxLvl + 1; // to make up for indexing at 0
    }

    public void mlsHelp(TreeNode root, int level) {
        if (root == null)
            return;
        if (lSum.size() - 1 >= level) {
            int sum = lSum.get(level) + root.val;
            lSum.set(level, sum);
        } else {
            lSum.add(root.val);
        }
        mlsHelp(root.left, level + 1);
        mlsHelp(root.right, level + 1);
    }
}