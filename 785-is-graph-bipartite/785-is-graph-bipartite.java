class Solution {
    public boolean isBipartite(int[][] graph) {
        // Bipartite : Color graph using two colors such that no two vertices have same color
        
        int n = graph.length;
        
        int []color = new int[n];
        Arrays.fill(color, -1);
        
        for(int i=0; i < n; i++) {
            if(color[i] == -1) {
                if(!bfsCheck(i, graph, color)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean bfsCheck(int curr, int [][]graph, int []color) {
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(curr);
        
        color[curr] = 1;
        
        while(!queue.isEmpty()) {
            Integer node = queue.poll();
            
            for(Integer itr : graph[node]) {
                if(color[itr] == -1) {
                    color[itr] = 1 - color[node];
                    queue.offer(itr);
                }
                else if (color[itr] == color[node]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}