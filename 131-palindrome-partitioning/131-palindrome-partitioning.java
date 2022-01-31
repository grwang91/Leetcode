class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        
        for (int i=0; i<s.length(); i++) {
            dp[i][i] = true;
        }
        
        for (int i=s.length()-1; i>=0; i--) {
            for (int j=i+1; j<s.length(); j++) {
                if(s.charAt(i)==s.charAt(j)) {
                    if(j-i==1 || dp[i+1][j-1]) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        
        backTrack(s, 0, dp, new ArrayList<>(), ans);
        
        return ans;
    }
    
    private void backTrack(String s, int start, boolean[][] dp, ArrayList<String> tmp, List<List<String>> ans) {
        if(start >= s.length()) {
            ans.add((ArrayList<String>)tmp.clone());
            return;
        }
        
        for (int i=start; i<s.length(); i++) {
            if(dp[start][i]) {
                tmp.add(s.substring(start,i+1));
                backTrack(s, i+1, dp, tmp, ans);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}