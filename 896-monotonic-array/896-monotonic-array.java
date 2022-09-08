class Solution {
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;
        
        if(n == 1) {
            return true;
        }
        
        boolean increasing = true, decreasing = true;
        for(int i=0; i < n-1; i++) {
            if(nums[i] < nums[i+1]) {
                increasing = false;
            }
            if(nums[i] > nums[i+1]) {
                decreasing = false;
            }
        }
        
        return increasing || decreasing;
    }
}