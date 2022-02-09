class Solution {
    int ans = 0;
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] cnt = new int[26];
        int[] wordScore = new int[words.length];
        int[][] strCnt = new int[words.length][26];
        for (char c : letters) {
            cnt[c-'a']++;
        }
        
        for (int i=0; i<words.length; i++) {
            String word = words[i];
            int s = 0;
            for (char c : word.toCharArray()) {
                s+=score[c-'a'];
                strCnt[i][c-'a']++;
            }
            wordScore[i] = s;
        }
        
        backTrack(words, strCnt, wordScore, 0, 0, cnt);
        
        return ans;
    }
    
    private void backTrack(String[] words, int[][] strCnt, int[] wordScore, int score, int idx, int[] cnt) {
        ans = Math.max(ans,score);
        for (int i=idx; i<words.length; i++) {
            String word = words[0];
            
            if(valid(strCnt[i], cnt)) {
                subtract(strCnt[i], cnt);
                backTrack(words, strCnt, wordScore, score+wordScore[i], i+1, cnt);
                add(strCnt[i], cnt);
            }
        }
    }
    
    private void subtract(int[] strCnt, int[] cnt) {
        for (int i=0; i<26; i++) {
            cnt[i]-=strCnt[i];
        }
    }
    private void add(int[] strCnt, int[] cnt) {
        for (int i=0; i<26; i++) {
            cnt[i]+=strCnt[i];
        }
    }
    
    private boolean valid(int[] strCnt, int[] cnt) {
        for (int i=0; i<26; i++) {
            if(strCnt[i]>cnt[i]) {
                return false;
            }
        }
        return true;
    }
}