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
    public boolean isCompleteTree(TreeNode root) {
        if(root == null) {
            return true;
        }
        
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        boolean isEmpty = false;
        
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(curr == null) {
                isEmpty = true;
            }
            else {
                if(isEmpty) {
                    return false;
                }
            q.offer(curr.left);
            q.offer(curr.right);
                
            }
        }
        
        return true;
    }
}