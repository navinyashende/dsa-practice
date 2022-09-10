class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        
        int []res = new int[n];
        
        int i = n - 1, l = 0, r = n-1;
        
        while(l <= r) {
            if(Math.abs(nums[l]) > Math.abs(nums[r])) {
                res[i] = nums[l] * nums[l];
                l++;
            }else {
                res[i] = nums[r] * nums[r];
                r--;
            }
            i--;
        }
        
        return res;
    }
}