class Solution {
    public String toHex(int num) {
        Map<Integer,Character> map = new HashMap<>();
        map.put(0,'0');
        map.put(1,'1');
        map.put(2,'2');
        map.put(3,'3');
        map.put(4,'4');
        map.put(5,'5');
        map.put(6,'6');
        map.put(7,'7');
        map.put(8,'8');
        map.put(9,'9');
        map.put(10, 'a');
        map.put(11, 'b');
        map.put(12, 'c');
        map.put(13, 'd');
        map.put(14, 'e');
        map.put(15, 'f');
        
        if(num == 0) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder("");
        
        int n = num;
        
        while(n != 0) {
            sb.append(map.get(n & 15));
            n = n >>> 4;                      
        }
        
        return sb.reverse().toString();
    }
}