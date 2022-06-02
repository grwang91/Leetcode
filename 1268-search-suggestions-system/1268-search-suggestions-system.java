class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode(false);
        List<List<String>> ans = new ArrayList<>();
        for(String p: products) {
            insertTrie(root, p);
        }
        List<String> tt = new ArrayList<>();
        findAll(root, tt, "");
        for(String ff: tt) {
            System.out.println(ff);
        }
        TrieNode cur = root;
        String s = "";
        for(char c: searchWord.toCharArray()) {
            s+=c;
            List<String> tmp = new ArrayList<>();
            if(cur == null) {
                ans.add(tmp);
                continue;
            }
            cur = cur.next[c-'a'];
            findAll(cur, tmp, s);
            Collections.sort(tmp);
            if(tmp.size() > 3) {
                tmp = tmp.subList(0,3);
            }
            ans.add(tmp);
        }
        
        
        return ans;
    }
    
    private void findAll(TrieNode root, List<String> tmp, String prefix) {
        if(root == null) return;
        
        if(root.isEnd) {
            tmp.add(prefix);
        }
        
        for(int i=0; i<26; i++) {
            TrieNode next = root.next[i];
            if(next == null) continue;
            findAll(next, tmp, prefix+(char)('a'+i));
        }
    }
    
    private void insertTrie(TrieNode root, String s) {
        TrieNode cur = root;
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if(cur.next[c-'a'] == null) {
                cur.next[c-'a'] = new TrieNode(false);
            }
            cur = cur.next[c-'a'];
            
            if(i == s.length()-1) {
                cur.isEnd = true;
            }
        }
    }
    
    
    class TrieNode {
        TrieNode[] next;
        boolean isEnd;
        
        public TrieNode(boolean isEnd) {
            this.isEnd = isEnd;
            next = new TrieNode[26];
        }
    }
}