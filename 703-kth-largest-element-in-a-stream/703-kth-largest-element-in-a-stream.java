class KthLargest {
    
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    int k;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(Integer i : nums) {
            add(i);
        }
    }
    
    public int add(int val) {
        if(pq.size() < k) {
            pq.add(val);
        }
        else if(pq.peek() < val) {
            pq.poll();
            pq.add(val);
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */