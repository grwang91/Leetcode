class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        
        for (String ss: wordDict) {
            set.add(ss);
        }
        
        backTrack(s, 0, "", set, ans);
        
        return ans;
    }
    
    private void backTrack(String s, int start, String tmp, Set<String> set, List<String> ans) {
        if(start==s.length()) {
            ans.add(tmp.trim());
            return;
        }
        
        String str = "";
        for(int i=start; i<s.length(); i++) {
            str+=s.charAt(i);
            if(set.contains(str)) {
                backTrack(s, i+1, tmp+" "+str, set, ans);
            }
        }
    }
}