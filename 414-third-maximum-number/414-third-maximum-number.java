class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(Integer i : set) {
            pq.add(i);
        }
        
        if(pq.size() < 3) {
            return pq.poll();
        }
        
        for(int i = 0; i < 2; i++) {
            pq.poll();
        }
        
        return pq.poll();
    }
}