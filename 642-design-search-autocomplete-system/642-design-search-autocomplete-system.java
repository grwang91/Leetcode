class AutocompleteSystem {
    Map<String, Integer> score;
    TrieNode head;
    TrieNode cur;
    StringBuilder sb;
    public AutocompleteSystem(String[] sentences, int[] times) {
        sb = new StringBuilder();
        score = new HashMap<>();
        head = new TrieNode();
        cur = head;
        
        for(int i=0; i<times.length; i++) {
            score.put(sentences[i], times[i]);
            buildTrie(head, sentences[i]);
        }
    }
    
    public List<String> input(char c) {
        if(c=='#') {
            cur = head;
            String str = sb.toString();
            buildTrie(head, str);
            score.put(str, score.getOrDefault(str,0)+1);
            sb = new StringBuilder();
            return new ArrayList<>();
        }
        sb.append(c);
        if(cur == null) return new ArrayList<>();
        int idx = c-'a';
        if(c==' ') idx = 26;
        cur = cur.next[idx];
        
        List<String> candidates = new ArrayList<>();
        findAllCandidates(cur, candidates);
        Collections.sort(candidates, (i1,i2) -> score.get(i2)==score.get(i1)? i1.compareTo(i2): score.get(i2)-score.get(i1));
        
        return candidates.subList(0,Math.min(3, candidates.size()));
    }
    
    private void findAllCandidates(TrieNode cur, List<String> candidates) {
        if(cur == null) return;
        
        if(cur.isEnd) {
            candidates.add(cur.word);
        }
        
        for(int i=0; i<27; i++) {
            if(cur.next[i] != null) {
                findAllCandidates(cur.next[i], candidates);
            }
        }
    }
    
    private void buildTrie(TrieNode head, String s) {
        TrieNode tmp = head;
        for(int i=0; i<s.length(); i++) {
            char c= s.charAt(i);
            int idx = c-'a';
            if(c==' ') {
                idx = 26;
            }
            if(tmp.next[idx] == null) {
                tmp.next[idx] = new TrieNode();
            }
            tmp = tmp.next[idx];
            if(i==s.length()-1) {
                tmp.isEnd = true;
                tmp.word = s;
            }
        }
    }
}

class TrieNode {
    boolean isEnd;
    TrieNode[] next;
    String word;
    
    public TrieNode() {
        isEnd = false;
        word = "";
        next = new TrieNode[27];
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */