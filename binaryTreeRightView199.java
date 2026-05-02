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
    public class NodeWrap {
        TreeNode t;
        int level;

        NodeWrap(TreeNode t, int level) {
            this.t = t;
            this.level = level;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new LinkedList<Integer>();

        if (root == null) {
            return ans;
        }

        Queue<NodeWrap> q = new LinkedList<NodeWrap>();
        NodeWrap n = new NodeWrap(root, 1);
        q.add(n);
        while (!q.isEmpty()) {
            NodeWrap nw = q.remove();
            // System.out.println("node: " + nw.t.val + " level: " + nw.level + " ans: " + ans.toString());
            if (ans.size() < nw.level) {
                ans.add(nw.t.val);
            }

            if (nw.t.right != null) {
                NodeWrap r = new NodeWrap(nw.t.right, nw.level + 1);
                q.add(r);
            }
            if (nw.t.left != null) {
                NodeWrap l = new NodeWrap(nw.t.left, nw.level + 1);
                q.add(l);
            }

        }

        return ans;

    }
}