class Solution {
    public int numDecodings(String s) {
        char []a = s.toCharArray();
        int n = s.length();
        
        int []dp = new int[n];
        
        dp[0] = (a[0] == '0') ? 0 : 1;
        
        char curr, prev;
        for(int i = 1; i < n; i++) {
            curr = a[i];
            prev = a[i-1];
            
            if(curr >= '1' && curr <= '9') {
                dp[i] += dp[i-1];
            }
            
            if(prev == '1' && curr >= '0' && curr <= '9' || prev == '2' && curr >= '0' && curr <= '6') {
                dp[i] += (i >= 2) ? dp[i-2] : 1;
            }
        }
        
        return dp[n-1];
    }
}