class Solution {
    public int longestArithSeqLength(int[] nums) {
        int ans = 2;
        int n = nums.length;
        HashMap<Integer, Integer> []dp = new HashMap[n];
        
        for(int j = 0; j < n; j++) {
            dp[j] = new HashMap<>();
            
            for(int i=0; i < j ; i++) {
                int d = nums[j] - nums[i];
                
                dp[j].put(d, dp[i].getOrDefault(d, 1) + 1);
                
                ans = Math.max(dp[j].get(d), ans);
            }
        }
        
        return ans;
    }
}