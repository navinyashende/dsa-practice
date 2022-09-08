class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        int n = a.length() - 1;
        int m = b.length() - 1;
        
        StringBuilder sb = new StringBuilder("");
        int sum = 0;
            
        while(n >= 0 && m >= 0) {
            int x = a.charAt(n) - '0';
            int y = b.charAt(m) - '0';
            
            sum  = x + y + carry;
            
            carry = sum / 2;
            
            sb.append(sum % 2);
            n--;
            m--;
        }
        
        while(n >= 0) {
            int x = a.charAt(n) - '0';
            sum  = x + carry;
            carry = sum / 2;
            sb.append(sum % 2);
            n--;
        }
        
        while(m >= 0) {
            int y = b.charAt(m) - '0';
            sum  = y + carry;
            carry = sum / 2;
            sb.append(sum % 2);
            m--;
        }
        
        if(carry != 0) {
            sb.append(carry);
        }
        
        return sb.reverse().toString();
    }
}