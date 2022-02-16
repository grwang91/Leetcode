class StreamChecker {
    
    TrieNode root;
    
    String queryString = "";

   public StreamChecker(String[] words) {
       this.root = new TrieNode();
       
       TrieNode tmp = this.root;
       
       for (int i=0; i<words.length; i++) {
           tmp = this.root;
           for (int j=words[i].length()-1; j>=0; j--) {
               char c = words[i].charAt(j);
               
               if(!tmp.next.containsKey(c)) {
                   tmp.next.put(c, new TrieNode());
               }
               tmp = tmp.next.get(c);
               
           }
           tmp.isEnd = true;
           //System.out.println(tmp.isEnd);
       }
    }
    
    public boolean query(char letter) {
        //System.out.println();
        this.queryString = letter + queryString;
        
        
        TrieNode tmp = this.root;
        
        for (int i=0; i<this.queryString.length(); i++) {
            char c = this.queryString.charAt(i);
            //System.out.println(c);
            
            if(!tmp.next.containsKey(c)) {
                return false;
            }
            
            tmp = tmp.next.get(c);
            
            if(tmp.isEnd) {
                return true;
            }
            
        }
        return tmp.isEnd;
        
        
    }
    
    class TrieNode {
        boolean isEnd = false;
        HashMap<Character, TrieNode> next =  new HashMap<>();
        
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */