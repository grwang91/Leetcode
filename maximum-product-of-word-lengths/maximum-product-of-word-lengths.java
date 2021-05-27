class Solution {
    public int maxProduct(String[] words) {
        int ans = 0;
        
        int[][] counts = new int[words.length][26];
        for (int i=0; i<words.length; i++) {
            for (char c : words[i].toCharArray()) {
                counts[i][c-'a']++;
            }
        }
        
        for (int i=0; i<words.length; i++) {
            for (int j=i+1; j<words.length; j++) {
                if(!checkShare(counts,i,j)) {
                    ans = Math.max(ans,words[i].length()*words[j].length());
                }
            }
        }
        return ans;
    }
    
    private boolean checkShare(int[][] counts, int a, int b) {
        for (int i=0; i<26; i++) {
            if(counts[a][i] > 0 && counts[b][i] > 0) {
                return true;
            }
        }
        return false;
    }
}