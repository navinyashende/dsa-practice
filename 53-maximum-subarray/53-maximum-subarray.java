class Solution {
    public int maxSubArray(int[] nums) {
        int meh = 0, currMax = 0;
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i < nums.length; i++) {
            if(meh > 0) {
                currMax = meh + nums[i];
            }
            else {
                currMax = nums[i];
            }
            max = Math.max(max, currMax);
            meh = currMax;
        }
        
        return max;
    }
}