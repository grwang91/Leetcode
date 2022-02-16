class StreamChecker {
    Trie root;
    String stream = "";
    public StreamChecker(String[] words) {
        root = new Trie();
        
        for(String word : words) {
            Trie tmp = root;
            for (int i=word.length()-1; i>=0; i--) {
                char c = word.charAt(i);
                if(tmp.children[c-'a'] == null) {
                    tmp.children[c-'a'] = new Trie();
                }
                tmp = tmp.children[c-'a'];
            }
            tmp.isEnd = true;
        }
    }
    
    public boolean query(char letter) {
        stream+=letter;
        
        Trie tmp = root;
        for(int i=stream.length()-1; i>=0; i--) {
            char c = stream.charAt(i);
            
            if(tmp.children[c-'a'] == null) {
                return false;
            }
            
            tmp = tmp.children[c-'a'];
            if(tmp.isEnd) {
                return true;
            }
        }
        return false;
    }
    
    class Trie {
        Trie[] children;
        boolean isEnd;
        
        public Trie() {
            isEnd = false;
            this.children = new Trie[26];
        }
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */