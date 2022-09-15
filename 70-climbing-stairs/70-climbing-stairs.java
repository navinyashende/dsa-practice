class Solution {
    public int climbStairs(int n) {
        // int []count = new int[1];
        // count[0] = 0;
        // helper(n, 0, count);
        // return count[0];
        
        int dp[] = new int[n+2];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i=3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[n];
    }
    
//     private void helper(int n, int i, int []count) {
//         if(i == n) {
//             count[0]++;
//             return;
//         }
//         else if(i > n) {
//             return;
//         }
        
//         helper(n, i+1, count);
//         helper(n, i+2, count);
//     } 
}