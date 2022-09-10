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
        if(root == null) {
            return 0;
        }
        
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(root);
        int level = 1;
        
        while(!que.isEmpty()) {
            int n = que.size();
            while(n-- > 0) {
                TreeNode curr = que.poll();
                
                if(curr.left == null && curr.right == null) {
                    return level;
                }
                
                if(curr.left != null) {
                    que.add(curr.left);
                }
                
                if(curr.right != null) {
                    que.add(curr.right);
                }
            }
            
            level++;
        }
        
        return level;
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