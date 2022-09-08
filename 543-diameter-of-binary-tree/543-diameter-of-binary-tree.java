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
    
    int ans = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        diameterUtil(root);
        return ans;
    }
    
    private void diameterUtil(TreeNode root) {
        if(root == null) {
            return;
        }
        int lHeight = height(root.left);
        int rHeight = height(root.right);
        
        ans = Math.max(lHeight + rHeight, ans);
        
        // Check if there is a longest path that doesn't pass through the root
        diameterUtil(root.left);
        diameterUtil(root.right);
    }
    
    private int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int lh = 1 + height(root.left);
        int rh = 1 + height(root.right);
        
       
        
        return Math.max(lh, rh);
    }
}