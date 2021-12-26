class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        
        for (String word : words) {
            if(isMatchPattern(word, pattern)) {
                ans.add(word);
            }
        }
        
        return ans;
    }
    
    private boolean isMatchPattern(String word, String pattern) {
        Map<Character, Character> match1 = new HashMap<>();
        Map<Character, Character> match2 = new HashMap<>();
        
        for (int i=0; i<word.length(); i++) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            
            if(match1.containsKey(w) && match1.get(w) != p || match2.containsKey(p) && match2.get(p) != w) {
                return false;
            } 
            match1.put(w,p);
            match2.put(p,w);

        }
        return true;
    }
}