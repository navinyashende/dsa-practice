class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        int sum = 0; //prefix sum
        int count = 0;
        int n = nums.length;
        for(int i=0; i < n; i++) {
            sum += nums[i];
            
            if(sum == k) {
                count++;
            }
            
            if(freqMap.containsKey(sum-k)) {
                count += freqMap.get(sum - k);
            }
            
            freqMap.put(sum, freqMap.getOrDefault(sum, 0) + 1);
            
        }
        return count;
    }
}

