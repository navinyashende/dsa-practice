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
    public int minDepth(TreeNode root) {
        int []min = new int[1];
        min[0] = Integer.MAX_VALUE;
        // pass by reference
        minDepth(root, 1, min);
        // handle empty tree
        if(min[0] == Integer.MAX_VALUE) {
            min[0] = 0;
        }
        return min[0];
    }
    
    private void minDepth(TreeNode root,int curr, int []min) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            min[0] = Math.min(curr, min[0]);
        }
        
        minDepth(root.left, curr + 1, min);
        minDepth(root.right, curr + 1, min);
    }
}