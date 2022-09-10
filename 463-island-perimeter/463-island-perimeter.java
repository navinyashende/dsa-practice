class Solution {
    
    static int []dx = {-1,1,0,0};
    static int []dy = {0,0,-1,1};
    
    public int islandPerimeter(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        
        int res = 0;
        
        for(int i=0; i < n; i++) {
            for(int j=0; j < m; j++) {
                if(grid[i][j] == 1) {
                   res = dfs(grid, i , j ,n, m);
                }
            }
        }
        
        return res;
    }
    
    private int dfs(int [][]grid, int i, int j, int n, int m) {
        
        if(i < 0 || i == n || j < 0 || j == m || grid[i][j] == 0) {
            return 1;
        }
        
        if(grid[i][j] == -1) {
            return 0;
        }
        
        // Mark node as visited
        grid[i][j] = -1;
        
        int peri = 0;
        
        for(int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            {
                peri += dfs(grid, x, y , n , m);
            }
        }
        
        return peri;
    }
}