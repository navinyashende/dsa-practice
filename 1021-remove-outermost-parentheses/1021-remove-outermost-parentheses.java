class Solution {
    public String removeOuterParentheses(String s) {
        int oc = 0;
        char []arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        for(char ch: arr) {
            if(ch == '(' && oc++ > 0) {
                sb.append(ch);
            }
            else if(ch == ')' && oc-- > 1) {
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}