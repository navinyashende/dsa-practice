class Solution {
    public int calculate(String s) {
        int n = s.length();
        
        char op = '+';
        int res = 0, prev = 0, currNum = 0;
        
        
        for(int i = 0; i < n; i++) {
            
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch)) {
                currNum = currNum * 10 + (ch - '0');
            }
            
            if(!Character.isDigit(ch) && !Character.isWhitespace(ch) || i == n - 1) {
                switch(op) {
                    case '+': {
                        res += prev;
                        prev = currNum;
                        break;
                    }
                    case '-': {
                        res += prev;
                        prev = -currNum;
                        break;
                    }
                    case '*': {
                        prev *= currNum;
                        break;
                    }
                    case '/': {
                        prev /= currNum;
                        break;
                    }
                }
                op = ch;
                currNum = 0;
            }
        }
        
        res += prev;
        
        return res;
    }
}