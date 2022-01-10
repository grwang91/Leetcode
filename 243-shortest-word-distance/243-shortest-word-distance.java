class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int idx1 = -1, idx2 = -1;
        int ans = wordsDict.length;
        
        for (int i=0; i<wordsDict.length; i++) {
            if(wordsDict[i].equals(word1)) {
                idx1 = i;
            }
            if(wordsDict[i].equals(word2)) {
                idx2 = i;
            }
            if(idx1 != -1 && idx2 != -1)
                ans = Math.min(ans, Math.abs(idx1-idx2));
        }
        
        return ans;
    }
}