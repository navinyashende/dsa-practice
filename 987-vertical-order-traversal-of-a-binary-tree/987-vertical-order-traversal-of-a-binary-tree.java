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
class BTreeNode {
    
    int val, row, col;
    TreeNode left, right;
    
    BTreeNode(TreeNode node, int row, int col) {
        val = node.val;
        left = node.left;
        right = node.right;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null) {
            return res;
        }
        
        // Define a map to store the mapping of nodes in a row.
        // A row might have multiple columns, each column might have multiple nodes
        
        Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> colRowMap = new TreeMap<>();
        
        Queue<BTreeNode> queue = new ArrayDeque<>();
        queue.add(new BTreeNode(root, 0,0));
        
        while( !queue.isEmpty() ) 
        {
            BTreeNode curr = queue.remove();
            int currRow = curr.row;
            int currCol = curr.col;
            
            colRowMap.putIfAbsent(currCol, new TreeMap<>());
            
            colRowMap.get(currCol).putIfAbsent(currRow, new PriorityQueue<>());
            
            colRowMap.get(currCol).get(currRow).add(curr.val);
            
            if(curr.left != null) {
                queue.add(new BTreeNode(curr.left, currRow + 1, currCol - 1));
            }
            
            if(curr.right != null) {
                queue.add(new BTreeNode(curr.right, currRow + 1, currCol + 1));
            }
        }
        
        for(TreeMap<Integer, PriorityQueue<Integer>> colValMap : colRowMap.values())         {
            res.add(new ArrayList<>());
            for(PriorityQueue<Integer> pq : colValMap.values()) {
                while(!pq.isEmpty()) {
                    res.get(res.size() - 1).add(pq.poll());
                }
            }
        }
        
        return res;
    }
}
