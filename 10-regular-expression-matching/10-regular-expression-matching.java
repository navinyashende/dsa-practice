class Solution {
    
    public boolean isMatch(String s, String p) {
        int n = p.length();
        int m = s.length();
        
        boolean [][]dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        
        for(int j = 2; j <= n; j++) {
            if(p.charAt(j-1) == '*' && dp[0][j-2]) {
                dp[0][j] = true;
            }
        }
        
        for(int j=1; j <= n; j++) {
            for(int i=1; i <= m; i++) {
                
                if(p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '.') {
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-2] || ((p.charAt(j-2) == s.charAt(i-1) || p.charAt(j-2) == '.') && dp[i-1][j]); 
                }
            }
        }
        
        return dp[m][n];
    }
}