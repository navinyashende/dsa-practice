class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = Integer.MAX_VALUE;
        int sum = 0;
        
        int start = 0;
        
        for(int i=0; i < nums.length; i++) {
            sum += nums[i];
            while(start < nums.length && sum >= target) {
                len = Math.min(i - start + 1, len);
                sum -= nums[start++];
            }
        }
        
        if(len == Integer.MAX_VALUE)
            return 0;
        
        return len;
    }
}