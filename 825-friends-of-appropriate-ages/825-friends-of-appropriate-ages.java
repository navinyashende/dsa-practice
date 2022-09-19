class Solution {
    public int numFriendRequests(int[] ages) {
        int n = ages.length;
        
        int count = 0;
        Arrays.sort(ages);
        
        for(int age : ages) {
            int lower = findFirstIndex(ages, age/2 + 7);
            int upper = findFirstIndex(ages, age);
            count += Math.max(upper-lower-1, 0);
        }
        
        return count;
    }
    
    private int findFirstIndex(int []ages, int target) {
        int low = 0, high = ages.length - 1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(ages[mid] <= target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        
        return low;
    }
}