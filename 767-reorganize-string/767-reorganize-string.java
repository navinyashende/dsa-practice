class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        char []arr = s.toCharArray();
        for(Character ch : arr) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        
        pq.addAll(freqMap.entrySet());
        
        StringBuilder sb = new StringBuilder();
        
        while(!pq.isEmpty()) {
            Map.Entry<Character, Integer> top = pq.poll();
            Character ch = top.getKey();
            
            if(sb.length() == 0 || ch != sb.charAt(sb.length() - 1)) {
                sb.append(ch);
                top.setValue(top.getValue() - 1);
                if(top.getValue() != 0) {
                    pq.add(top);
                }
            }
            else { // we have already added character with highest freq
                //get character with second highest freq
                Map.Entry<Character, Integer> stop = pq.poll();
                if(stop == null) {
                    return "";
                }
                ch = stop.getKey();
                sb.append(ch);
                stop.setValue(stop.getValue() - 1);
                if(stop.getValue() != 0) {
                    pq.add(stop);
                }
                // add back top
                pq.add(top);
            }
        }
        
        return sb.toString();
    }
}

// aaabbccccddd
// cadbcadbcadbc