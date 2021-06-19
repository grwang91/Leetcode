class MapSum {

    TrieNode root;
    
    /** Initialize your data structure here. */
    public MapSum() {
        root = new TrieNode(0);
    }
    
    public void insert(String key, int val) {
        TrieNode tmp = root;
        for (int i=0; i<key.length(); i++) {
            char c = key.charAt(i);
            if(tmp.next[c-'a'] == null) {
                tmp.next[c-'a'] = new TrieNode(0);
            }
            tmp = tmp.next[c-'a'];
            if(i==key.length()-1) {
                tmp.score = val;
            }
                
        }
        
    }
    
    public int sum(String prefix) {
        TrieNode tmp = root;

        for (int i=0; i<prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(tmp.next[c-'a'] == null) {
                return 0;
            }
            tmp = tmp.next[c-'a'];
        }
        
        return bfs(tmp);
        
    }
    
    private int bfs(TrieNode start) {
        int sum = 0;
        Queue<TrieNode> q = new LinkedList<>();
        q.add(start);
        
        while(!q.isEmpty()) {
            TrieNode current = q.poll();
            sum+=current.score;
            // System.out.println(current.score);
            for(TrieNode node : current.next) {
                if(node ==null)
                    continue;
                
                q.add(node);
            }
        }
        
        return sum;
        
    }
    
    static class TrieNode {
        TrieNode[] next;
        int score;
        
        public TrieNode(int score) {
            this.score = score;
            next = new TrieNode[26];
        }
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */