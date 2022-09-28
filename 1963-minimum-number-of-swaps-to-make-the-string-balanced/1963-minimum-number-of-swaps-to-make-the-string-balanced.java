class Solution {
    public int minSwaps(String s) {
        int count = 0, bal = 0;
        for(int i=0; i < s.length(); i++) {
            if(s.charAt(i) == '[') {
                bal++;
            }
            else {
                bal--;
            }
            if(bal < 0) {
                bal++;
            }
        }
        
        return (bal + 1)/2;
    }
}