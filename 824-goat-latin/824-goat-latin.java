class Solution {
    public String toGoatLatin(String sentence) {
        String []words = sentence.split(" ");
        for(int i=0; i < words.length; i++) {
            char ch = words[i].charAt(0);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                words[i] = words[i] + "ma";
            }
            else {
                words[i] = words[i].substring(1,words[i].length()) + ch + "ma";
            }
            
            for(int j=0; j <= i; j++) {
                words[i] = words[i] + "a";
            }
        }
        
        StringBuilder sj = new StringBuilder("");
        for(int i=0; i < words.length - 1; i++) {
            sj.append(words[i] + " ");
        }
        sj.append(words[words.length - 1]);
        
        return sj.toString();
    }
}