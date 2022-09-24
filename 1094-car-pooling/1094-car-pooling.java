class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        
        for(int []t : trips) {
            tm.put(t[1], tm.getOrDefault(t[1],0) + t[0]);
            tm.put(t[2], tm.getOrDefault(t[2],0) - t[0]);
        }
        
        for(int i : tm.values()) {
            capacity -= i;
            if(capacity < 0) {
                return false;
            }
        }
        
        return true;
    }
}