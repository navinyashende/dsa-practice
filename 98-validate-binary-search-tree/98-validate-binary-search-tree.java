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
    public boolean isValidBST(TreeNode root) {
        return isBSTUtil(root, null, null);
    }
    
    private boolean isBSTUtil(TreeNode curr, TreeNode max, TreeNode min) {
        if(curr == null) {
            return true;
        }
        
        if(max != null && curr.val >= max.val) {
            return false;
        }
        
        if(min != null && curr.val <= min.val) {
            return false;
        }
        return isBSTUtil(curr.left, curr, min) && isBSTUtil(curr.right, max, curr);
    }
}