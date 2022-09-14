class Solution {
    public boolean backspaceCompare(String s, String t) {
        char []arr = s.toCharArray();
        StringBuilder sb1 = new StringBuilder();
        for(char ch : arr) {
            if(ch == '#') {
                 if(sb1.length() > 0) {
                    sb1.setLength(sb1.length() - 1);
                }
            }
            else {
                sb1.append(ch);
            }
        }
        
        arr = t.toCharArray();
        StringBuilder sb2 = new StringBuilder();
        for(char ch : arr) {
            if(ch == '#') {
                if(sb2.length() > 0) {
                    sb2.setLength(sb2.length() - 1);
                }
            }
            else {
                sb2.append(ch);
            }
        }
        
        return sb1.toString().equals(sb2.toString());
    }
}