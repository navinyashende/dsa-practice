class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        if(n == 0) {
            return tasks.length;
        }
        
        // Create a frequency map
        Map<Character, Integer> freqMap = new HashMap<>();
        
        for(char ch : tasks) {
            freqMap.put(ch, freqMap.getOrDefault(ch,0) + 1);    
        }
        
        // Create a max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(freqMap.values());
        
        // Maintain a queue for finding the tasks within cooldown period
        Map<Integer, Integer> coolDown = new HashMap<>();
        
        int time = 0;
        
        while(!pq.isEmpty() || !coolDown.isEmpty()) {
            // check if there is task that has completed the cooldown period
            if(coolDown.containsKey(time - n - 1)) {
                pq.add(coolDown.remove(time - n - 1)); // add the task back to heap
            }
            
            if(!pq.isEmpty()) {
            
                Integer curr = pq.poll() - 1;
            
                if(curr != 0) {
                    coolDown.put(time, curr);
                }
            }
            
            time++;
        }
        
        return time;
    }
}