class Solution {
    public int[][] merge(int[][] intervals) {
        
        List<int []> res = new ArrayList<>();
        
        // Sort by start
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        for(int []a : intervals) {
            if(a[0] <= end) {
                end = Math.max(a[1], end);
            }
            else {
                res.add(new int[]{start, end});
                start = a[0];
                end = a[1];
            }
        }
        
        res.add(new int[]{start,end}); //add last interval
        
        int [][]ans = res.toArray(new int [0][]);
        
        return ans;
    }
}