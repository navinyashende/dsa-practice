class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        
        for(Integer i : nums) {
            sum += i;
        }
        
        if(sum % 2  != 0) {
            return false;
        }
        
        int target = sum/2;
        
        Set<Integer> dp = new HashSet<>();
        dp.add(0);
        dp.add(nums[0]);
        
        for(int i = 1; i < nums.length; i++) {
            Set<Integer> nextDp = new HashSet<>();
            nextDp.addAll(dp);
            
            for(Integer j : dp) {
                if(j + nums[i] == target) {
                    return true;
                }
                
                nextDp.add(j + nums[i]);
            }
            
            dp = nextDp;
        }
        
        return dp.contains(target);
    }
}