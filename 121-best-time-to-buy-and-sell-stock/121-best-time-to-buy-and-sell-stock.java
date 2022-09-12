class Solution {
    public int maxProfit(int[] prices) {
        int lowestPrice = Integer.MAX_VALUE;
        
        int ans = 0;
        
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < lowestPrice) {
                lowestPrice = prices[i];
            }
            ans = Math.max(prices[i] - lowestPrice, ans);
        }
        
        return ans;
    }
}