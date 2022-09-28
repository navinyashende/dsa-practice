class Solution {
    public double myPow(double x, int n) {
       double res = 1.0;
       long nn = n;
       if(nn < 0) {
           nn = nn * -1;
       }
        
       while(nn > 0) {
           if((nn & 1) != 0) {
               res = res * x;
           }
           x = x * x;
           nn = nn >> 1;
       } 
       if(n < 0) {
           return (1/res);
       } 
       return res;
    }
}