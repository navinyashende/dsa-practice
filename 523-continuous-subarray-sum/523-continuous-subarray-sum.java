class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        int n = nums.length;
        if(n < 2) {
            return false;
        }
        
        int sum = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        
        int key = 0;
        
        for(int i=0; i < n; i++) {
            sum += nums[i];
            
            if(k != 0) {
                key = sum % k;
            }
            
            if(map.containsKey(key)) {
                if(i - map.get(key) >= 2)
                return true;
            }
            else {
                map.put(key, i);
            }
            
        }
        
        return false;
    }
}

// 23 25 31 35 42
// 5  1  1  5  0