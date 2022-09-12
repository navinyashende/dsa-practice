class Solution {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder("");
        char []arr = address.toCharArray();
        for(char ch : arr) {
            if(ch == '.') {
                sb.append("[.]");
            }
            else {
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}