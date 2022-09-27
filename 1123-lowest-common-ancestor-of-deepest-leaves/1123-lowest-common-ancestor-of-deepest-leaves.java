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
    
    int deepest = 0;
    TreeNode lca;
    
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        helper(root, 0);
        return lca;
    }
    
    private int helper(TreeNode root, int depth) {
        deepest = Math.max(deepest, depth);
        if(root == null) {
            return depth;
        }
        int left = helper(root.left, depth + 1);
        int right = helper(root.right, depth + 1);
        
        if(left == deepest && right == deepest) {
            lca = root;
        }
        
        return Math.max(left, right);
    }
    
}