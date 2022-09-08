class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        
        HashMap<Character, Integer> posMap = new HashMap<>();
        
        for(int i=0; i < order.length(); i++) {
            posMap.put(order.charAt(i), i);
        }
        
        for(int i=0; i < words.length - 1; i++) {
            for(int j=0; j < words[i].length(); j++) {
                //edge cases like apple,app
                if(j >= words[i+1].length()) {
                    return false;
                }
                
                // if the characters are not same, check the order
                if(words[i].charAt(j) != words[i+1].charAt(j)) {
                    if(posMap.get(words[i].charAt(j)) > posMap.get(words[i+1].charAt(j))) {
                        return false;
                    }
                    else {
                        break; // we found the first different character that is sorted , hence no need to check other characters
                    }
                }
            }
        }
        
        return true;
    }
}