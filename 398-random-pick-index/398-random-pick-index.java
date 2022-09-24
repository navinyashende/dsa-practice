class Solution {
    
    Map<Integer, List<Integer>> idxMap = new HashMap<>();
    
    Random rand;
    
    public Solution(int[] nums) {
        rand = new Random();
        for(int i=0; i < nums.length; i++) {
            idxMap.putIfAbsent(nums[i], new ArrayList<>());
            idxMap.get(nums[i]).add(i);
        }    
    }
    
    public int pick(int target) {
        int n = idxMap.get(target).size();
        int idx = idxMap.get(target).get(rand.nextInt(n));
        return idx;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */