class Solution {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while(l < r) {
            if(s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            }
            else {
                // try deleting characters at l or r and check if it makes valid palindrome
                return isValidPalindrome(s, l+1, r) || isValidPalindrome(s, l, r-1);
            }
        }
        return true;
    }
    
    public boolean isValidPalindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        
        return true;
    }
}