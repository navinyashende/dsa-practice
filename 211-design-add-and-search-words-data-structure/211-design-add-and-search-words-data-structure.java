class TrieNode {
    private static final int size = 26;
    
    TrieNode[] children;
    boolean isEndOfWord;
    
    TrieNode() {
        children = new TrieNode[size];
        isEndOfWord = false;
    }
}

class WordDictionary {
    
    TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();    
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        
        for(int i=0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        
        curr.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }
    
    private boolean searchHelper(String word, int k, TrieNode curr) {
        if(k == word.length()) {
            return curr != null && curr.isEndOfWord;
        }
        
        char ch = word.charAt(k);
        if(ch == '.') {
            for(int i=0; i < curr.children.length; i++) {
                if(curr.children[i] != null && searchHelper(word, k+1, curr.children[i])) {
                    return true;
                }
            }
        }
        else {
            int index = ch - 'a';
            if(curr.children[index] == null) {
                return false;
            }
            return searchHelper(word, k+1, curr.children[index]);
        }
        
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */