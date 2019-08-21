// Given a binary tree, find its minimum depth.

// The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

// Note: A leaf is a node with no children.

// Example:

// Given binary tree [3,9,20,null,null,15,7],

//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its minimum depth = 2.

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
    public int minDepth(TreeNode root) {
        return minHelper(root,0);
    }
    public int minHelper(TreeNode node, int level) {
        if(node==null) return level;
        else if(node.left ==null && node.right ==null) return level + 1;
        else if(node.left!=null&&node.right!=null) return Math.min(minHelper(node.left, level+1), minHelper(node.right,level+1));
        else if(node.left!=null) return minHelper(node.left, level+1);
        else return minHelper(node.right,level+1);
    }
}