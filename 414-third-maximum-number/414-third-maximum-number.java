class Solution {
    public int thirdMax(int[] nums) {
        Integer max = null, smax = null, tmax = null;
        
        for(Integer i : nums) {
            if(i.equals(max) || i.equals(smax) || i.equals(tmax)) {
                continue;
            }
            if(max == null || i > max) {
                tmax = smax;
                smax = max;
                max = i;
            }
            else if(smax == null || i > smax) {
                tmax = smax;
                smax = i;
            }
            else if(tmax == null || i > tmax) {
                tmax = i;
            }
        }
        
        return tmax == null ? max : tmax;
    }
}