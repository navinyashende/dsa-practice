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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        
        if(root == null) {
            return res;
        }
        
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            
            int n = queue.size();
            
            long sum = 0, count = n;
            
            while(n-- > 0) {
                TreeNode curr = queue.poll();
                
                sum += curr.val;
                
                if(curr.left != null) {
                    queue.offer(curr.left);
                }
                
                if(curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            
            res.add(sum * 1.0/count);
        }
        
        return res;
    }
}