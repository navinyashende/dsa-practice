class Solution {
    
    Map<Character, Integer> map = new HashMap<>();
    
    {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }
    
    public int romanToInt(String s) {
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            int curr = map.get(s.charAt(i));
            int next = (i < s.length() - 1) ? map.get(s.charAt(i + 1)) : 0;
            if(next > curr) {
                ans += (next - curr);
                i++;
            }
            else {
                ans += curr;
            }
        }   
        
        return ans;
    }
}