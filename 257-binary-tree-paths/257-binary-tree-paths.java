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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        helper(root, res, "");
        return res;
    }
    
    private void helper(TreeNode node, List<String> res, String curr) {
        
        if(curr != "") {
            curr = curr + "->" + node.val;
        }
        else {
            curr += node.val;
        }
        
        if(node.left == null && node.right == null) {
            res.add(curr);
            return;
        }
        
        
        if(node.left != null) {
            helper(node.left, res, curr);
        }
        if(node.right != null) {
            helper(node.right, res, curr);
        }
       
        
    }
}