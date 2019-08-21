// Given the root of a binary tree, then value v and depth d, you need to add a row of nodes with value v at the given depth d. The root node is at depth 1.

// The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1, create two tree nodes with value v as N's left subtree root and right subtree root. And N's original left subtree should be the left subtree of the new left subtree root, its original right subtree should be the right subtree of the new right subtree root. If depth d is 1 that means there is no depth d-1 at all, then create a tree node with value v as the new root of the whole original tree, and the original tree is the new root's left subtree.

// Example 1:
// Input: 
// A binary tree as following:
//        4
//      /   \
//     2     6
//    / \   / 
//   3   1 5   

// v = 1

// d = 2

// Output: 
//        4
//       / \
//      1   1
//     /     \
//    2       6
//   / \     / 
//  3   1   5   

// Note:
// The given d is in range [1, maximum depth of the given tree + 1].
// The given binary tree has at least one tree node.

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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1){
            TreeNode ans = new TreeNode(v);
            ans.left = root;
            return ans;
        }
        ArrayList<TreeNode> parents = getPar(root,d-1,1);
        for(int i = 0; i<parents.size(); i++){
            if(parents.get(i).left!=null){
                TreeNode subtree = parents.get(i).left;
                TreeNode level = new TreeNode(v);
                level.left = subtree;
                parents.get(i).left = level;
            }else{
                TreeNode level = new TreeNode(v);
                parents.get(i).left = level;
            }
            if(parents.get(i).right!=null){
                TreeNode subtree = parents.get(i).right;
                TreeNode level = new TreeNode(v);
                level.right = subtree;
                parents.get(i).right = level;
            }else{
                TreeNode level = new TreeNode(v);
                parents.get(i).right = level;
            }
        }
        return root;
    }
    public ArrayList<TreeNode> getPar(TreeNode root, int d, int count){
        ArrayList<TreeNode> pars = new ArrayList<>();
        if(count == d) {
            pars.add(root);
            return pars;
        }
        else{
            if(root.left!= null) pars.addAll(getPar(root.left, d, count+1));
            if(root.right!= null) pars.addAll(getPar(root.right, d, count+1));
        }
        return pars;
    }
}