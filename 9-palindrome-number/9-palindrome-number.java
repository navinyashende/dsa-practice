class Solution {
    public boolean isPalindrome(int x) {
        int n = x;
        int rev = 0;
        int digit = 0;
        while(n > 0) {
            digit = n % 10;
            rev = rev * 10 + digit;
            n /= 10;
        }
        
        if(rev == x) {
            return true;
        }
        
        return false;
    }
}