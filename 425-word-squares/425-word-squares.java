class Solution {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> ans = new ArrayList<>();
        TrieNode root = new TrieNode("", false);
        for(String word: words) {
            insertToTrie(word, root);
        }

        ArrayList<String> tmp = new ArrayList<>();
        
        for(String word: words) {
            tmp.add(word);
            findSquare(words[0].length(),tmp, ans, root);
            tmp.remove(tmp.size()-1);
        }
        
        return ans;
    }
    
    private void findSquare(int n, ArrayList<String> tmp, List<List<String>> ans, TrieNode root) {
        if(tmp.size()==n) {
            ans.add((ArrayList<String>)tmp.clone());
            return;
        }
        
        TrieNode cur = root;
        int size = tmp.size();
        for(int i=0; i<size; i++) {
            cur = cur.next[tmp.get(i).charAt(size)-'a'];
            if(cur == null) return;
        }
        
        List<String> allWords = findAll(cur);
        for(String next: allWords) {
            tmp.add(next);
            findSquare(n, tmp, ans, root);
            tmp.remove(tmp.size()-1);
        }
    }
    
    private List<String> findAll( TrieNode root) {
        List<String> out = new ArrayList<>();
        
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TrieNode cur = q.poll();
            if(cur.isEnd) {
                out.add(cur.str);
            }
            for(TrieNode t: cur.next) {
                if(t != null) {
                    q.add(t);
                }
            }
        }
        return out;
    }
    
    
    private void insertToTrie(String word, TrieNode root) {
        TrieNode cur = root;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(cur.next[c-'a'] == null) {
                cur.next[c-'a'] = new TrieNode(cur.str+c,false);
            }
            cur = cur.next[c-'a'];
            if(i==word.length()-1) {
                cur.isEnd = true;
            }
        }
    }
    
    class TrieNode {
        boolean isEnd;
        String str;
        TrieNode[] next;
        public TrieNode(String str, boolean isEnd) {
            this.str = str;
            this.isEnd = isEnd;
            next = new TrieNode[26];
        }
    }
}