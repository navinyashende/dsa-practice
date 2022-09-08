class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        
        char []arr = s.toCharArray();
        
        while(l < r) {
            // skip non alpha numeric characters
            if(!isAlphaNumeric(arr[l])) {
                l++;
            }
            else if(!isAlphaNumeric(arr[r])) {
                r--;
            }
            else {
                if(equals(arr[l],arr[r])) {
                    l++;
                    r--;
                }
                else {
                    return false;
                }
            }
            
        }
        
        return true;
    }
    
    private boolean isAlphaNumeric(char ch) {
        return (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9');
    }
    
    private boolean equals(char ch1, char ch2) {
        if(ch1 >= 'A' && ch1 <= 'Z') {
            ch1 = (char) (ch1 - 'A' + 'a');
        }
        if(ch2 >= 'A' && ch2 <= 'Z') {
            ch2 = (char) (ch2 - 'A' + 'a');
        }
        return ch1 == ch2;
    }
}