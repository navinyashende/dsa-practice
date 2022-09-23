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
    
    
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        List<Integer> res = new ArrayList<>();
        
        if(root == null || target == null) {
            return res;
        }
        
        if(k == 0) {
            res.add(target.val);
            return res;
        }
        
        dfs(root, target, k, 0, res);
        return res;
    }
    
    private int dfs(TreeNode curr, TreeNode target, int k, int dist, List<Integer> res) {
        if(curr == null) {
            return 0;
        }
        
        if(dist == k) {
            res.add(curr.val);
            return 0;
        }
        
        int left = 0, right = 0;
        
        // traverse from top to bottom
        if(curr.val == target.val || dist > 0) {
            left = dfs(curr.left, target, k, dist + 1, res);
            right = dfs(curr.right, target, k, dist + 1, res);
        }
        else {
            left = dfs(curr.left, target, k, dist, res);
            right = dfs(curr.right, target, k, dist, res);
        }
        
        // traverse from bottom to top
        if(left == k || right == k) {
            res.add(curr.val);
            return 0;
        }
        
        if(curr.val == target.val) {
            return 1;
        }
        
        if(left > 0) {
            dfs(curr.right, target, k, left + 1, res);
        }
        
         if(right > 0) {
            dfs(curr.left, target, k, right + 1, res);
        }
        
        if(left > 0 || right > 0) {
            return left > 0 ? left + 1 : right + 1;
        }
        
        return 0;
    }
}