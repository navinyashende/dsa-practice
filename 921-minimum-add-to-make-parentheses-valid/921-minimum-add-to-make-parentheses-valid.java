class Solution {
    public int minAddToMakeValid(String s) {
        int count = 0, bal = 0;
        
        for(int i=0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                bal++;
            }
            else {
                bal--;
            }
            if(bal < 0) {
                count++;
                bal++;
            }
        }
        
        return count + bal;
    }
}