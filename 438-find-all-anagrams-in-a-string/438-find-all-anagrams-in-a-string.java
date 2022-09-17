class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        
        int []freq = new int[26];
        
        int count = 0;
        
        char []arr =  p.toCharArray();
        int idx = 0;
        
        for(char ch : arr) {
            idx = (int) (ch - 'a');
            if(freq[idx] == 0) {
                count++;
            }
            freq[idx]++;
        }
        
        arr = s.toCharArray();
        int i = 0;
        
        for(int j=0; j < arr.length; j++) {
            idx = (int) (s.charAt(j) - 'a');
            freq[idx]--;
            
            if(freq[idx] == 0) {
                count--;
            }
            
            if(count == 0) {
                
                while(count == 0) {
                    
                    idx = s.charAt(i) - 'a';
                    
                    freq[idx]++;
                    
                    if(freq[idx] == 1) {
                        count++;
                    }
                    
                    if((j - i + 1) == p.length())
                    {
                        res.add(i);
                    }
                    
                    i++;
                }
            }
        }
        
        return res;
    }
}